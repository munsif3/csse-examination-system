/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.exam.model;

/**
 *
 * @author saranki
 */
public class Session {
    
    private static String examId;
    private static String moduleId;
    private static String examDate;
    private static String examTime;
    private static int sessionId;
    private static String examVenue;
    
    public Session(String examId, String moduleId, String examDate, String examTime,int sessionId,String examVenue)
    {
        Session.examId = examId;
        Session.moduleId = moduleId;
        Session.examDate = examDate;
        Session.examTime = examTime;
        Session.sessionId = sessionId;
        Session.examVenue = examVenue;
    }
    public Session()
    {
    
    }

    public static String getExamId() {
        return examId;
    }

    public static void setExamId(String examId) {
        Session.examId = examId;
    }

    public static String getModuleId() {
        return moduleId;
    }

    public static void setModuleId(String moduleId) {
        Session.moduleId = moduleId;
    }

    public static String getExamDate() {
        return examDate;
    }

    public static void setExamDate(String examDate) {
        Session.examDate = examDate;
    }

    public static String getExamTime() {
        return examTime;
    }

    public static void setExamTime(String examTime) {
        Session.examTime = examTime;
    }

    public static int getSessionId() {
        return sessionId;
    }

    public static void setSessionId(int sessionId) {
        Session.sessionId = sessionId;
    }

    public static String getExamVenue() {
        return examVenue;
    }

    public static void setExamVenue(String examVenue) {
        Session.examVenue = examVenue;
    }
    
    
}
