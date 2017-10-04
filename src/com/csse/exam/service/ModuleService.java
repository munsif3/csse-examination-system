/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.exam.service;

import com.csse.exam.config.DBConnection;
import com.csse.exam.main.Login;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Neruppuda
 */
public class ModuleService {

    private  ResultSet resultSet;
    public static Login login = new Login();
   // private static  String userId = login.getUser().getUserId();
    public ModuleService(){
       
        
    }
    public static void main(String[] args) {
        ModuleService moduleService= new ModuleService();
       for(Map.Entry<String,String> modules: moduleService.getModulesByStudentId().entrySet()){
           System.out.println(modules.getKey()+" "+modules.getValue());
       }
        //System.out.println(userId);
    }
    public HashMap<String,String> getModulesByStudentId() {
        Map<String,String>  moduleMap = new HashMap<String, String>();
        try (Connection dbConnection = DBConnection.getConnection()) {
            resultSet = dbConnection.createStatement().executeQuery("select m.moduleName , m.moduleId from student s, module m where s.currentYear=m.allocatedTo and s.userId='ST001'");
            while (resultSet.next()) {
                moduleMap.put(resultSet.getString("moduleId"), resultSet.getString("moduleName"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (HashMap<String, String>) moduleMap;
    }
    
    private String getEnrollementKey(){
        String enrollmentKey = null;
        
        try (Connection dbConnection = DBConnection.getConnection()) {
            resultSet = dbConnection.createStatement().executeQuery("select m.moduleName from student s, module m where s.currentYear=m.allocatedTo and s.userId='ST001'");
            while (resultSet.next()) {
             enrollmentKey=resultSet.getString("moduleName");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
       
        return enrollmentKey;
    }
    public boolean enrollToModule(String enrollmentKey){
        return enrollmentKey.equals(getEnrollementKey());
    }
    
    private HashMap<String,String> getExamsByModuleId(String moduleId){
        Map<String,String> exams = new HashMap<String,String>();
        try (Connection dbConnection = DBConnection.getConnection()) {
            resultSet = dbConnection.createStatement().executeQuery("select examId,examPassword from exam where moduleId = '"+moduleId+"' and examState = 'Enabled'");
            while (resultSet.next()) {
                exams.put(resultSet.getString("examId"), resultSet.getString("examPassword"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (HashMap<String, String>) exams;
    }
}
