/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package scholarshipmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.text.MessageFormat;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JTable;

/**
 *
 * @author User
 */
public class adminDash extends javax.swing.JFrame {
    Connection conn;
    /**
     * Creates new form adminDashboard
     */
    public adminDash() {
        initComponents();
        
        this.conn = studentDashboard.DBConnection.connect();
    
        if (conn != null) {
            System.out.println("Connection successful!");
        } else {
            System.out.println("Connection failed.");
        }
        loadAdminAccounts();
        studentSubmissionTable();
        announcementTable();
        loadAllStudentsTable();
    }

    private PrintRequestAttributeSet HashPrintRequestAttributeSet() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/bucot_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (java.sql.SQLException ex) {
            System.out.println("Database connection failed: " + ex.getMessage());
            return null;
        }
    }
}
    
    public void loadAdminAccounts() {
    DefaultTableModel model = (DefaultTableModel) admin_account_table.getModel(); // replace 'adminTable' with your JTable variable name
    model.setRowCount(0); // Clear existing rows

    String query = "SELECT * FROM admin WHERE role = 'admin'";

    try (Connection conn = DBConnection.connect();
         PreparedStatement pst = conn.prepareStatement(query);
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            int id = rs.getInt("admin_id");
            String name = rs.getString("name");  // Replace with your actual column
            String email = rs.getString("email");
            String role = rs.getString("role");

            model.addRow(new Object[]{id, name, email, role});
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error loading admin accounts: " + e.getMessage());
    }
}

    public void studentSubmissionTable() {
        DefaultTableModel model = (DefaultTableModel) student_jtable.getModel();
        model.setRowCount(0); // Clear existing rows

        String query = "SELECT s.student_id, s.first_name, s.middle_name, s.last_name, s.email, st.status_name, sub.date_submitted " +
                       "FROM student s " +
                       "JOIN submission sub ON s.sub_id = sub.sub_id " +
                       "JOIN status st ON s.status_id = st.status_id " +
                       "WHERE s.status_id = 3";

        try (Connection conn = DBConnection.connect();
             PreparedStatement pst = conn.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int student_id = rs.getInt("student_id");
                String firstName = rs.getString("first_name");
                String middleName = rs.getString("middle_name");
                String lastName = rs.getString("last_name");
                String fullname = firstName + " " + middleName + " " + lastName;

                String email = rs.getString("email");
                String date_of_sub = rs.getString("date_submitted"); // from submission table
                String status = rs.getString("status_name"); // from status table

                model.addRow(new Object[]{student_id, fullname, email, date_of_sub, status});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading student submissions: " + e.getMessage());
        }

}
    
    
public void announcementTable() {
        DefaultTableModel model = (DefaultTableModel) announcement_table.getModel();
        model.setRowCount(0); // Clear existing rows

        String query = "SELECT title, description, announcement_date FROM announcement_tbl";

        try (Connection conn = DBConnection.connect();
             PreparedStatement pst = conn.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                
                String title = rs.getString("title");
                String desc = rs.getString("description"); 
                String announcement_date = rs.getString("announcement_date");

                model.addRow(new Object[]{title, desc, announcement_date});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading student submissions: " + e.getMessage());
        }

}
    
    


        public void loadAllStudentsTable() {
            DefaultTableModel model = (DefaultTableModel) report_table.getModel();
            model.setRowCount(0); // Clear existing rows

            String query = "SELECT " +
                           "  s.student_id, " +
                           "  CONCAT(s.first_name, ' ', s.middle_name, ' ', s.last_name) AS full_name, " +
                           "  s.sex, " +
                           "  s.purok, " +
                           "  s.email, " +
                           "  sub.date_submitted, " +
                           "  st.status_name " +
                           "FROM student s " +
                           "LEFT JOIN submission sub ON s.sub_id = sub.sub_id " +
                           "LEFT JOIN status st ON s.status_id = st.status_id";

            try (Connection conn = DBConnection.connect();
                 PreparedStatement pst = conn.prepareStatement(query);
                 ResultSet rs = pst.executeQuery()) {

                while (rs.next()) {
                    
                    String fullName = rs.getString("full_name");
                    String sex = rs.getString("sex");
                    String purok = rs.getString("purok");
                    String email = rs.getString("email");
                    String dateSubmitted = rs.getString("date_submitted"); // from submission table
                    String statusName = rs.getString("status_name");       // from status table

                    model.addRow(new Object[]{ fullName, sex, purok, email, dateSubmitted, statusName});
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error loading all students: " + e.getMessage());
            }
        }






    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btn1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btn2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btn3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btn4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        p1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        admin_account_table = new javax.swing.JTable();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        p2 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        student_jtable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        p3 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        announcement_table = new javax.swing.JTable();
        jButton17 = new javax.swing.JButton();
        p4 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        report_table = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();

        jScrollPane3.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(15, 91, 150));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Super Admin Dashboard");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scholarshipmanagement/images/logout (1).png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(0, 2, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 700, 50));

        jPanel3.setBackground(new java.awt.Color(15, 91, 150));

        btn1.setBackground(new java.awt.Color(255, 255, 255));
        btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn1MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Manage Account");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btn1Layout = new javax.swing.GroupLayout(btn1);
        btn1.setLayout(btn1Layout);
        btn1Layout.setHorizontalGroup(
            btn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        btn1Layout.setVerticalGroup(
            btn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn2.setBackground(new java.awt.Color(15, 91, 150));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Review Submission");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btn2Layout = new javax.swing.GroupLayout(btn2);
        btn2.setLayout(btn2Layout);
        btn2Layout.setHorizontalGroup(
            btn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        btn2Layout.setVerticalGroup(
            btn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn3.setBackground(new java.awt.Color(15, 91, 150));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Post Updates");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btn3Layout = new javax.swing.GroupLayout(btn3);
        btn3.setLayout(btn3Layout);
        btn3Layout.setHorizontalGroup(
            btn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        btn3Layout.setVerticalGroup(
            btn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn4.setBackground(new java.awt.Color(15, 91, 150));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Generate Reports");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btn4Layout = new javax.swing.GroupLayout(btn4);
        btn4.setLayout(btn4Layout);
        btn4Layout.setHorizontalGroup(
            btn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        btn4Layout.setVerticalGroup(
            btn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scholarshipmanagement/images/bbss-logo.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 510));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(15, 85, 150));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        admin_account_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "name", "email", "role"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        admin_account_table.setRowHeight(40);
        jScrollPane6.setViewportView(admin_account_table);
        if (admin_account_table.getColumnModel().getColumnCount() > 0) {
            admin_account_table.getColumnModel().getColumn(0).setResizable(false);
            admin_account_table.getColumnModel().getColumn(1).setResizable(false);
            admin_account_table.getColumnModel().getColumn(2).setResizable(false);
            admin_account_table.getColumnModel().getColumn(3).setResizable(false);
        }

        jButton12.setBackground(new java.awt.Color(255, 51, 51));
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("DELETE");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(0, 204, 51));
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("UPDATE");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scholarshipmanagement/images/refresh (1) (1).png"))); // NOI18N
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jButton14)))
                .addGap(22, 22, 22))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton12)
                    .addComponent(jButton13)
                    .addComponent(jButton14))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout p1Layout = new javax.swing.GroupLayout(p1);
        p1.setLayout(p1Layout);
        p1Layout.setHorizontalGroup(
            p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        p1Layout.setVerticalGroup(
            p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 491, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab1", p1);

        p2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(15, 85, 150));
        jLabel11.setText("Submission of Request");

        student_jtable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        student_jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Student ID", "Full Name", "Email", "Date of Submission", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        student_jtable.setRowHeight(40);
        jScrollPane2.setViewportView(student_jtable);
        if (student_jtable.getColumnModel().getColumnCount() > 0) {
            student_jtable.getColumnModel().getColumn(0).setResizable(false);
            student_jtable.getColumnModel().getColumn(1).setResizable(false);
            student_jtable.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Search");

        jButton15.setBackground(new java.awt.Color(15, 91, 150));
        jButton15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("Read");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scholarshipmanagement/images/refresh (1) (1).png"))); // NOI18N
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(154, 154, 154)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jButton15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton16)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton15)
                    .addComponent(jButton16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout p2Layout = new javax.swing.GroupLayout(p2);
        p2.setLayout(p2Layout);
        p2Layout.setHorizontalGroup(
            p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        p2Layout.setVerticalGroup(
            p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab2", p2);

        p3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setBackground(new java.awt.Color(15, 91, 150));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(15, 91, 150));
        jLabel12.setText("Announcements");

        jButton10.setBackground(new java.awt.Color(56, 153, 244));
        jButton10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Add Announcement");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        announcement_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title", "Description", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        announcement_table.setRowHeight(70);
        jScrollPane1.setViewportView(announcement_table);
        if (announcement_table.getColumnModel().getColumnCount() > 0) {
            announcement_table.getColumnModel().getColumn(0).setMinWidth(150);
            announcement_table.getColumnModel().getColumn(0).setPreferredWidth(150);
            announcement_table.getColumnModel().getColumn(0).setMaxWidth(150);
            announcement_table.getColumnModel().getColumn(2).setMinWidth(150);
            announcement_table.getColumnModel().getColumn(2).setPreferredWidth(150);
            announcement_table.getColumnModel().getColumn(2).setMaxWidth(150);
        }

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scholarshipmanagement/images/refresh (1) (1).png"))); // NOI18N
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton17))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jButton10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton17)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout p3Layout = new javax.swing.GroupLayout(p3);
        p3.setLayout(p3Layout);
        p3Layout.setHorizontalGroup(
            p3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        p3Layout.setVerticalGroup(
            p3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab3", p3);

        p4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jLabel21.setBackground(new java.awt.Color(56, 153, 244));
        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(56, 153, 244));
        jLabel21.setText("Reports");

        report_table.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null}
            },
            new String [] {
                "Full_name", "Sex", "Purok", "Email", "Date Submitted", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        report_table.setRowHeight(40);
        jScrollPane4.setViewportView(report_table);
        if (report_table.getColumnModel().getColumnCount() > 0) {
            report_table.getColumnModel().getColumn(0).setResizable(false);
            report_table.getColumnModel().getColumn(1).setResizable(false);
            report_table.getColumnModel().getColumn(2).setResizable(false);
            report_table.getColumnModel().getColumn(4).setResizable(false);
            report_table.getColumnModel().getColumn(5).setResizable(false);
        }

        jButton11.setBackground(new java.awt.Color(56, 153, 244));
        jButton11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton11.setText("Download");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jButton11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout p4Layout = new javax.swing.GroupLayout(p4);
        p4.setLayout(p4Layout);
        p4Layout.setHorizontalGroup(
            p4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        p4Layout.setVerticalGroup(
            p4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab4", p4);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 700, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn1MouseClicked
        
    }//GEN-LAST:event_btn1MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        jTabbedPane1.setSelectedIndex(0);
        btn1.setBackground(new java.awt.Color(255, 255, 255));
        btn2.setBackground(new java.awt.Color(15, 91, 150));
        btn3.setBackground(new java.awt.Color(15, 91, 150));
        btn4.setBackground(new java.awt.Color(15, 91, 150));
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        jTabbedPane1.setSelectedIndex(1);
        btn1.setBackground(new java.awt.Color(15, 91, 150));
        btn2.setBackground(new java.awt.Color(255, 255, 255));
        btn3.setBackground(new java.awt.Color(15, 91, 150));
        btn4.setBackground(new java.awt.Color(15, 91, 150));
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        jTabbedPane1.setSelectedIndex(2);
        btn1.setBackground(new java.awt.Color(15, 91, 150));
        btn2.setBackground(new java.awt.Color(15, 91, 150));
        btn3.setBackground(new java.awt.Color(255, 255, 255));
        btn4.setBackground(new java.awt.Color(15, 91, 150));
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        jTabbedPane1.setSelectedIndex(3);
        btn1.setBackground(new java.awt.Color(15, 91, 150));
        btn2.setBackground(new java.awt.Color(15, 91, 150));
        btn3.setBackground(new java.awt.Color(15, 91, 150));
        btn4.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
        addAdmin addNewAdmin = new addAdmin();
        addNewAdmin.pack();
        addNewAdmin.setVisible(true);
        
        
        this.dispose();
                    
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        
        
        addAnnouncement aa = new addAnnouncement();
        aa.pack();
        aa.setVisible(true);
        
        
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        int selectedRow = admin_account_table.getSelectedRow();
    
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a record to delete!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Confirm before deletion
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this record?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                PreparedStatement pst;
                String admin_id = admin_account_table.getValueAt(selectedRow, 0).toString();

                pst = conn.prepareStatement("DELETE FROM admin WHERE admin_id = ?");
                pst.setString(1, admin_id);

                int k = pst.executeUpdate();

                if (k == 1) {
                    JOptionPane.showMessageDialog(this, "Record Deleted Successfully!");
                    loadAdminAccounts(); 
                } else {
                    JOptionPane.showMessageDialog(this, "Error! Record could not be deleted.");
                }

            } catch (SQLException ex) {
                Logger.getLogger(adminDash.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        
        
        int selectedRow = admin_account_table.getSelectedRow();
    
        if (selectedRow != -1) {
            int id = (int) admin_account_table.getValueAt(selectedRow, 0); // Column 0 = admin_id
            updateAdd ua = new updateAdd(id);
            ua.pack();
            ua.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to update.");
        }
        
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        
        loadAdminAccounts();
        
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        
        
        
        int selectedRow = student_jtable.getSelectedRow();
    
        if (selectedRow != -1) {
            int student_id = (int) student_jtable.getValueAt(selectedRow, 0); // Column 0 = admin_id
            readStudentSubmission sub = new readStudentSubmission(student_id);
            sub.pack();
            sub.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to read submission.");
        }
        
        
        
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        
        studentSubmissionTable();
        
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        
        
        announcementTable();
        
        
        
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        
        MessageFormat header = new MessageFormat("BRGY Bucot Scholarship System - Student Report");
        MessageFormat footer = new MessageFormat("Page");
        
        try{
            PrintRequestAttributeSet set = new HashPrintRequestAttributeSet(); 
            set.add(OrientationRequested.LANDSCAPE);

            report_table.print(JTable.PrintMode.FIT_WIDTH, header, footer, true, set, true); 

            JOptionPane.showMessageDialog(null, "Downloaded successfully!");
            
            
        }
        catch(java.awt.print.PrinterException e){
            JOptionPane.showMessageDialog(null, "\n" + "Download failed");
        }
        
        
        
        
        
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to log out?",
            "Logout Confirmation",
            JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            this.dispose();
            login ds = new login();
            ds.pack();
            ds.setVisible(true);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(adminDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminDash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable admin_account_table;
    private javax.swing.JTable announcement_table;
    private javax.swing.JPanel btn1;
    private javax.swing.JPanel btn2;
    private javax.swing.JPanel btn3;
    private javax.swing.JPanel btn4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton3;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel p1;
    private javax.swing.JPanel p2;
    private javax.swing.JPanel p3;
    private javax.swing.JPanel p4;
    private javax.swing.JTable report_table;
    private javax.swing.JTable student_jtable;
    // End of variables declaration//GEN-END:variables
}
