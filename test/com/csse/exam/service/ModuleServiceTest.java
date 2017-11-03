/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.exam.service;

import com.csse.exam.model.Exam;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Neruppuda
 */
public class ModuleServiceTest {
    DateFormat oDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public ModuleServiceTest() {
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
     * Test of enrollToModule method, of class ModuleService.
     */
    @Test
    public void testEnrollToModule() {
        System.out.println("enrollToModule");
        String enrollmentKey = "CSS";
        String module = "MO001";
        ModuleService instance = new ModuleService();
        boolean expResult = false;
        boolean result = instance.enrollToModule(enrollmentKey, module);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetEnrollementKey(){
        String key="csse";
        String module="MO001";
        ModuleService instance = new ModuleService();
        String enrollMentKeyFromMethod = instance.getEnrollementKey(module);
        assertEquals(key, enrollMentKeyFromMethod);
    }

    @Test
    public void testGetExam() throws ParseException{
        ExamService examService = new ExamService();
        String examLink="MO001-ASSIGNMENT-E:02";
        Exam exam = new Exam("MO001-ASSIGNMENT-E:02","45 mins","MO001",oDateFormat.parse("2017-11-12"),20,20,"Enabled","1234");
        Exam examFromMethod = examService.getExam(examLink);
        assertEquals(exam, examFromMethod);
   }
   
}
