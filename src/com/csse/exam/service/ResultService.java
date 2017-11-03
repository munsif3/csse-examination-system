/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.exam.service;

import com.csse.exam.config.DBConnection;
import com.csse.exam.model.Result;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author munsif
 */
public final class ResultService {

    private static final Connection CONNECTION = DBConnection.getConnection();
    public static final Logger LOGGER = Logger.getLogger(ResultService.class.getName());

    private Result result;
    private ArrayList<Result> resultList = new ArrayList<>();

    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    private static Handler fileHandler = null;
    private static Handler consoleHandler = null;

    /**
     * Constructor to initialize the logger specific tasks
     */
    public ResultService() {
        try {
            consoleHandler = new ConsoleHandler();
            fileHandler = new FileHandler("./logs/resultservice/log_result_service.log", true);

            LOGGER.addHandler(consoleHandler);
            LOGGER.addHandler(fileHandler);

            consoleHandler.setLevel(Level.ALL);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.setLevel(Level.ALL);

            LOGGER.info("Result Service Initiated");
            this.getResult();
            LOGGER.info("Results retrieved from the Database");
        }
        catch (IOException | SecurityException e) {
            LOGGER.log(Level.SEVERE, "Error occur in FileHandler : ", e);
        }
    }

    /**
     *
     * @return ArrayList of type Result and complete extraction of the result
     *         table
     */
    public ArrayList<Result> getResult() {

        try {
            preparedStatement = CONNECTION.prepareStatement("SELECT * FROM result ");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result = new Result();
                result.setUserId(resultSet.getString("userId"));
                result.setExamId(resultSet.getString("examId"));
                result.setScore(resultSet.getString("score"));
                result.setGrade(resultSet.getString("grade"));
                resultList.add(result);
            }

        }
        catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error occur in getResult() : ", e);
        }
        return resultList;
    }

    /**
     *
     * @return Distinct ExamId from the ArrayList
     */
    public List<Result> getDistinctStudentId() {
        return resultList.stream()
                .filter(distinctByKey(p -> p.getUserId()))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param <T>
     * @param keyExtractor
     * @return key and true if seen already in the Array
     */
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    /**
     *
     * @return List of unique student id
     */
    public List<Result> getStudentId() {
        return resultList.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     *
     * @param studentId
     * @return List of Exams of the particular student
     */
    public List<Result> getExamIdByStudentId(String studentId) {
        return resultList.stream()
                .filter(t -> t.getUserId().equals(studentId))
                .collect(Collectors.toList());

    }

    /**
     *
     * @param studentId
     * @param examId
     * @return List of Score of the particular student's particular exam
     */
    public List<Result> getScoreByStudentIdExamId(String studentId, String examId) {
        //return scores list
        return resultList.stream()
                .filter(t -> t.getUserId().equals(studentId) && t.getExamId().equals(examId))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param score
     * @return Grade of the particular exam
     */
    public char getGrade(int score) {

        char grade;
        if ((score > 75) && (score <= 100)) {
            grade = 'A';
        }
        else if ((score > 50) && (score <= 75)) {
            grade = 'B';
        }
        else if ((score > 35) && (score <= 50)) {
            grade = 'C';
        }
        else {
            grade = 'F';
        }
        return grade;
    }

    /**
     *
     * @return Default Table Model to populate the jTable in View
     */
    public DefaultTableModel fillResultsTable() {
        DefaultTableModel table = new DefaultTableModel(new Object[]{"Student ID", "Exam ID", "Score", "Grade"}, 0);

        resultList.forEach((result) -> {
            table.addRow(new Object[]{result.getUserId(), result.getExamId(), result.getScore(), result.getGrade()});
        });

        return table;
    }

    public boolean updateScore(String studentId, String examId, char grade, int score) {
        boolean status = false;

        try {
            preparedStatement = CONNECTION.prepareStatement("UPDATE result SET score = ?, grade = ? WHERE userId = ? AND examId = ?");
            preparedStatement.setInt(1, score);
            preparedStatement.setString(2, String.valueOf(grade));
            preparedStatement.setString(3, studentId);
            preparedStatement.setString(4, examId);
            int updated = preparedStatement.executeUpdate();
            LOGGER.log(Level.INFO, "{0} Records Updated", updated);
            status = true;
        }
        catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error occur in updateScore() : ", e);
        }

        return status;
    }

}
