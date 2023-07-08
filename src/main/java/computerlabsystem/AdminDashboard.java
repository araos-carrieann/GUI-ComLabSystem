/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package computerlabsystem;

import java.util.List;
import javax.swing.JComboBox;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

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
        displayFacultyAccount();
        displayLogs();

    }

    private void displayStudentAccount() {
        DefaultTableModel studentAccount = (DefaultTableModel) studentAcctTable.getModel();
        studentAccount.setRowCount(0);

        List<Data> acctList = ComLabMethods.getAllStudentDatas();

        for (Data acct : acctList) {
            Object[] row = {acct.getStudentfacultyID(), acct.getFirstName(), acct.getLastName(), acct.getEmail(), acct.getProgram(), acct.getYrlvl()};
            studentAccount.addRow(row);
        }
    }

    public void searchStudentAcct(String search) {
        DefaultTableModel studentAccount = (DefaultTableModel) studentAcctTable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(studentAccount);
        studentAcctTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(search));

    }

    public void searchFacultyAcct(String search) {
        DefaultTableModel facultyAccount = (DefaultTableModel) facultyAcctTable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(facultyAccount);
        facultyAcctTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(search));

    }

    private void displayFacultyAccount() {
        DefaultTableModel facultyAccount = (DefaultTableModel) facultyAcctTable.getModel();
        facultyAccount.setRowCount(0);

        List<Data> acctList = ComLabMethods.getAllFacultiesDatas();

        for (Data acct : acctList) {
            Object[] row = {acct.getStudentfacultyID(), acct.getDepartment(), acct.getFirstName(), acct.getLastName(), acct.getEmail()};
            facultyAccount.addRow(row);
        }
    }

    public void searchLogs(String search) {
        DefaultTableModel logs = (DefaultTableModel) logsTable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(logs);
        logsTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(search));

    }

    private void displayLogs() {
        DefaultTableModel allLogs = (DefaultTableModel) logsTable.getModel();
        allLogs.setRowCount(0);

        List<Data> acctList = ComLabMethods.getAllLogs();

        for (Data acct : acctList) {
            Object[] logsRow = {acct.getLogsID(), acct.getRole(), acct.getStudentfacultyID(), acct.getFullname(), acct.getProgram(), acct.getYrlvl(), acct.getDepartment(), acct.getUserLogin(), acct.getUserLogout()};
            allLogs.addRow(logsRow);
        }
    }

    private void insertContentComboProgram() {
        JComboBox<String> comboBox = new JComboBox<>();
        List<Data> programList = ComLabMethods.programComboContent();
        if (!programList.isEmpty()) {
            Data acct = programList.get(0);
            comboBox.addItem(acct.getProgram());
        }
    }

    private void insertContentComboYearLvl() {
        JComboBox<String> comboBox = new JComboBox<>();
        List<Data> yrLvlList = ComLabMethods.yearlvlComboContent();
        if (!yrLvlList.isEmpty()) {
            Data acct = yrLvlList.get(1);
            comboBox.addItem(acct.getYrlvl());
        }
    }

    private void insertContentComboDepartment() {
        JComboBox<String> comboBox = new JComboBox<>();
        List<Data> departmentList = ComLabMethods.departmentComboContent();
        if (!departmentList.isEmpty()) {
            Data acct = departmentList.get(2);
            comboBox.addItem(acct.getDepartment());
        }
    }

    private void displayDepartment() {
        DefaultTableModel allDepartment = (DefaultTableModel) logsTable.getModel();
        allDepartment.setRowCount(0);

        List<Data> departmentList = ComLabMethods.getAllLogs();

        for (Data acct : departmentList) {
            Object[] departmentRow = {acct.getDepartment()};
            allDepartment.addRow(departmentRow);
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        accountPage = new computerlabsystem.Design.PanelGradient();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        studentAccountPanel = new computerlabsystem.Design.PanelGradient();
        btnDeleteStuAcct = new javax.swing.JButton();
        studentAcctPane = new javax.swing.JScrollPane();
        studentAcctTable = new javax.swing.JTable();
        lblSearch = new javax.swing.JLabel();
        btnAddStudentAcct = new javax.swing.JButton();
        txtStudentSearchAcct = new javax.swing.JTextField();
        btnUpdateAccount = new javax.swing.JButton();
        facultyAccountPanel = new computerlabsystem.Design.PanelGradient();
        lblSearch1 = new javax.swing.JLabel();
        btnDeleteFacultyAcct = new javax.swing.JButton();
        btnAddFacultyAccount = new javax.swing.JButton();
        txtFacultySearchAcct = new javax.swing.JTextField();
        facultyAcctPane = new javax.swing.JScrollPane();
        facultyAcctTable = new javax.swing.JTable();
        logsPage = new computerlabsystem.Design.PanelGradient();
        logsPane = new javax.swing.JScrollPane();
        logsTable = new javax.swing.JTable();
        btnDeleteLogs = new javax.swing.JButton();
        btnUpdateLogs = new javax.swing.JButton();
        txtSearchLogs = new javax.swing.JTextField();
        lblSeachLogs = new javax.swing.JLabel();

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
        lblAdminName.setBounds(1110, 0, 100, 30);

        lblAdmin.setText("ADMIN");
        headerPanel.add(lblAdmin);
        lblAdmin.setBounds(1140, 30, 60, 16);

        panelGradient1.add(headerPanel, java.awt.BorderLayout.PAGE_START);

        cardPanel.setColorPrimary(new java.awt.Color(0, 0, 0));
        cardPanel.setColorSecondary(new java.awt.Color(51, 51, 51));
        cardPanel.setLayout(new java.awt.CardLayout());

        homePage.setColorPrimary(new java.awt.Color(51, 0, 255));

        jButton1.setText("PROGRAM");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("YEAR LEVEL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("DEPARTMENT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        homePage.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        homePage.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        homePage.setLayer(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout homePageLayout = new javax.swing.GroupLayout(homePage);
        homePage.setLayout(homePageLayout);
        homePageLayout.setHorizontalGroup(
            homePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePageLayout.createSequentialGroup()
                .addContainerGap(610, Short.MAX_VALUE)
                .addGroup(homePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(393, 393, 393))
        );
        homePageLayout.setVerticalGroup(
            homePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePageLayout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jButton1)
                .addGap(78, 78, 78)
                .addComponent(jButton2)
                .addGap(87, 87, 87)
                .addComponent(jButton3)
                .addContainerGap(191, Short.MAX_VALUE))
        );

        cardPanel.add(homePage, "card6");

        accountPage.setColorPrimary(new java.awt.Color(255, 0, 0));

        studentAccountPanel.setColorPrimary(new java.awt.Color(255, 0, 153));

        btnDeleteStuAcct.setText("DELETE");
        btnDeleteStuAcct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteStuAcctActionPerformed(evt);
            }
        });

        studentAcctTable.setModel(new javax.swing.table.DefaultTableModel(
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
        studentAcctPane.setViewportView(studentAcctTable);

        lblSearch.setText("SEARCH");

        btnAddStudentAcct.setText("ADD USER");
        btnAddStudentAcct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStudentAcctActionPerformed(evt);
            }
        });

        txtStudentSearchAcct.setText("Enter Search");
        txtStudentSearchAcct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStudentSearchAcctKeyReleased(evt);
            }
        });

        btnUpdateAccount.setText("UPDATE");
        btnUpdateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateAccountActionPerformed(evt);
            }
        });

        studentAccountPanel.setLayer(btnDeleteStuAcct, javax.swing.JLayeredPane.DEFAULT_LAYER);
        studentAccountPanel.setLayer(studentAcctPane, javax.swing.JLayeredPane.DEFAULT_LAYER);
        studentAccountPanel.setLayer(lblSearch, javax.swing.JLayeredPane.DEFAULT_LAYER);
        studentAccountPanel.setLayer(btnAddStudentAcct, javax.swing.JLayeredPane.DEFAULT_LAYER);
        studentAccountPanel.setLayer(txtStudentSearchAcct, javax.swing.JLayeredPane.DEFAULT_LAYER);
        studentAccountPanel.setLayer(btnUpdateAccount, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout studentAccountPanelLayout = new javax.swing.GroupLayout(studentAccountPanel);
        studentAccountPanel.setLayout(studentAccountPanelLayout);
        studentAccountPanelLayout.setHorizontalGroup(
            studentAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentAccountPanelLayout.createSequentialGroup()
                .addGroup(studentAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(studentAccountPanelLayout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStudentSearchAcct, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(studentAccountPanelLayout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(btnDeleteStuAcct)
                        .addGap(58, 58, 58)
                        .addComponent(btnAddStudentAcct)
                        .addGap(74, 74, 74)
                        .addComponent(btnUpdateAccount)))
                .addGap(375, 566, Short.MAX_VALUE))
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
                    .addComponent(txtStudentSearchAcct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(studentAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeleteStuAcct)
                    .addGroup(studentAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAddStudentAcct)
                        .addComponent(btnUpdateAccount)))
                .addGap(17, 17, 17)
                .addComponent(studentAcctPane, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("STUDENT", studentAccountPanel);

        facultyAccountPanel.setColorPrimary(new java.awt.Color(255, 255, 0));

        lblSearch1.setText("jLabel1");

        btnDeleteFacultyAcct.setText("DELETE");
        btnDeleteFacultyAcct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteFacultyAcctActionPerformed(evt);
            }
        });

        btnAddFacultyAccount.setText("ADD USER");
        btnAddFacultyAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFacultyAccountActionPerformed(evt);
            }
        });

        txtFacultySearchAcct.setText("jTextField1");
        txtFacultySearchAcct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFacultySearchAcctActionPerformed(evt);
            }
        });
        txtFacultySearchAcct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFacultySearchAcctKeyReleased(evt);
            }
        });

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
        facultyAccountPanel.setLayer(btnDeleteFacultyAcct, javax.swing.JLayeredPane.DEFAULT_LAYER);
        facultyAccountPanel.setLayer(btnAddFacultyAccount, javax.swing.JLayeredPane.DEFAULT_LAYER);
        facultyAccountPanel.setLayer(txtFacultySearchAcct, javax.swing.JLayeredPane.DEFAULT_LAYER);
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
                        .addComponent(txtFacultySearchAcct, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(facultyAccountPanelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(facultyAcctPane, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(373, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, facultyAccountPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnDeleteFacultyAcct)
                .addGap(71, 71, 71)
                .addComponent(btnAddFacultyAccount)
                .addGap(283, 283, 283))
        );
        facultyAccountPanelLayout.setVerticalGroup(
            facultyAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(facultyAccountPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(facultyAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFacultySearchAcct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch1))
                .addGap(47, 47, 47)
                .addGroup(facultyAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddFacultyAccount)
                    .addComponent(btnDeleteFacultyAcct))
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
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "LOGS ID", "ROLE", "STUDENT / FACULTY ID", "FULL NAME", "PROGRAM", "YEAR LEVEL", "DEPARTMENT", "LOG IN TIME", "LOG OUT TIME"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        logsPane.setViewportView(logsTable);
        if (logsTable.getColumnModel().getColumnCount() > 0) {
            logsTable.getColumnModel().getColumn(0).setResizable(false);
            logsTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            logsTable.getColumnModel().getColumn(1).setResizable(false);
            logsTable.getColumnModel().getColumn(1).setPreferredWidth(30);
            logsTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            logsTable.getColumnModel().getColumn(4).setResizable(false);
            logsTable.getColumnModel().getColumn(4).setPreferredWidth(10);
            logsTable.getColumnModel().getColumn(5).setResizable(false);
            logsTable.getColumnModel().getColumn(5).setPreferredWidth(10);
            logsTable.getColumnModel().getColumn(8).setPreferredWidth(100);
        }

        btnDeleteLogs.setText("DELETE");
        btnDeleteLogs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteLogsActionPerformed(evt);
            }
        });

        btnUpdateLogs.setText("UPDATE");

        txtSearchLogs.setText("Enter Search");
        txtSearchLogs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchLogsKeyReleased(evt);
            }
        });

        lblSeachLogs.setText("Search");

        logsPage.setLayer(logsPane, javax.swing.JLayeredPane.DEFAULT_LAYER);
        logsPage.setLayer(btnDeleteLogs, javax.swing.JLayeredPane.DEFAULT_LAYER);
        logsPage.setLayer(btnUpdateLogs, javax.swing.JLayeredPane.DEFAULT_LAYER);
        logsPage.setLayer(txtSearchLogs, javax.swing.JLayeredPane.DEFAULT_LAYER);
        logsPage.setLayer(lblSeachLogs, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout logsPageLayout = new javax.swing.GroupLayout(logsPage);
        logsPage.setLayout(logsPageLayout);
        logsPageLayout.setHorizontalGroup(
            logsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logsPageLayout.createSequentialGroup()
                .addGroup(logsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(logsPageLayout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(btnDeleteLogs)
                        .addGap(88, 88, 88)
                        .addComponent(btnUpdateLogs))
                    .addGroup(logsPageLayout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(lblSeachLogs)
                        .addGap(75, 75, 75)
                        .addComponent(txtSearchLogs, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(logsPageLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(logsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1064, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        logsPageLayout.setVerticalGroup(
            logsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logsPageLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(logsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSeachLogs)
                    .addComponent(txtSearchLogs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(logsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeleteLogs, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnUpdateLogs, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
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
        cardPanel.add(logsPage);
        cardPanel.repaint();
        cardPanel.revalidate();
    }//GEN-LAST:event_lblAllLogsMouseClicked

    private void btnDeleteStuAcctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteStuAcctActionPerformed
        DefaultTableModel model = (DefaultTableModel) studentAcctTable.getModel();
        int selectedRow = studentAcctTable.getSelectedRow();
        if (selectedRow != 1) {
            String studentID = (String) model.getValueAt(selectedRow, 0);
            model.removeRow(selectedRow);
            ComLabMethods.deleteAcct(studentID);
        }
    }//GEN-LAST:event_btnDeleteStuAcctActionPerformed

    private void btnAddStudentAcctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStudentAcctActionPerformed
        AddAccount dialog = new AddAccount(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        dialog.setVisible(true);

    }//GEN-LAST:event_btnAddStudentAcctActionPerformed

    private void btnDeleteFacultyAcctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteFacultyAcctActionPerformed
        DefaultTableModel model = (DefaultTableModel) facultyAcctTable.getModel();
        int selectedRow = facultyAcctTable.getSelectedRow();
        if (selectedRow != 1) {
            String facultyID = (String) model.getValueAt(selectedRow, 0);
            model.removeRow(selectedRow);
            ComLabMethods.deleteAcct(facultyID);
        }
    }//GEN-LAST:event_btnDeleteFacultyAcctActionPerformed

    private void btnAddFacultyAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFacultyAccountActionPerformed
        AddAccount dialog = new AddAccount(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        dialog.setVisible(true);

    }//GEN-LAST:event_btnAddFacultyAccountActionPerformed

    private void txtStudentSearchAcctKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStudentSearchAcctKeyReleased
        String search = txtStudentSearchAcct.getText();
        searchStudentAcct(search);
    }//GEN-LAST:event_txtStudentSearchAcctKeyReleased

    private void txtFacultySearchAcctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFacultySearchAcctActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFacultySearchAcctActionPerformed

    private void txtFacultySearchAcctKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFacultySearchAcctKeyReleased
        String search = txtFacultySearchAcct.getText();
        searchFacultyAcct(search);
    }//GEN-LAST:event_txtFacultySearchAcctKeyReleased

    private void txtSearchLogsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchLogsKeyReleased
        String search = txtSearchLogs.getText();
        searchLogs(search);
    }//GEN-LAST:event_txtSearchLogsKeyReleased

    private void btnDeleteLogsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteLogsActionPerformed
        DefaultTableModel model = (DefaultTableModel) logsTable.getModel();
        int selectedRow = logsTable.getSelectedRow();
        if (selectedRow != 1) {
            int logID = (Integer) model.getValueAt(selectedRow, 0);
            model.removeRow(selectedRow);
            ComLabMethods.deleteLogs(logID);
        }
    }//GEN-LAST:event_btnDeleteLogsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ProgramAddDelete dialog = new ProgramAddDelete(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        YearLevelAddDelete dialog = new YearLevelAddDelete(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DepartmentAddDelete dialog = new DepartmentAddDelete(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnUpdateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateAccountActionPerformed
        DefaultTableModel model = (DefaultTableModel) studentAcctTable.getModel();
        int selectedRow = studentAcctTable.getSelectedRow();

        if (selectedRow != -1) {
            // Get the values of each column in the selected row
            String studentID = (String) model.getValueAt(selectedRow, 0);
            String email = (String) model.getValueAt(selectedRow, 1);
            String firstName = (String) model.getValueAt(selectedRow, 2);
            String lastName = (String) model.getValueAt(selectedRow, 3);
            String program = (String) model.getValueAt(selectedRow, 4);
            String yearLevel = (String) model.getValueAt(selectedRow, 5);
  
            // new UpdateAcct(studentID, email, firstName, lastName, program, yearLevel);

        }

    }//GEN-LAST:event_btnUpdateAccountActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private computerlabsystem.Design.PanelGradient accountPage;
    private javax.swing.JButton btnAddFacultyAccount;
    private javax.swing.JButton btnAddStudentAcct;
    private javax.swing.JButton btnDeleteFacultyAcct;
    private javax.swing.JButton btnDeleteLogs;
    private javax.swing.JButton btnDeleteStuAcct;
    private javax.swing.JButton btnUpdateAccount;
    private javax.swing.JButton btnUpdateLogs;
    private computerlabsystem.Design.PanelGradient cardPanel;
    private computerlabsystem.Design.PanelGradient facultyAccountPanel;
    private javax.swing.JScrollPane facultyAcctPane;
    private javax.swing.JTable facultyAcctTable;
    private computerlabsystem.Design.PanelGradient headerPanel;
    private computerlabsystem.Design.PanelGradient homePage;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private computerlabsystem.Design.PanelGradient studentAccountPanel;
    private javax.swing.JScrollPane studentAcctPane;
    private javax.swing.JTable studentAcctTable;
    private javax.swing.JTextField txtFacultySearchAcct;
    private javax.swing.JTextField txtSearchLogs;
    private javax.swing.JTextField txtStudentSearchAcct;
    // End of variables declaration//GEN-END:variables
}
