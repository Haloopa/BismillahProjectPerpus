/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;
import com.mycompany.projectperpus.ConnectionDatabase;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Asus
 */
public class frameDataAdmin extends javax.swing.JFrame {
    public frameDataAdmin() {
        initComponents();
        showData();
    }
    private void refreshForm(){
        inputIDPetugas.setText(null);
        inputNamaPetugas.setText(null);
        inputPassword.setText(null);
        inputNoHP.setText(null);
        inputAlamatRumah.setText(null);
    }
    
    private void showData(){
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("ID Petugas");
        tbl.addColumn("Nama Petugas");
        tbl.addColumn("Password");
        tbl.addColumn("Nomor HP");
        tbl.addColumn("Alamat Rumah");
        tabelDataAdmin.setModel(tbl);

        try {
            int no = 1;
            String sql = "SELECT * FROM petugas WHERE idPetugas like '%"
                    + inputPencarian.getText() + "%'"
                    + " or namaPetugas like '%" + inputNamaPetugas.getText()
                    + "%' or password like '%" + inputPassword.getText()
                    + "%' or nomorHP like '%" + inputNoHP.getText()
                    + "%' or alamatPetugas like '%" + inputAlamatRumah.getText()
                    + "%'";
            ConnectionDatabase koneksidatabase = ConnectionDatabase.getInstance();
            Connection connect = koneksidatabase.getConnection();
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                tbl.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)});
                tabelDataAdmin.setModel(tbl);
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputIDPetugas = new javax.swing.JTextField();
        inputNamaPetugas = new javax.swing.JTextField();
        inputPassword = new javax.swing.JTextField();
        inputNoHP = new javax.swing.JTextField();
        inputAlamatRumah = new javax.swing.JTextField();
        inputPencarian = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelDataAdmin = new javax.swing.JTable();
        bgDataAdmin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inputIDPetugas.setBackground(new java.awt.Color(222, 217, 186));
        inputIDPetugas.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        inputIDPetugas.setBorder(null);
        inputIDPetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputIDPetugasActionPerformed(evt);
            }
        });
        getContentPane().add(inputIDPetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 390, 30));

        inputNamaPetugas.setBackground(new java.awt.Color(222, 217, 186));
        inputNamaPetugas.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        inputNamaPetugas.setBorder(null);
        inputNamaPetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNamaPetugasActionPerformed(evt);
            }
        });
        getContentPane().add(inputNamaPetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 390, 30));

        inputPassword.setBackground(new java.awt.Color(222, 217, 186));
        inputPassword.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        inputPassword.setBorder(null);
        inputPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(inputPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 390, 30));

        inputNoHP.setBackground(new java.awt.Color(222, 217, 186));
        inputNoHP.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        inputNoHP.setBorder(null);
        inputNoHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNoHPActionPerformed(evt);
            }
        });
        getContentPane().add(inputNoHP, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 390, 30));

        inputAlamatRumah.setBackground(new java.awt.Color(222, 217, 186));
        inputAlamatRumah.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        inputAlamatRumah.setBorder(null);
        inputAlamatRumah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputAlamatRumahActionPerformed(evt);
            }
        });
        getContentPane().add(inputAlamatRumah, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, 390, 30));

        inputPencarian.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        inputPencarian.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        inputPencarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPencarianActionPerformed(evt);
            }
        });
        getContentPane().add(inputPencarian, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 230, 30));

        btnCari.setBackground(new java.awt.Color(125, 39, 34));
        btnCari.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        btnCari.setForeground(new java.awt.Color(255, 204, 0));
        btnCari.setText("Cari");
        btnCari.setBorder(null);
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });
        getContentPane().add(btnCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 430, 110, 30));

        btnKeluar.setBackground(new java.awt.Color(125, 39, 34));
        btnKeluar.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        btnKeluar.setForeground(new java.awt.Color(255, 204, 0));
        btnKeluar.setText("Keluar");
        btnKeluar.setBorder(null);
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });
        getContentPane().add(btnKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 370, 220, 50));

        btnHapus.setBackground(new java.awt.Color(125, 39, 34));
        btnHapus.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(255, 204, 0));
        btnHapus.setText("Hapus");
        btnHapus.setBorder(null);
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 300, 220, 50));

        btnUbah.setBackground(new java.awt.Color(125, 39, 34));
        btnUbah.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        btnUbah.setForeground(new java.awt.Color(255, 204, 0));
        btnUbah.setText("Ubah");
        btnUbah.setBorder(null);
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        getContentPane().add(btnUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 230, 220, 50));

        btnTambah.setBackground(new java.awt.Color(125, 39, 34));
        btnTambah.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(255, 204, 0));
        btnTambah.setText("Tambah");
        btnTambah.setBorder(null);
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        getContentPane().add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 150, 220, 50));

        tabelDataAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Petugas", "Nama Petugas", "Password", "Nomor HP", "Alamat Rumah "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelDataAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelDataAdminMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelDataAdmin);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 1300, 280));

        bgDataAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DATA ADMIN.png"))); // NOI18N
        getContentPane().add(bgDataAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputNamaPetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNamaPetugasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNamaPetugasActionPerformed

    private void inputIDPetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputIDPetugasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputIDPetugasActionPerformed

    private void inputNoHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNoHPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNoHPActionPerformed

    private void inputAlamatRumahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputAlamatRumahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputAlamatRumahActionPerformed

    private void inputPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputPasswordActionPerformed

    private void tabelDataAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelDataAdminMouseClicked
        try {
            ConnectionDatabase koneksidatabase;
            koneksidatabase = ConnectionDatabase.getInstance();
            Connection connect = koneksidatabase.getConnection();
            
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        int row = tabelDataAdmin.getSelectedRow();

        //        if (row == -1){
            //            return;
            //
            //        }
        String idPetugas = (String) tabelDataAdmin.getValueAt(row, 0);
        inputIDPetugas.setText(idPetugas);

        String namaPetugas = (String) tabelDataAdmin.getValueAt(row, 1);
        inputNamaPetugas.setText(namaPetugas);

        String password = (String) tabelDataAdmin.getValueAt(row, 2);
        inputPassword.setText(password);

        String nomorHP = (String) tabelDataAdmin.getValueAt(row, 3);
        inputNoHP.setText(nomorHP);

        String alamatRumah = (String) tabelDataAdmin.getValueAt(row, 4);
        inputAlamatRumah.setText(alamatRumah);
    }//GEN-LAST:event_tabelDataAdminMouseClicked

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        frameMenu menu = new frameMenu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        try {
            int selectedRow = tabelDataAdmin.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Pilih data yang akan dihapus!");
        } else {
            String idPetugas = (String) tabelDataAdmin.getValueAt(selectedRow, 0);

            String deletePeminjamanSQL = "DELETE FROM peminjaman WHERE idPetugas = ?";
            ConnectionDatabase koneksidatabase = ConnectionDatabase.getInstance();
            Connection connect = koneksidatabase.getConnection();
            PreparedStatement psPeminjaman = connect.prepareStatement(deletePeminjamanSQL);
            psPeminjaman.setString(1, idPetugas);
            psPeminjaman.executeUpdate();

            String deletePetugasSQL = "DELETE FROM petugas WHERE idPetugas = ?";
            PreparedStatement psPetugas = connect.prepareStatement(deletePetugasSQL);
            psPetugas.setString(1, idPetugas);
            psPetugas.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Admin Berhasil Dihapus!");
            showData();
            refreshForm();
        }
    } catch (HeadlessException | SQLException e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }//GEN-LAST:event_btnHapusActionPerformed
    }
    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        try {
            String sql = "UPDATE petugas SET idPetugas = '" + inputIDPetugas.getText()
                    + "' , namaPetugas = '" + inputNamaPetugas.getText()
                    + "' , password = '" + inputPassword.getText()
                    + "' , nomorHP = '" + inputNoHP.getText() 
                    + "' , alamatPetugas = '" + inputAlamatRumah.getText() 
                    + "' WHERE idPetugas = '" + inputIDPetugas.getText() + "'"; 
            ConnectionDatabase koneksidatabase;
            koneksidatabase = ConnectionDatabase.getInstance();
            Connection connect = koneksidatabase.getConnection();
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Data Admin Berhasil Diubah!");
            showData();
            refreshForm();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        try {
            String sql = "INSERT INTO petugas VALUES (?, ?, ?, ?, ?)";
            ConnectionDatabase koneksidatabase = ConnectionDatabase.getInstance();
            Connection connect = koneksidatabase.getConnection();
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setString(1, inputIDPetugas.getText());
            ps.setString(2, inputNamaPetugas.getText());
            ps.setString(3, inputPassword.getText());
            ps.setString(4, inputNoHP.getText());
            ps.setString(5, inputAlamatRumah.getText());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Data Admin Berhasil Ditambahkan!");
            showData();
            refreshForm();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        try {
           String sql = "SELECT * FROM petugas WHERE idPetugas LIKE ? OR namaPetugas LIKE ? OR password LIKE ? OR nomorHP LIKE ? OR alamatPetugas LIKE ?";
           ConnectionDatabase koneksidatabase = ConnectionDatabase.getInstance();
           Connection connect = koneksidatabase.getConnection();
           PreparedStatement ps = connect.prepareStatement(sql);

           // Mengatur parameter dengan menambahkan karakter wildcard (%) ke nilai input
           String searchValue = "%" + inputPencarian.getText() + "%";
           for (int i = 1; i <= 5; i++) {
               ps.setString(i, searchValue);
           }

           ResultSet rs = ps.executeQuery();

           DefaultTableModel tbl = new DefaultTableModel();
           tbl.addColumn("ID Petugas");
           tbl.addColumn("Nama Petugas");
           tbl.addColumn("Password");
           tbl.addColumn("Nomor HP");
           tbl.addColumn("Alamat Rumah");
           tabelDataAdmin.setModel(tbl);

           while (tbl.getRowCount() > 0) {
               tbl.removeRow(0); // Hapus baris yang ada
           }

           int rowCount = 0;
           while (rs.next()) {
               tbl.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)});
               rowCount++;
           }

           if (rowCount > 0) {
               JOptionPane.showMessageDialog(null, "Data Admin Ditemukan!");
           } else {
               JOptionPane.showMessageDialog(null, "Data Admin Tidak Ditemukan!", "Perhatian", JOptionPane.WARNING_MESSAGE);
           }

       } catch (HeadlessException | SQLException e) {
           JOptionPane.showMessageDialog(this, e.getMessage());
       }
    }//GEN-LAST:event_btnCariActionPerformed

    private void inputPencarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPencarianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputPencarianActionPerformed

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
            java.util.logging.Logger.getLogger(frameDataAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frameDataAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frameDataAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frameDataAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frameDataAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgDataAdmin;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JTextField inputAlamatRumah;
    private javax.swing.JTextField inputIDPetugas;
    private javax.swing.JTextField inputNamaPetugas;
    private javax.swing.JTextField inputNoHP;
    private javax.swing.JTextField inputPassword;
    private javax.swing.JTextField inputPencarian;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelDataAdmin;
    // End of variables declaration//GEN-END:variables
}
