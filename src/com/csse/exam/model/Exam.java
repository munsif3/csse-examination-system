/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.exam.model;

import java.util.Date;

/**
 *
 * @author Neruppuda
 */
public class Exam {

    private static String examId;
    private static int examDuration;
    private static String moduleId;
    private static Date examDate;
    private static int numberOfQuestions;
    private static int totalMarks;
    private static String examState;
    private static String examPassword;

    public Exam() {

    }

    public Exam(String examId, int examDuration, String moduleId, Date examDate, int numberOfQuestions, int totalMarks, String examState, String examPassword) {
        this.examId = examId;
        this.examDuration = examDuration;
        this.moduleId = moduleId;
        this.examDate = examDate;
        this.numberOfQuestions = numberOfQuestions;
        this.totalMarks = totalMarks;
        this.examState = examState;
        this.examPassword = examPassword;

    }

    public static String getExamId() {
        return examId;
    }

    public static void setExamId(String examId) {
        Exam.examId = examId;
    }

    public static int getExamDuration() {
        return examDuration;
    }

    public static void setExamDuration(int examDuration) {
        Exam.examDuration = examDuration;
    }

    public static String getModuleId() {
        return moduleId;
    }

    public static void setModuleId(String moduleId) {
        Exam.moduleId = moduleId;
    }

    public static Date getExamDate() {
        return examDate;
    }

    public static void setExamDate(Date examDate) {
        Exam.examDate = examDate;
    }

    public static int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public static void setNumberOfQuestions(int numberOfQuestions) {
        Exam.numberOfQuestions = numberOfQuestions;
    }

    public static int getTotalMarks() {
        return totalMarks;
    }

    public static void setTotalMarks(int totalMarks) {
        Exam.totalMarks = totalMarks;
    }

    public static String getExamState() {
        return examState;
    }

    public static void setExamState(String examState) {
        Exam.examState = examState;
    }

    public static String getExamPassword() {
        return examPassword;
    }

    public static void setExamPassword(String examPassword) {
        Exam.examPassword = examPassword;
    }

}
