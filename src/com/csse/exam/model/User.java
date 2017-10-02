/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.exam.model;

/**
 *
 * @author User
 */
public class User {
    private static String userId;
    private static String name;
    private static String role;
    private static String username;
    private static String userPassword;
  
    public static String getName() {
        return name;
    }

    public static String getRole() {
        return role;
    }
    
    public static void logout(){
        userId = null;
        name = null;
        role = null;
        username = null;
        userPassword = null;
    }
    
    public static int checkRole(){
        String role = getRole();
        if("admin".equals(role))
            return 0;
        else if("lecturer".equals(role))
            return 1;
        else 
            return 2;
    }
    

    public User(String userId, String name, String role, String username, String userPassword) {
        this.userId = userId;
        this.name = name;
        this.role = role;
        this.username = username;
        this.userPassword = userPassword;
    }

    public User() {
    }
    
    public static  String getUserId(){
        return userId;
    }
    
    
}
