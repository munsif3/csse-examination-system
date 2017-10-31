/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.exam.main;

import com.csse.exam.common.ClearComponents;
import com.csse.exam.common.CommonComponents;
import com.csse.exam.service.LinkService;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Saranki
 */
public class ExamLink extends javax.swing.JFrame {

    /**
     * Creates new form ExamLink
     */
    
    LinkService linkService = new LinkService();
    ClearComponents clear = new ClearComponents();
    CommonComponents commonComponents = new CommonComponents();
    DefaultTableModel tableModel;  
    public ExamLink() {
        initComponents();
        commonComponents.addValueToComboBox(cmbExaminationCode, "exam", "examId");
        commonComponents.addValueToComboBox(cmbExaminationCodeSearch, "exam", "examId");
        linkService.fillExamLinkTable(tblExamLink);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlNavigation = new javax.swing.JPanel();
        pnlDashboard = new javax.swing.JPanel();
        lblDashboard = new javax.swing.JLabel();
        pnlCourse = new javax.swing.JPanel();
        lblCourse = new javax.swing.JLabel();
        pnlExam = new javax.swing.JPanel();
        lblExam = new javax.swing.JLabel();
        pnlResult = new javax.swing.JPanel();
        lblResult = new javax.swing.JLabel();
        pnlLogo = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        pnlSystem = new javax.swing.JPanel();
        lblSystem = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pnlContent = new javax.swing.JPanel();
        pnlExamLink = new javax.swing.JPanel();
        lblExamCode = new javax.swing.JLabel();
        lblExamLink = new javax.swing.JLabel();
        lblLinkStatus = new javax.swing.JLabel();
        cmbExaminationCode = new javax.swing.JComboBox<>();
        btnEnableLink = new javax.swing.JButton();
        btnClearAll = new javax.swing.JButton();
        btnBlockLink = new javax.swing.JButton();
        txtExamLinkAvailable = new javax.swing.JTextField();
        txtExamState = new javax.swing.JTextField();
        pnlExamLinkTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblExamLink = new javax.swing.JTable();
        lblExamCode1 = new javax.swing.JLabel();
        cmbExaminationCodeSearch = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EXAMINATION LINK");
        setMaximumSize(new java.awt.Dimension(950, 600));
        setMinimumSize(new java.awt.Dimension(950, 600));
        setPreferredSize(new java.awt.Dimension(950, 600));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlNavigation.setBackground(new java.awt.Color(105, 135, 170));
        pnlNavigation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlDashboard.setBackground(new java.awt.Color(70, 102, 144));
        pnlDashboard.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlDashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlDashboardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlDashboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlDashboardMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlDashboardMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnlDashboardMouseReleased(evt);
            }
        });

        lblDashboard.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lblDashboard.setForeground(new java.awt.Color(255, 255, 255));
        lblDashboard.setText("Dashboard");

        javax.swing.GroupLayout pnlDashboardLayout = new javax.swing.GroupLayout(pnlDashboard);
        pnlDashboard.setLayout(pnlDashboardLayout);
        pnlDashboardLayout.setHorizontalGroup(
            pnlDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlDashboardLayout.setVerticalGroup(
            pnlDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlNavigation.add(pnlDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 130, 50));

        pnlCourse.setBackground(new java.awt.Color(70, 102, 144));
        pnlCourse.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlCourse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlCourseMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnlCourseMouseReleased(evt);
            }
        });

        lblCourse.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lblCourse.setForeground(new java.awt.Color(255, 255, 255));
        lblCourse.setText("Course");
        lblCourse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pnlCourseLayout = new javax.swing.GroupLayout(pnlCourse);
        pnlCourse.setLayout(pnlCourseLayout);
        pnlCourseLayout.setHorizontalGroup(
            pnlCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCourseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCourse, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlCourseLayout.setVerticalGroup(
            pnlCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCourseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCourse, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlNavigation.add(pnlCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 130, 50));

        pnlExam.setBackground(new java.awt.Color(70, 102, 144));
        pnlExam.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlExam.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlExam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlExamMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnlExamMouseReleased(evt);
            }
        });

        lblExam.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lblExam.setForeground(new java.awt.Color(255, 255, 255));
        lblExam.setText("Exam");

        javax.swing.GroupLayout pnlExamLayout = new javax.swing.GroupLayout(pnlExam);
        pnlExam.setLayout(pnlExamLayout);
        pnlExamLayout.setHorizontalGroup(
            pnlExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlExamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblExam, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlExamLayout.setVerticalGroup(
            pnlExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlExamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblExam, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlNavigation.add(pnlExam, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 130, 50));

        pnlResult.setBackground(new java.awt.Color(70, 102, 144));
        pnlResult.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlResult.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlResult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlResultMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnlResultMouseReleased(evt);
            }
        });

        lblResult.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lblResult.setForeground(new java.awt.Color(255, 255, 255));
        lblResult.setText("Result");

        javax.swing.GroupLayout pnlResultLayout = new javax.swing.GroupLayout(pnlResult);
        pnlResult.setLayout(pnlResultLayout);
        pnlResultLayout.setHorizontalGroup(
            pnlResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblResult, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlResultLayout.setVerticalGroup(
            pnlResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblResult, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlNavigation.add(pnlResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 130, 50));

        pnlLogo.setBackground(new java.awt.Color(204, 217, 233));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/csse/exam/resource/SLIIT_Crest.png"))); // NOI18N

        javax.swing.GroupLayout pnlLogoLayout = new javax.swing.GroupLayout(pnlLogo);
        pnlLogo.setLayout(pnlLogoLayout);
        pnlLogoLayout.setHorizontalGroup(
            pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogoLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        pnlLogoLayout.setVerticalGroup(
            pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlNavigation.add(pnlLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 100));

        getContentPane().add(pnlNavigation, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 620));

        pnlSystem.setBackground(new java.awt.Color(105, 135, 170));
        pnlSystem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSystem.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        lblSystem.setForeground(new java.awt.Color(255, 255, 255));
        lblSystem.setText("MCQ EXAM SYSTEM");
        pnlSystem.add(lblSystem, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        lblUser.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUser.setText("BobTheBuilder");
        lblUser.setToolTipText("");
        pnlSystem.add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 10, 460, 20));

        lblLogout.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblLogout.setForeground(new java.awt.Color(204, 217, 233));
        lblLogout.setText("(LOGOUT)");
        lblLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlSystem.add(lblLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, -1, 20));

        jPanel2.setBackground(new java.awt.Color(70, 102, 144));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Examination Link Availability");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        pnlSystem.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 830, 40));

        getContentPane().add(pnlSystem, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 830, 100));

        pnlContent.setBackground(new java.awt.Color(204, 217, 233));
        pnlContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlExamLink.setBackground(new java.awt.Color(204, 217, 233));
        pnlExamLink.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlExamLink.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblExamCode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblExamCode.setText("EXAMINATION CODE :");
        pnlExamLink.add(lblExamCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, 30));

        lblExamLink.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblExamLink.setText("EXAMINATION LINK :");
        pnlExamLink.add(lblExamLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, 30));

        lblLinkStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLinkStatus.setText("LINK STATUS :");
        pnlExamLink.add(lblLinkStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, -1, 30));

        cmbExaminationCode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbExaminationCode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT EXAMINATION CODE" }));
        cmbExaminationCode.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbExaminationCodeItemStateChanged(evt);
            }
        });
        cmbExaminationCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbExaminationCodeActionPerformed(evt);
            }
        });
        cmbExaminationCode.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbExaminationCodePropertyChange(evt);
            }
        });
        pnlExamLink.add(cmbExaminationCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 220, 30));

        btnEnableLink.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEnableLink.setText("ENABLE LINK");
        btnEnableLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnableLinkMouseClicked(evt);
            }
        });
        pnlExamLink.add(btnEnableLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 180, 40));

        btnClearAll.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnClearAll.setText("CLEAR ALL");
        btnClearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClearAllMouseClicked(evt);
            }
        });
        pnlExamLink.add(btnClearAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 180, 40));

        btnBlockLink.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBlockLink.setText("BLOCK LINK");
        btnBlockLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBlockLinkMouseClicked(evt);
            }
        });
        pnlExamLink.add(btnBlockLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 180, 40));
        pnlExamLink.add(txtExamLinkAvailable, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 220, 30));
        pnlExamLink.add(txtExamState, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 220, 30));

        pnlContent.add(pnlExamLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 780, 190));

        pnlExamLinkTable.setBackground(new java.awt.Color(204, 217, 233));
        pnlExamLinkTable.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlExamLinkTable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblExamLink.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EXAMINATION CODE", "MODULE ID", "EXAMINATION DATE", "EXAM LINK STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblExamLink.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblExamLink);

        pnlExamLinkTable.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 760, 210));

        lblExamCode1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblExamCode1.setText("SEARCH EXAMINATION CODE :");
        pnlExamLinkTable.add(lblExamCode1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, 30));

        cmbExaminationCodeSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbExaminationCodeSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT EXAMINATION CODE" }));
        cmbExaminationCodeSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbExaminationCodeSearchActionPerformed(evt);
            }
        });
        pnlExamLinkTable.add(cmbExaminationCodeSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 220, 30));

        pnlContent.add(pnlExamLinkTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 780, 270));

        getContentPane().add(pnlContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 830, 520));

        setSize(new java.awt.Dimension(966, 639));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pnlDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDashboardMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlDashboardMouseClicked

    private void pnlDashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDashboardMouseEntered
        // TODO add your handling code here:
        //        jPanel5.setBackground(new Color(153,150,255));
    }//GEN-LAST:event_pnlDashboardMouseEntered

    private void pnlDashboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDashboardMouseExited
        // TODO add your handling code here:[153,204,255]
    }//GEN-LAST:event_pnlDashboardMouseExited

    private void pnlDashboardMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDashboardMousePressed
        // TODO add your handling code here:
        pnlDashboard.setBackground(new Color(204, 217, 233));
    }//GEN-LAST:event_pnlDashboardMousePressed

    private void pnlDashboardMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDashboardMouseReleased
        // TODO add your handling code here:
        pnlDashboard.setBackground(new Color(70, 102, 144));
    }//GEN-LAST:event_pnlDashboardMouseReleased

    private void pnlCourseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCourseMousePressed
        // TODO add your handling code here:
        pnlCourse.setBackground(new Color(204, 217, 233));
    }//GEN-LAST:event_pnlCourseMousePressed

    private void pnlCourseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCourseMouseReleased
        // TODO add your handling code here:
        pnlCourse.setBackground(new Color(70, 102, 144));
    }//GEN-LAST:event_pnlCourseMouseReleased

    private void pnlExamMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlExamMousePressed
        // TODO add your handling code here:
        pnlExam.setBackground(new Color(204, 217, 233));
    }//GEN-LAST:event_pnlExamMousePressed

    private void pnlExamMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlExamMouseReleased
        // TODO add your handling code here:
        pnlExam.setBackground(new Color(70, 102, 144));
    }//GEN-LAST:event_pnlExamMouseReleased

    private void pnlResultMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlResultMousePressed
        // TODO add your handling code here:
        pnlResult.setBackground(new Color(204, 217, 233));
    }//GEN-LAST:event_pnlResultMousePressed

    private void pnlResultMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlResultMouseReleased
        // TODO add your handling code here:
        pnlResult.setBackground(new Color(70, 102, 144));
    }//GEN-LAST:event_pnlResultMouseReleased

    private void cmbExaminationCodeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbExaminationCodeItemStateChanged
        // TODO add your handling code here:
                                  
    }//GEN-LAST:event_cmbExaminationCodeItemStateChanged

    private void cmbExaminationCodePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbExaminationCodePropertyChange
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmbExaminationCodePropertyChange

    private void cmbExaminationCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbExaminationCodeActionPerformed
        // TODO add your handling code here:
        String examId = cmbExaminationCode.getSelectedItem().toString();
        String examinationStatus = linkService.getExamLinkStatus(examId);
        
        txtExamLinkAvailable.setText(linkService.showExamLink(examId));
        
        if(examinationStatus == null)
        {
            //cmbExamLink.setSelectedIndex(0);
            txtExamState.setText("");
        }
        else
            //cmbExamLink.setSelectedItem(examinationStatus);
            txtExamState.setText(examinationStatus);
    }//GEN-LAST:event_cmbExaminationCodeActionPerformed

    private void btnClearAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearAllMouseClicked
        // TODO add your handling code here:
        clear.clearTextFields(pnlExamLink);        
        clear.resetComboBox(pnlExamLink);
        clear.resetComboBox(pnlExamLinkTable);
        
        //tableModel = (DefaultTableModel) tblExamLink.getModel();  
        //tableModel.setRowCount(0);
        //link.fillExamLinkTable(tblExamLink); 
        
        
        
                           
    }//GEN-LAST:event_btnClearAllMouseClicked

    private void btnEnableLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnableLinkMouseClicked
        // TODO add your handling code here:
        String examId = cmbExaminationCode.getSelectedItem().toString();
        String examState = "Enabled";
        tableModel = (DefaultTableModel) tblExamLink.getModel();       
        boolean value = linkService.updateExamLinkStatus(examId,examState);
        
        if(cmbExaminationCode.getSelectedIndex()!=0 && value)
        {
            JOptionPane.showMessageDialog(this, "Exam Link status was successfully updated", "Success Message", 1);  
            tableModel.setRowCount(0);
            linkService.fillExamLinkTable(tblExamLink);
        }
        else
            JOptionPane.showMessageDialog(this, "Sorry, Exam link status couldn't be updated", "Failure Message", 1);
             
        txtExamState.setText(linkService.getExamLinkStatus(examId));
       
        
       
    }//GEN-LAST:event_btnEnableLinkMouseClicked

    private void btnBlockLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBlockLinkMouseClicked
        // TODO add your handling code here:
        String examId = cmbExaminationCode.getSelectedItem().toString();
        String examState = "Blocked";
        tableModel = (DefaultTableModel) tblExamLink.getModel();        
        boolean value = linkService.updateExamLinkStatus(examId,examState);
        
        if(cmbExaminationCode.getSelectedIndex()!=0 && value)
        {
            JOptionPane.showMessageDialog(this, "Exam Link status was successfully updated", "Success Message", 1);  
            tableModel.setRowCount(0);
            linkService.fillExamLinkTable(tblExamLink);
        }
        else
            JOptionPane.showMessageDialog(this, "Sorry, Exam link status couldn't be updated", "Failure Message", 1);
        
        txtExamState.setText((linkService.getExamLinkStatus(examId)));

    }//GEN-LAST:event_btnBlockLinkMouseClicked

    /**
     * 
     * @param evt 
     */
    
    private void cmbExaminationCodeSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbExaminationCodeSearchActionPerformed
        // TODO add your handling code here:
        tableModel = (DefaultTableModel) tblExamLink.getModel();   
        
        if(cmbExaminationCodeSearch.getSelectedIndex() == 0)
        {                 
            tableModel.setRowCount(0);
            linkService.fillExamLinkTable(tblExamLink);
        }
        else
        { 
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(tableModel); 
            sorter.setRowFilter(RowFilter.regexFilter(cmbExaminationCodeSearch.getSelectedItem().toString()));
            tblExamLink.setRowSorter(sorter);
        
        }
    }//GEN-LAST:event_cmbExaminationCodeSearchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ExamLink.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExamLink.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExamLink.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExamLink.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExamLink().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBlockLink;
    private javax.swing.JButton btnClearAll;
    private javax.swing.JButton btnEnableLink;
    private javax.swing.JComboBox<String> cmbExaminationCode;
    private javax.swing.JComboBox<String> cmbExaminationCodeSearch;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCourse;
    private javax.swing.JLabel lblDashboard;
    private javax.swing.JLabel lblExam;
    private javax.swing.JLabel lblExamCode;
    private javax.swing.JLabel lblExamCode1;
    private javax.swing.JLabel lblExamLink;
    private javax.swing.JLabel lblLinkStatus;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblResult;
    private javax.swing.JLabel lblSystem;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlCourse;
    private javax.swing.JPanel pnlDashboard;
    private javax.swing.JPanel pnlExam;
    private javax.swing.JPanel pnlExamLink;
    private javax.swing.JPanel pnlExamLinkTable;
    private javax.swing.JPanel pnlLogo;
    private javax.swing.JPanel pnlNavigation;
    private javax.swing.JPanel pnlResult;
    private javax.swing.JPanel pnlSystem;
    private javax.swing.JTable tblExamLink;
    private javax.swing.JTextField txtExamLinkAvailable;
    private javax.swing.JTextField txtExamState;
    // End of variables declaration//GEN-END:variables
}
