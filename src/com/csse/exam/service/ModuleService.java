/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.exam.service;

import com.csse.exam.config.DBConnection;
import com.csse.exam.main.Login;
import com.csse.exam.model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Neruppuda
 */
public class ModuleService {

    private  ResultSet resultSet;
    private static  User user;
    public ModuleService(){
       this.user=new Login().user;
        
    }
    public static void main(String[] args) {
        ModuleService moduleService= new ModuleService();
       for(String modules: moduleService.getModulesByStudentId()){
           System.out.println(modules);
       }
        System.out.println(user.getUserId());
    }

    public List<String> getModulesByStudentId() {
        List<String> moduleList;
        moduleList = new ArrayList<>();
        try (Connection dbConnection = DBConnection.getConnection()) {
            resultSet = dbConnection.createStatement().executeQuery("select m.moduleName from student s, module m where s.currentYear=m.allocatedTo and s.userId='"+user.getUserId()+"'");
            while (resultSet.next()) {
                moduleList.add(resultSet.getString("moduleName"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return moduleList;
    }
    
    private String getEnrollementKey(){
        String enrollmentKey = null;
        
        try (Connection dbConnection = DBConnection.getConnection()) {
            resultSet = dbConnection.createStatement().executeQuery("select m.moduleName from student s, module m where s.currentYear=m.allocatedTo and s.userId='"+user.getUserId()+"'");
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
}
