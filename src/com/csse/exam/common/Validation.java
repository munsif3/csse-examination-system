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
import java.awt.Component;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class Validation {

    Connection conn = null;
<<<<<<< HEAD
   
        public static boolean checkTextNull(String text){
            if(text.length()==0)// Checking for empty field
            {  
=======
    User user;

    //to check the login credentials 
    public boolean validateLogin(String username, String password) {
        try {
            conn = (Connection) DBConnection.getConnection();
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement("Select * from user where username=? and userPassword=?");
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                user = new User(rs.getString("userId"), rs.getString("name"), rs.getString("role"), rs.getString("username"), rs.getString("userPassword"));
//                    JOptionPane.showMessageDialog(null, "Name is" +rs.getString("name") );
>>>>>>> 4a0c5aaf1768a95f6b4b549b23617a2a409ffaa6
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkTextNull(String text) {
        if (text.length() == 0)// Checking for empty field
        {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param number
     * @return
     */
    public boolean checkNumberBox(String number) {
        return (number.matches("[0-9]+"));
    }

    /**
     *
     * @param numbers[]
     * @return
     */
    public boolean checkOverAllNumberBox(String numbers[]) {
        boolean value = true;
        for (String number : numbers) {
            value = checkNumberBox(number);
            if (value == false) {
                return value;
            }
        }
        return value;
    }

    public boolean checkTextBox(String text) {
        return (text.matches("[A-Za-z]+"));
    }

    /**
     *
     * @param text[]
     * @return
     */
    public boolean checkOverAllTextBox(String text[]) {
        boolean value = true;
        for (String word : text) {
            value = checkTextBox(word);
            if (value == false) {
                return value;
            }
        }
        return value;
    }

    /**
     *
     * @param panel
     * @return
     */
    public boolean checkEmptyTextBox(JPanel panel) {
        Component components[] = panel.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                JTextField textBox = (JTextField) component;
                System.out.println(textBox.getText());

                if (textBox.getText().equals("")) {
                    return true;
                }
            }
        }
        return false;
    }

}
