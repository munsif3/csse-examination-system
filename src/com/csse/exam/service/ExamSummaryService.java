/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.exam.service;

import com.csse.exam.config.DBConnection;
import com.csse.exam.model.Exam;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class ExamSummaryService {

    private static final Connection CONNECTION = DBConnection.getConnection();
    public static final Logger LOGGER = Logger.getLogger(ResultService.class.getName());
    private static Handler fileHandler = null;
    private static Handler consoleHandler = null;

    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    private Exam exam;
    private ArrayList<Exam> examList = new ArrayList<>();

    //get passed student count
    //get result state as out or not
    public ExamSummaryService() {
        try {
            consoleHandler = new ConsoleHandler();
            fileHandler = new FileHandler("./logs/examsummaryservice/log_exam_summary_service.log", true);

            LOGGER.addHandler(consoleHandler);
            LOGGER.addHandler(fileHandler);

            consoleHandler.setLevel(Level.ALL);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.setLevel(Level.ALL);

            LOGGER.info("Result Service Initiated");
        }
        catch (IOException | SecurityException e) {
            LOGGER.log(Level.SEVERE, "Error occur in FileHandler : ", e);
        }
    }

    /**
     *
     * @return ArrayList of type Exam and extraction all fields
     */
    public ArrayList<Exam> getExamDetails() {
        try {
            preparedStatement = CONNECTION.prepareStatement("SELECT * FROM exam");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                exam = new Exam();
                exam.setExamDate(resultSet.getDate("examDate"));
                exam.setExamId(resultSet.getString("examId"));
                exam.setModuleId(resultSet.getString("moduleId"));
                exam.setResultState(resultSet.getString("resultState"));
                exam.setExamDuration(resultSet.getString("examDuration"));
                exam.setExamPassword(resultSet.getString("examPassword"));
                exam.setExamState(resultSet.getString("examState"));
                exam.setNumberOfQuestions(resultSet.getInt("noOfQuestion"));
                exam.setTotalMarks(resultSet.getInt("totalMarks"));
                examList.add(exam);
            }
        }
        catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error occured in getExamDetails() : ", e);
        }
        return examList;
    }

    /**
     *
     * @param examId
     * @return List of Exams specific to that Id
     */
    public List<Exam> getExamDetailsStream(String examId) {
        return examList.stream()
                .filter(t -> t.getExamId().equals(examId))
                .collect(Collectors.toList());
    }

    /**
     *
     * @return Default Table Model to populate the jTable in View
     */
    public DefaultTableModel fillExamSummaryTable() {
        DefaultTableModel table = new DefaultTableModel(new Object[]{"Exam Id", "Module Id", "Exam Date", "Result"}, 0);

        examList.forEach((result) -> {
            table.addRow(new Object[]{result.getExamId(), result.getModuleId(), result.getExamDate(), result.getResultState()});
        });

        return table;
    }

    public int getStudentCountByExamId(String examId) {
        //get student count for each exam SELECT count(userId) FROM answer WHERE examId = ?
        int studentCount = 0;
        try {
            preparedStatement = CONNECTION.prepareStatement("SELECT count(userId) FROM answer WHERE examId = ?");
            preparedStatement.setString(1, examId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                studentCount = resultSet.getInt(1);
            }
        }
        catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error occured in getStudentCountByExamId() : ", e);
        }
        return studentCount;
    }

    public int getPassedStudentCountByExamId(String examId) {
        int passedCount = 0;
        try {
            preparedStatement = CONNECTION.prepareStatement("SELECT count(userId) FROM result WHERE examId = ? AND grade <> 'F'");
            preparedStatement.setString(1, examId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                passedCount = resultSet.getInt(1);
            }
        }
        catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error occured in getPassedStudentCountByExamId() : ", e);
        }
        return passedCount;
    }
}
