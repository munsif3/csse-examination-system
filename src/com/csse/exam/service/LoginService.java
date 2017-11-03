/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.exam.service;

import com.csse.exam.config.DBConnection;
import com.csse.exam.model.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author User
 */
public class LoginService {
    
    Connection conn = null;
    User user;
    /**
     * This method is used to validate the login. Check the username and password entered an validate. 
     * @param username
     * @param password
     * @return 
     */
    public boolean validateLogin(String username, String password) {
        
        PreparedStatement pst;
        ResultSet rs;
        try {
            conn = (Connection) DBConnection.getConnection();            
            pst = (PreparedStatement) conn.prepareStatement("Select * from user where username=? and userPassword=?");
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();

            if (rs.next()) {
                user = new User(rs.getString("userId"), rs.getString("name"), rs.getString("role"), rs.getString("username"), rs.getString("userPassword"));
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
