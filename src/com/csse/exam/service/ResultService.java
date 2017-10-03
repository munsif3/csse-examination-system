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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author munsif
 */
public final class ResultService {

    private static final Connection CONNECTION = DBConnection.getConnection();
    private static final Logger LOGGER = Logger.getLogger(ResultService.class.getName());

    private Result result;
    private ArrayList<Result> resultList = new ArrayList<>();

    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    private static Handler fileHandler = null;
    private static Handler consoleHandler = null;

    public ResultService() {
        try {
            consoleHandler = new ConsoleHandler();
            fileHandler = new FileHandler("./logs/resultservice/log_result_service.log");

            LOGGER.addHandler(consoleHandler);
            LOGGER.addHandler(fileHandler);

            consoleHandler.setLevel(Level.ALL);
            fileHandler.setLevel(Level.ALL);
            LOGGER.setLevel(Level.ALL);

            LOGGER.info("Result Service Initiated");
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
        if (score <= 100 && score > 75) {
            grade = 'A';
        }
        else if (score <= 75 && score > 50) {
            grade = 'B';
        }
        else if (score <= 50 && score > 35) {
            grade = 'C';
        }
        else {
            grade = 'F';
        }
        return grade;
    }

    public DefaultTableModel fillResultsTable() {
        DefaultTableModel table = new DefaultTableModel(new Object[]{"Student ID", "Exam ID", "Score"}, 0);

        resultList.forEach((r) -> {
            table.addRow(new Object[]{r.getUserId(), r.getExamId(), r.getScore()});
        });

        return table;
    }
}
