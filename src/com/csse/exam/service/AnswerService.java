/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.exam.service;

import com.csse.exam.config.DBConnection;
import com.csse.exam.model.Answer;
import com.csse.exam.model.Question;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

/**
 *
 * @author munsif
 */
public class AnswerService {

    private static final Connection CONNECTION = DBConnection.getConnection();
    public static final Logger LOGGER = Logger.getLogger(ResultService.class.getName());

    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    private Question question;
    private ArrayList<Question> questionList = new ArrayList<>();

    private static Handler fileHandler = null;
    private static Handler consoleHandler = null;

    /**
     * Constructor to initialize the logger specific tasks
     */
    public AnswerService() {
        try {
            consoleHandler = new ConsoleHandler();
            fileHandler = new FileHandler("./logs/answerservice/log_answer_service.log", true);

            LOGGER.addHandler(consoleHandler);
            LOGGER.addHandler(fileHandler);

            consoleHandler.setLevel(Level.ALL);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.setLevel(Level.ALL);

            LOGGER.info("Result Service Initiated");
        }
        catch (IOException | SecurityException e) {
            LOGGER.log(Level.SEVERE, "Error occur in FileHandler : ", e);
        }
    }

    /**
     *
     * @return ArrayList of type Answer and complete extraction of the result
     *         table
     */
    public ArrayList<Question> getQuestions() {
        try {
            preparedStatement = CONNECTION.prepareStatement("SELECT * FROM question");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                question = new Question();
                question.setExamId(resultSet.getString("examId"));
                question.setQuestionId(resultSet.getString("questionId"));
                question.setQuestion(resultSet.getString("question"));
                question.setOptions(resultSet.getString("options"));
                question.setFlag(resultSet.getString("flag"));
                question.setAnswer(resultSet.getString("answer"));
                questionList.add(question);
            }

        }
        catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error occur in getAnswers() : ", e);
        }
        return questionList;
    }

    /**
     *
     * @param examId
     * @return List of ExamId particular to that User
     */
    public List<Question> getQuestionId(String examId) {
        return questionList.stream()
                .filter(t -> t.getExamId().equals(examId))
                .collect(Collectors.toList());

    }

    /**
     *
     * @param examId
     * @param questionId
     * @return List of Questions filtered by UserId and ExamId
     */
    public List<Question> getQuestion(String examId, String questionId) {
        return questionList.stream()
                .filter(t -> t.getExamId().equals(examId) && t.getQuestionId().equals(questionId))
                .collect(Collectors.toList());
    }
}
