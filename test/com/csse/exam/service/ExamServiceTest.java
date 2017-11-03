/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.exam.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class ExamServiceTest {
    
    public ExamServiceTest() {
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
     * Test of getExamId method, of class ExamService.
     */
    @Test
    public void testGetExamId() {
        System.out.println("getExamId");
        String examType = "ASSIGNMENT";
        String moduleId = "MO001";
        ExamService instance = new ExamService();
        String expResult = "MO001-ASSIGNMENT-E:01";
        String result = instance.getExamId(examType, moduleId);
        assertEquals(expResult, result);

    }


    /**
     * Test of validateExamPassword method, of class ExamService.
     */
    @Test
    public void testValidateExamPassword() {
        System.out.println("validateExamPassword");
        String examId = "MO002-MID EXAM-E:01";
        String password = "1234";
        ExamService instance = new ExamService();
        boolean expResult = false;
        boolean result = instance.validateExamPassword(examId, password);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of valaidateExamDate method, of class ExamService.
     */
    @Test
    public void testValaidateExamDate() {
        System.out.println("valaidateExamDate");
        String examDate = "2017-12-28";
        ExamService instance = new ExamService();
        boolean expResult = false;
        boolean result = instance.valaidateExamDate(examDate);
        assertEquals(expResult, result);
        
    }

 
}
