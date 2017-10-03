/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.exam.service;

import com.csse.exam.config.DBConnection;
import com.csse.exam.model.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author munsif
 */
public final class ResultService {

    private Result result;
    private ArrayList<Result> resultList = new ArrayList<>();
    private static final Connection connection = DBConnection.getConnection();
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    public ResultService() {

    }

    public ArrayList<Result> getResult() {

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM result ");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result = new Result();
                result.setUserId(resultSet.getString("userId"));
                result.setExamId(resultSet.getString("examId"));
                result.setScore(resultSet.getString("score"));
                resultList.add(result);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public List<Result> getExamIdByStudentId(String studentId) {
        return resultList.stream()
                .filter(t -> t.getUserId().equals(studentId))
                .collect(Collectors.toList());

    }

    public List<Result> getScoreByStudentIdExamId(String studentId, String examId) {
        return resultList.stream()
                .filter(t -> t.getUserId().equals(studentId) && t.getExamId().equals(examId))
                .collect(Collectors.toList());
    }

    public char getGrade(int score) {

        char grade;
        if (score <= 100 && score > 75) {
            grade = 'A';
        } else if (score <= 75 && score > 50) {
            grade = 'B';
        } else if (score <= 50 && score > 35) {
            grade = 'C';
        } else {
            grade = 'F';
        }
        return grade;
    }
}
