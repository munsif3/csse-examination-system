/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.exam.service;
import com.csse.exam.config.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author saranki
 */
public class LinkService 
{
    /**
     * Declare variables 
     */
    Connection con = DBConnection.getConnection();
    PreparedStatement preparedStatement ;
    ResultSet result;
    
    /**
     * Get exam id count 
     * @return row count
     */
    public int getRowCount() {
        int rowCount = 0;

        try {
            preparedStatement = con.prepareStatement("SELECT COUNT(examId) FROM exam");
             result = preparedStatement.executeQuery();

            while (result.next()) {
                rowCount = Integer.parseInt(result.getString(1));
            }
        } catch (SQLException e) {

        }
        return rowCount;
    }

    
    
    
    /**
     * Once an examId is selected the exam status of that exam id will be changed in the exam status combo box
     * @param examId
     * @return 
     */
    public String getExamLinkStatus(String examId) {
        String state = null;
        try {
            preparedStatement = con.prepareStatement("SELECT examState FROM exam WHERE examId=?");
            preparedStatement.setString(1, examId);
            result = preparedStatement.executeQuery();

            while (result.next()) {
                state = result.getString(1);
                if(state ==null)
               {
                   state = "-";
               }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return state;
    }
    
    /**
     * Get exam Link for an exam based on exam id
     * @param examId
     * @param table
     * @return examLink
     */

    public String[] getExamLink(String examId, String table) {
        String examLink[] = new String[2];

        try {

            preparedStatement = con.prepareStatement("SELECT examId,examDate FROM exam WHERE examId =?");
            preparedStatement.setString(1, examId);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                examLink[0] = result.getString(1);
                examLink[1] = result.getString(2);
                return examLink;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return examLink;
    }
    
    /**
     * Show exam link based on exam id
     * @param examId
     * @return 
     */
    public String showExamLink(String examId)
    {
        String linkName[] = getExamLink(examId, "exam");
        
        if((linkName[0] ==null) && (linkName[1] ==null))
        {
            return null;
        }
        else
            return(linkName[0] + linkName[1]);  
    
    }
    
    /**
     * Fill exam link table based on module id
     * @param table
     * @param moduleId 
     */
    public void fillExamLinkTable(JTable table, String moduleId)
    {
        System.out.println("from table "+moduleId);
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();       
        try
        {
            preparedStatement = con.prepareStatement("SELECT examId, moduleId, examDate, examState FROM exam WHERE moduleId=?");
            preparedStatement.setString(1, moduleId);
            result = preparedStatement.executeQuery();
            
            ResultSetMetaData resultMetaData = result.getMetaData();
            int columnCount=resultMetaData.getColumnCount();
            System.out.println(columnCount);
            
            while(result.next())
            {         
                Object[] objects = new Object[columnCount];
 
                for(int i=0;i<columnCount;i++)
                {
                    objects[i]=result.getObject(i+1);
                }
                tableModel.addRow(objects);
            }
                    
            table.setModel(tableModel);
        }
        catch(SQLException e)
        {
        
        }        
    }
    
    /**
     * update exam link status
     * @param examId
     * @param examState
     * @return boolean value
     */
    public boolean updateExamLinkStatus(String examId, String examState) {
        try {
            preparedStatement = con.prepareStatement("UPDATE exam SET examState=? WHERE examId=?");         
            preparedStatement.setString(1, examState);
            preparedStatement.setString(2, examId);
            int i = preparedStatement.executeUpdate();
            System.out.println(i + " records updated");            
            return true;
        } catch (SQLException e) {

        }
        return false;
    }
    
    /**
     * Add exam id to combo box based on exam module
     * @param comboBox
     * @param moduleId 
     */
    public void addValueToComboBoxBasedOnField(JComboBox comboBox, String moduleId) {

        String examId = null;
        try {
            preparedStatement = con.prepareStatement("SELECT DISTINCT examId FROM exam WHERE moduleId=?");
            preparedStatement.setString(1, moduleId);
            result = preparedStatement.executeQuery();

            while (result.next()) {
                examId = result.getString("examId");
                if (examId == null) {
                    examId = "-";
                }
                comboBox.addItem(examId);
            }

        } catch (SQLException e) {
            System.out.println("from link table");
            System.out.println(e);
        }
    }
}
