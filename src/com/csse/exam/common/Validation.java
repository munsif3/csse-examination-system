/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.exam.common;

import com.mysql.jdbc.Connection;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class Validation {

    Connection conn = null;


    public boolean checkTextNull(String text) {
        return text.length() == 0; // Checking for empty field
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
    public boolean checkEmptyTextBox(JPanel panel) 
    {
        Component components[] = panel.getComponents();
        for (Component component : components) 
        {
            if (component instanceof JTextField) 
            {   
                System.out.println("in1");
                JTextField textBox = (JTextField) component;
                System.out.println(textBox.getText());
                System.out.println("in2");
                if (textBox.getText().equals("")) 
                {
                    System.out.println("in3");
                    
                    return false;
                    
                }
                
            }
        }
        return true;
    }
    
    public boolean checkComboBox(JPanel panel) {
        Component components[] = panel.getComponents();
        for (Component component : components) {
            if (component instanceof JComboBox) {
                JComboBox comboBox = (JComboBox) component;
                
                if (comboBox.getSelectedIndex()==0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean checkModuleId(String moduleId)
    {
        String number = moduleId.substring(2);
        return((moduleId.startsWith("MO")) &&(checkNumberBox(number)));      
    }
    
    public boolean checkExamId(String examId, String moduleId, String examType)
    {
        return((examId.contains(moduleId)) && (examId.contains(examType)));        
    }

}
