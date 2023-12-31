/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package computerlabsystem;

import java.awt.Color;
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

    private String sfID;

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
        ComLabMethods clm = new ComLabMethods();
        clm.Scroll(studentAcctPane);
        clm.Scroll(facultyAcctPane);
        clm.Scroll(adminPane);
        clm.Scroll(logsPane);
        clm.Scroll(visitorPane);
        clm.Table(longestTimeSpentTable);
        clm.Table(mostLogsTable);
        clm.Table(studentAcctTable);
        clm.Table(facultyAcctTable);
        clm.Table(adminAccountTable);
        clm.Table(logsTable);
        clm.Table(visitorsLogsTable);
        displayLongestSpent();
        displayMostLogs();
        displayLogs();
        displayVisitorsLogs();
        displayStudentAccount();
        displayFacultyAccount();
        displayAdminAccount();

    }

    void displayStudentAccount() {
        DefaultTableModel studentAccount = (DefaultTableModel) studentAcctTable.getModel();
        studentAccount.setRowCount(0);

        List<AccountDTO> acctList = ComLabMethods.getAllStudentDatas();

        for (AccountDTO acct : acctList) {
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

    void displayFacultyAccount() {
        DefaultTableModel facultyAccount = (DefaultTableModel) facultyAcctTable.getModel();
        facultyAccount.setRowCount(0);

        List<AccountDTO> acctList = ComLabMethods.getAllFacultiesDatas();

        for (AccountDTO acct : acctList) {
            Object[] row = {acct.getStudentfacultyID(), acct.getDepartment(), acct.getFirstName(), acct.getLastName(), acct.getEmail()};
            facultyAccount.addRow(row);
        }
        lblTotalNumberUsers.setText(String.valueOf(ComLabMethods.getTotalUserRows()));
    }

    void displayAdminAccount() {
        DefaultTableModel adminAccount = (DefaultTableModel) adminAccountTable.getModel();
        adminAccount.setRowCount(0);

        List<AccountDTO> acctList = ComLabMethods.getAllAdminDatas();

        for (AccountDTO acct : acctList) {
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

    void displayLogs() {
        DefaultTableModel allLogs = (DefaultTableModel) logsTable.getModel();
        allLogs.setRowCount(0);

        List<LogsDTO> acctList = LogsDAO.getAllLogs();

        for (LogsDTO acct : acctList) {
            Object[] logsRow = {acct.getRole(), acct.getFullname(), acct.getProgram(), acct.getYrlvl(), acct.getDepartment(), acct.getLoginTime(), acct.getLogoutTime(), acct.getAccountableName()};
            allLogs.addRow(logsRow);
        }
    }

    void displayVisitorsLogs() {
        DefaultTableModel visitorsLogs = (DefaultTableModel) visitorsLogsTable.getModel();
        visitorsLogs.setRowCount(0);

        List<VisitorsDTO> visitorsList = LogsDAO.getAllVisitorsLogs();

        for (VisitorsDTO acct : visitorsList) {
            Object[] logsRow = {acct.getFullname(), acct.getEmail(), acct.getMobilenumber(), acct.getGender(), acct.getPurpose(), acct.getLoginTime(), acct.getLogoutTime()};
            visitorsLogs.addRow(logsRow);
        }
    }

    private void insertContentComboProgram() {
        JComboBox<String> comboBox = new JComboBox<>();
        List<AccountDTO> programList = ComLabMethods.programComboContent();
        if (!programList.isEmpty()) {
            AccountDTO acct = programList.get(0);
            comboBox.addItem(acct.getProgram());
        }
    }

    private void insertContentComboYearLvl() {
        JComboBox<String> comboBox = new JComboBox<>();
        List<AccountDTO> yrLvlList = ComLabMethods.yearlvlComboContent();
        if (!yrLvlList.isEmpty()) {
            AccountDTO acct = yrLvlList.get(1);
            comboBox.addItem(acct.getYrlvl());
        }
    }

    private void insertContentComboDepartment() {
        JComboBox<String> comboBox = new JComboBox<>();
        List<AccountDTO> departmentList = ComLabMethods.departmentComboContent();
        if (!departmentList.isEmpty()) {
            AccountDTO acct = departmentList.get(2);
            comboBox.addItem(acct.getDepartment());
        }
    }

    private void displayDepartment() {
        DefaultTableModel allDepartment = (DefaultTableModel) logsTable.getModel();
        allDepartment.setRowCount(0);

        List<LogsDTO> departmentList = LogsDAO.getAllLogs();

        for (LogsDTO acct : departmentList) {
            Object[] departmentRow = {acct.getDepartment()};
            allDepartment.addRow(departmentRow);
        }
    }

    void displayMostLogs() {
        DefaultTableModel mostLogs = (DefaultTableModel) mostLogsTable.getModel();
        mostLogs.setRowCount(0);

        List<AccountDTO> mostLogsList = ComLabMethods.mostLogs();

        for (AccountDTO acct : mostLogsList) {
            Object[] mLogs = {acct.getRole(), acct.getFullname(), acct.getMostLogs()};
            mostLogs.addRow(mLogs);
        }
    }

    void displayLongestSpent() {
        DefaultTableModel longestSpent = (DefaultTableModel) longestTimeSpentTable.getModel();
        longestSpent.setRowCount(0);

        List<AccountDTO> longestTimeSpent = ComLabMethods.longestTimeSpent();

        for (AccountDTO acct : longestTimeSpent) {
            Object[] longestTimeS = {acct.getRole(), acct.getFullname(), acct.getLogsDuration()};
            longestSpent.addRow(longestTimeS);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradient1 = new computerlabsystem.Design.PanelGradient();
        menuDashboard = new computerlabsystem.Design.PanelBorder();
        panelHome = new computerlabsystem.Design.PanelBorder();
        lblHome = new javax.swing.JLabel();
        panelAccounts = new computerlabsystem.Design.PanelBorder();
        lblAccounts = new javax.swing.JLabel();
        panelLogs = new computerlabsystem.Design.PanelBorder();
        lblAllLogs = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelLogout = new computerlabsystem.Design.PanelBorder();
        lblLogout = new javax.swing.JLabel();
        cardPanel = new computerlabsystem.Design.PanelGradient();
        homePage = new computerlabsystem.Design.PanelGradient();
        panelBorder1 = new computerlabsystem.Design.PanelBorder();
        lblAdminName = new javax.swing.JLabel();
        panelBorder2 = new computerlabsystem.Design.PanelBorder();
        scroll = new javax.swing.JScrollPane();
        mostLogsTable = new javax.swing.JTable();
        lblTopFiveLogs = new javax.swing.JLabel();
        panelBorder3 = new computerlabsystem.Design.PanelBorder();
        jScrollPane2 = new javax.swing.JScrollPane();
        longestTimeSpentTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        panelBorder4 = new computerlabsystem.Design.PanelBorder();
        lblRegisteredIcon = new javax.swing.JLabel();
        lblTotalNumberUsers = new javax.swing.JLabel();
        panelBorder7 = new computerlabsystem.Design.PanelBorder();
        btnDepartment = new javax.swing.JButton();
        btnYearLevel = new javax.swing.JButton();
        btnProgram = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        panelBorder8 = new computerlabsystem.Design.PanelBorder();
        chartPanel1 = new computerlabsystem.ChartPanel();
        jLabel1 = new javax.swing.JLabel();
        panelBorder9 = new computerlabsystem.Design.PanelBorder();
        lblActiveIcon = new javax.swing.JLabel();
        lblNumberOfActive = new javax.swing.JLabel();
        btnRefresh2 = new javax.swing.JLabel();
        accountPage = new computerlabsystem.Design.PanelGradient();
        jLabel6 = new javax.swing.JLabel();
        panelBorder10 = new computerlabsystem.Design.PanelBorder();
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
        adminPane = new javax.swing.JScrollPane();
        adminAccountTable = new javax.swing.JTable();
        lblSearchAdmin = new javax.swing.JLabel();
        btnDeleteAdminAcct = new javax.swing.JButton();
        txtAdminSearchAcct = new javax.swing.JTextField();
        btnUpdateAdminAcct = new javax.swing.JButton();
        btnRefresh = new javax.swing.JLabel();
        logsPage = new computerlabsystem.Design.PanelGradient();
        panelBorder5 = new computerlabsystem.Design.PanelBorder();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        UsersLogsPanel = new computerlabsystem.Design.PanelGradient();
        logsPane = new javax.swing.JScrollPane();
        logsTable = new javax.swing.JTable();
        lblSeachLogs = new javax.swing.JLabel();
        lblSearchIcon = new javax.swing.JLabel();
        txtSearchLogs = new javax.swing.JTextField();
        visitorsLogsPanel = new computerlabsystem.Design.PanelGradient();
        lblIconSearch = new javax.swing.JLabel();
        visitorPane = new javax.swing.JScrollPane();
        visitorsLogsTable = new javax.swing.JTable();
        txtVisitorsLogsSearch = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnRefresh1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1250, 600));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelGradient1.setBackground(new java.awt.Color(255, 255, 204));
        panelGradient1.setColorPrimary(new java.awt.Color(255, 255, 204));
        panelGradient1.setColorSecondary(new java.awt.Color(255, 255, 204));
        panelGradient1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuDashboard.setBackground(new java.awt.Color(109, 113, 249));

        panelHome.setBackground((new Color(0, 0, 0, 0)));
        panelHome.setLayout(new java.awt.GridLayout(1, 0));

        lblHome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblHome.setForeground(new java.awt.Color(255, 255, 255));
        lblHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menuDashboardIcon.png"))); // NOI18N
        lblHome.setText("DASHBOARD");
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
        lblHome.getAccessibleContext().setAccessibleName("");

        menuDashboard.add(panelHome);
        panelHome.setBounds(10, 220, 130, 50);

        panelAccounts.setBackground((new Color(0, 0, 0, 0)));
        panelAccounts.setLayout(new java.awt.GridLayout(1, 0));

        lblAccounts.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAccounts.setForeground(new java.awt.Color(255, 255, 255));
        lblAccounts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menuUserIcon.png"))); // NOI18N
        lblAccounts.setText("ACCOUNTS");
        lblAccounts.setMaximumSize(new java.awt.Dimension(122, 30));
        lblAccounts.setMinimumSize(new java.awt.Dimension(122, 30));
        lblAccounts.setPreferredSize(new java.awt.Dimension(122, 30));
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
        lblAccounts.getAccessibleContext().setAccessibleName("");

        menuDashboard.add(panelAccounts);
        panelAccounts.setBounds(10, 280, 130, 50);

        panelLogs.setBackground((new Color(0, 0, 0, 0)));
        panelLogs.setLayout(new java.awt.GridLayout(1, 0));

        lblAllLogs.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAllLogs.setForeground(new java.awt.Color(255, 255, 255));
        lblAllLogs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menuLogsIcon.png"))); // NOI18N
        lblAllLogs.setText("LOGS");
        lblAllLogs.setMaximumSize(new java.awt.Dimension(122, 30));
        lblAllLogs.setMinimumSize(new java.awt.Dimension(122, 30));
        lblAllLogs.setPreferredSize(new java.awt.Dimension(122, 30));
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
        lblAllLogs.getAccessibleContext().setAccessibleName("");

        menuDashboard.add(panelLogs);
        panelLogs.setBounds(10, 350, 130, 50);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo.png"))); // NOI18N
        menuDashboard.add(jLabel2);
        jLabel2.setBounds(0, 10, 140, 120);

        panelLogout.setLayout(new java.awt.GridLayout(1, 0));

        lblLogout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLogout.setForeground(new java.awt.Color(255, 255, 255));
        lblLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menuLogoutIcon.png"))); // NOI18N
        lblLogout.setText("LOGOUT");
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLogoutMouseExited(evt);
            }
        });
        panelLogout.add(lblLogout);

        menuDashboard.add(panelLogout);
        panelLogout.setBounds(10, 520, 130, 50);

        panelGradient1.add(menuDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 580));

        cardPanel.setColorPrimary(new java.awt.Color(0, 0, 0));
        cardPanel.setColorSecondary(new java.awt.Color(51, 51, 51));
        cardPanel.setLayout(new java.awt.CardLayout());

        homePage.setColorPrimary(new java.awt.Color(255, 255, 204));
        homePage.setColorSecondary(new java.awt.Color(255, 255, 204));
        homePage.setPreferredSize(new java.awt.Dimension(900, 800));
        homePage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder1.setBackground(new java.awt.Color(79, 255, 176));

        lblAdminName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblAdminName.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblAdminName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/dashboardUserIcon.png"))); // NOI18N
        lblAdminName.setText("jLabel2");
        lblAdminName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAdminNameMouseClicked(evt);
            }
        });

        panelBorder1.setLayer(lblAdminName, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addContainerGap(474, Short.MAX_VALUE)
                .addComponent(lblAdminName, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAdminName, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );

        homePage.add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 680, 90));

        panelBorder2.setBackground(new java.awt.Color(109, 113, 249));
        panelBorder2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scroll.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        scroll.setRowHeaderView(null);

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
        mostLogsTable.setRowHeight(22);
        mostLogsTable.setSelectionForeground(new java.awt.Color(101, 100, 124));
        mostLogsTable.setShowGrid(true);
        scroll.setViewportView(mostLogsTable);
        if (mostLogsTable.getColumnModel().getColumnCount() > 0) {
            mostLogsTable.getColumnModel().getColumn(0).setResizable(false);
            mostLogsTable.getColumnModel().getColumn(0).setPreferredWidth(30);
            mostLogsTable.getColumnModel().getColumn(1).setResizable(false);
            mostLogsTable.getColumnModel().getColumn(1).setPreferredWidth(30);
            mostLogsTable.getColumnModel().getColumn(2).setResizable(false);
            mostLogsTable.getColumnModel().getColumn(2).setPreferredWidth(20);
        }

        panelBorder2.add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 490, 160));

        lblTopFiveLogs.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        lblTopFiveLogs.setForeground(new java.awt.Color(255, 255, 255));
        lblTopFiveLogs.setText("TOP 5 MOST LOGS");
        panelBorder2.add(lblTopFiveLogs, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 240, 40));

        homePage.add(panelBorder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 350, 510, 240));

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
        longestTimeSpentTable.setOpaque(false);
        longestTimeSpentTable.setRowHeight(22);
        longestTimeSpentTable.setSelectionBackground(new java.awt.Color(55, 126, 249));
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
        jScrollPane2.setBounds(10, 60, 490, 150);

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TOP 5 LONGEST TIME SPENT");
        panelBorder3.add(jLabel3);
        jLabel3.setBounds(10, 20, 400, 29);

        homePage.add(panelBorder3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 510, 220));

        panelBorder4.setBackground(new java.awt.Color(79, 255, 176));

        lblRegisteredIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegisteredIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/dashboardRegisteredUserIcon.png"))); // NOI18N
        panelBorder4.add(lblRegisteredIcon);
        lblRegisteredIcon.setBounds(0, 0, 90, 80);

        lblTotalNumberUsers.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        lblTotalNumberUsers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalNumberUsers.setText("0");
        panelBorder4.add(lblTotalNumberUsers);
        lblTotalNumberUsers.setBounds(110, 0, 110, 80);

        homePage.add(panelBorder4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 220, 80));

        panelBorder7.setBackground(new java.awt.Color(79, 255, 176));

        btnDepartment.setBackground(new java.awt.Color(39, 40, 72));
        btnDepartment.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDepartment.setForeground(new java.awt.Color(255, 255, 255));
        btnDepartment.setText("DEPARTMENT");
        btnDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepartmentActionPerformed(evt);
            }
        });
        panelBorder7.add(btnDepartment);
        btnDepartment.setBounds(90, 120, 120, 35);

        btnYearLevel.setBackground(new java.awt.Color(39, 40, 72));
        btnYearLevel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnYearLevel.setForeground(new java.awt.Color(255, 255, 255));
        btnYearLevel.setText("YEAR LEVEL");
        btnYearLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYearLevelActionPerformed(evt);
            }
        });
        panelBorder7.add(btnYearLevel);
        btnYearLevel.setBounds(170, 60, 120, 35);

        btnProgram.setBackground(new java.awt.Color(39, 40, 72));
        btnProgram.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnProgram.setForeground(new java.awt.Color(255, 255, 255));
        btnProgram.setText("PROGRAM");
        btnProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProgramActionPerformed(evt);
            }
        });
        panelBorder7.add(btnProgram);
        btnProgram.setBounds(20, 60, 120, 35);

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CUSTOMIZE DROPDOWN");
        panelBorder7.add(jLabel4);
        jLabel4.setBounds(7, 10, 300, 29);

        homePage.add(panelBorder7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 310, 180));

        panelBorder8.setBackground(new java.awt.Color(79, 255, 176));
        panelBorder8.add(chartPanel1);
        chartPanel1.setBounds(10, 10, 520, 260);

        homePage.add(panelBorder8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 540, 280));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        jLabel1.setText("DASHBOARD");
        homePage.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        panelBorder9.setBackground(new java.awt.Color(79, 255, 176));

        lblActiveIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblActiveIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/dashboardActiveUser.png"))); // NOI18N
        panelBorder9.add(lblActiveIcon);
        lblActiveIcon.setBounds(0, 0, 90, 70);

        lblNumberOfActive.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        lblNumberOfActive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumberOfActive.setText("0");
        panelBorder9.add(lblNumberOfActive);
        lblNumberOfActive.setBounds(110, 0, 110, 80);

        homePage.add(panelBorder9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 220, 80));

        btnRefresh2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRefresh2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        btnRefresh2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRefresh2MouseClicked(evt);
            }
        });
        homePage.add(btnRefresh2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 30, 80, 40));

        cardPanel.add(homePage, "card6");

        accountPage.setColorPrimary(new java.awt.Color(255, 255, 204));
        accountPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        jLabel6.setText("ACCOUNTS");
        accountPage.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 340, 50));

        panelBorder10.setBackground(new java.awt.Color(109, 113, 249));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 204));
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTabbedPane1.setName(""); // NOI18N

        studentAccountPanel.setBackground(new java.awt.Color(0, 102, 255));
        studentAccountPanel.setColorPrimary(new java.awt.Color(255, 255, 204));
        studentAccountPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDeleteStuAcct.setBackground(new java.awt.Color(255, 51, 51));
        btnDeleteStuAcct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDeleteStuAcct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-delete-20.png"))); // NOI18N
        btnDeleteStuAcct.setText("DELETE");
        btnDeleteStuAcct.setEnabled(false);
        btnDeleteStuAcct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteStuAcctActionPerformed(evt);
            }
        });
        studentAccountPanel.add(btnDeleteStuAcct, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, -1, -1));

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
        studentAcctTable.setShowGrid(true);
        studentAcctTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentAcctTableMouseClicked(evt);
            }
        });
        studentAcctPane.setViewportView(studentAcctTable);

        studentAccountPanel.add(studentAcctPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 990, 330));

        lblSearchStudent.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSearchStudent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSearchStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-search-20.png"))); // NOI18N
        studentAccountPanel.add(lblSearchStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 20, 40, 40));

        btnAddStudentAcct.setBackground(new java.awt.Color(204, 255, 204));
        btnAddStudentAcct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddStudentAcct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-add-user-20.png"))); // NOI18N
        btnAddStudentAcct.setText("ADD USER");
        btnAddStudentAcct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStudentAcctActionPerformed(evt);
            }
        });
        studentAccountPanel.add(btnAddStudentAcct, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, -1, -1));

        txtStudentSearchAcct.setText("Enter Search");
        txtStudentSearchAcct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStudentSearchAcctKeyReleased(evt);
            }
        });
        studentAccountPanel.add(txtStudentSearchAcct, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 390, 40));

        btnUpdateStudentAccount.setBackground(new java.awt.Color(51, 102, 255));
        btnUpdateStudentAccount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdateStudentAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-update-20.png"))); // NOI18N
        btnUpdateStudentAccount.setText("UPDATE");
        btnUpdateStudentAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateStudentAccountActionPerformed(evt);
            }
        });
        studentAccountPanel.add(btnUpdateStudentAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jTabbedPane1.addTab("STUDENT", studentAccountPanel);

        facultyAccountPanel.setBackground(new java.awt.Color(255, 255, 255));
        facultyAccountPanel.setColorPrimary(new java.awt.Color(255, 255, 204));
        facultyAccountPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSearchFaculty.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSearchFaculty.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSearchFaculty.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-search-20.png"))); // NOI18N
        facultyAccountPanel.add(lblSearchFaculty, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 20, 50, 40));

        btnDeleteFacultyAcct.setBackground(new java.awt.Color(255, 51, 51));
        btnDeleteFacultyAcct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDeleteFacultyAcct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-delete-20.png"))); // NOI18N
        btnDeleteFacultyAcct.setText("DELETE");
        btnDeleteFacultyAcct.setEnabled(false);
        btnDeleteFacultyAcct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteFacultyAcctActionPerformed(evt);
            }
        });
        facultyAccountPanel.add(btnDeleteFacultyAcct, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));

        btnAddFacultyAccount.setBackground(new java.awt.Color(204, 255, 204));
        btnAddFacultyAccount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddFacultyAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-add-user-20.png"))); // NOI18N
        btnAddFacultyAccount.setText("ADD USER");
        btnAddFacultyAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFacultyAccountActionPerformed(evt);
            }
        });
        facultyAccountPanel.add(btnAddFacultyAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, -1, -1));

        txtFacultySearchAcct.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtFacultySearchAcct.setText("Search");
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
        facultyAccountPanel.add(txtFacultySearchAcct, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 390, 40));

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
        facultyAcctTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                facultyAcctTableMouseClicked(evt);
            }
        });
        facultyAcctPane.setViewportView(facultyAcctTable);

        facultyAccountPanel.add(facultyAcctPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 1000, 320));

        btnUpdateFacultyAcct.setBackground(new java.awt.Color(51, 102, 255));
        btnUpdateFacultyAcct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdateFacultyAcct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-update-20.png"))); // NOI18N
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
        adminAccountTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminAccountTableMouseClicked(evt);
            }
        });
        adminPane.setViewportView(adminAccountTable);
        if (adminAccountTable.getColumnModel().getColumnCount() > 0) {
            adminAccountTable.getColumnModel().getColumn(0).setResizable(false);
            adminAccountTable.getColumnModel().getColumn(1).setResizable(false);
        }

        adminAccountPanel.add(adminPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 990, 320));

        lblSearchAdmin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSearchAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSearchAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-search-20.png"))); // NOI18N
        adminAccountPanel.add(lblSearchAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 30, 30, 40));

        btnDeleteAdminAcct.setBackground(new java.awt.Color(255, 51, 51));
        btnDeleteAdminAcct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDeleteAdminAcct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-delete-20.png"))); // NOI18N
        btnDeleteAdminAcct.setText("DELETE");
        btnDeleteAdminAcct.setEnabled(false);
        btnDeleteAdminAcct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAdminAcctActionPerformed(evt);
            }
        });
        adminAccountPanel.add(btnDeleteAdminAcct, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, -1, -1));

        txtAdminSearchAcct.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtAdminSearchAcct.setText("Search");
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
        adminAccountPanel.add(txtAdminSearchAcct, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 390, 40));

        btnUpdateAdminAcct.setBackground(new java.awt.Color(51, 102, 255));
        btnUpdateAdminAcct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdateAdminAcct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-update-20.png"))); // NOI18N
        btnUpdateAdminAcct.setText("UPDATE");
        btnUpdateAdminAcct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateAdminAcctActionPerformed(evt);
            }
        });
        adminAccountPanel.add(btnUpdateAdminAcct, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jTabbedPane1.addTab("ADMINS", adminAccountPanel);

        panelBorder10.add(jTabbedPane1);
        jTabbedPane1.setBounds(10, 0, 1030, 470);

        accountPage.add(panelBorder10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 1050, 490));

        btnRefresh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        btnRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRefreshMouseClicked(evt);
            }
        });
        accountPage.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 30, 80, 40));

        cardPanel.add(accountPage, "card2");

        logsPage.setColorPrimary(new java.awt.Color(255, 255, 204));
        logsPage.setColorSecondary(new java.awt.Color(255, 255, 204));
        logsPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder5.setBackground(new java.awt.Color(109, 113, 249));

        jTabbedPane3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        UsersLogsPanel.setColorPrimary(new java.awt.Color(255, 255, 204));
        UsersLogsPanel.setColorSecondary(new java.awt.Color(255, 255, 204));

        logsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ROLE", "FULL NAME", "PROGRAM", "YEAR LEVEL", "DEPARTMENT", "LOG IN TIME", "LOG OUT TIME", "ACCOUNTABLE PROFESSOR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        logsTable.setEnabled(false);
        logsTable.setRowSelectionAllowed(false);
        logsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        logsTable.setShowGrid(true);
        logsPane.setViewportView(logsTable);
        if (logsTable.getColumnModel().getColumnCount() > 0) {
            logsTable.getColumnModel().getColumn(0).setResizable(false);
            logsTable.getColumnModel().getColumn(0).setPreferredWidth(60);
            logsTable.getColumnModel().getColumn(1).setResizable(false);
            logsTable.getColumnModel().getColumn(2).setResizable(false);
            logsTable.getColumnModel().getColumn(2).setPreferredWidth(60);
            logsTable.getColumnModel().getColumn(3).setResizable(false);
            logsTable.getColumnModel().getColumn(3).setPreferredWidth(70);
            logsTable.getColumnModel().getColumn(4).setResizable(false);
            logsTable.getColumnModel().getColumn(4).setPreferredWidth(100);
            logsTable.getColumnModel().getColumn(5).setResizable(false);
            logsTable.getColumnModel().getColumn(5).setPreferredWidth(150);
            logsTable.getColumnModel().getColumn(6).setResizable(false);
            logsTable.getColumnModel().getColumn(6).setPreferredWidth(150);
            logsTable.getColumnModel().getColumn(7).setResizable(false);
            logsTable.getColumnModel().getColumn(7).setPreferredWidth(200);
        }

        UsersLogsPanel.add(logsPane);
        logsPane.setBounds(10, 70, 1030, 330);
        UsersLogsPanel.add(lblSeachLogs);
        lblSeachLogs.setBounds(0, 0, 0, 0);

        lblSearchIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSearchIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-search-20.png"))); // NOI18N
        UsersLogsPanel.add(lblSearchIcon);
        lblSearchIcon.setBounds(510, 16, 40, 40);

        txtSearchLogs.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtSearchLogs.setText("Search");
        txtSearchLogs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchLogsKeyReleased(evt);
            }
        });
        UsersLogsPanel.add(txtSearchLogs);
        txtSearchLogs.setBounds(10, 20, 540, 30);

        jTabbedPane3.addTab("USER", UsersLogsPanel);

        visitorsLogsPanel.setColorPrimary(new java.awt.Color(255, 255, 204));
        visitorsLogsPanel.setColorSecondary(new java.awt.Color(255, 255, 204));
        visitorsLogsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIconSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-search-20.png"))); // NOI18N
        visitorsLogsPanel.add(lblIconSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 30, 30));

        visitorsLogsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NAME", "EMAIL", "MOBILE NUMBER", "GENDER", "PURPOSE", "TIME IN", "TIME OUT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        visitorsLogsTable.setShowGrid(true);
        visitorPane.setViewportView(visitorsLogsTable);
        if (visitorsLogsTable.getColumnModel().getColumnCount() > 0) {
            visitorsLogsTable.getColumnModel().getColumn(0).setResizable(false);
            visitorsLogsTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            visitorsLogsTable.getColumnModel().getColumn(1).setResizable(false);
            visitorsLogsTable.getColumnModel().getColumn(1).setPreferredWidth(120);
            visitorsLogsTable.getColumnModel().getColumn(2).setResizable(false);
            visitorsLogsTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            visitorsLogsTable.getColumnModel().getColumn(3).setResizable(false);
            visitorsLogsTable.getColumnModel().getColumn(3).setPreferredWidth(50);
            visitorsLogsTable.getColumnModel().getColumn(4).setResizable(false);
            visitorsLogsTable.getColumnModel().getColumn(4).setPreferredWidth(150);
            visitorsLogsTable.getColumnModel().getColumn(5).setResizable(false);
            visitorsLogsTable.getColumnModel().getColumn(5).setPreferredWidth(100);
            visitorsLogsTable.getColumnModel().getColumn(6).setResizable(false);
            visitorsLogsTable.getColumnModel().getColumn(6).setPreferredWidth(100);
        }

        visitorsLogsPanel.add(visitorPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1030, 350));

        txtVisitorsLogsSearch.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtVisitorsLogsSearch.setText("Search");
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
        visitorsLogsPanel.add(txtVisitorsLogsSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 540, 30));

        jTabbedPane3.addTab("VISITORS", visitorsLogsPanel);

        panelBorder5.add(jTabbedPane3);
        jTabbedPane3.setBounds(10, 10, 1050, 480);

        logsPage.add(panelBorder5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1070, 500));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        jLabel5.setText("LOGS");
        logsPage.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 170, 40));

        btnRefresh1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRefresh1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        btnRefresh1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRefresh1MouseClicked(evt);
            }
        });
        logsPage.add(btnRefresh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 30, 80, 40));

        cardPanel.add(logsPage, "card4");

        panelGradient1.add(cardPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 0, 1390, 623));

        getContentPane().add(panelGradient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1552, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseClicked
        cardPanel.removeAll();
        cardPanel.add(homePage);
        cardPanel.repaint();
        cardPanel.revalidate();
        panelAccounts.setBackground(new Color(0, 0, 0, 0));
    }//GEN-LAST:event_lblHomeMouseClicked

    private void lblAccountsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAccountsMouseClicked
        cardPanel.removeAll();
        cardPanel.add(accountPage);
        panelAccounts.setBackground(new Color(0, 0, 0, 50));
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
            AccountDAO.deleteAcct(studentID);
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
            AccountDAO.deleteAcct(facultyID);
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
            AccountDAO.deleteAcct(adminID);
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
        panelHome.setBackground(new Color(0, 0, 0, 50));
    }//GEN-LAST:event_lblHomeMouseEntered

    private void lblHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseExited
        panelHome.setBackground(new Color(0, 0, 0, 0));
    }//GEN-LAST:event_lblHomeMouseExited

    private void lblAccountsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAccountsMouseEntered
        panelAccounts.setBackground(new Color(0, 0, 0, 50));
    }//GEN-LAST:event_lblAccountsMouseEntered

    private void lblAccountsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAccountsMouseExited
        panelAccounts.setBackground(new Color(0, 0, 0, 0));
    }//GEN-LAST:event_lblAccountsMouseExited

    private void lblAllLogsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAllLogsMouseEntered
        panelLogs.setBackground(new Color(0, 0, 0, 50));
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

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        System.out.println(getSfID());
        UserDashboardDAO.userLogout(getSfID());
        dispose();
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void lblLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseEntered
        panelLogout.setBackground(new Color(0, 0, 0, 50));
    }//GEN-LAST:event_lblLogoutMouseEntered

    private void lblLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseExited
        panelLogout.setBackground(new Color(0, 0, 0, 0));
    }//GEN-LAST:event_lblLogoutMouseExited

    private void studentAcctTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentAcctTableMouseClicked
        btnDeleteStuAcct.setEnabled(true);
    }//GEN-LAST:event_studentAcctTableMouseClicked

    private void facultyAcctTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_facultyAcctTableMouseClicked
        btnDeleteFacultyAcct.setEnabled(true);
    }//GEN-LAST:event_facultyAcctTableMouseClicked

    private void adminAccountTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminAccountTableMouseClicked
        btnDeleteAdminAcct.setEnabled(true);
    }//GEN-LAST:event_adminAccountTableMouseClicked

    private void btnRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseClicked
        displayLongestSpent();
        displayMostLogs();
        displayLogs();
        displayVisitorsLogs();
        displayStudentAccount();
        displayFacultyAccount();
        displayAdminAccount();
    }//GEN-LAST:event_btnRefreshMouseClicked

    private void btnRefresh1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefresh1MouseClicked
        displayLongestSpent();
        displayMostLogs();
        displayLogs();
        displayVisitorsLogs();
        displayStudentAccount();
        displayFacultyAccount();
        displayAdminAccount();
    }//GEN-LAST:event_btnRefresh1MouseClicked

    private void btnRefresh2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefresh2MouseClicked
        displayLongestSpent();
        displayMostLogs();
        displayLogs();
        displayVisitorsLogs();
        displayStudentAccount();
        displayFacultyAccount();
        displayAdminAccount();
    }//GEN-LAST:event_btnRefresh2MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private computerlabsystem.Design.PanelGradient UsersLogsPanel;
    private computerlabsystem.Design.PanelGradient accountPage;
    private computerlabsystem.Design.PanelGradient adminAccountPanel;
    private javax.swing.JTable adminAccountTable;
    private javax.swing.JScrollPane adminPane;
    private javax.swing.JButton btnAddFacultyAccount;
    private javax.swing.JButton btnAddStudentAcct;
    private javax.swing.JButton btnDeleteAdminAcct;
    private javax.swing.JButton btnDeleteFacultyAcct;
    private javax.swing.JButton btnDeleteStuAcct;
    private javax.swing.JButton btnDepartment;
    private javax.swing.JButton btnProgram;
    private javax.swing.JLabel btnRefresh;
    private javax.swing.JLabel btnRefresh1;
    private javax.swing.JLabel btnRefresh2;
    private javax.swing.JButton btnUpdateAdminAcct;
    private javax.swing.JButton btnUpdateFacultyAcct;
    private javax.swing.JButton btnUpdateStudentAccount;
    private javax.swing.JButton btnYearLevel;
    private computerlabsystem.Design.PanelGradient cardPanel;
    private computerlabsystem.ChartPanel chartPanel1;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel lblAccounts;
    private javax.swing.JLabel lblActiveIcon;
    private javax.swing.JLabel lblAdminName;
    private javax.swing.JLabel lblAllLogs;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblIconSearch;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblNumberOfActive;
    private javax.swing.JLabel lblRegisteredIcon;
    private javax.swing.JLabel lblSeachLogs;
    private javax.swing.JLabel lblSearchAdmin;
    private javax.swing.JLabel lblSearchFaculty;
    private javax.swing.JLabel lblSearchIcon;
    private javax.swing.JLabel lblSearchStudent;
    private javax.swing.JLabel lblTopFiveLogs;
    private javax.swing.JLabel lblTotalNumberUsers;
    private computerlabsystem.Design.PanelGradient logsPage;
    private javax.swing.JScrollPane logsPane;
    private javax.swing.JTable logsTable;
    private javax.swing.JTable longestTimeSpentTable;
    private computerlabsystem.Design.PanelBorder menuDashboard;
    private javax.swing.JTable mostLogsTable;
    private computerlabsystem.Design.PanelBorder panelAccounts;
    private computerlabsystem.Design.PanelBorder panelBorder1;
    private computerlabsystem.Design.PanelBorder panelBorder10;
    private computerlabsystem.Design.PanelBorder panelBorder2;
    private computerlabsystem.Design.PanelBorder panelBorder3;
    private computerlabsystem.Design.PanelBorder panelBorder4;
    private computerlabsystem.Design.PanelBorder panelBorder5;
    private computerlabsystem.Design.PanelBorder panelBorder7;
    private computerlabsystem.Design.PanelBorder panelBorder8;
    private computerlabsystem.Design.PanelBorder panelBorder9;
    private computerlabsystem.Design.PanelGradient panelGradient1;
    private computerlabsystem.Design.PanelBorder panelHome;
    private computerlabsystem.Design.PanelBorder panelLogout;
    private computerlabsystem.Design.PanelBorder panelLogs;
    private javax.swing.JScrollPane scroll;
    private computerlabsystem.Design.PanelGradient studentAccountPanel;
    private javax.swing.JScrollPane studentAcctPane;
    private javax.swing.JTable studentAcctTable;
    private javax.swing.JTextField txtAdminSearchAcct;
    private javax.swing.JTextField txtFacultySearchAcct;
    private javax.swing.JTextField txtSearchLogs;
    private javax.swing.JTextField txtStudentSearchAcct;
    private javax.swing.JTextField txtVisitorsLogsSearch;
    private javax.swing.JScrollPane visitorPane;
    private computerlabsystem.Design.PanelGradient visitorsLogsPanel;
    private javax.swing.JTable visitorsLogsTable;
    // End of variables declaration//GEN-END:variables
}
