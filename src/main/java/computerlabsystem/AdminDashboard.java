/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package computerlabsystem;

import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author araos
 */
public class AdminDashboard extends javax.swing.JFrame {

    /**
     * Creates new form AdminDashboard
     */
    public AdminDashboard(String fname) {
        initComponents();
        lblAdminName.setText(fname);
        displayStudentAccount();
        displayStudenFacultyAccount();
        displayLogs();

    }

    private void displayStudentAccount() {
        DefaultTableModel studentAccount = (DefaultTableModel) acctTable.getModel();
        studentAccount.setRowCount(0);

        List<Data> acctList = ComLabMethods.getAllStudentDatas();

        for (Data acct : acctList) {
            Object[] row = {acct.getStudentfacultyID(), acct.getFirstName(), acct.getLastName(), acct.getEmail(), acct.getProgram(), acct.getYrlvl()};
            studentAccount.addRow(row);
        }
    }

    private void displayStudenFacultyAccount() {
        DefaultTableModel facultyAccount = (DefaultTableModel) facultyAcctTable.getModel();
        facultyAccount.setRowCount(0);

        List<Data> acctList = ComLabMethods.getAllStudentDatas();

        for (Data acct : acctList) {
            Object[] row = {acct.getStudentfacultyID(), acct.getDepartment(), acct.getFirstName(), acct.getLastName(), acct.getEmail()};
            facultyAccount.addRow(row);
        }
    }

    private void displayLogs() {
        DefaultTableModel allLogs = (DefaultTableModel) logsTable.getModel();
        allLogs.setRowCount(0);

        List<Data> acctList = ComLabMethods.getAllStudentDatas();

        for (Data acct : acctList) {
            Object[] row = {acct.getLogsID(), acct.getStudentfacultyID(), acct.getRole(), acct.getDepartment(), acct.getProgram(), acct.getYrlvl(), acct.getFullname(), acct.getUserLogin(), acct.getUserLogout()};
            allLogs.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradient1 = new computerlabsystem.Design.PanelGradient();
        menuPanel = new computerlabsystem.Design.PanelGradient();
        lblHome = new javax.swing.JLabel();
        lblAccounts = new javax.swing.JLabel();
        lblAllLogs = new javax.swing.JLabel();
        headerPanel = new computerlabsystem.Design.PanelGradient();
        lblBurgerMenu = new javax.swing.JLabel();
        lblAdminName = new javax.swing.JLabel();
        lblAdmin = new javax.swing.JLabel();
        cardPanel = new computerlabsystem.Design.PanelGradient();
        homePage = new computerlabsystem.Design.PanelGradient();
        accountPage = new computerlabsystem.Design.PanelGradient();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        studentAccountPanel = new computerlabsystem.Design.PanelGradient();
        btnDeleteStuAcct = new javax.swing.JButton();
        studentAcctPane = new javax.swing.JScrollPane();
        acctTable = new javax.swing.JTable();
        lblSearch = new javax.swing.JLabel();
        btnAddStuAcct1 = new javax.swing.JButton();
        txtSearchAcct = new javax.swing.JTextField();
        facultyAccountPanel = new computerlabsystem.Design.PanelGradient();
        lblSearch1 = new javax.swing.JLabel();
        btnDeleteStuAcct1 = new javax.swing.JButton();
        btnAddStuAcct2 = new javax.swing.JButton();
        txtSearchAcct2 = new javax.swing.JTextField();
        facultyAcctPane = new javax.swing.JScrollPane();
        facultyAcctTable = new javax.swing.JTable();
        logsPage = new computerlabsystem.Design.PanelGradient();
        logsPane = new javax.swing.JScrollPane();
        logsTable = new javax.swing.JTable();
        btnDeleteLogs = new javax.swing.JButton();
        btnAddSlogs = new javax.swing.JButton();
        btnUpdateLogs = new javax.swing.JButton();
        rbtnStudentLogs = new javax.swing.JRadioButton();
        rbtnFacultyLogs = new javax.swing.JRadioButton();
        txtSearchLogs = new javax.swing.JTextField();
        lblSeachLogs = new javax.swing.JLabel();
        rbtnVisitorsLogs = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelGradient1.setColorPrimary(new java.awt.Color(204, 204, 204));
        panelGradient1.setColorSecondary(new java.awt.Color(153, 153, 153));
        panelGradient1.setLayout(new java.awt.BorderLayout());

        menuPanel.setColorPrimary(new java.awt.Color(225, 236, 200));
        menuPanel.setColorSecondary(new java.awt.Color(153, 169, 143));
        menuPanel.setPreferredSize(new java.awt.Dimension(150, 100));

        lblHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHome.setIcon(new javax.swing.ImageIcon("C:\\Users\\araos\\Downloads\\icons8-home-40.png")); // NOI18N
        lblHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomeMouseClicked(evt);
            }
        });

        lblAccounts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAccounts.setIcon(new javax.swing.ImageIcon("C:\\Users\\araos\\Downloads\\icons8-college-40.png")); // NOI18N
        lblAccounts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAccountsMouseClicked(evt);
            }
        });

        lblAllLogs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAllLogs.setIcon(new javax.swing.ImageIcon("C:\\Users\\araos\\Downloads\\icons8-moleskine-40.png")); // NOI18N
        lblAllLogs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAllLogsMouseClicked(evt);
            }
        });

        menuPanel.setLayer(lblHome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        menuPanel.setLayer(lblAccounts, javax.swing.JLayeredPane.DEFAULT_LAYER);
        menuPanel.setLayer(lblAllLogs, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHome, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAccounts, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAllLogs, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(lblHome)
                .addGap(35, 35, 35)
                .addComponent(lblAccounts, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(lblAllLogs, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(247, 247, 247))
        );

        panelGradient1.add(menuPanel, java.awt.BorderLayout.LINE_START);

        headerPanel.setColorPrimary(new java.awt.Color(160, 196, 157));
        headerPanel.setColorSecondary(new java.awt.Color(196, 215, 178));
        headerPanel.setPreferredSize(new java.awt.Dimension(100, 60));

        lblBurgerMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBurgerMenu.setIcon(new javax.swing.ImageIcon("C:\\Users\\araos\\Downloads\\icons8-menu-rounded-50.png")); // NOI18N
        lblBurgerMenu.setText("jLabel2");
        headerPanel.add(lblBurgerMenu);
        lblBurgerMenu.setBounds(30, 10, 50, 40);

        lblAdminName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdminName.setIcon(new javax.swing.ImageIcon("C:\\Users\\araos\\Downloads\\icons8-male-user-24.png")); // NOI18N
        lblAdminName.setText("jLabel2");
        headerPanel.add(lblAdminName);
        lblAdminName.setBounds(590, 10, 100, 30);

        lblAdmin.setText("ADMIN");
        headerPanel.add(lblAdmin);
        lblAdmin.setBounds(630, 40, 60, 16);

        panelGradient1.add(headerPanel, java.awt.BorderLayout.PAGE_START);

        cardPanel.setColorPrimary(new java.awt.Color(0, 0, 0));
        cardPanel.setColorSecondary(new java.awt.Color(51, 51, 51));
        cardPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout homePageLayout = new javax.swing.GroupLayout(homePage);
        homePage.setLayout(homePageLayout);
        homePageLayout.setHorizontalGroup(
            homePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1107, Short.MAX_VALUE)
        );
        homePageLayout.setVerticalGroup(
            homePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 571, Short.MAX_VALUE)
        );

        cardPanel.add(homePage, "card6");

        accountPage.setColorPrimary(new java.awt.Color(255, 0, 0));

        studentAccountPanel.setColorPrimary(new java.awt.Color(255, 0, 153));

        btnDeleteStuAcct.setText("DELETE");

        acctTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STUDENT ID", "EMAIL", "FIRST NAME", "LAST NAME", "PROGRAM", "YEAR LEVEL"
            }
        ));
        studentAcctPane.setViewportView(acctTable);

        lblSearch.setText("jLabel1");

        btnAddStuAcct1.setText("ADD USER");

        txtSearchAcct.setText("jTextField1");

        studentAccountPanel.setLayer(btnDeleteStuAcct, javax.swing.JLayeredPane.DEFAULT_LAYER);
        studentAccountPanel.setLayer(studentAcctPane, javax.swing.JLayeredPane.DEFAULT_LAYER);
        studentAccountPanel.setLayer(lblSearch, javax.swing.JLayeredPane.DEFAULT_LAYER);
        studentAccountPanel.setLayer(btnAddStuAcct1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        studentAccountPanel.setLayer(txtSearchAcct, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout studentAccountPanelLayout = new javax.swing.GroupLayout(studentAccountPanel);
        studentAccountPanel.setLayout(studentAccountPanelLayout);
        studentAccountPanelLayout.setHorizontalGroup(
            studentAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentAccountPanelLayout.createSequentialGroup()
                .addGroup(studentAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(studentAccountPanelLayout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtSearchAcct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(studentAccountPanelLayout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(btnDeleteStuAcct)
                        .addGap(58, 58, 58)
                        .addComponent(btnAddStuAcct1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, studentAccountPanelLayout.createSequentialGroup()
                .addComponent(studentAcctPane)
                .addContainerGap())
        );
        studentAccountPanelLayout.setVerticalGroup(
            studentAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentAccountPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(studentAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSearch)
                    .addComponent(txtSearchAcct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(studentAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeleteStuAcct)
                    .addComponent(btnAddStuAcct1))
                .addGap(17, 17, 17)
                .addComponent(studentAcctPane, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("STUDENT", studentAccountPanel);

        facultyAccountPanel.setColorPrimary(new java.awt.Color(255, 255, 0));

        lblSearch1.setText("jLabel1");

        btnDeleteStuAcct1.setText("DELETE");

        btnAddStuAcct2.setText("ADD USER");

        txtSearchAcct2.setText("jTextField1");

        facultyAcctTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "FACULTY ID", "DEPARTMENT", "EMAIL", "FIRST NAME", "LASTNAME"
            }
        ));
        facultyAcctPane.setViewportView(facultyAcctTable);

        facultyAccountPanel.setLayer(lblSearch1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        facultyAccountPanel.setLayer(btnDeleteStuAcct1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        facultyAccountPanel.setLayer(btnAddStuAcct2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        facultyAccountPanel.setLayer(txtSearchAcct2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        facultyAccountPanel.setLayer(facultyAcctPane, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout facultyAccountPanelLayout = new javax.swing.GroupLayout(facultyAccountPanel);
        facultyAccountPanel.setLayout(facultyAccountPanelLayout);
        facultyAccountPanelLayout.setHorizontalGroup(
            facultyAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(facultyAccountPanelLayout.createSequentialGroup()
                .addGroup(facultyAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(facultyAccountPanelLayout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(lblSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(txtSearchAcct2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(facultyAccountPanelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(facultyAcctPane, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(373, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, facultyAccountPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnDeleteStuAcct1)
                .addGap(71, 71, 71)
                .addComponent(btnAddStuAcct2)
                .addGap(283, 283, 283))
        );
        facultyAccountPanelLayout.setVerticalGroup(
            facultyAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(facultyAccountPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(facultyAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchAcct2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch1))
                .addGap(47, 47, 47)
                .addGroup(facultyAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddStuAcct2)
                    .addComponent(btnDeleteStuAcct1))
                .addGap(18, 18, 18)
                .addComponent(facultyAcctPane, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("FACULTY", facultyAccountPanel);

        accountPage.setLayer(jTabbedPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout accountPageLayout = new javax.swing.GroupLayout(accountPage);
        accountPage.setLayout(accountPageLayout);
        accountPageLayout.setHorizontalGroup(
            accountPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        accountPageLayout.setVerticalGroup(
            accountPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
        );

        cardPanel.add(accountPage, "card2");

        logsPage.setColorPrimary(new java.awt.Color(153, 0, 153));

        logsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        logsPane.setViewportView(logsTable);

        btnDeleteLogs.setText("DELETE");

        btnAddSlogs.setText("ADD LOGS");

        btnUpdateLogs.setText("UPDATE");

        rbtnStudentLogs.setText("STUDENT");

        rbtnFacultyLogs.setText("FACULTY");

        txtSearchLogs.setText("Enter Search");

        lblSeachLogs.setText("Search");

        rbtnVisitorsLogs.setText("VISITORS");

        logsPage.setLayer(logsPane, javax.swing.JLayeredPane.DEFAULT_LAYER);
        logsPage.setLayer(btnDeleteLogs, javax.swing.JLayeredPane.DEFAULT_LAYER);
        logsPage.setLayer(btnAddSlogs, javax.swing.JLayeredPane.DEFAULT_LAYER);
        logsPage.setLayer(btnUpdateLogs, javax.swing.JLayeredPane.DEFAULT_LAYER);
        logsPage.setLayer(rbtnStudentLogs, javax.swing.JLayeredPane.DEFAULT_LAYER);
        logsPage.setLayer(rbtnFacultyLogs, javax.swing.JLayeredPane.DEFAULT_LAYER);
        logsPage.setLayer(txtSearchLogs, javax.swing.JLayeredPane.DEFAULT_LAYER);
        logsPage.setLayer(lblSeachLogs, javax.swing.JLayeredPane.DEFAULT_LAYER);
        logsPage.setLayer(rbtnVisitorsLogs, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout logsPageLayout = new javax.swing.GroupLayout(logsPage);
        logsPage.setLayout(logsPageLayout);
        logsPageLayout.setHorizontalGroup(
            logsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logsPageLayout.createSequentialGroup()
                .addGroup(logsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(logsPageLayout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(btnDeleteLogs)
                        .addGap(84, 84, 84)
                        .addComponent(btnAddSlogs)
                        .addGap(97, 97, 97)
                        .addComponent(btnUpdateLogs))
                    .addGroup(logsPageLayout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addGroup(logsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(logsPageLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblSeachLogs)
                                .addGap(59, 59, 59)
                                .addComponent(txtSearchLogs, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(logsPageLayout.createSequentialGroup()
                                .addComponent(rbtnStudentLogs)
                                .addGap(54, 54, 54)
                                .addComponent(rbtnFacultyLogs)
                                .addGap(68, 68, 68)
                                .addComponent(rbtnVisitorsLogs))))
                    .addComponent(logsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 947, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        logsPageLayout.setVerticalGroup(
            logsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logsPageLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(logsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnStudentLogs)
                    .addComponent(rbtnFacultyLogs)
                    .addComponent(rbtnVisitorsLogs))
                .addGap(18, 18, 18)
                .addGroup(logsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchLogs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSeachLogs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(logsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteLogs)
                    .addComponent(btnAddSlogs)
                    .addComponent(btnUpdateLogs))
                .addGap(18, 18, 18)
                .addComponent(logsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        cardPanel.add(logsPage, "card4");

        panelGradient1.add(cardPanel, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseClicked
        cardPanel.removeAll();
        cardPanel.add(homePage);
        cardPanel.repaint();
        cardPanel.revalidate();
    }//GEN-LAST:event_lblHomeMouseClicked

    private void lblAccountsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAccountsMouseClicked
        cardPanel.removeAll();
        cardPanel.add(accountPage);
        cardPanel.repaint();
        cardPanel.revalidate();
    }//GEN-LAST:event_lblAccountsMouseClicked

    private void lblAllLogsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAllLogsMouseClicked
        cardPanel.removeAll();
        cardPanel.add(homePage);
        cardPanel.repaint();
        cardPanel.revalidate();
    }//GEN-LAST:event_lblAllLogsMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private computerlabsystem.Design.PanelGradient accountPage;
    private javax.swing.JTable acctTable;
    private javax.swing.JButton btnAddSlogs;
    private javax.swing.JButton btnAddStuAcct1;
    private javax.swing.JButton btnAddStuAcct2;
    private javax.swing.JButton btnDeleteLogs;
    private javax.swing.JButton btnDeleteStuAcct;
    private javax.swing.JButton btnDeleteStuAcct1;
    private javax.swing.JButton btnUpdateLogs;
    private computerlabsystem.Design.PanelGradient cardPanel;
    private computerlabsystem.Design.PanelGradient facultyAccountPanel;
    private javax.swing.JScrollPane facultyAcctPane;
    private javax.swing.JTable facultyAcctTable;
    private computerlabsystem.Design.PanelGradient headerPanel;
    private computerlabsystem.Design.PanelGradient homePage;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAccounts;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblAdminName;
    private javax.swing.JLabel lblAllLogs;
    private javax.swing.JLabel lblBurgerMenu;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblSeachLogs;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblSearch1;
    private computerlabsystem.Design.PanelGradient logsPage;
    private javax.swing.JScrollPane logsPane;
    private javax.swing.JTable logsTable;
    private computerlabsystem.Design.PanelGradient menuPanel;
    private computerlabsystem.Design.PanelGradient panelGradient1;
    private javax.swing.JRadioButton rbtnFacultyLogs;
    private javax.swing.JRadioButton rbtnStudentLogs;
    private javax.swing.JRadioButton rbtnVisitorsLogs;
    private computerlabsystem.Design.PanelGradient studentAccountPanel;
    private javax.swing.JScrollPane studentAcctPane;
    private javax.swing.JTextField txtSearchAcct;
    private javax.swing.JTextField txtSearchAcct2;
    private javax.swing.JTextField txtSearchLogs;
    // End of variables declaration//GEN-END:variables
}
