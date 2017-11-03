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
 * @author munsif
 */
public class ResultServiceTest {
    
    public ResultServiceTest() {
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
     * Test of getGrade method, of class ResultService.
     */
    @Test
    public void testGetGrade() {
        System.out.println("getGrade");
        int score = 85;
        ResultService instance = new ResultService();
        char expResult = 'A';
        char result = instance.getGrade(score);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateScore method, of class ResultService.
     */
    @Test
    public void testUpdateScore() {
        System.out.println("updateScore");
        String studentId = "ST001";
        String examId = "MO001-ASSIGNMENT-E:02";
        char grade = 'A';
        int score = 88;
        ResultService instance = new ResultService();
        boolean expResult = true;
        boolean result = instance.updateScore(studentId, examId, grade, score);
        assertEquals(expResult, result);
    }
    
}
