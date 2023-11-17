/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import com.mycompany.projectperpus.ConnectionDatabase;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class framePeminjaman extends javax.swing.JFrame {
    private int nomorUrut = 1;
    public framePeminjaman() {
        initComponents();
        showData();
    }
    
    private void refreshForm(){
        inputIDPinjam.setText(null);
        inputIDPetugas.setText(null);
        inputIDAnggota.setText(null);
        inputNamaAnggota.setText(null);
        inputIDBuku.setText(null);
        inputJudulBuku.setText(null);
        inputTanggalPinjam.setText(null);
        inputJatuhTempo.setText(null);
    }
    private void showData(){
        DefaultTableModel table = new DefaultTableModel();
        table.addColumn("ID Pinjam");
        table.addColumn("ID Petugas");
        table.addColumn("ID Anggota");
        table.addColumn("Nama Anggota");
        table.addColumn("ID Buku");
        table.addColumn("Judul Buku");
        table.addColumn("Tanggal Pinjam");
        table.addColumn("Jatuh Tempo");
        tabelPeminjaman.setModel(table);

        
        try {
            int no = 1;
            String sql = "SELECT * FROM peminjaman WHERE idPinjam like ? "
                    + " or idPetugas like ? or idAnggota like ?"
                    + " or namaAnggota like ? or idBuku like ?"
                    + " or judulBuku like ? or tanggalPinjam like ?"
                    + " or jatuhTempo like ?";

            ConnectionDatabase koneksiDatabase = ConnectionDatabase.getInstance();
            Connection connect = koneksiDatabase.getConnection();
            PreparedStatement ps = connect.prepareStatement(sql);
            for (int i = 1; i <= 8; i++) {
                ps.setString(i, "%" + inputPencarian.getText() + "%");
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                table.addRow(new Object[] {rs.getString(1), rs.getString(2), rs.getString(3), 
                    rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });
            }
            
            String sqlGetMaxId = "SELECT MAX(SUBSTRING(idPinjam, 9, 3)) FROM peminjaman";
            PreparedStatement psMaxId = connect.prepareStatement(sqlGetMaxId);
            ResultSet rsMaxId = psMaxId.executeQuery();

            if (rsMaxId.next()) {
                nomorUrut = rsMaxId.getInt(1) + 1;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelPeminjaman = new javax.swing.JTable();
        inputIDPinjam = new javax.swing.JTextField();
        inputIDPetugas = new javax.swing.JTextField();
        inputIDAnggota = new javax.swing.JTextField();
        inputNamaAnggota = new javax.swing.JTextField();
        inputIDBuku = new javax.swing.JTextField();
        inputJudulBuku = new javax.swing.JTextField();
        inputTanggalPinjam = new javax.swing.JTextField();
        inputJatuhTempo = new javax.swing.JTextField();
        inputPencarian = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        txtOtomatis = new javax.swing.JLabel();
        txtOtomatis1 = new javax.swing.JLabel();
        bgPeminjaman = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelPeminjaman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No. Pinjam ", "ID Petugas", "ID Anggota", "Nama Anggota", "ID Buku", "Judul Buku", "Tanggal Pinjam", "Batas Pengembalian "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelPeminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPeminjamanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelPeminjaman);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 1300, 270));

        inputIDPinjam.setBackground(new java.awt.Color(222, 217, 186));
        inputIDPinjam.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        inputIDPinjam.setBorder(null);
        inputIDPinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputIDPinjamActionPerformed(evt);
            }
        });
        getContentPane().add(inputIDPinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 390, 30));

        inputIDPetugas.setBackground(new java.awt.Color(222, 217, 186));
        inputIDPetugas.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        inputIDPetugas.setBorder(null);
        inputIDPetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputIDPetugasActionPerformed(evt);
            }
        });
        getContentPane().add(inputIDPetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 390, 30));

        inputIDAnggota.setBackground(new java.awt.Color(222, 217, 186));
        inputIDAnggota.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        inputIDAnggota.setBorder(null);
        inputIDAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputIDAnggotaActionPerformed(evt);
            }
        });
        getContentPane().add(inputIDAnggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 390, 30));

        inputNamaAnggota.setBackground(new java.awt.Color(222, 217, 186));
        inputNamaAnggota.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        inputNamaAnggota.setBorder(null);
        inputNamaAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNamaAnggotaActionPerformed(evt);
            }
        });
        getContentPane().add(inputNamaAnggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 390, 30));

        inputIDBuku.setBackground(new java.awt.Color(222, 217, 186));
        inputIDBuku.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        inputIDBuku.setBorder(null);
        inputIDBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputIDBukuActionPerformed(evt);
            }
        });
        getContentPane().add(inputIDBuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 390, 30));

        inputJudulBuku.setBackground(new java.awt.Color(222, 217, 186));
        inputJudulBuku.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        inputJudulBuku.setBorder(null);
        inputJudulBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputJudulBukuActionPerformed(evt);
            }
        });
        getContentPane().add(inputJudulBuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, 390, 30));

        inputTanggalPinjam.setBackground(new java.awt.Color(222, 217, 186));
        inputTanggalPinjam.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        inputTanggalPinjam.setBorder(null);
        inputTanggalPinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputTanggalPinjamActionPerformed(evt);
            }
        });
        getContentPane().add(inputTanggalPinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, 390, 30));

        inputJatuhTempo.setBackground(new java.awt.Color(222, 217, 186));
        inputJatuhTempo.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        inputJatuhTempo.setBorder(null);
        inputJatuhTempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputJatuhTempoActionPerformed(evt);
            }
        });
        getContentPane().add(inputJatuhTempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 380, 390, 30));

        inputPencarian.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        inputPencarian.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        inputPencarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPencarianActionPerformed(evt);
            }
        });
        getContentPane().add(inputPencarian, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 230, 30));

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
        getContentPane().add(btnCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, 110, 30));

        txtOtomatis.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtOtomatis.setForeground(java.awt.Color.orange);
        txtOtomatis.setText("(OTOMATIS)");
        getContentPane().add(txtOtomatis, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 350, -1, -1));

        txtOtomatis1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtOtomatis1.setForeground(java.awt.Color.orange);
        txtOtomatis1.setText("(OTOMATIS)");
        getContentPane().add(txtOtomatis1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 280, -1, -1));

        bgPeminjaman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DATA PEMINJAMAN.png"))); // NOI18N
        getContentPane().add(bgPeminjaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputIDPetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputIDPetugasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputIDPetugasActionPerformed

    private void inputIDPinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputIDPinjamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputIDPinjamActionPerformed

    private void inputIDAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputIDAnggotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputIDAnggotaActionPerformed

    private void inputNamaAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNamaAnggotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNamaAnggotaActionPerformed

    private void inputIDBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputIDBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputIDBukuActionPerformed

    private void inputJudulBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputJudulBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputJudulBukuActionPerformed

    private void inputTanggalPinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputTanggalPinjamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputTanggalPinjamActionPerformed

    private void inputJatuhTempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputJatuhTempoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputJatuhTempoActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        frameMenu menu = new frameMenu();
        menu.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnKeluarActionPerformed

    private void tabelPeminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPeminjamanMouseClicked
        // TODO add your handling code here:
        int row = tabelPeminjaman.getSelectedRow();

        //        if (row == -1){
            //            return;
            //
            //        }
        inputIDPinjam.setText((String) tabelPeminjaman.getValueAt(row, 0));
        inputIDPetugas.setText((String) tabelPeminjaman.getValueAt(row, 1));
        inputIDAnggota.setText((String) tabelPeminjaman.getValueAt(row, 2));
        inputNamaAnggota.setText((String) tabelPeminjaman.getValueAt(row, 3));
        inputIDBuku.setText((String) tabelPeminjaman.getValueAt(row, 4));
        inputJudulBuku.setText((String) tabelPeminjaman.getValueAt(row, 5));
        inputTanggalPinjam.setText((String) tabelPeminjaman.getValueAt(row, 6));
        inputJatuhTempo.setText((String) tabelPeminjaman.getValueAt(row, 7));


    }//GEN-LAST:event_tabelPeminjamanMouseClicked

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
    try {
            String sql = "DELETE FROM peminjaman WHERE idPinjam = ?"; 
            ConnectionDatabase koneksiDatabase = ConnectionDatabase.getInstance();
            Connection connect = koneksiDatabase.getConnection();
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, inputIDPinjam.getText());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Data Peminjaman Berhasil Dihapus!");
            showData();
            refreshForm();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        try {
            String sql = "UPDATE peminjaman SET idPinjam = ?, idPetugas = ?, idAnggota = ?, "
                    + "namaAnggota = ?, idBuku = ?, judulBuku = ?, tanggalPinjam = ?, jatuhTempo = ? "
                    + "WHERE idPinjam = ?";
            ConnectionDatabase koneksidatabase = ConnectionDatabase.getInstance();
            Connection connect = koneksidatabase.getConnection();
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, inputIDPinjam.getText());
            ps.setString(2, inputIDPetugas.getText());
            ps.setString(3, inputIDAnggota.getText());
            ps.setString(4, inputNamaAnggota.getText());
            ps.setString(5, inputIDBuku.getText());
            ps.setString(6, inputJudulBuku.getText());
            ps.setString(7, inputTanggalPinjam.getText());
            ps.setString(8, inputJatuhTempo.getText());
            ps.setString(9, inputIDPinjam.getText()); 
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Peminjaman Berhasil Diubah!");
            showData();
            refreshForm();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        try {
            LocalDate tanggalPeminjaman = LocalDate.now();
            LocalDate tanggalJatuhTempo = tanggalPeminjaman.plusDays(5);
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String strTanggalPeminjaman = tanggalPeminjaman.format(dateFormat);
            String strTanggalJatuhTempo = tanggalJatuhTempo.format(dateFormat);
            
            String tanggalBulan = String.format("%02d%02d", tanggalPeminjaman.getDayOfMonth(), tanggalPeminjaman.getMonthValue());
            String nomorUrutFormatted = String.format("%03d", nomorUrut);
            String idPinjam = "PJ" + tanggalBulan + nomorUrutFormatted;

            inputIDPinjam.setText(idPinjam);
            inputTanggalPinjam.setText(strTanggalPeminjaman);
            inputJatuhTempo.setText(strTanggalJatuhTempo);
            
            String sql = "INSERT INTO peminjaman VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            ConnectionDatabase koneksiDatabase = ConnectionDatabase.getInstance();
            Connection connect = koneksiDatabase.getConnection();
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, inputIDPinjam.getText());
            ps.setString(2, inputIDPetugas.getText());
            ps.setString(3, inputIDAnggota.getText());
            ps.setString(4, inputNamaAnggota.getText());
            ps.setString(5, inputIDBuku.getText());
            ps.setString(6, inputJudulBuku.getText());
            ps.setString(7, inputTanggalPinjam.getText());
            ps.setString(8, inputJatuhTempo.getText());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Data Peminjaman Berhasil Ditambahkan!");
            showData();
            refreshForm();
            nomorUrut++;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        try {
            String sql = "SELECT * FROM peminjaman WHERE idPinjam LIKE ? OR "
                    + "idPetugas LIKE ? OR "
                    + "idAnggota LIKE ? OR "
                    + "namaAnggota LIKE ? OR "
                    + "idBuku LIKE ? OR "
                    + "judulBuku LIKE ? OR "
                    + "tanggalPinjam LIKE ? OR "
                    + "jatuhTempo LIKE ?";

            ConnectionDatabase koneksidatabase = ConnectionDatabase.getInstance();
            Connection connect = koneksidatabase.getConnection();
            PreparedStatement ps = connect.prepareStatement(sql);
            for (int i = 1; i <= 8; i++) {
                ps.setString(i, "%" + inputPencarian.getText() + "%");
            }

            ResultSet rs = ps.executeQuery();

            DefaultTableModel table = new DefaultTableModel();
            table.addColumn("ID Pinjam");
            table.addColumn("ID Petugas");
            table.addColumn("ID Anggota");
            table.addColumn("Nama Anggota");
            table.addColumn("ID Buku");
            table.addColumn("Judul Buku");
            table.addColumn("Tanggal Pinjam");
            table.addColumn("Jatuh Tempo");
            tabelPeminjaman.setModel(table);

            while (rs.next()) {
                table.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)});
            }

            if (table.getRowCount() > 0) {
                JOptionPane.showMessageDialog(null, "Data Peminjaman Ditemukan!");
            } else {
                JOptionPane.showMessageDialog(null, "Data Peminjaman Tidak Ditemukan!");
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
            java.util.logging.Logger.getLogger(framePeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(framePeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(framePeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(framePeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new framePeminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgPeminjaman;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JTextField inputIDAnggota;
    private javax.swing.JTextField inputIDBuku;
    private javax.swing.JTextField inputIDPetugas;
    private javax.swing.JTextField inputIDPinjam;
    private javax.swing.JTextField inputJatuhTempo;
    private javax.swing.JTextField inputJudulBuku;
    private javax.swing.JTextField inputNamaAnggota;
    private javax.swing.JTextField inputPencarian;
    private javax.swing.JTextField inputTanggalPinjam;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelPeminjaman;
    private javax.swing.JLabel txtOtomatis;
    private javax.swing.JLabel txtOtomatis1;
    // End of variables declaration//GEN-END:variables
}
