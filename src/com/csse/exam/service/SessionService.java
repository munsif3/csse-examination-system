/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.exam.service;

import com.csse.exam.config.DBConnection;
import com.csse.exam.model.Session;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author saranki
 */
public class SessionService {
    
    private static final Connection connection = DBConnection.getConnection();
    private Session session;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;
    private ArrayList<Session> sessionList = new ArrayList<>();
    DefaultTableModel tableModel;
    
    
    
    /**
     * This method will get the necessary attributes from the relevant tables and load the values to the specified table.
     * @param table - This is the table to which we will be loading the values
     */
    public void fillSessionDetailsTable(JTable table)
    {
       
        tableModel= (DefaultTableModel) table.getModel();       
        try
        {             
            preparedStatement = connection.prepareStatement("SELECT e.examId, e.moduleId, e.examDate,s.sessionId, s.examTime, s.examVenue FROM exam e, session s WHERE e.examId=s.examId");
            resultSet = preparedStatement.executeQuery();
            
            ResultSetMetaData resultMetaData = resultSet.getMetaData();
            int columnCount=resultMetaData.getColumnCount();           
            
            while(resultSet.next())
            {   
                
                Object[] objects = new Object[columnCount];
 
                for(int i=0;i<columnCount;i++)
                {
                    objects[i]=resultSet.getObject(i+1);
                }
                tableModel.addRow(objects);
            }
                    
            table.setModel(tableModel);
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }        
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Session> getSession() 
    {
        try
        {
            preparedStatement = connection.prepareStatement("SELECT e.examId, e.moduleId, e.examDate,s.sessionId, s.examTime, s.examVenue FROM exam e, session s");
            
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next())
            {
                session = new Session();
            
               session.setExamId(resultSet.getString("examId"));
               session.setModuleId(resultSet.getString("moduleId"));
               session.setExamDate(resultSet.getString("examDate"));
               session.setSessionId(resultSet.getInt("sessionId"));
               session.setExamTime(resultSet.getString("examTime"));
               session.setExamVenue(resultSet.getString("examVenue"));
               
               sessionList.add(session);
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return sessionList;
    }
   
   public DefaultTableModel fillSessionTable() {
        //DefaultTableModel table = new DefaultTableModel(new Object[]{"Student ID", "Exam ID", "Score"}, 0);

        sessionList.forEach((r) -> {
            tableModel.addRow(new Object[]{r.getExamId(), r.getModuleId(), r.getExamDate(), r.getSessionId(),r.getExamTime(), r.getExamVenue() });
        });

        return tableModel;
    }
   
   /**
    * 
    * @param examId
    * @param module
    * @param examDate
    * @param sessionId
    * @param examTime
    * @param examVenue 
    */
   public void getExamDetailsById(String examId, JTextField module, JTextField examDate) 
    {
        try
        {
            
            preparedStatement = connection.prepareStatement("SELECT examId, moduleId, examDate FROM exam WHERE examId=?");
            preparedStatement.setString(1, examId);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next())
            {
               module.setText(resultSet.getString("moduleId"));              
               examDate.setText(resultSet.getString("examDate"));
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }           
    }
   
   public boolean isExamIdExisting(String examId)
   {
       try
       {
           preparedStatement = connection.prepareStatement("SELECT examId FROM session WHERE examId=?");
           preparedStatement.setString(1, examId);
           resultSet = preparedStatement.executeQuery();
           
           if(resultSet.next())
           {
               return true;
           }
       }
       catch(SQLException e)
       {
           
       }
       return false;
   }
   
   public void getSessionDetailsById(String examId, JTextField module, JTextField examDate, JTextField sessionId, JSpinner examTime, JTextField examVenue) 
    {
        try
        {           
            preparedStatement = connection.prepareStatement("SELECT e.examId, e.moduleId, e.examDate,s.sessionId, s.examTime, s.examVenue FROM exam e, session s WHERE e.examId=s.examId and e.examId=?");
            preparedStatement.setString(1, examId);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next())
            {
               module.setText(resultSet.getString("moduleId"));              
               examDate.setText(resultSet.getString("examDate"));
               sessionId.setText(resultSet.getString("sessionId"));              
               examVenue.setText(resultSet.getString("examVenue"));
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }           
    }
   
   public String getLatestSessionId(String examId)
    {
        String sessionId = null;

        try {
            preparedStatement = connection.prepareStatement("SELECT MAX(sessionId)\n"
                    + "FROM session\n"
                    + "WHERE examId=?");
            preparedStatement.setString(1, examId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                sessionId = resultSet.getString(1);
            }
        } catch (SQLException e) {

        }
        return sessionId;
        
    }
   
   public String getSessionId(String examId)
    {
        String sessionId;
        String maxSessionId;
        int number;
        
        maxSessionId = getLatestSessionId(examId);
        
        if(maxSessionId == null)
        {
            sessionId = "1";
        }
        else
        {
            number = Integer.parseInt(maxSessionId) + 1;                     
            sessionId = String.valueOf(number);
        }
        return sessionId;
    }       
    
    public void getSessionIdByExamId(JComboBox comboBox, String examId) {
        //this is a test comment
        String value = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT DISTINCT sessionId FROM session WHERE examId=?");
            preparedStatement.setString(1, examId);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next())
            {
               value =  resultSet.getString("sessionId"); 
               if(value == null)
               {
                   value = "-";
               }
               comboBox.addItem(value);                
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
