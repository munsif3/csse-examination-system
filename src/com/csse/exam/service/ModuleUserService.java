/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.exam.service;

import com.csse.exam.common.Validation;
import com.csse.exam.config.DBConnection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ModuleUserService {

    private String moduleId;

    /**
     * This method will validate the module fields
     *
     * @param moduleName
     * @param password
     * @return
     */
    public boolean validateValues(String moduleName, String password) {
        Validation validation = new Validation();
        if (validation.checkTextNull(moduleName) || validation.checkTextNull(password)) {
            JOptionPane.showMessageDialog(null, "You can't keep fields empty");
            return false;
        } else {
            return true;
        }
    }

    /**
     * This method will generate new module id
     *
     * @return
     */
    public String getNewModuleId() {
        String lastModuleId = null;
        String newModuleId = null;

        try {

            Connection con = DBConnection.getConnection();
            String query = "SELECT moduleId FROM module\n"
                    + "order by moduleId desc limit 1;";
            PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);

            // execute the preparedstatement
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next()) {
                lastModuleId = rs.getString("moduleId");
            }
            String last3 = lastModuleId.substring(lastModuleId.length() - 3);
            newModuleId = lastModuleId.substring(0, 4) + String.valueOf(Integer.parseInt(last3) + 1);

            con.close();

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return newModuleId;
    }

    /**
     * this method will generate allocated year and semester
     *
     * @param year
     * @param semester
     * @return
     */
    public String getAllocatedYearAndSemester(int year, int semester) {
        String yearPrefix = null;
        String semesterPrefix = null;
        String allocatedTo;

        switch (year) {
            case (0):
                yearPrefix = "Y1";
                break;
            case (1):
                yearPrefix = "Y2";
                break;
            case (2):
                yearPrefix = "Y3";
                break;
            case (3):
                yearPrefix = "Y4";
                break;
        }
        switch (semester) {
            case (0):
                semesterPrefix = "S1";
                break;
            case (1):
                semesterPrefix = "S2";
                break;
        }

        allocatedTo = yearPrefix + semesterPrefix;
        return allocatedTo;
    }

    public void setModuleID(String id) {
        moduleId = id;
    }

    public String getModuleID() {
        return moduleId;
    }

}
