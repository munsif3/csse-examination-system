/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.exam.common;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author saranki
 */
public class ClearComponents {
    /**
     * 
     * @param panel 
     */
     public void clearTextFields(JPanel panel) {
        Component components[] = panel.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField && component.isEnabled() == true) {
                JTextField textBox = (JTextField) component;
                textBox.setText("");
            }
        }
    }
    
     /**
      * 
      * @param panel 
      */
    public void resetComboBox(JPanel panel)
    {
        Component components[] = panel.getComponents();
        for (Component component : components) {
            if (component instanceof JComboBox) {
                JComboBox comboBox = (JComboBox) component;
                comboBox.setSelectedIndex(0);
            }
        }
    }
    
}
