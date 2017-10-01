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
   
        public static boolean checkTextNull(String text){
            if(text.length()==0)// Checking for empty field
            {  
                return true;
            }
            else{
                return false;
            }
        }
        
        
}
