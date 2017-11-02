/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.exam.common;

import com.csse.exam.config.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

/**
 *
 * @author Saranki
 */
public class CommonComponents 
{
    Connection connection = DBConnection.getConnection();
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    /**
     * 
     * @param comboBox
     * @param table
     * @param column  
     */
    public void addValueToComboBox(JComboBox comboBox, String table, String column) {
        
        String value = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT DISTINCT " + column + " FROM " + table);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next())
            {
               value =  resultSet.getString(column); 
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
