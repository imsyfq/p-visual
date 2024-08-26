/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package jobsheet09;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tb12as
 */
public class KelolaDataJurusan extends javax.swing.JDialog {

    DefaultTableModel model;
    boolean modeSimpan;
    Connection koneksi;
    Statement perintah;
    ResultSet rs;
    boolean dataDitemukan;

    /**
     * Creates new form KelolaDataJurusan
     *
     * @param parent
     * @param modal
     */
    public KelolaDataJurusan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        model = (DefaultTableModel) jTable1.getModel();
        modeSimpan = true;
        dataDitemukan = false;

        try {
            // Step 1: Registrasi atau lood JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Step 2: Ciptakan dan bangun koneksi ke database "polnep"
            String url = "jdbc:mysql://localhost/polnep";
            String user = "root";
            String password = "root";
            koneksi = DriverManager.getConnection(url, user, password);
            // Step 3: Ciptakan koneksi
            perintah = koneksi.createStatement();
        } catch (ClassNotFoundException ex) {
            System.err.println("JDBC Driver tidak ditemukan");
        } catch (SQLException ex) {
            System.err.println("Gagal koneksi atau menciptakan objek statement");
        }

    }

    private void bersihData() {
        jTextField1.setText("");
        jTextField2.setText("");
    }

    private void tampilData() {
        try {
            rs = perintah.executeQuery("select * from jurusan");
            model.setRowCount(0);
            model.fireTableDataChanged();
            while (rs.next()) {
                model.addRow(
                        new Object[]{
                            rs.getString("kode_jurusan"),
                            rs.getString("nama_jurusan")
                        }
                );
            }

        } catch (SQLException ex) {
            System.out.println("jobsheet09.KelolaDataJurusan.tampilData()");
            System.err.println("Query Error");
        }
    }

    private boolean cariData(String data) {
        if (!jTextField1.getText().equals("")) {
            try {
                rs = perintah.executeQuery("select * from jurusan where kode_jurusan = '" + data + "'");
                return rs.next();
            } catch (SQLException ex) {
                System.err.println("Query Error");
            }
        }

        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kelola Data Jurusan");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel1.setText("KELOLA DATA JURUSAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(103, 103, 103))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jLabel2.setText("Kode Jurusan");

        jLabel3.setText("Nama Jurusan");

        jButton1.setText("Baru");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Simpan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Ubah");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Hapus");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Batal");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Kode Jurusan", "Nama Jurusan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setText("Tekan enter untuk melanjutkan");
        jLabel4.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        bersihData();
        jTextField1.setEnabled(false);
        jTextField2.setEnabled(false);
        jButton1.setEnabled(true);
        jButton1.requestFocus();
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        bersihData();
        tampilData();
        jTextField1.setEnabled(false);
        jTextField2.setEnabled(false);
        jButton1.setEnabled(true);
        jButton1.requestFocus();
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        bersihData();
        jTextField1.setEnabled(true);
        jTextField1.requestFocus();
        jTextField2.setEnabled(false);
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jButton5.setEnabled(true);
        modeSimpan = true;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // pengecekan apakah tombol enter di keyboard telah ditekan
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            dataDitemukan = cariData(jTextField1.getText());
            if (!dataDitemukan) {
                jTextField2.setEnabled(true);
                jTextField2.requestFocus();
                jButton2.setEnabled(true);
                return;
            }

            if (dataDitemukan) {
                int pilihan;
                pilihan = JOptionPane.showConfirmDialog(this,
                        "Kode Jurusan " + jTextField1.getText() + " sudah ada! "
                        + "Apakah Anda ingin menghapus / mengubah data?",
                        "Konfirmasi",
                        JOptionPane.YES_NO_OPTION
                );

                if (pilihan == 0) { // yes
                    try {
                        jTextField2.setText(rs.getString("nama_jurusan"));
                        jTextField1.setEnabled(false);
                        jTextField2.setEnabled(false);
                        jButton1.setEnabled(false);
                        jButton2.setEnabled(false);
                        jButton3.setEnabled(true);
                        jButton3.requestFocus();
                        jButton4.setEnabled(true);
                        jButton5.setEnabled(true);
                    } catch (SQLException ex) {
                        System.err.println("Query error");
                    }
                } else {
                    jTextField1.setText("");
                    jTextField1.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // Limit to 2 characters
        if (jTextField1.getText().length() >= 2) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // Limit to 100 characters
        if (jTextField2.getText().length() >= 100) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jTextField1.getText().equals("")) {
            JOptionPane.showMessageDialog(
                    this,
                    "Silahkan lengkapi data kode jurusan!",
                    "Informasi",
                    JOptionPane.INFORMATION_MESSAGE
            );
            jTextField1.requestFocus();
        } else if (jTextField2.getText().equals("")) {
            JOptionPane.showMessageDialog(
                    this,
                    "Silahkan lengkapi data nama jurusan!",
                    "Informasi",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            if (modeSimpan) {
                dataDitemukan = cariData(jTextField1.getText());
                if (dataDitemukan) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Penyimpanan data jurusan gagal dilakukan"
                            + ", karena kode jurusan " + jTextField1.getText()
                            + " telah ada di table",
                            "Informasi",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    try {
                        perintah.execute("insert into jurusan values ('"
                                + jTextField1.getText() + "','"
                                + jTextField2.getText() + "');"
                        );

                        tampilData();
                    } catch (SQLException ex) {
                        System.err.println(ex.getMessage());
                        JOptionPane.showMessageDialog(
                                this,
                                "Penyimpanan data jurusan gagal dilakukan",
                                "Informasi",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                }
            } else {
                if ((jTable1.getSelectedRow() == -1) && (!dataDitemukan)) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Silahkan pilih baris yang akan diubah",
                            "Informasi",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    try {
                        perintah.execute("update jurusan set nama_jurusan ='"
                                + jTextField2.getText()
                                + "' where kode_jurusan = '" + jTextField1.getText() + "'");

                        tampilData();
                    } catch (SQLException ex) {
                        System.err.println("Query error");
                    }
                }
            }

            bersihData();
            jTextField1.setEnabled(false);
            jTextField2.setEnabled(false);
            jButton1.setEnabled(true);
            jButton1.requestFocus();
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
            jButton4.setEnabled(false);
            jButton5.setEnabled(false);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTextField1.setEnabled(false);
        jTextField2.setEnabled(true);
        jTextField2.requestFocus();

        jButton1.setEnabled(false);
        jButton2.setEnabled(true);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jButton5.setEnabled(true);

        modeSimpan = false;
    }//GEN-LAST:event_jButton3ActionPerformed

    private boolean cariProdi(String data) {
        if (!jTextField1.getText().equals("")) {
            try {
                rs = perintah.executeQuery("select * from prodi "
                        + "where kode_jurusan = '" + data + "' limit 1");
                return rs.next();
            } catch (SQLException ex) {
                System.err.println("Query Error");
            }
        }

        return false;
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if ((jTable1.getSelectedRow() == -1) && (!dataDitemukan)) {
            JOptionPane.showMessageDialog(
                    this,
                    "Silahkan pilih baris yang akan diubah",
                    "Informasi",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            int pilihan;
            pilihan = JOptionPane.showConfirmDialog(
                    this,
                    "Apakah anda yakin akan menghapus data?",
                    "Konfirmasi",
                    JOptionPane.YES_NO_OPTION
            );

            if (pilihan == 0) {
                if (cariProdi(jTextField1.getText())) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Tidak dapat menghapus jurusan, telah digunakan di prodi.",
                            "Informasi",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                try {
                    perintah.execute("delete from jurusan where kode_jurusan = '"
                            + jTextField1.getText() + "'"
                    );

                    tampilData();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }

                bersihData();
                jTextField1.setEnabled(false);
                jTextField2.setEnabled(false);
                jButton1.setEnabled(true);
                jButton1.requestFocus();
                jButton2.setEnabled(false);
                jButton3.setEnabled(false);
                jButton4.setEnabled(false);
                jButton5.setEnabled(false);
            }

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (jTable1.getSelectedRow() >= 0) {
            jTextField1.setText(model.getValueAt(jTable1.getSelectedRow(), 0).toString());
            jTextField2.setText(model.getValueAt(jTable1.getSelectedRow(), 1).toString());
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            jButton3.setEnabled(true);
            jButton3.requestFocus();
            jButton4.setEnabled(true);
            jButton5.setEnabled(true);

            jTextField1.setEnabled(false);
            jTextField2.setEnabled(false);
        }
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(KelolaDataJurusan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KelolaDataJurusan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KelolaDataJurusan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KelolaDataJurusan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                KelolaDataJurusan dialog = new KelolaDataJurusan(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
