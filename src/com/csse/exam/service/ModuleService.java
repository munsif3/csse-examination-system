/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.exam.service;

import com.csse.exam.config.DBConnection;
import com.csse.exam.model.Exam;
import com.csse.exam.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Neruppuda
 */
public class ModuleService {

    private ResultSet resultSet;
    public Exam exam;
    DateFormat oDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public ModuleService() {

    }

    public static void main(String[] args) {
        ModuleService moduleService = new ModuleService();
        for (Map.Entry<String, String> modules : moduleService.getModulesByStudentId(User.getUserId()).entrySet()) {
            System.out.println(modules.getKey() + " " + modules.getValue());
        }
        System.out.println(User.getUserId());
    }

    public HashMap<String, String> getModulesByStudentId(String studentId) {
        Map<String, String> moduleMap = new HashMap<String, String>();
        try (Connection dbConnection = DBConnection.getConnection()) {
            resultSet = dbConnection.createStatement().executeQuery("select m.moduleName , m.moduleId from student s, module m where s.currentYear=m.allocatedTo and s.userId='" + studentId + "'");
            while (resultSet.next()) {
                moduleMap.put(resultSet.getString("moduleId"), resultSet.getString("moduleName"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (HashMap<String, String>) moduleMap;
    }

    private String getEnrollementKey(String module) {
        String enrollmentKey = null;
        try (Connection dbConnection = DBConnection.getConnection()) {
            resultSet = dbConnection.createStatement().executeQuery("select modulePassword from module where moduleId='" + module + "'");
            while (resultSet.next()) {
                enrollmentKey = resultSet.getString("modulePassword");
                return enrollmentKey;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return enrollmentKey;
    }

    public boolean enrollToModule(String enrollmentKey, String module) {
        return enrollmentKey.equals(getEnrollementKey(module));
    }

    public ArrayList<Exam> getExamsByModuleId(String moduleId) {

        ArrayList<Exam> exams = new ArrayList<Exam>();
        try (Connection dbConnection = DBConnection.getConnection()) {
            resultSet = dbConnection.createStatement().executeQuery("select * from exam  where examDate > CURDATE() and moduleId = '" + moduleId + "' and examState = 'Enabled'");
            while (resultSet.next()) {
                exams.add(new Exam(resultSet.getString("examId"), resultSet.getString("examDuration"), resultSet.getString("moduleId"), oDateFormat.parse(resultSet.getString("examDate")), Integer.parseInt(resultSet.getString("noOfQuestion")), Integer.parseInt(resultSet.getString("totalMarks")), resultSet.getString("examState"), resultSet.getString("examPassword")));
            }

        } catch (ParseException | SQLException e) {
            e.printStackTrace();
        }
        return (ArrayList<Exam>) exams;
    }

    public ArrayList<Exam> getExamsByStudentId() {
        ArrayList<Exam> exams = new ArrayList<Exam>();
        try (Connection dbConnection = DBConnection.getConnection()) {
            resultSet = dbConnection.createStatement().executeQuery("select * from exam e where e.examDate > CURDATE()  and e.moduleId in (select m.moduleId from module m , student s where m.allocatedTo=s.currentYear and s.userId='" + User.getUserId() + "')");
            while (resultSet.next()) {
                exams.add(new Exam(resultSet.getString("examId"), resultSet.getString("examDuration"), resultSet.getString("moduleId"), oDateFormat.parse(resultSet.getString("examDate")), Integer.parseInt(resultSet.getString("noOfQuestion")), Integer.parseInt(resultSet.getString("totalMarks")), resultSet.getString("examState"), resultSet.getString("examPassword")));
            }

        } catch (ParseException | SQLException e) {
            e.printStackTrace();
        }
        return (ArrayList<Exam>) exams;
    }

    public String getAllEnrolledModules() {
        String modules = null;
        try (Connection dbConnection = DBConnection.getConnection()) {
            resultSet = dbConnection.createStatement().executeQuery("select enrolledModules from student where userId='" + User.getUserId() + "'");
            while (resultSet.next()) {
                modules = resultSet.getString("enrolledModules");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modules;
    }

    public boolean checkEnrolledModule(String selectedModule) {
        if (getAllEnrolledModules() != null || "".equals(getAllEnrolledModules())) {
            List<String> moduleList = Arrays.asList(getAllEnrolledModules().split(","));
            if (moduleList.contains(selectedModule)) {
                return true;
            }
        }
        return false;
    }

    public void updateEnrolledModules(String studentId, String module) {
        String modules = null;
        try (Connection dbConnection = DBConnection.getConnection()) {
            resultSet = dbConnection.createStatement().executeQuery("select enrolledModules from student where userId='" + User.getUserId() + "'");
            while (resultSet.next()) {
                modules = resultSet.getString("enrolledModules");
            }
            if (modules == null || "".equals(modules)) {
                modules = module + ",";
            } else {
                if (modules.split(",").length == 1) {
                    modules = modules.substring(0, modules.length() - 1);
                }

                modules = modules + "," + module;
            }

            dbConnection.createStatement().executeUpdate("UPDATE student SET enrolledModules = '" + modules + "' WHERE userId='" + studentId + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Map<String, String> getAllModules() {
//        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement;
        ResultSet rs;
        Map<String, String> moduleMap = new HashMap<>();
        try (Connection connection = DBConnection.getConnection()) {
            preparedStatement = connection.prepareStatement("SELECT moduleId, moduleName FROM module");

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                moduleMap.put(rs.getString("moduleId"), rs.getString("moduleName"));
            }
        } catch (SQLException e) {

        }
        return moduleMap;
    }
}
