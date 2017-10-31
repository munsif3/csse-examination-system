/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.exam.service;

import com.csse.exam.config.DBConnection;
import com.csse.exam.model.Exam;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Saranki
 */
public final class ExamService 
{
    private static final Connection connection = DBConnection.getConnection();
    DateFormat oDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private Exam exam;
    private final ArrayList<Exam> examList = new ArrayList<>(); 
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;
    DefaultTableModel tableModel;
    public ExamService() 
    {
        
    }
    
    public ArrayList<Exam> getExam() {

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM exam ");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                exam = new Exam();         
                
                exam.setExamId(resultSet.getString("examId"));                
                exam.setExamDuration(resultSet.getString("examDuration"));
                exam.setModuleId(resultSet.getString("moduleId"));
                exam.setExamDate(resultSet.getDate("examDate"));
                exam.setNumberOfQuestions(resultSet.getInt("noOfQuestion"));
                exam.setTotalMarks(resultSet.getInt("totalMarks"));
                exam.setExamState(resultSet.getString("examState"));

                examList.add(exam);
            }

        } 
        catch (SQLException e) 
        {
            System.out.println(e);
        }
        return examList;
    }
    /**
     * 
     * @param examType
     * @return 
     */
    
    public String getLatestExamCode(String examType) {
        String examCode = null;

        try {
            preparedStatement = connection.prepareStatement("SELECT MAX(examId)\n"
                    + "FROM exam\n"
                    + "WHERE examId like'%" + examType + "%'");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                examCode = resultSet.getString(1);
            }
        } catch (SQLException e) {

        }
        return examCode;
    }
    
    /**
     * Get all the examId which contains the specified exam type.
     * @param examType
     * @return 
     */
    public List<Exam> getExamIdByExamType(String examType) {
        return examList.stream()
                .filter(t -> t.getExamId().contains(examType))
                .collect(Collectors.toList());
                

    }
    /**
     * 
     * @param examType
     * @param moduleId
     * @return 
     */
    public String getExamId(String examType, String moduleId)
    {
        String examId;
        String examNumber;
        String indexValue;
        String latestExamCode = getLatestExamCode(examType);        
        int newIndex;
        int index;

               
        if ((latestExamCode != null))
        {         
           examNumber = latestExamCode.split("-")[2].split(":")[1];
           index= Integer.parseInt(examNumber);
           newIndex = ++index;
        
            if(String.valueOf(newIndex).length()==1)
            {
                indexValue = "0"+String.valueOf(newIndex);           
            }
            else
            {
                indexValue = String.valueOf(newIndex);
            }                      
            examId = moduleId+"-"+examType+"-E:"+indexValue;
            return examId;           
        }  
        else
        {
            examId = moduleId+"-"+examType+"-E:01";
        }
        return examId;
    }
    
    public void fillExamDetailsTable(JTable table)
    {
       
        tableModel= (DefaultTableModel) table.getModel();       
        try
        {
             
            preparedStatement = connection.prepareStatement("SELECT examId,moduleId,examDate,examDuration,noOfQuestion,totalMarks FROM exam");
            resultSet = preparedStatement.executeQuery();
            
            ResultSetMetaData resultMetaData = resultSet.getMetaData();
            int columnCount=resultMetaData.getColumnCount();
            System.out.println(columnCount);
            
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
        
        }        
    }
    
    public boolean addExamdetails(String examId, String examDuration, String moduleId, int noOfQuestion, int totalMarks, String dateString) {
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO exam (examId, examDuration, moduleId, examDate, noOfQuestion, totalMarks)" + "VALUES(?,?,?,?,?,?)");
              
            preparedStatement.setString(1, examId);
            preparedStatement.setString(2, examDuration);
            preparedStatement.setString(3, moduleId);
            preparedStatement.setString(4, dateString);
            preparedStatement.setInt(5, noOfQuestion);
            preparedStatement.setInt(6, totalMarks);

            int i = preparedStatement.executeUpdate();
            System.out.println(i + " records updated");      
            
            return true;
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, "Exam details were not added", "Failure Message", 1);
        }
        return false;
    }
    
    public boolean updateExamDetails(String examDuration, int noOfQuestion, int totalMarks,String examId, String dateString){
        try {
            
            preparedStatement = connection.prepareStatement("UPDATE exam SET examDuration=?, examDate =?, noOfQuestion=?, totalMarks=? WHERE examId=?");         
            
            preparedStatement.setString(1, examDuration);
            preparedStatement.setString(2, dateString);
            preparedStatement.setInt(3, noOfQuestion);
            preparedStatement.setInt(4, totalMarks);
            preparedStatement.setString(5, examId);
            
            int i = preparedStatement.executeUpdate();
            System.out.println(i + " records updated");            
            return true;
        } catch (SQLException e) {
                System.out.println(e);
        }        
        return false;
    }
  
    public Exam getExam(String examID){
        Exam exam = new Exam();
        try (Connection dbConnection = DBConnection.getConnection()) {
            resultSet = dbConnection.createStatement().executeQuery("select * from exam where examId='"+examID+"'");
            while (resultSet.next()) {
                exam.setExamId(resultSet.getString("examId"));
                exam.setExamDuration(resultSet.getString("examDuration"));
                exam.setModuleId(resultSet.getString("moduleId"));
                exam.setExamDate(oDateFormat.parse(resultSet.getString("examDate")));
                exam.setNumberOfQuestions(Integer.parseInt(resultSet.getString("noOfQuestion")));
                exam.setExamState(resultSet.getString("examState"));
                exam.setTotalMarks(Integer.parseInt(resultSet.getString("totalMarks")));
                exam.setExamPassword(resultSet.getString("examPassword"));
                
            }

        } catch (ParseException | SQLException e) {
            e.printStackTrace();
        }
        return exam;
    }
    
    public boolean validateExamPassword(String examId , String password){
        return password.equals(getExam(examId).getExamPassword());
    }
    

    public boolean valaidateExamDate(String examDate)
    {       
        return examDate == null;
    }
    
    public boolean deleteExamDetails(String examId){
        try {
            
            preparedStatement = connection.prepareStatement("DELETE FROM exam WHERE examId=?");                     
            preparedStatement.setString(1, examId);
            
            int i = preparedStatement.executeUpdate();
            System.out.println(i + " records deleted");            
            return true;
        } catch (SQLException e) {
                System.out.println(e);
        }        
        return false;

    }
    
   public void submitAnswers(long id , String examID, String userId,String answerSet){
        try (Connection dbConnection = DBConnection.getConnection()) {
             dbConnection.createStatement().executeUpdate("insert into student values('" +id + "','" + examID + "','" + userId + "','" + answerSet +"')");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
}
