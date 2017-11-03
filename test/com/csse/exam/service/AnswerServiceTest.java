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
public class AnswerServiceTest {
    
    public AnswerServiceTest() {
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
     * Test of updateCorrectAnswer method, of class AnswerService.
     */
    @Test
    public void testUpdateCorrectAnswer() {
        System.out.println("updateCorrectAnswer");
        String answer = "1";
        String examId = "MO001-ASSIGNMENT-E:02";
        String questionId = "Q04";
        AnswerService instance = new AnswerService();
        boolean expResult = true;
        boolean result = instance.updateCorrectAnswer(answer, examId, questionId);
        assertEquals(expResult, result);
    }
    
}
