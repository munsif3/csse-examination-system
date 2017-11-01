/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.exam.model;

/**
 *
 * @author munsif
 */
public class Answer {
    private String userId;
    private String examId;
    private String answer;

    /**
     *
     * @return userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 
     * @param userId set the userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 
     * @return examId
     */
    public String getExamId() {
        return examId;
    }

    /**
     * 
     * @param examId set the examId
     */
    public void setExamId(String examId) {
        this.examId = examId;
    }

    /**
     * 
     * @return answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * 
     * @param answer set the answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
