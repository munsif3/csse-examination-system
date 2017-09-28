/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.exam.common;

import com.csse.exam.config.DBConnection;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.csse.exam.model.User;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Validation {
    
    Connection conn = null;
    User user;
    
        //to check the login credentials 
        public boolean validateLogin(String username,String password) {
            try{              
                 conn = (Connection) DBConnection.getConnection();
                PreparedStatement pst = (PreparedStatement) conn.prepareStatement("Select * from user where username=? and userPassword=?");
                pst.setString(1, username); 
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery(); 
                
                if(rs.next()){
                    user= new User(rs.getString("userId"),rs.getString("name"),rs.getString("role"),rs.getString("username"),rs.getString("userPassword"));
//                    JOptionPane.showMessageDialog(null, "Name is" +rs.getString("name") );
                    return true;    
            }else
                    return false;            
            }
            catch(Exception e){
                e.printStackTrace();
                return false;
            }       
} 
        
        public boolean checkTextNull(String text){
            if(text.length()==0)// Checking for empty field
            {  
                return true;
            }
            else{
                return false;
            }
        }
        
        
}
