/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;
import com.mycompany.projectperpus.ConnectionDatabase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Septiancesare
 */
public class framePengembalian extends javax.swing.JFrame {

    /**
     * Creates new form framePengembalian
     */
    private DefaultTableModel tableModel;
    
    public framePengembalian() {
        initComponents();
        
        tableModel = (DefaultTableModel) tabelPengembalian.getModel();

       
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshTableData();
            }
        });
        timer.start();

        refreshTableData();
    }
    
   private void refreshTableData() {
        try {
            ConnectionDatabase koneksidatabase = ConnectionDatabase.getInstance();
            Connection connect = koneksidatabase.getConnection();

            // Mengambil data dari database
            String query = "SELECT * FROM pengembalian";
            try (PreparedStatement statement = connect.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {

                // Clear existing data
                tableModel.setRowCount(0);

                // Populate data from the result set
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();

                // tambah baris
                while (resultSet.next()) {
                    Object[] row = new Object[columnCount];
                    for (int i = 1; i <= columnCount; i++) {
                        row[i - 1] = resultSet.getObject(i);
                    }
                    tableModel.addRow(row);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        inputNoUrut = new javax.swing.JTextField();
        inputIdPetugas = new javax.swing.JTextField();
        inputIdAnggota = new javax.swing.JTextField();
        inputNamaAnggota = new javax.swing.JTextField();
        inputIdBuku = new javax.swing.JTextField();
        inputJudulBuku = new javax.swing.JTextField();
        TanggalKembali = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelPengembalian = new javax.swing.JTable();
        inputIdPinjam = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inputNoUrut.setBackground(new java.awt.Color(222, 217, 186));
        inputNoUrut.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        inputNoUrut.setForeground(new java.awt.Color(125, 39, 34));
        inputNoUrut.setBorder(null);
        inputNoUrut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNoUrutActionPerformed(evt);
            }
        });
        jPanel1.add(inputNoUrut, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 410, 40));

        inputIdPetugas.setBackground(new java.awt.Color(222, 217, 186));
        inputIdPetugas.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        inputIdPetugas.setForeground(new java.awt.Color(125, 39, 34));
        inputIdPetugas.setBorder(null);
        jPanel1.add(inputIdPetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 410, 30));

        inputIdAnggota.setBackground(new java.awt.Color(222, 217, 186));
        inputIdAnggota.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        inputIdAnggota.setForeground(new java.awt.Color(125, 39, 34));
        inputIdAnggota.setBorder(null);
        jPanel1.add(inputIdAnggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 410, 30));

        inputNamaAnggota.setBackground(new java.awt.Color(222, 217, 186));
        inputNamaAnggota.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        inputNamaAnggota.setForeground(new java.awt.Color(125, 39, 34));
        inputNamaAnggota.setBorder(null);
        jPanel1.add(inputNamaAnggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 410, 30));

        inputIdBuku.setBackground(new java.awt.Color(222, 217, 186));
        inputIdBuku.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        inputIdBuku.setForeground(new java.awt.Color(125, 39, 34));
        inputIdBuku.setBorder(null);
        jPanel1.add(inputIdBuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 410, 30));

        inputJudulBuku.setBackground(new java.awt.Color(222, 217, 186));
        inputJudulBuku.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        inputJudulBuku.setForeground(new java.awt.Color(125, 39, 34));
        inputJudulBuku.setBorder(null);
        jPanel1.add(inputJudulBuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, 410, 30));

        TanggalKembali.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        TanggalKembali.setForeground(new java.awt.Color(125, 39, 34));
        jPanel1.add(TanggalKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, 410, 30));

        btnTambah.setBackground(new java.awt.Color(125, 39, 34));
        btnTambah.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(222, 217, 186));
        btnTambah.setText("Tambah");
        btnTambah.setBorder(null);
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        jPanel1.add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 120, 210, 40));

        btnUbah.setBackground(new java.awt.Color(125, 39, 34));
        btnUbah.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        btnUbah.setForeground(new java.awt.Color(222, 217, 186));
        btnUbah.setText("Ubah");
        btnUbah.setBorder(null);
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        jPanel1.add(btnUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 180, 210, 40));

        btnHapus.setBackground(new java.awt.Color(125, 39, 34));
        btnHapus.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(222, 217, 186));
        btnHapus.setText("Hapus");
        btnHapus.setBorder(null);
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 250, 210, 40));

        btnKeluar.setBackground(new java.awt.Color(125, 39, 34));
        btnKeluar.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        btnKeluar.setForeground(new java.awt.Color(222, 217, 186));
        btnKeluar.setText("Keluar");
        btnKeluar.setBorder(null);
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });
        jPanel1.add(btnKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 323, 210, 40));

        tabelPengembalian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Anggota", "Nama Anggota", "ID Buku", "Judul Buku", "ID Petugas", "Tanggal Pengembalian", "Denda", "ID Pinjam", "ID Kembali"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelPengembalian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPengembalianMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelPengembalian);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 477, 1300, 260));

        inputIdPinjam.setBackground(new java.awt.Color(222, 217, 186));
        inputIdPinjam.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        inputIdPinjam.setBorder(null);
        jPanel1.add(inputIdPinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, 410, 40));

        jLabel2.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 0));
        jLabel2.setText("ID Pinjam");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, -1, -1));

        btnClear.setBackground(new java.awt.Color(255, 204, 0));
        btnClear.setForeground(new java.awt.Color(102, 0, 0));
        btnClear.setText("Clear All");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel1.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 90, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DATA PENGEMBALIAN.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        LocalDateTime currentime = LocalDateTime.now();
        DateTimeFormatter formatt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String tanggalSekarang = currentime.format(formatt);
        TanggalKembali.setText(tanggalSekarang);

    try {
        ConnectionDatabase koneksidatabase;
        koneksidatabase = ConnectionDatabase.getInstance();
        Connection connect = koneksidatabase.getConnection();

        String idAnggota = inputIdAnggota.getText();
        String namaAnggota = inputNamaAnggota.getText();
        String idBuku = inputIdBuku.getText();
        String judulBuku = inputJudulBuku.getText();
        String idPetugas = inputIdPetugas.getText();
        String idPinjam = inputIdPinjam.getText();

        String tanggal = TanggalKembali.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date tglKembali = new Date(sdf.parse(tanggal).getTime());

        SimpleDateFormat sdfid = new SimpleDateFormat("ddMM");
        String tglKembaliId = sdfid.format(tglKembali);

        // Ambil tanggalPinjam dari tabel peminjaman
        Date tglPinjam;
        String queryTanggalPinjam = "SELECT tanggalPinjam FROM peminjaman WHERE idPinjam = ?";
        try (PreparedStatement statement = connect.prepareStatement(queryTanggalPinjam)) {
            statement.setString(1, idPinjam);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                tglPinjam = resultSet.getDate("tanggalPinjam");
                System.out.println("Tanggal Pinjam: " + sdf.format(tglPinjam));
            } else {
                System.out.println("Data tidak ditemukan");
                JOptionPane.showMessageDialog(this, "Data tidak Valid", "Pesan", JOptionPane.INFORMATION_MESSAGE);
         
                return;
            }
        }

        long hariPinjam = TimeUnit.DAYS.convert(tglKembali.getTime() - tglPinjam.getTime(), TimeUnit.MILLISECONDS);
        int denda = (hariPinjam > 5) ? (int) ((hariPinjam - 5) * 5000) : 0;

        String idKembali = "PL" + tglKembaliId + inputNoUrut.getText();

        String query = "INSERT INTO pengembalian (idAnggota, namaAnggota, idBuku, judulBuku, idPetugas, tanggalKembali, denda, idPinjam, idKembali) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connect.prepareStatement(query)) {
            ps.setString(1, idAnggota);
            ps.setString(2, namaAnggota);
            ps.setString(3, idBuku);
            ps.setString(4, judulBuku);
            ps.setString(5, idPetugas);
            ps.setDate(6, new java.sql.Date(tglKembali.getTime()));
            ps.setInt(7, denda);
            ps.setString(8, idPinjam);
            ps.setString(9, idKembali);

      
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Data Pengembalian Berhasil ditambahkan!", "Pesan", JOptionPane.INFORMATION_MESSAGE);
            
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menambahkan data ke tabel pengembalian", "Pesan", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    } catch (ParseException | SQLException ex) {
           
        Logger.getLogger(framePengembalian.class.getName()).log(Level.SEVERE, null, ex);
    }
            
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        frameMenu menu = new frameMenu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void tabelPengembalianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPengembalianMouseClicked
        // TODO add your handling code here:
        
        
        
        int row = tabelPengembalian.getSelectedRow();
        
        if (row == -1){
            return;
        
        }
        

        String idKembali = (String) tabelPengembalian.getValueAt(row, 8);
        inputNoUrut.setText(idKembali);
        
        String idAnggota = (String) tabelPengembalian.getValueAt(row, 0);
        inputIdAnggota.setText(idAnggota);
        
        String namaAnggota = (String) tabelPengembalian.getValueAt(row, 1);
        inputNamaAnggota.setText(namaAnggota);
        
        String idBuku = (String) tabelPengembalian.getValueAt(row, 2);
        inputIdBuku.setText(idBuku);
        
        String idPetugas = (String) tabelPengembalian.getValueAt(row, 4);
        inputIdPetugas.setText(idPetugas);
        
        String judulBuku = (String) tabelPengembalian.getValueAt(row, 3);
        inputJudulBuku.setText(judulBuku);
        
        String idPinjam = (String) tabelPengembalian.getValueAt(row, 7);
        inputIdPinjam.setText(idPinjam);
        
        java.sql.Date tanggalSql = (java.sql.Date) tabelPengembalian.getValueAt(row, 5);
        
        // Ubah java.sql.Date menjadi string dengan menggunakan SimpleDateFormat
        String tanggal = new SimpleDateFormat("yyyy-MM-dd").format(tanggalSql);
        TanggalKembali.setText(tanggal);
        
        
        
        
        
    }//GEN-LAST:event_tabelPengembalianMouseClicked

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
       
        try {
            ConnectionDatabase koneksidatabase;
            koneksidatabase = ConnectionDatabase.getInstance();
            Connection connect = koneksidatabase.getConnection();
            
            String idBuku = inputIdBuku.getText();
            String query = "DELETE FROM pengembalian WHERE idBuku = ?";
            PreparedStatement statement = connect.prepareStatement(query);
            
             // Set nilai parameter idBuku pada query DELETE
            statement.setString(1, idBuku);

            // Jalankan query DELETE
            int rowsAffected = statement.executeUpdate();

            // Periksa apakah baris berhasil dihapus
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus", "Pesan", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Hapus Data gagal", "Pesan", JOptionPane.INFORMATION_MESSAGE);
            }

            
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(framePengembalian.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_btnHapusActionPerformed

    private void inputNoUrutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNoUrutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNoUrutActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        try {
        ConnectionDatabase koneksidatabase;
        koneksidatabase = ConnectionDatabase.getInstance();
        Connection connect = koneksidatabase.getConnection();
        
        String namaAnggota = inputNamaAnggota.getText();
        String judulBuku = inputJudulBuku.getText();
        String idPinjam = inputIdPinjam.getText();

        String tanggal = TanggalKembali.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date tglKembali = null;
        try {
            tglKembali = new Date(sdf.parse(tanggal).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(framePengembalian.class.getName()).log(Level.SEVERE, null, ex);
        }
        SimpleDateFormat sdfid = new SimpleDateFormat("ddMM");
        String tglKembaliId = sdfid.format(tglKembali);

        String idKembali = "PL" + tglKembaliId + inputNoUrut.getText();

        
        String query = "UPDATE pengembalian SET namaAnggota = ?, judulBuku = ?, idKembali = ? WHERE idPinjam = ?";
        try (PreparedStatement st = connect.prepareStatement(query)) {
            st.setString(1, namaAnggota);
            st.setString(2, judulBuku);
            st.setString(3, idKembali);
            st.setString(4, idPinjam);

            
            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil diubah", "Pesan", JOptionPane.INFORMATION_MESSAGE);
            
            } else {
                JOptionPane.showMessageDialog(this, "Ubah Data gagal", "Pesan", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(framePengembalian.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        String kosong = "";
        inputNoUrut.setText(kosong);
        inputIdAnggota.setText(kosong);
        inputIdBuku.setText(kosong);
        inputIdPetugas.setText(kosong);
        inputJudulBuku.setText(kosong);
        inputNamaAnggota.setText(kosong);
        inputIdPinjam.setText(kosong);
        TanggalKembali.setText(kosong);
    }//GEN-LAST:event_btnClearActionPerformed

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
            java.util.logging.Logger.getLogger(framePengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(framePengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(framePengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(framePengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new framePengembalian().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TanggalKembali;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JTextField inputIdAnggota;
    private javax.swing.JTextField inputIdBuku;
    private javax.swing.JTextField inputIdPetugas;
    private javax.swing.JTextField inputIdPinjam;
    private javax.swing.JTextField inputJudulBuku;
    private javax.swing.JTextField inputNamaAnggota;
    private javax.swing.JTextField inputNoUrut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelPengembalian;
    // End of variables declaration//GEN-END:variables
}
