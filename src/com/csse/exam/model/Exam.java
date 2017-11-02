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

    private String examId;
    private String examDuration;
    private String moduleId;
    private Date examDate;
    private int numberOfQuestions;
    private int totalMarks;
    private String examState;
    private String examPassword;
    private String resultState;

    public String getResultState() {
        return resultState;
    }

    public void setResultState(String resultState) {
        this.resultState = resultState;
    }

    public Exam() {

    }

    public Exam(String examId, String examDuration, String moduleId, Date examDate, int numberOfQuestions, int totalMarks, String examState, String examPassword) {
        this.examId = examId;
        this.examDuration = examDuration;
        this.moduleId = moduleId;
        this.examDate = examDate;
        this.numberOfQuestions = numberOfQuestions;
        this.totalMarks = totalMarks;
        this.examState = examState;
        this.examPassword = examPassword;

    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getExamDuration() {
        return examDuration;
    }

    public void setExamDuration(String examDuration) {
        this.examDuration = examDuration;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public String getExamState() {
        return examState;
    }

    public void setExamState(String examState) {
        this.examState = examState;
    }

    public String getExamPassword() {
        return examPassword;
    }

    public void setExamPassword(String examPassword) {
        this.examPassword = examPassword;
    }

}
