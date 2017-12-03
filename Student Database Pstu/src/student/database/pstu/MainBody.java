/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.database.pstu;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author SUDIPTOB2
 */
public class MainBody extends javax.swing.JFrame {

    /**
     * connecting to the database connection is made for showing data in Jtable
     */
    Connection conn = Javaconnect.connectDatabase();

    /**
     * Creates new form MainBody
     */
    public MainBody() {
        initComponents();
        setIcon();
        DisplayTimeNDate();
        updateJtable();

    }


    public void DisplayTimeNDate() {

        Thread clock = new Thread() {

            public void run() {
                for (;;) {

                    Calendar cal = new GregorianCalendar();
                    int month = cal.get(Calendar.MONTH);
                    int year = cal.get(Calendar.YEAR);
                    int day = cal.get(Calendar.DAY_OF_MONTH);
                    date.setText("Date:" + day + "/" + (month + 1) + "/" + year);
                    int sec = cal.get(Calendar.SECOND);
                    int min = cal.get(Calendar.MINUTE);
                    int hour = cal.get(Calendar.HOUR);
                    time.setText("Time: " + hour + ":" + min + ":" + sec);

                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }

            }

        };

        clock.start();
    }

    private void updateJtable() {
        try {
            String sql = "select  ID,FirstName,LastName,Reg,Faculty from datatable order by ID ";
            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();
            tb_dataTable.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }
    }

    private void clearJtextField() {
        fnamField.setText("");
        lnamField.setText("");
        idField.setText("");
        regField.setText("");
        facField.setText("");
        sesField.setText("");
        genField.setText("");
        addField.setText("");
        phoField.setText("");
        pathField.setText("");
        imaField.setIcon(null);
        imaField.setText(" Image 128x128px");
    }

    private void modifyData() {
        try {
            fname=fnamField.getText();
            lname=lnamField.getText();
            faculty=facField.getText();
            session=sesField.getText();
            gender=genField.getText();
            address=addField.getText();
            phone= phoField.getText();
            if(!(fname.equals("")||lname.equals("")||faculty.equals("")||session.equals("")||gender.equals("")||address.equals("")||phone.equals("")))
            {     
            String id = idField.getText();
            String sql = "UPDATE datatable SET ID=?,FirstName=?,LastName=?,Reg=?,Faculty=?,Session=?,Gender=?,Address=?,Phone=?,Image=? WHERE ID = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            pst.setString(2, fname);
            pst.setString(3, lname);
            pst.setString(4, regField.getText());
            pst.setString(5, faculty);
            pst.setString(6, session);
            pst.setString(7, gender);
            pst.setString(8, address);
            pst.setString(9, phone);
            pst.setBytes(10, person_image);
            pst.setString(11, id);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Data Successfully Updated");

            }
            else
            {
                 Toolkit.getDefaultToolkit().beep();
                 JOptionPane.showMessageDialog(null, "Please Fill up Every Field properly");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            try {
                pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

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

        jMenu1 = new javax.swing.JMenu();
        jButton1 = new javax.swing.JButton();
        bt_update = new javax.swing.JButton();
        bt_delete = new javax.swing.JButton();
        bt_exit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_dataTable = new javax.swing.JTable();
        bt_logOut = new javax.swing.JButton();
        bt_reset = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fnamField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lnamField = new javax.swing.JTextField();
        idField = new javax.swing.JTextField();
        regField = new javax.swing.JTextField();
        facField = new javax.swing.JTextField();
        sesField = new javax.swing.JTextField();
        genField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        addField = new javax.swing.JTextArea();
        phoField = new javax.swing.JTextField();
        Bt_upload = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        imaField = new javax.swing.JLabel();
        pathField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        Combobox = new javax.swing.JComboBox();
        seaField = new javax.swing.JTextField();
        bt_search = new javax.swing.JButton();
        time = new javax.swing.JLabel();
        date = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        jButton1.setBackground(new java.awt.Color(186, 245, 186));
        jButton1.setText("Add");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 204));
        setResizable(false);

        bt_update.setBackground(new java.awt.Color(153, 190, 248));
        bt_update.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_update.setForeground(new java.awt.Color(51, 51, 51));
        bt_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Pencil-icon.png"))); // NOI18N
        bt_update.setText("Modify");
        bt_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_updateActionPerformed(evt);
            }
        });

        bt_delete.setBackground(new java.awt.Color(255, 200, 153));
        bt_delete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_delete.setForeground(new java.awt.Color(51, 51, 51));
        bt_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Editing-Delete-icon.png"))); // NOI18N
        bt_delete.setText("Delete");
        bt_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_deleteActionPerformed(evt);
            }
        });

        bt_exit.setBackground(new java.awt.Color(255, 0, 25));
        bt_exit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_exit.setForeground(new java.awt.Color(51, 51, 51));
        bt_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/blue-document-cross-icon.png"))); // NOI18N
        bt_exit.setText("Exit");
        bt_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_exitActionPerformed(evt);
            }
        });

        tb_dataTable.setBackground(new java.awt.Color(255, 249, 190));
        tb_dataTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tb_dataTable.setModel(new javax.swing.table.DefaultTableModel(
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
                "Roll", "First Name", "Last Name", "Reg no", "Faculty"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_dataTable.setPreferredSize(new java.awt.Dimension(350, 352));
        tb_dataTable.setUpdateSelectionOnSort(false);
        tb_dataTable.setVerifyInputWhenFocusTarget(false);
        tb_dataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_dataTableMouseClicked(evt);
            }
        });
        tb_dataTable.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                tb_dataTableComponentMoved(evt);
            }
        });
        jScrollPane2.setViewportView(tb_dataTable);

        bt_logOut.setBackground(new java.awt.Color(255, 102, 51));
        bt_logOut.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt_logOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/User-Interface-Logout-icon.png"))); // NOI18N
        bt_logOut.setText("Log-Out");
        bt_logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_logOutActionPerformed(evt);
            }
        });

        bt_reset.setBackground(new java.awt.Color(255, 255, 255));
        bt_reset.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_reset.setForeground(new java.awt.Color(51, 51, 51));
        bt_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Reset-icon.png"))); // NOI18N
        bt_reset.setText("Reset");
        bt_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_resetActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Programming-Save-As-icon.png"))); // NOI18N
        jButton2.setText("save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Student's Information", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(504, 630));

        jLabel10.setBackground(new java.awt.Color(3, 135, 3));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 51));
        jLabel10.setText("Phone no:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 51));
        jLabel11.setText("Image:");

        jLabel2.setBackground(new java.awt.Color(3, 135, 3));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 51));
        jLabel2.setText("Student Name:");

        jLabel3.setBackground(new java.awt.Color(3, 135, 3));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 51));
        jLabel3.setText("Student ID:");

        jLabel4.setBackground(new java.awt.Color(3, 135, 3));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 51));
        jLabel4.setText("Reg Number:");

        jLabel5.setBackground(new java.awt.Color(3, 135, 3));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 51));
        jLabel5.setText("Faculty:");

        jLabel6.setBackground(new java.awt.Color(3, 135, 3));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 51));
        jLabel6.setText("Session:");

        jLabel7.setBackground(new java.awt.Color(3, 135, 3));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 51));
        jLabel7.setText("Gender:");

        fnamField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnamFieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("First Name:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Last Name:");

        idField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idFieldKeyTyped(evt);
            }
        });

        regField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regFieldActionPerformed(evt);
            }
        });
        regField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                regFieldKeyTyped(evt);
            }
        });

        addField.setColumns(20);
        addField.setRows(5);
        jScrollPane1.setViewportView(addField);

        phoField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phoFieldKeyTyped(evt);
            }
        });

        Bt_upload.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Bt_upload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/upload-icon.png"))); // NOI18N
        Bt_upload.setText("choose");
        Bt_upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bt_uploadActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 51));
        jLabel12.setText("Address:");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(129, 129));

        imaField.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        imaField.setForeground(new java.awt.Color(51, 51, 51));
        imaField.setText("   Image 128x128px");
        imaField.setPreferredSize(new java.awt.Dimension(128, 128));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(imaField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(imaField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pathField.setPreferredSize(new java.awt.Dimension(100, 23));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(genField, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                    .addComponent(phoField)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fnamField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(idField)
                                        .addComponent(regField)
                                        .addComponent(facField, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(sesField, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lnamField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(195, 195, 195))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pathField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Bt_upload, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fnamField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lnamField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(facField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(genField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(Bt_upload)
                        .addGap(18, 18, 18)
                        .addComponent(pathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pathField.getAccessibleContext().setAccessibleName("");
        pathField.getAccessibleContext().setAccessibleDescription("");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "search Info", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        Combobox.setBackground(new java.awt.Color(255, 255, 204));
        Combobox.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        Combobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Id", "FirstName", "LastNAme", "Reg no", "Faculty" }));
        Combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboboxActionPerformed(evt);
            }
        });

        seaField.setBackground(new java.awt.Color(226, 255, 255));
        seaField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                seaFieldKeyReleased(evt);
            }
        });

        bt_search.setBackground(new java.awt.Color(204, 255, 255));
        bt_search.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search-icon.png"))); // NOI18N
        bt_search.setPreferredSize(new java.awt.Dimension(36, 36));
        bt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(seaField, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seaField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_search, seaField});

        time.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        time.setForeground(new java.awt.Color(51, 51, 51));
        time.setText("time");

        date.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        date.setForeground(new java.awt.Color(51, 51, 51));
        date.setText("date");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_logOut))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(time))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(date)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_update)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bt_delete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_reset)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_exit))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(bt_logOut)
                        .addGap(18, 18, 18)
                        .addComponent(time)
                        .addGap(18, 18, 18)
                        .addComponent(date)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(53, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_reset)
                    .addComponent(bt_delete)
                    .addComponent(bt_update)
                    .addComponent(jButton2)
                    .addComponent(bt_exit))
                .addGap(136, 136, 136))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_delete, bt_exit, bt_reset, bt_update});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboboxActionPerformed

    private void Bt_uploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bt_uploadActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        try {
            File f = chooser.getSelectedFile();
            filePath = f.getAbsolutePath();
            pathField.setText(filePath);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please select a valid Image!");
        }

        imaField.setIcon(new ImageIcon(pathField.getText()));
        imaField.setText("");
        File image = new File(filePath);
        try {
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);

            }
            person_image = bos.toByteArray();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }


    }//GEN-LAST:event_Bt_uploadActionPerformed

    private void bt_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_resetActionPerformed
        clearJtextField();
    }//GEN-LAST:event_bt_resetActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       if (LogIn.admin) {
            
            try {
            fname=fnamField.getText();
            lname=lnamField.getText();
            faculty=facField.getText();
            session=sesField.getText();
            gender=genField.getText();
            address=addField.getText();
            phone= phoField.getText();
            if(!(fname.equals("")||lname.equals("")||faculty.equals("")||session.equals("")||gender.equals("")||address.equals("")||phone.equals("")))
            {
            
            //Code to populate Database  table;
            String sql = "INSERT INTO datatable (ID,FirstName,LastName,Reg,Faculty,Session,Gender,Address,Phone,Image) VALUES (?,?,?,?,?,?,?,?,?,?)";

            pst = conn.prepareStatement(sql);
            pst.setString(1, idField.getText());
            pst.setString(2, fname);
            pst.setString(3, lname);
            pst.setString(4, regField.getText());
            pst.setString(5, faculty);
            pst.setString(6, session);
            pst.setString(7, gender);
            pst.setString(8, address);
            pst.setString(9, phone);
            /**
             * Statement for Image Mysql File f = new File(filePathString);
             * FileInputStream fileInput = new FileInputStream(f); int length =
             * (int) f.length(); End of the Preparation of Image input
             * pst.setBinaryStream(10, fileInput, length);
             */
            pst.setBytes(10, person_image);//statement for image sqlite
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data saved Successfully");
            updateJtable();
            clearJtextField();
            }
            else
            {
                 Toolkit.getDefaultToolkit().beep();
                 JOptionPane.showMessageDialog(null, "Please Fill up Every Field properly");
            }
        } catch (SQLException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "It seems that you didn't fill up ID/Reg correctly"
                    + "\n\t or\n"
                    + "Upload a Valid Image");
        } finally {
            try {
                pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }
                
        } else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,
                    "<html><div color=red>Admin Access requred <html><div color=black>  to SAVE data", "ACCESS DENIED", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void bt_logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_logOutActionPerformed
        int selectedOption = JOptionPane.showConfirmDialog(null,
                "Are you sure ?", "Chose",
                JOptionPane.YES_NO_OPTION);
        if (selectedOption == JOptionPane.YES_OPTION) {
            dispose();
            LogIn login = new LogIn();
            login.setVisible(true);
        }


    }//GEN-LAST:event_bt_logOutActionPerformed

    private void bt_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_exitActionPerformed
        int selectedOption = JOptionPane.showConfirmDialog(null,
                "Are you sure?", "CONFIRM EXIT",
                JOptionPane.YES_NO_OPTION);
        if (selectedOption == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_bt_exitActionPerformed

    private void tb_dataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_dataTableMouseClicked
        try {
            int row = tb_dataTable.getSelectedRow();
            clickedId = (tb_dataTable.getModel().getValueAt(row, 0).toString());
            String sql = "select * from datatable where ID = '" + clickedId + "' ";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                String id = rs.getString("ID");
                idField.setText(id);
                String fname = rs.getString("FirstName");
                fnamField.setText(fname);
                String lname = rs.getString("LastName");
                lnamField.setText(lname);
                String reg = rs.getString("Reg");
                regField.setText(reg);
                String faculty = rs.getString("Faculty");
                facField.setText(faculty);
                String session = rs.getString("Session");
                sesField.setText(session);
                String gender = rs.getString("Gender");
                genField.setText(gender);
                String address = rs.getString("Address");
                addField.setText(address);
                String phone = rs.getString("phone");
                phoField.setText(phone);
                //start reriving Image from table SQLITE
                person_image = rs.getBytes("Image");
                format = new ImageIcon(person_image);
                imaField.setIcon(format);
                imaField.setText("");
                // end of retrive
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "sql" + ex);
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }


    }//GEN-LAST:event_tb_dataTableMouseClicked

    private void bt_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_deleteActionPerformed
        /**
         * Delete Action Performed created 24-09-2015;
         */

        if (LogIn.admin) {

            int selectedOption = JOptionPane.showConfirmDialog(null,
                    "Do you want to delete parmanently?", "",
                    JOptionPane.YES_NO_OPTION);
            if (selectedOption == JOptionPane.YES_OPTION) {
                String sql = "delete from datatable where ID = ?";
                try {
                    pst = conn.prepareStatement(sql);
                    pst.setString(1, idField.getText());
                    pst.execute();
                    clearJtextField();
                    updateJtable();
                    JOptionPane.showMessageDialog(null, "Data Deleted");
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, e);
                } finally {
                    try {
                        pst.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }

                }
            }

        } else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,
                    "<html><div color=red>Admin Access requred <html><div color=black>  to DELETE data", "ACCESS DENIED", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_bt_deleteActionPerformed

    private void bt_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_updateActionPerformed

        if (LogIn.admin) {
            modifyData();
            updateJtable();
        } else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,
                    "<html><div color=red>Admin Access requred <html><div color=black>  to MODIFY data", "ACCESS DENIED", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_bt_updateActionPerformed

    private void fnamFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnamFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnamFieldActionPerformed

    private void regFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regFieldActionPerformed

    private void tb_dataTableComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tb_dataTableComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_dataTableComponentMoved

    private void seaFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_seaFieldKeyReleased
        String sql = null;
        try {
            Object selectedItem = Combobox.getSelectedItem();
            String searchBy = selectedItem.toString();
            switch (searchBy) {
                case "FirstName":
                    sql = "select ID,FirstName,LastName,Reg,Faculty from datatable where FirstName = ? ";
                    break;
                case "LastName":
                    sql = "select ID,FirstName,LastName,Reg,Faculty from datatable where LastName = ? ";
                    break;
                case "Reg no":
                    sql = "select ID,FirstName,LastName,Reg,Faculty from datatable where Reg = ? ";
                    break;
                case "Id":
                    sql = "select ID,FirstName,LastName,Reg,Faculty from datatable where ID = ? ";
                    break;
                case "Faculty":
                    sql = "select ID,FirstName,LastName,Reg,Faculty from datatable where Faculty = ? ";
                    break;
            }
            pst = conn.prepareStatement(sql);
            pst.setString(1, seaField.getText());
            rs = pst.executeQuery();
            tb_dataTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }
    }//GEN-LAST:event_seaFieldKeyReleased

    private void bt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_searchActionPerformed
        String sql = null;
        try {
            Object selectedItem = Combobox.getSelectedItem();
            String searchBy = selectedItem.toString();
            switch (searchBy) {
                case "FirstName":
                    sql = "select * from datatable where FirstName = ? ";
                    break;
                case "LastName":
                    sql = "select * from datatable where LastName = ? ";
                    break;
                case "Reg no":
                    sql = "select * from datatable where Reg = ? ";
                    break;
                case "Id":
                    sql = "select * from datatable where ID = ? ";
                    break;
                case "Faculty":
                    sql = "select * from datatable where Faculty = ? ";
                    break;
            }
            pst = conn.prepareStatement(sql);
            pst.setString(1, seaField.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                String id = rs.getString("ID");
                idField.setText(id);
                String fname = rs.getString("FirstName");
                fnamField.setText(fname);
                String lname = rs.getString("LastName");
                lnamField.setText(lname);
                String reg = rs.getString("Reg");
                regField.setText(reg);
                String faculty = rs.getString("Faculty");
                facField.setText(faculty);
                String session = rs.getString("Session");
                sesField.setText(session);
                String gender = rs.getString("Gender");
                genField.setText(gender);
                String address = rs.getString("Address");
                addField.setText(address);
                String phone = rs.getString("phone");
                phoField.setText(phone);
                //start reriving Image from database table SQLITE
                person_image = rs.getBytes("Image");
                format = new ImageIcon(person_image);
                imaField.setIcon(format);

                // end of retrive
                updateJtable();
            } else {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null,
                        "<html><div color=black>Your search about: <html><div color=red>" + searchBy + " = " + seaField.getText()
                        + "<br><div color=black>Not found!", "RESULT NOT FOUND", JOptionPane.ERROR_MESSAGE);
                updateJtable();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }
    }//GEN-LAST:event_bt_searchActionPerformed

    private void idFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idFieldKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE) {
            evt.consume();

        }

    }//GEN-LAST:event_idFieldKeyTyped

    private void regFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_regFieldKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE) {
            evt.consume();

        }
    }//GEN-LAST:event_regFieldKeyTyped

    private void phoFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoFieldKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE) {
            evt.consume();

        }
    }//GEN-LAST:event_phoFieldKeyTyped

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
            JOptionPane.showMessageDialog(null, ex);
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainBody().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bt_upload;
    private javax.swing.JComboBox Combobox;
    private javax.swing.JTextArea addField;
    private javax.swing.JButton bt_delete;
    private javax.swing.JButton bt_exit;
    private javax.swing.JButton bt_logOut;
    private javax.swing.JButton bt_reset;
    private javax.swing.JButton bt_search;
    private javax.swing.JButton bt_update;
    private javax.swing.JLabel date;
    private javax.swing.JTextField facField;
    private javax.swing.JTextField fnamField;
    private javax.swing.JTextField genField;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel imaField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lnamField;
    private javax.swing.JTextField pathField;
    private javax.swing.JTextField phoField;
    private javax.swing.JTextField regField;
    private javax.swing.JTextField seaField;
    private javax.swing.JTextField sesField;
    public javax.swing.JTable tb_dataTable;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables
    String clickedId = null;
    String filePath = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int s = 0;
    byte[] person_image = null;
    byte[] imageData = null;
    private ImageIcon format = null;
    String fname=null,lname=null,faculty=null,session=null,gender=null,address=null,phone=null;

    private void setIcon() {

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("favicon.jpg")));

    }
}
