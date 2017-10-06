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
public class Module {
    
    private String moduleID;
    private String moduleName;
    private String modulePassword;
    private String allocatedTo;

    public Module(String moduleID, String moduleName, String modulePassword, String allocatedTo) {
        this.moduleID = moduleID;
        this.moduleName = moduleName;
        this.modulePassword = modulePassword;
        this.allocatedTo = allocatedTo;
    }
    
    public String getModuleID() {
        return moduleID;
    }

    public String getModuleName() {
        return moduleName;
    }

    public String getModulePassword() {
        return modulePassword;
    }

    public String getAllocatedTo() {
        return allocatedTo;
    }
    
    
    
}
