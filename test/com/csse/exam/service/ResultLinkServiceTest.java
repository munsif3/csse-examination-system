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
public class ResultLinkServiceTest {
    
    public ResultLinkServiceTest() {
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
     * Test of updateResultLinkStatus method, of class ResultLinkService.
     */
    @Test
    public void testUpdateResultLinkStatus() {
        System.out.println("updateResultLinkStatus");
        String resultState = "Enabled";
        String examId = "MO001-ASSIGNMENT-E:08";
        ResultLinkService instance = new ResultLinkService();
        boolean expResult = true;
        boolean result = instance.updateResultLinkStatus(resultState, examId);
        assertEquals(expResult, result);
    }    
}
