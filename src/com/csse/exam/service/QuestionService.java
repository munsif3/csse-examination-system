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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author user
 */
public class QuestionService 
{
    private static final Connection connection = DBConnection.getConnection();    
    PreparedStatement preparedStatement;
    private static ResultSet resultSet;
    Question question;
    ArrayList<Question> list = new ArrayList<>();
  
    public Object[] getExamDetailsById(String examId)
    {
        Object[] objects = new Object[8];
         try {
            preparedStatement = connection.prepareStatement("SELECT examId,examDate,examDuration,noOfQuestion,totalMarks FROM exam WHERE examId=?");
            preparedStatement.setString(1, examId);
            resultSet = preparedStatement.executeQuery();
            
            ResultSetMetaData resultMetaData = resultSet.getMetaData();
            int columnCount=resultMetaData.getColumnCount();
             
             System.out.println("column count");
             System.out.println(columnCount);
            while (resultSet.next()) 
            {
                        
                for(int i=1; i<8; i++)
                {
                    objects[i] = resultSet.getString(i); 
                    if(objects[i] == null)
                    {
                        objects[i] = "-";
                    }
                    //System.out.println(objects[i]);
                }
               
            }

        } 
        catch (SQLException e) 
        {
            System.out.println(e);
        }
         
        return objects;
    }
    
    public String getLatestQuestionId(String examId, String moduleId)
    {
        String questionId = null;

        try {
            preparedStatement = connection.prepareStatement("SELECT MAX(q.questionId)\n"
                    + "FROM question q, exam e\n"
                    + "WHERE q.examId=e.examId AND e.examId=? AND e.moduleId=?");
            preparedStatement.setString(1, examId);
            preparedStatement.setString(2, moduleId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                questionId = resultSet.getString(1);
            }
        } catch (SQLException e) {

        }
        return questionId;
        
    }
    
    public String getQuestionId(String examId, String moduleId)
    {
        String questionId=null;
        String maxQuestionNo=null;
        int number = 0;
        
        maxQuestionNo = getLatestQuestionId(examId, moduleId);
        System.out.println("max no from get question id ="+maxQuestionNo);
        if(maxQuestionNo == null)
        {
            questionId = "Q01";
        }
        else
        {
            number = Integer.parseInt(maxQuestionNo.split("Q")[1]) + 1;
            if(number < 10)
            {
                questionId = "Q0"+String.valueOf(number);
            }
            else
            {
                questionId = "Q"+String.valueOf(number);
            }
            
        }
        
        return questionId;
    }
    
    public boolean addQuestion(String examId, String questionId, String question, String options) {
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO question (examId, questionId, question, options)" + "VALUES(?,?,?,?)");
              
            preparedStatement.setString(1, examId);
            preparedStatement.setString(2, questionId);
            preparedStatement.setString(3, question);           
            preparedStatement.setString(4, options);

            int i = preparedStatement.executeUpdate();
            System.out.println(i + " records updated");      
            
            return true;
        } 
        catch (SQLException e) 
        {
            System.out.println(e);
        }
        return false;
    }
    
    public boolean updateQuestion(String examId, String questionId, String question, String options){
        try {
            
            preparedStatement = connection.prepareStatement("UPDATE question SET question=?, options =? WHERE examId=? AND questionId=?");         
            
            preparedStatement.setString(1, question);
            preparedStatement.setString(2, options);
            preparedStatement.setString(3, examId);
            preparedStatement.setString(4, questionId);
            
            int i = preparedStatement.executeUpdate();
            System.out.println(i + " records updated");            
            return true;
        } catch (SQLException e) {
                System.out.println(e);
        }        
        return false;
    }
    
    public void addValueToComboBoxBasedOnField(JComboBox comboBox, String moduleId) {

        String value = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT DISTINCT examId FROM exam WHERE moduleId=?");
            preparedStatement.setString(1, moduleId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                value = resultSet.getString("examId");
                if (value == null) {
                    value = "-";
                }
                comboBox.addItem(value);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
