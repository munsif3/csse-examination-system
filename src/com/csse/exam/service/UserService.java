/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.exam.service;

import com.csse.exam.common.Validation;
import com.csse.exam.config.DBConnection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class UserService {
    
     public boolean validateValues(String name,String username,String password)
    {           
        Validation validation = new Validation();
        if (validation.checkTextNull(name) || validation.checkTextNull(username) || validation.checkTextNull(password)) {
            JOptionPane.showMessageDialog(null, "You can't keep fields empty");
            return false;
        } 
        else {
            return true;
        }
    }
    
    public String getNewId(boolean lecturer, boolean student){
        String rolePrefix;
        String lastUserId = null;
        String newUserId = null;
        if(lecturer)
            rolePrefix = "LT%";
        else
            rolePrefix = "ST%";
        try {
               
                Connection con = DBConnection.getConnection();
                String query = " SELECT userId FROM user\n" +
                                "where userId like ?\n" +
                                "order by userId desc limit 1;";
                PreparedStatement preparedStmt;
                preparedStmt = (PreparedStatement) con.prepareStatement(query);
                preparedStmt.setString (1, rolePrefix);
                
                // execute the preparedstatement
                ResultSet rs; 
                rs = preparedStmt.executeQuery();
                if(rs.next()){
                    lastUserId = rs.getString("userId");
                }
                String last3;
                last3 = lastUserId.substring(lastUserId.length() - 3);
                newUserId = lastUserId.substring(0,4)+String.valueOf(Integer.parseInt(last3) + 1);
                
                con.close();

                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
        return newUserId;
    }
    
    public void addUser(String name,String username,String password,boolean lecturer,boolean student)
    {
        String role;
        if(validateValues(name,username,password))
        {         
           if(lecturer){
               role = "lecturer";
           }
           else
               role = "student";
           
           try {
               
                Connection con = DBConnection.getConnection();
                String query = " insert into user (userId,name,role,username,userPassword)"
                 + " values (?, ?, ?, ?, ?)";
                PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
                preparedStmt.setString(1,  getNewId(lecturer,student));
                preparedStmt.setString(2, name);
                preparedStmt.setString(3, role);
                preparedStmt.setString(4, username);
                preparedStmt.setString(5, password);

                // execute the preparedstatement
                preparedStmt.execute();

                con.close();
                JOptionPane.showMessageDialog(null, "Suceesfully Added!");
                                
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, e);
                }

        }
    }
}
