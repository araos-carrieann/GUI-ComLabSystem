/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package computerlabsystem;

import computerlabsystem.Design.PanelBorder;
import java.awt.Color;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author araos
 */
public class AdminDashboard extends javax.swing.JFrame {

    private String sfID;

    // Other class members and methods
    public String getSfID() {
        return sfID;
    }

    public void setSfID(String sfID) {
        this.sfID = sfID;
    }

    public AdminDashboard(String fname, String sfID) {
        this.sfID = sfID;
        initComponents();
        lblAdminName.setText(fname);
        displayLongestSpent();
        displayMostLogs();
        displayLogs();
        displayVisitorsLogs();
        displayStudentAccount();
        displayFacultyAccount();
        displayAdminAccount();

    }

    private void displayStudentAccount() {
        DefaultTableModel studentAccount = (DefaultTableModel) studentAcctTable.getModel();
        studentAccount.setRowCount(0);

        List<DTOaccount> acctList = ComLabMethods.getAllStudentDatas();

        for (DTOaccount acct : acctList) {
            Object[] row = {acct.getStudentfacultyID(), acct.getFirstName(), acct.getLastName(), acct.getEmail(), acct.getProgram(), acct.getYrlvl()};
            studentAccount.addRow(row);
        }
        lblTotalNumberUsers.setText(String.valueOf(ComLabMethods.getTotalUserRows()));
        lblNumberOfActive.setText(String.valueOf(ComLabMethods.getTotalActiveUser()));
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

        List<DTOaccount> acctList = ComLabMethods.getAllFacultiesDatas();

        for (DTOaccount acct : acctList) {
            Object[] row = {acct.getStudentfacultyID(), acct.getDepartment(), acct.getFirstName(), acct.getLastName(), acct.getEmail()};
            facultyAccount.addRow(row);
        }
        lblTotalNumberUsers.setText(String.valueOf(ComLabMethods.getTotalUserRows()));
    }

    private void displayAdminAccount() {
        DefaultTableModel adminAccount = (DefaultTableModel) adminAccountTable.getModel();
        adminAccount.setRowCount(0);

        List<DTOaccount> acctList = ComLabMethods.getAllAdminDatas();

        for (DTOaccount acct : acctList) {
            Object[] row = {acct.getStudentfacultyID(), acct.getFirstName(), acct.getLastName(), acct.getEmail()};
            adminAccount.addRow(row);
        }
        lblTotalNumberUsers.setText(String.valueOf(ComLabMethods.getTotalUserRows()));
    }

    public void searchAdminAcct(String search) {
        DefaultTableModel adminyAccount = (DefaultTableModel) adminAccountTable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(adminyAccount);
        adminAccountTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(search));

    }

    public void searchUserLogs(String search) {
        DefaultTableModel logs = (DefaultTableModel) logsTable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(logs);
        logsTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(search));

    }

    public void searchVisitorsLogs(String search) {
        DefaultTableModel logs = (DefaultTableModel) visitorsLogsTable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(logs);
        visitorsLogsTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(search));

    }

    private void displayLogs() {
        DefaultTableModel allLogs = (DefaultTableModel) logsTable.getModel();
        allLogs.setRowCount(0);

        List<DTOlogs> acctList = DAOlogs.getAllLogs();

        for (DTOlogs acct : acctList) {
            Object[] logsRow = {acct.getLogsID(), acct.getRole(), acct.getStudentfacultyID(), acct.getFullname(), acct.getProgram(), acct.getYrlvl(), acct.getDepartment(), acct.getLoginTime(), acct.getLogoutTime()};
            allLogs.addRow(logsRow);
        }
    }

    private void displayVisitorsLogs() {
        DefaultTableModel visitorsLogs = (DefaultTableModel) visitorsLogsTable.getModel();
        visitorsLogs.setRowCount(0);

        List<DTOvisitors> visitorsList = DAOlogs.getAllVisitorsLogs();

        for (DTOvisitors acct : visitorsList) {
            Object[] logsRow = {acct.getLogsID(), acct.getCodeIdentity(), acct.getFullname(), acct.getEmail(), acct.getMobilenumber(), acct.getGender(), acct.getPurpose(), acct.getLoginTime(), acct.getLogoutTime()};
            visitorsLogs.addRow(logsRow);
        }
    }

    private void insertContentComboProgram() {
        JComboBox<String> comboBox = new JComboBox<>();
        List<DTOaccount> programList = ComLabMethods.programComboContent();
        if (!programList.isEmpty()) {
            DTOaccount acct = programList.get(0);
            comboBox.addItem(acct.getProgram());
        }
    }

    private void insertContentComboYearLvl() {
        JComboBox<String> comboBox = new JComboBox<>();
        List<DTOaccount> yrLvlList = ComLabMethods.yearlvlComboContent();
        if (!yrLvlList.isEmpty()) {
            DTOaccount acct = yrLvlList.get(1);
            comboBox.addItem(acct.getYrlvl());
        }
    }

    private void insertContentComboDepartment() {
        JComboBox<String> comboBox = new JComboBox<>();
        List<DTOaccount> departmentList = ComLabMethods.departmentComboContent();
        if (!departmentList.isEmpty()) {
            DTOaccount acct = departmentList.get(2);
            comboBox.addItem(acct.getDepartment());
        }
    }

    private void displayDepartment() {
        DefaultTableModel allDepartment = (DefaultTableModel) logsTable.getModel();
        allDepartment.setRowCount(0);

        List<DTOlogs> departmentList = DAOlogs.getAllLogs();

        for (DTOlogs acct : departmentList) {
            Object[] departmentRow = {acct.getDepartment()};
            allDepartment.addRow(departmentRow);
        }
    }

    private void displayMostLogs() {
        DefaultTableModel mostLogs = (DefaultTableModel) mostLogsTable.getModel();
        mostLogs.setRowCount(0);

        List<DTOaccount> mostLogsList = ComLabMethods.mostLogs();

        for (DTOaccount acct : mostLogsList) {
            Object[] mLogs = {acct.getRole(), acct.getFullname(), acct.getMostLogs()};
            mostLogs.addRow(mLogs);
        }
    }

    private void displayLongestSpent() {
        DefaultTableModel longestSpent = (DefaultTableModel) longestTimeSpentTable.getModel();
        longestSpent.setRowCount(0);

        List<DTOaccount> longestTimeSpent = ComLabMethods.longestTimeSpent();

        for (DTOaccount acct : longestTimeSpent) {
            Object[] longestTimeS = {acct.getRole(), acct.getFullname(), acct.getLogsDuration()};
            longestSpent.addRow(longestTimeS);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradient1 = new computerlabsystem.Design.PanelGradient();
        menuPanel = new computerlabsystem.Design.PanelGradient();
        panelHome = new computerlabsystem.Design.PanelBorder();
        lblHome = new javax.swing.JLabel();
        panelAccounts = new computerlabsystem.Design.PanelBorder();
        lblAccounts = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelLogs = new computerlabsystem.Design.PanelBorder();
        lblAllLogs = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        cardPanel = new computerlabsystem.Design.PanelGradient();
        homePage = new computerlabsystem.Design.PanelGradient();
        panelBorder1 = new computerlabsystem.Design.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        lblAdminName = new javax.swing.JLabel();
        panelBorder2 = new computerlabsystem.Design.PanelBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        mostLogsTable = new javax.swing.JTable();
        lblTopFiveLogs = new javax.swing.JLabel();
        panelBorder3 = new computerlabsystem.Design.PanelBorder();
        jScrollPane2 = new javax.swing.JScrollPane();
        longestTimeSpentTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        panelBorder4 = new computerlabsystem.Design.PanelBorder();
        lblRegisteredIcon = new javax.swing.JLabel();
        lblNumberOfActive = new javax.swing.JLabel();
        lblActiveIcon = new javax.swing.JLabel();
        lblTotalNumberUsers = new javax.swing.JLabel();
        panelBorder7 = new computerlabsystem.Design.PanelBorder();
        btnDepartment = new javax.swing.JButton();
        btnYearLevel = new javax.swing.JButton();
        btnProgram = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        panelBorder8 = new computerlabsystem.Design.PanelBorder();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        lblNotification = new javax.swing.JLabel();
        accountPage = new computerlabsystem.Design.PanelGradient();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        studentAccountPanel = new computerlabsystem.Design.PanelGradient();
        btnDeleteStuAcct = new javax.swing.JButton();
        studentAcctPane = new javax.swing.JScrollPane();
        studentAcctTable = new javax.swing.JTable();
        lblSearchStudent = new javax.swing.JLabel();
        btnAddStudentAcct = new javax.swing.JButton();
        txtStudentSearchAcct = new javax.swing.JTextField();
        btnUpdateStudentAccount = new javax.swing.JButton();
        facultyAccountPanel = new computerlabsystem.Design.PanelGradient();
        lblSearchFaculty = new javax.swing.JLabel();
        btnDeleteFacultyAcct = new javax.swing.JButton();
        btnAddFacultyAccount = new javax.swing.JButton();
        txtFacultySearchAcct = new javax.swing.JTextField();
        facultyAcctPane = new javax.swing.JScrollPane();
        btnUpdateFacultyAcct = new javax.swing.JButton();
        adminAccountPanel = new computerlabsystem.Design.PanelGradient();
        jScrollPane3 = new javax.swing.JScrollPane();
        adminAccountTable = new javax.swing.JTable();
        lblSearchAdmin = new javax.swing.JLabel();
        btnDeleteAdminAcct = new javax.swing.JButton();
        txtAdminSearchAcct = new javax.swing.JTextField();
        btnUpdateAdminAcct = new javax.swing.JButton();
        panelBorder6 = new computerlabsystem.Design.PanelBorder();
        jLabel6 = new javax.swing.JLabel();
        logsPage = new computerlabsystem.Design.PanelGradient();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        UsersLogsPanel = new computerlabsystem.Design.PanelGradient();
        logsPane = new javax.swing.JScrollPane();
        logsTable = new javax.swing.JTable();
        lblSeachLogs = new javax.swing.JLabel();
        txtSearchLogs = new javax.swing.JTextField();
        visitorsLogsPanel = new computerlabsystem.Design.PanelGradient();
        jScrollPane4 = new javax.swing.JScrollPane();
        visitorsLogsTable = new javax.swing.JTable();
        txtVisitorsLogsSearch = new javax.swing.JTextField();
        panelBorder5 = new computerlabsystem.Design.PanelBorder();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1250, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelGradient1.setColorPrimary(new java.awt.Color(204, 204, 204));
        panelGradient1.setColorSecondary(new java.awt.Color(153, 153, 153));
        panelGradient1.setLayout(new java.awt.BorderLayout());

        menuPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 3, new java.awt.Color(109, 113, 249)));
        menuPanel.setColorPrimary(new java.awt.Color(109, 113, 249));
        menuPanel.setColorSecondary(new java.awt.Color(109, 113, 249));
        menuPanel.setPreferredSize(new java.awt.Dimension(150, 150));
        menuPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelHome.setBackground((new Color(0, 0, 0, 0)));
        panelHome.setLayout(new java.awt.GridLayout(1, 0));

        lblHome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menuHome.png"))); // NOI18N
        lblHome.setText("Home");
        lblHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblHomeMouseExited(evt);
            }
        });
        panelHome.add(lblHome);

        menuPanel.add(panelHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 130, 60));

        panelAccounts.setBackground((new Color(0, 0, 0, 0)));
        panelAccounts.setLayout(new java.awt.GridLayout(1, 0));

        lblAccounts.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAccounts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menuUser.png"))); // NOI18N
        lblAccounts.setText("Accounts");
        lblAccounts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAccountsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAccountsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAccountsMouseExited(evt);
            }
        });
        panelAccounts.add(lblAccounts);

        menuPanel.add(panelAccounts, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 130, 60));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo.png"))); // NOI18N
        menuPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 130, 130));

        panelLogs.setBackground((new Color(0, 0, 0, 0)));
        panelLogs.setLayout(new java.awt.GridLayout(1, 0));

        lblAllLogs.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAllLogs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menuLogs.png"))); // NOI18N
        lblAllLogs.setText("Logs ");
        lblAllLogs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAllLogsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAllLogsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAllLogsMouseExited(evt);
            }
        });
        panelLogs.add(lblAllLogs);

        menuPanel.add(panelLogs, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 130, 60));

        btnLogout.setBackground(new java.awt.Color(255, 255, 204));
        btnLogout.setIcon(new javax.swing.ImageIcon("C:\\Users\\araos\\Downloads\\icons8-logout-30.png")); // NOI18N
        btnLogout.setText("LOGOUT");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        menuPanel.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, -1, -1));

        panelGradient1.add(menuPanel, java.awt.BorderLayout.LINE_START);

        cardPanel.setColorPrimary(new java.awt.Color(0, 0, 0));
        cardPanel.setColorSecondary(new java.awt.Color(51, 51, 51));
        cardPanel.setLayout(new java.awt.CardLayout());

        homePage.setColorPrimary(new java.awt.Color(255, 255, 204));
        homePage.setColorSecondary(new java.awt.Color(255, 255, 204));
        homePage.setPreferredSize(new java.awt.Dimension(900, 800));
        homePage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder1.setBackground(new java.awt.Color(39, 40, 72));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("WELCOME ADMIN!");

        lblAdminName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblAdminName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdminName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/adminSmallUser.png"))); // NOI18N
        lblAdminName.setText("jLabel2");
        lblAdminName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAdminNameMouseClicked(evt);
            }
        });

        panelBorder1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelBorder1.setLayer(lblAdminName, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 489, Short.MAX_VALUE)
                .addComponent(lblAdminName, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAdminName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        homePage.add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1070, 70));

        panelBorder2.setBackground(new java.awt.Color(109, 113, 249));
        panelBorder2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jScrollPane1.setRowHeaderView(null);

        mostLogsTable.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        mostLogsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ROLE", "NAME", "NUMBER OF LOGS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        mostLogsTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        mostLogsTable.setEnabled(false);
        mostLogsTable.setGridColor(new java.awt.Color(0, 0, 0));
        mostLogsTable.setOpaque(false);
        mostLogsTable.setSelectionForeground(new java.awt.Color(101, 100, 124));
        mostLogsTable.setShowGrid(true);
        jScrollPane1.setViewportView(mostLogsTable);
        if (mostLogsTable.getColumnModel().getColumnCount() > 0) {
            mostLogsTable.getColumnModel().getColumn(0).setResizable(false);
            mostLogsTable.getColumnModel().getColumn(0).setPreferredWidth(30);
            mostLogsTable.getColumnModel().getColumn(1).setResizable(false);
            mostLogsTable.getColumnModel().getColumn(1).setPreferredWidth(30);
            mostLogsTable.getColumnModel().getColumn(2).setResizable(false);
            mostLogsTable.getColumnModel().getColumn(2).setPreferredWidth(20);
        }

        panelBorder2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 470, 130));

        lblTopFiveLogs.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTopFiveLogs.setText("TOP 5");
        panelBorder2.add(lblTopFiveLogs, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 15, 140, 40));

        homePage.add(panelBorder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, 500, 210));

        panelBorder3.setBackground(new java.awt.Color(109, 113, 249));
        panelBorder3.setPreferredSize(new java.awt.Dimension(495, 210));

        longestTimeSpentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ROLE", "NAME", "TIME DURATION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        longestTimeSpentTable.setEnabled(false);
        longestTimeSpentTable.setShowGrid(true);
        jScrollPane2.setViewportView(longestTimeSpentTable);
        if (longestTimeSpentTable.getColumnModel().getColumnCount() > 0) {
            longestTimeSpentTable.getColumnModel().getColumn(0).setResizable(false);
            longestTimeSpentTable.getColumnModel().getColumn(0).setPreferredWidth(30);
            longestTimeSpentTable.getColumnModel().getColumn(1).setResizable(false);
            longestTimeSpentTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            longestTimeSpentTable.getColumnModel().getColumn(2).setResizable(false);
            longestTimeSpentTable.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        panelBorder3.add(jScrollPane2);
        jScrollPane2.setBounds(10, 80, 480, 120);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("TOP 5");
        panelBorder3.add(jLabel3);
        jLabel3.setBounds(17, 30, 90, 25);

        homePage.add(panelBorder3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 500, -1));

        panelBorder4.setBackground(new java.awt.Color(160, 118, 249));

        lblRegisteredIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegisteredIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/registeredUser.png"))); // NOI18N
        panelBorder4.add(lblRegisteredIcon);
        lblRegisteredIcon.setBounds(10, 10, 80, 60);

        lblNumberOfActive.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblNumberOfActive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumberOfActive.setText("0");
        panelBorder4.add(lblNumberOfActive);
        lblNumberOfActive.setBounds(90, 80, 100, 70);

        lblActiveIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/active.png"))); // NOI18N
        panelBorder4.add(lblActiveIcon);
        lblActiveIcon.setBounds(20, 80, 70, 70);

        lblTotalNumberUsers.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblTotalNumberUsers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalNumberUsers.setText("0");
        panelBorder4.add(lblTotalNumberUsers);
        lblTotalNumberUsers.setBounds(90, 0, 100, 70);

        homePage.add(panelBorder4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 210, 160));

        btnDepartment.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDepartment.setText("DEPARTMENT");
        btnDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepartmentActionPerformed(evt);
            }
        });
        panelBorder7.add(btnDepartment);
        btnDepartment.setBounds(100, 100, 120, 23);

        btnYearLevel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnYearLevel.setText("YEAR LEVEL");
        btnYearLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYearLevelActionPerformed(evt);
            }
        });
        panelBorder7.add(btnYearLevel);
        btnYearLevel.setBounds(180, 60, 120, 23);

        btnProgram.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnProgram.setText("PROGRAM");
        btnProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProgramActionPerformed(evt);
            }
        });
        panelBorder7.add(btnProgram);
        btnProgram.setBounds(20, 60, 120, 23);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CUSTOMIZE DROPDOWN");
        panelBorder7.add(jLabel4);
        jLabel4.setBounds(67, 10, 180, 16);

        homePage.add(panelBorder7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 310, 160));

        panelBorder8.setBackground(new java.awt.Color(51, 255, 255));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(jList1);

        panelBorder8.add(jScrollPane5);
        jScrollPane5.setBounds(10, 70, 510, 190);

        lblNotification.setText("NOTIFICATION");
        panelBorder8.add(lblNotification);
        lblNotification.setBounds(20, 20, 110, 16);

        homePage.add(panelBorder8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 540, 280));

        cardPanel.add(homePage, "card6");

        accountPage.setColorPrimary(new java.awt.Color(255, 255, 204));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 204));
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTabbedPane1.setName(""); // NOI18N

        studentAccountPanel.setBackground(new java.awt.Color(0, 102, 255));
        studentAccountPanel.setColorPrimary(new java.awt.Color(255, 255, 204));
        studentAccountPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDeleteStuAcct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDeleteStuAcct.setText("DELETE");
        btnDeleteStuAcct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteStuAcctActionPerformed(evt);
            }
        });
        studentAccountPanel.add(btnDeleteStuAcct, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, -1));

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

        studentAccountPanel.add(studentAcctPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 1040, 330));

        lblSearchStudent.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSearchStudent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentAccountPanel.add(lblSearchStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 20, 40, 40));

        btnAddStudentAcct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddStudentAcct.setText("ADD USER");
        btnAddStudentAcct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStudentAcctActionPerformed(evt);
            }
        });
        studentAccountPanel.add(btnAddStudentAcct, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, -1, -1));

        txtStudentSearchAcct.setText("Enter Search");
        txtStudentSearchAcct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStudentSearchAcctKeyReleased(evt);
            }
        });
        studentAccountPanel.add(txtStudentSearchAcct, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 310, 40));

        btnUpdateStudentAccount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdateStudentAccount.setText("UPDATE");
        btnUpdateStudentAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateStudentAccountActionPerformed(evt);
            }
        });
        studentAccountPanel.add(btnUpdateStudentAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        jTabbedPane1.addTab("STUDENT", studentAccountPanel);

        facultyAccountPanel.setBackground(new java.awt.Color(255, 255, 255));
        facultyAccountPanel.setColorPrimary(new java.awt.Color(255, 255, 204));
        facultyAccountPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSearchFaculty.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSearchFaculty.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        facultyAccountPanel.add(lblSearchFaculty, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 20, 40, 40));

        btnDeleteFacultyAcct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDeleteFacultyAcct.setText("DELETE");
        btnDeleteFacultyAcct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteFacultyAcctActionPerformed(evt);
            }
        });
        facultyAccountPanel.add(btnDeleteFacultyAcct, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));

        btnAddFacultyAccount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddFacultyAccount.setText("ADD USER");
        btnAddFacultyAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFacultyAccountActionPerformed(evt);
            }
        });
        facultyAccountPanel.add(btnAddFacultyAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, -1, -1));

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
        facultyAccountPanel.add(txtFacultySearchAcct, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 390, 40));

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
        facultyAcctTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        facultyAcctPane.setViewportView(facultyAcctTable);

        facultyAccountPanel.add(facultyAcctPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 100, 1010, 320));

        btnUpdateFacultyAcct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdateFacultyAcct.setText("UPDATE");
        btnUpdateFacultyAcct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateFacultyAcctActionPerformed(evt);
            }
        });
        facultyAccountPanel.add(btnUpdateFacultyAcct, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jTabbedPane1.addTab("FACULTY", facultyAccountPanel);

        adminAccountPanel.setBackground(new java.awt.Color(255, 255, 204));
        adminAccountPanel.setColorPrimary(new java.awt.Color(255, 255, 204));
        adminAccountPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        adminAccountTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "FIRST NAME", "LAST NAME", "EMAIL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(adminAccountTable);
        if (adminAccountTable.getColumnModel().getColumnCount() > 0) {
            adminAccountTable.getColumnModel().getColumn(0).setResizable(false);
            adminAccountTable.getColumnModel().getColumn(1).setResizable(false);
        }

        adminAccountPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 1040, 320));

        lblSearchAdmin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSearchAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminAccountPanel.add(lblSearchAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 30, -1, 40));

        btnDeleteAdminAcct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDeleteAdminAcct.setText("DELETE");
        btnDeleteAdminAcct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAdminAcctActionPerformed(evt);
            }
        });
        adminAccountPanel.add(btnDeleteAdminAcct, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, -1));

        txtAdminSearchAcct.setText("Enter Search");
        txtAdminSearchAcct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdminSearchAcctActionPerformed(evt);
            }
        });
        txtAdminSearchAcct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAdminSearchAcctKeyReleased(evt);
            }
        });
        adminAccountPanel.add(txtAdminSearchAcct, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, 290, 40));

        btnUpdateAdminAcct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdateAdminAcct.setText("UPDATE");
        btnUpdateAdminAcct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateAdminAcctActionPerformed(evt);
            }
        });
        adminAccountPanel.add(btnUpdateAdminAcct, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, -1));

        jTabbedPane1.addTab("ADMINS", adminAccountPanel);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setText("ACCOUNTS");
        panelBorder6.add(jLabel6);
        jLabel6.setBounds(30, 10, 200, 50);

        accountPage.setLayer(jTabbedPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        accountPage.setLayer(panelBorder6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout accountPageLayout = new javax.swing.GroupLayout(accountPage);
        accountPage.setLayout(accountPageLayout);
        accountPageLayout.setHorizontalGroup(
            accountPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountPageLayout.createSequentialGroup()
                .addGroup(accountPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(accountPageLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(accountPageLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(panelBorder6, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        accountPageLayout.setVerticalGroup(
            accountPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountPageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        cardPanel.add(accountPage, "card2");

        logsPage.setColorPrimary(new java.awt.Color(255, 255, 204));
        logsPage.setColorSecondary(new java.awt.Color(255, 255, 204));
        logsPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        UsersLogsPanel.setColorPrimary(new java.awt.Color(255, 255, 204));
        UsersLogsPanel.setColorSecondary(new java.awt.Color(255, 255, 204));

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
        logsTable.setEnabled(false);
        logsPane.setViewportView(logsTable);
        if (logsTable.getColumnModel().getColumnCount() > 0) {
            logsTable.getColumnModel().getColumn(0).setResizable(false);
            logsTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            logsTable.getColumnModel().getColumn(1).setResizable(false);
            logsTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            logsTable.getColumnModel().getColumn(2).setResizable(false);
            logsTable.getColumnModel().getColumn(2).setPreferredWidth(150);
            logsTable.getColumnModel().getColumn(3).setResizable(false);
            logsTable.getColumnModel().getColumn(4).setResizable(false);
            logsTable.getColumnModel().getColumn(4).setPreferredWidth(100);
            logsTable.getColumnModel().getColumn(5).setResizable(false);
            logsTable.getColumnModel().getColumn(5).setPreferredWidth(100);
            logsTable.getColumnModel().getColumn(6).setResizable(false);
            logsTable.getColumnModel().getColumn(6).setPreferredWidth(100);
            logsTable.getColumnModel().getColumn(7).setResizable(false);
            logsTable.getColumnModel().getColumn(7).setPreferredWidth(150);
            logsTable.getColumnModel().getColumn(8).setResizable(false);
            logsTable.getColumnModel().getColumn(8).setPreferredWidth(150);
        }

        UsersLogsPanel.add(logsPane);
        logsPane.setBounds(10, 70, 1060, 380);
        UsersLogsPanel.add(lblSeachLogs);
        lblSeachLogs.setBounds(0, 0, 0, 0);

        txtSearchLogs.setText("Enter Search");
        txtSearchLogs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchLogsKeyReleased(evt);
            }
        });
        UsersLogsPanel.add(txtSearchLogs);
        txtSearchLogs.setBounds(340, 20, 310, 22);

        jTabbedPane3.addTab("USER", UsersLogsPanel);

        visitorsLogsPanel.setColorPrimary(new java.awt.Color(255, 255, 204));
        visitorsLogsPanel.setColorSecondary(new java.awt.Color(255, 255, 204));

        visitorsLogsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "LOGS ID", "ID CODE", "NAME", "EMAIL", "MOBILE NUMBER", "GENDER", "PURPOSE", "TIME IN", "TIME OUT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(visitorsLogsTable);
        if (visitorsLogsTable.getColumnModel().getColumnCount() > 0) {
            visitorsLogsTable.getColumnModel().getColumn(0).setResizable(false);
            visitorsLogsTable.getColumnModel().getColumn(0).setPreferredWidth(30);
            visitorsLogsTable.getColumnModel().getColumn(1).setResizable(false);
            visitorsLogsTable.getColumnModel().getColumn(1).setPreferredWidth(30);
            visitorsLogsTable.getColumnModel().getColumn(2).setResizable(false);
            visitorsLogsTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            visitorsLogsTable.getColumnModel().getColumn(3).setResizable(false);
            visitorsLogsTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            visitorsLogsTable.getColumnModel().getColumn(4).setResizable(false);
            visitorsLogsTable.getColumnModel().getColumn(4).setPreferredWidth(80);
            visitorsLogsTable.getColumnModel().getColumn(5).setResizable(false);
            visitorsLogsTable.getColumnModel().getColumn(5).setPreferredWidth(50);
            visitorsLogsTable.getColumnModel().getColumn(6).setResizable(false);
            visitorsLogsTable.getColumnModel().getColumn(6).setPreferredWidth(200);
            visitorsLogsTable.getColumnModel().getColumn(7).setResizable(false);
            visitorsLogsTable.getColumnModel().getColumn(7).setPreferredWidth(100);
            visitorsLogsTable.getColumnModel().getColumn(8).setResizable(false);
            visitorsLogsTable.getColumnModel().getColumn(8).setPreferredWidth(100);
        }

        visitorsLogsPanel.add(jScrollPane4);
        jScrollPane4.setBounds(10, 60, 1040, 350);

        txtVisitorsLogsSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVisitorsLogsSearchActionPerformed(evt);
            }
        });
        txtVisitorsLogsSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtVisitorsLogsSearchKeyReleased(evt);
            }
        });
        visitorsLogsPanel.add(txtVisitorsLogsSearch);
        txtVisitorsLogsSearch.setBounds(130, 20, 540, 30);

        jTabbedPane3.addTab("VISITORS", visitorsLogsPanel);

        logsPage.add(jTabbedPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1400, 510));

        panelBorder5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("LOGS");
        panelBorder5.add(jLabel5);
        jLabel5.setBounds(10, 10, 170, 40);

        logsPage.add(panelBorder5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1380, 60));

        cardPanel.add(logsPage, "card4");

        panelGradient1.add(cardPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelGradient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1552, 623));

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
            DAOaccount.deleteAcct(studentID);
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
            DAOaccount.deleteAcct(facultyID);
        } else {
            // lblWarningMessage.setText("Please Select a row you want to delete before hitting the button");
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
        searchUserLogs(search);
    }//GEN-LAST:event_txtSearchLogsKeyReleased

    private void btnProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProgramActionPerformed
        ComboBoxContentProgram dialog = new ComboBoxContentProgram(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_btnProgramActionPerformed

    private void btnYearLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYearLevelActionPerformed
        ComboBoxContentYearLevel dialog = new ComboBoxContentYearLevel(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_btnYearLevelActionPerformed

    private void btnDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepartmentActionPerformed
        ComboBoxContentDepartment dialog = new ComboBoxContentDepartment(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_btnDepartmentActionPerformed

    private void btnUpdateStudentAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateStudentAccountActionPerformed
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

            int id = ComLabMethods.getUserID(studentID);
            UpdateAcct updateDialog = new UpdateAcct(new javax.swing.JFrame(), true);
            updateDialog.setStudentData(id, studentID, email, firstName, lastName, program, yearLevel);
            updateDialog.setVisible(true);
            displayStudentAccount();
            System.out.println("bakit ayaw?");
        }
        displayStudentAccount();
        displayFacultyAccount();
        displayAdminAccount();
    }//GEN-LAST:event_btnUpdateStudentAccountActionPerformed

    private void btnUpdateFacultyAcctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateFacultyAcctActionPerformed
        DefaultTableModel model = (DefaultTableModel) facultyAcctTable.getModel();
        int selectedRow = facultyAcctTable.getSelectedRow();

        if (selectedRow != -1) {
            // Get the values of each column in the selected row
            String facultyAdminID = (String) model.getValueAt(selectedRow, 0);
            String department = (String) model.getValueAt(selectedRow, 1);
            String email = (String) model.getValueAt(selectedRow, 2);
            String firstName = (String) model.getValueAt(selectedRow, 3);
            String lastName = (String) model.getValueAt(selectedRow, 4);

            int id = ComLabMethods.getUserID(facultyAdminID);
            UpdateAcct updateDialog = new UpdateAcct(new javax.swing.JFrame(), true);
            updateDialog.setFacultyData(id, facultyAdminID, department, email, firstName, lastName);
            updateDialog.setVisible(true);
        }
        displayStudentAccount();
        displayFacultyAccount();
        displayAdminAccount();
    }//GEN-LAST:event_btnUpdateFacultyAcctActionPerformed

    private void lblAdminNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAdminNameMouseClicked
        UserProfile dialog = new UserProfile(new javax.swing.JFrame(), true);
        String studentfacultyID = getSfID();
        System.out.println(studentfacultyID);
        String userInfo = ComLabMethods.getInfo(studentfacultyID);
        String[] parts = userInfo.split(",");
        int id = Integer.parseInt(parts[0]);
        String studFaculID = parts[1];
        String fname = parts[2];
        String lname = parts[3];
        String email = parts[4];
        String program = parts[5];
        String yearLevel = parts[6];
        String department = parts[7];

        dialog.setAdminInfo(id, studFaculID, fname, lname, email, program, yearLevel, department);
        dialog.setVisible(true);
    }//GEN-LAST:event_lblAdminNameMouseClicked

    private void btnDeleteAdminAcctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAdminAcctActionPerformed
        DefaultTableModel model = (DefaultTableModel) adminAccountTable.getModel();
        int selectedRow = adminAccountTable.getSelectedRow();
        if (selectedRow != 1) {
            String adminID = (String) model.getValueAt(selectedRow, 0);
            model.removeRow(selectedRow);
            DAOaccount.deleteAcct(adminID);
            displayStudentAccount();
            displayFacultyAccount();
            displayAdminAccount();
        }

    }//GEN-LAST:event_btnDeleteAdminAcctActionPerformed

    private void txtAdminSearchAcctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdminSearchAcctActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdminSearchAcctActionPerformed

    private void txtAdminSearchAcctKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdminSearchAcctKeyReleased
        String search = txtAdminSearchAcct.getText();
        searchAdminAcct(search);
    }//GEN-LAST:event_txtAdminSearchAcctKeyReleased

    private void btnUpdateAdminAcctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateAdminAcctActionPerformed
        DefaultTableModel model = (DefaultTableModel) adminAccountTable.getModel();
        int selectedRow = adminAccountTable.getSelectedRow();

        if (selectedRow != -1) {
            // Get the values of each column in the selected row
            String facultyAdminID = (String) model.getValueAt(selectedRow, 0);
            String firstName = (String) model.getValueAt(selectedRow, 1);
            String lastName = (String) model.getValueAt(selectedRow, 2);
            String email = (String) model.getValueAt(selectedRow, 3);

            int id = ComLabMethods.getUserID(facultyAdminID);
            UpdateAcct updateDialog = new UpdateAcct(new javax.swing.JFrame(), true);
            updateDialog.setAdminData(id, facultyAdminID, firstName, lastName, email);
            updateDialog.setVisible(true);
        }
        displayStudentAccount();
        displayFacultyAccount();
        displayAdminAccount();
    }//GEN-LAST:event_btnUpdateAdminAcctActionPerformed

    private void lblHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseEntered
        panelHome.setBackground(new Color(220, 220, 220, 100));
    }//GEN-LAST:event_lblHomeMouseEntered

    private void lblHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseExited
        panelHome.setBackground(new Color(0, 0, 0, 0));
    }//GEN-LAST:event_lblHomeMouseExited

    private void lblAccountsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAccountsMouseEntered
        panelAccounts.setBackground(new Color(220, 220, 220, 100));
    }//GEN-LAST:event_lblAccountsMouseEntered

    private void lblAccountsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAccountsMouseExited
        panelAccounts.setBackground(new Color(0, 0, 0, 0));
    }//GEN-LAST:event_lblAccountsMouseExited

    private void lblAllLogsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAllLogsMouseEntered
        panelLogs.setBackground(new Color(220, 220, 220, 100));
    }//GEN-LAST:event_lblAllLogsMouseEntered

    private void lblAllLogsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAllLogsMouseExited
        panelLogs.setBackground(new Color(0, 0, 0, 0));
    }//GEN-LAST:event_lblAllLogsMouseExited

    private void txtVisitorsLogsSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVisitorsLogsSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVisitorsLogsSearchActionPerformed

    private void txtVisitorsLogsSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVisitorsLogsSearchKeyReleased
        String search = txtVisitorsLogsSearch.getText();
        searchVisitorsLogs(search);
    }//GEN-LAST:event_txtVisitorsLogsSearchKeyReleased

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        UserDashboardMethods.userLogout(getSfID());
        dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private computerlabsystem.Design.PanelGradient UsersLogsPanel;
    private computerlabsystem.Design.PanelGradient accountPage;
    private computerlabsystem.Design.PanelGradient adminAccountPanel;
    private javax.swing.JTable adminAccountTable;
    private javax.swing.JButton btnAddFacultyAccount;
    private javax.swing.JButton btnAddStudentAcct;
    private javax.swing.JButton btnDeleteAdminAcct;
    private javax.swing.JButton btnDeleteFacultyAcct;
    private javax.swing.JButton btnDeleteStuAcct;
    private javax.swing.JButton btnDepartment;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnProgram;
    private javax.swing.JButton btnUpdateAdminAcct;
    private javax.swing.JButton btnUpdateFacultyAcct;
    private javax.swing.JButton btnUpdateStudentAccount;
    private javax.swing.JButton btnYearLevel;
    private computerlabsystem.Design.PanelGradient cardPanel;
    private computerlabsystem.Design.PanelGradient facultyAccountPanel;
    private javax.swing.JScrollPane facultyAcctPane;
    private final javax.swing.JTable facultyAcctTable = new javax.swing.JTable();
    private computerlabsystem.Design.PanelGradient homePage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel lblAccounts;
    private javax.swing.JLabel lblActiveIcon;
    private javax.swing.JLabel lblAdminName;
    private javax.swing.JLabel lblAllLogs;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblNotification;
    private javax.swing.JLabel lblNumberOfActive;
    private javax.swing.JLabel lblRegisteredIcon;
    private javax.swing.JLabel lblSeachLogs;
    private javax.swing.JLabel lblSearchAdmin;
    private javax.swing.JLabel lblSearchFaculty;
    private javax.swing.JLabel lblSearchStudent;
    private javax.swing.JLabel lblTopFiveLogs;
    private javax.swing.JLabel lblTotalNumberUsers;
    private computerlabsystem.Design.PanelGradient logsPage;
    private javax.swing.JScrollPane logsPane;
    private javax.swing.JTable logsTable;
    private javax.swing.JTable longestTimeSpentTable;
    private computerlabsystem.Design.PanelGradient menuPanel;
    private javax.swing.JTable mostLogsTable;
    private computerlabsystem.Design.PanelBorder panelAccounts;
    private computerlabsystem.Design.PanelBorder panelBorder1;
    private computerlabsystem.Design.PanelBorder panelBorder2;
    private computerlabsystem.Design.PanelBorder panelBorder3;
    private computerlabsystem.Design.PanelBorder panelBorder4;
    private computerlabsystem.Design.PanelBorder panelBorder5;
    private computerlabsystem.Design.PanelBorder panelBorder6;
    private computerlabsystem.Design.PanelBorder panelBorder7;
    private computerlabsystem.Design.PanelBorder panelBorder8;
    private computerlabsystem.Design.PanelGradient panelGradient1;
    private computerlabsystem.Design.PanelBorder panelHome;
    private computerlabsystem.Design.PanelBorder panelLogs;
    private computerlabsystem.Design.PanelGradient studentAccountPanel;
    private javax.swing.JScrollPane studentAcctPane;
    private javax.swing.JTable studentAcctTable;
    private javax.swing.JTextField txtAdminSearchAcct;
    private javax.swing.JTextField txtFacultySearchAcct;
    private javax.swing.JTextField txtSearchLogs;
    private javax.swing.JTextField txtStudentSearchAcct;
    private javax.swing.JTextField txtVisitorsLogsSearch;
    private computerlabsystem.Design.PanelGradient visitorsLogsPanel;
    private javax.swing.JTable visitorsLogsTable;
    // End of variables declaration//GEN-END:variables
}
