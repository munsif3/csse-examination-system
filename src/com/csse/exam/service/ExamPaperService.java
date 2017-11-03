/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.exam.service;

import com.csse.exam.config.DBConnection;
import com.csse.exam.model.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Saranki
 */

 
public class ExamPaperService 
{
    private static final Connection connection = DBConnection.getConnection();
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;
    Question question;
    private ArrayList<Question> questionList = new ArrayList<>();
       
    public ArrayList<Question> getQuestions() {

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM question");
            resultSet = preparedStatement.executeQuery();  

            while (resultSet.next()) {
                question = new Question();
                question.setExamId(resultSet.getString("examId"));
                question.setQuestionId(resultSet.getString("questionId"));
                question.setQuestion(resultSet.getString("question"));                        
                question.setOptions(resultSet.getString("options"));
                questionList.add(question);
            }

        }
        catch (SQLException e) {
            
        }
        return questionList;
    }
    
    public List<Question> getQuestionId(String examId) {
        return questionList.stream()
                .filter(t -> t.getExamId().equals(examId))
                .collect(Collectors.toList());

    }
    
    public List<Question> getQuestion(String examId, String questionId) {
        return questionList.stream()
                .filter(t -> t.getExamId().equals(examId) && t.getQuestionId().equals(questionId))
                .collect(Collectors.toList());
    }

}
