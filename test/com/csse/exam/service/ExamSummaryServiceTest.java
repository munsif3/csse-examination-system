/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.exam.service;

import com.csse.exam.model.Exam;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
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
public class ExamSummaryServiceTest {
    
    public ExamSummaryServiceTest() {
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
     * Test of getStudentCountByExamId method, of class ExamSummaryService.
     */
    @Test
    public void testGetStudentCountByExamId() {
        System.out.println("getStudentCountByExamId");
        String examId = "MO001-ASSIGNMENT-E:02";
        ExamSummaryService instance = new ExamSummaryService();
        int expResult = 2;
        int result = instance.getStudentCountByExamId(examId);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassedStudentCountByExamId method, of class ExamSummaryService.
     */
    @Test
    public void testGetPassedStudentCountByExamId() {
        System.out.println("getPassedStudentCountByExamId");
        String examId = "MO001-ASSIGNMENT-E:02";
        ExamSummaryService instance = new ExamSummaryService();
        int expResult = 2;
        int result = instance.getPassedStudentCountByExamId(examId);
        assertEquals(expResult, result);
    }
    
}
