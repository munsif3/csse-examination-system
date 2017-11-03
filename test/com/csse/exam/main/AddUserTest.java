/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.exam.main;

import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class AddUserTest {
    
    public AddUserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of validateValues method, of class AddUser.
     */
//    @Test
//    public void testValidateValues() {
//        System.out.println("validateValues");
//        AddUser instance = new AddUser();
//        boolean expResult = false;
//        boolean result = instance.validateValues();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getNewId method, of class AddUser.
     */
    @Test
    public void testGetNewId() {
        //System.out.println("getNewId");
        JOptionPane.showMessageDialog(null, "getNewId");
        boolean lecturer = true;
        boolean student = false;
        AddUser instance = new AddUser();
        String expResult = "LT002";
        String result = instance.getNewId(lecturer, student);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class AddUser.
     */
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        AddUser.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
