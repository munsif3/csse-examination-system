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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class LinkService 
{
    /**
     * 
     */
    Connection con = DBConnection.getConnection();
    
    /**
     * 
     * @return 
     */
    public int getRowCount() {
        int rowCount = 0;

        try {
            PreparedStatement statement = con.prepareStatement("SELECT COUNT(examId) FROM exam");
            ResultSet result = statement.executeQuery();

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
            PreparedStatement statement = con.prepareStatement("SELECT examState FROM exam WHERE examId=?");
            statement.setString(1, examId);
            ResultSet result = statement.executeQuery();

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

    public String[] getExamLink(String examId, String table) {
        String examLink[] = new String[2];

        try {

            PreparedStatement statement = con.prepareStatement("SELECT examId,examDate FROM exam WHERE examId =?");
            statement.setString(1, examId);

            ResultSet result = statement.executeQuery();

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
    
    public void fillExamLinkTable(JTable table)
    {
       
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();       
        try
        {
            PreparedStatement statement = con.prepareStatement("SELECT examId, moduleId, examDate, examState FROM exam");
            ResultSet result = statement.executeQuery();
            
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
    
    public boolean updateExamLinkStatus(String examId, String examState) {
        try {
            PreparedStatement statement = con.prepareStatement("UPDATE exam SET examState=? WHERE examId=?");         
            statement.setString(1, examState);
            statement.setString(2, examId);
            int i = statement.executeUpdate();
            System.out.println(i + " records updated");            
            return true;
        } catch (SQLException e) {

        }
        return false;
    }
}
