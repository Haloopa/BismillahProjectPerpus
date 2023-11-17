/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;
import com.mycompany.projectperpus.ConnectionDatabase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author acer
 */
public class frameAnggota extends javax.swing.JFrame {

    /**
     * Creates new form frameAnggota
     */
    private DefaultTableModel tableModel;
    
    public frameAnggota() {
        initComponents();
        
        tableModel = (DefaultTableModel) tabelAnggota.getModel();

       
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
            String query = "SELECT * FROM anggota";
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
                tabelAnggota.setModel(tableModel);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
}
    private void kosongkanForm(){
        inputIDAnggota.setEditable(true);
        inputNamaAnggota.setText(null);
        inputNomor.setText(null);
        inputProdi.setText(null);
        inputFakultas.setText(null);
        inputAlamatAnggota.setText(null);
        inputTahunMasuk.setText(null);
    }
    
    private void tampilkanData() {
    DefaultTableModel model = (DefaultTableModel) tabelAnggota.getModel();
    model.setRowCount(0);

    try {
        String sql = "SELECT * FROM anggota WHERE idAnggota LIKE '%" + inputCari.getText() + "%' "
                + "OR namaAnggota LIKE '%" + inputNamaAnggota.getText() + "%' "
                + "OR nomorHPAnggota LIKE '%" + inputNomor.getText() + "%' "
                + "OR prodi LIKE '%" + inputProdi.getText() + "%' "
                + "OR fakultas LIKE '%" + inputFakultas.getText() + "%' "
                + "OR alamat LIKE '%" + inputAlamatAnggota.getText() + "%' "
                + "OR tahunMasuk LIKE '%" + inputTahunMasuk.getText() + "%'";

        ConnectionDatabase koneksidatabase = ConnectionDatabase.getInstance();
        Connection connect = koneksidatabase.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        boolean dataDitemukan = false; // Tambahkan variabel boolean

        while (rs.next()) {
            dataDitemukan = true; // Set variabel ke true jika ada hasil pencarian
            model.addRow(new Object[]{
                    rs.getString(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5), rs.getString(6),
                    rs.getString(7)
            });
        }

        // Periksa setiap input untuk menampilkan pesan "Data ditemukan" jika setidaknya satu input terisi
        if (dataDitemukan && !(inputCari.getText().isEmpty() && inputNamaAnggota.getText().isEmpty() && inputNomor.getText().isEmpty() && inputProdi.getText().isEmpty() && inputFakultas.getText().isEmpty() && inputAlamatAnggota.getText().isEmpty() && inputTahunMasuk.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Data anggota ditemukan!");
        } else {
            // Tidak menampilkan pesan jika data tidak ditemukan pada operasi "Ubah" atau "Hapus"
            // JOptionPane.showMessageDialog(null, "Data anggota tidak ditemukan!");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
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
        inputIDAnggota = new javax.swing.JTextField();
        inputNamaAnggota = new javax.swing.JTextField();
        inputNomor = new javax.swing.JTextField();
        inputProdi = new javax.swing.JTextField();
        inputFakultas = new javax.swing.JTextField();
        inputAlamatAnggota = new javax.swing.JTextField();
        inputTahunMasuk = new javax.swing.JTextField();
        inputCari = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelAnggota = new javax.swing.JTable();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        inputIDAnggota.setBackground(new java.awt.Color(222, 217, 186));
        inputIDAnggota.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        inputIDAnggota.setBorder(null);
        inputIDAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputIDAnggotaActionPerformed(evt);
            }
        });
        getContentPane().add(inputIDAnggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 162, 400, 30));

        inputNamaAnggota.setBackground(new java.awt.Color(222, 217, 186));
        inputNamaAnggota.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        inputNamaAnggota.setBorder(null);
        inputNamaAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNamaAnggotaActionPerformed(evt);
            }
        });
        getContentPane().add(inputNamaAnggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 400, 30));

        inputNomor.setBackground(new java.awt.Color(222, 217, 186));
        inputNomor.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        inputNomor.setBorder(null);
        inputNomor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNomorActionPerformed(evt);
            }
        });
        getContentPane().add(inputNomor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 400, 30));

        inputProdi.setBackground(new java.awt.Color(222, 217, 186));
        inputProdi.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        inputProdi.setBorder(null);
        inputProdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputProdiActionPerformed(evt);
            }
        });
        getContentPane().add(inputProdi, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 382, 400, 30));

        inputFakultas.setBackground(new java.awt.Color(222, 217, 186));
        inputFakultas.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        inputFakultas.setBorder(null);
        inputFakultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputFakultasActionPerformed(evt);
            }
        });
        getContentPane().add(inputFakultas, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 162, 400, 30));

        inputAlamatAnggota.setBackground(new java.awt.Color(222, 217, 186));
        inputAlamatAnggota.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        inputAlamatAnggota.setBorder(null);
        inputAlamatAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputAlamatAnggotaActionPerformed(evt);
            }
        });
        getContentPane().add(inputAlamatAnggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, 400, 30));

        inputTahunMasuk.setBackground(new java.awt.Color(222, 217, 186));
        inputTahunMasuk.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        inputTahunMasuk.setBorder(null);
        inputTahunMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputTahunMasukActionPerformed(evt);
            }
        });
        getContentPane().add(inputTahunMasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, 410, 30));

        inputCari.setBackground(new java.awt.Color(222, 217, 186));
        inputCari.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        inputCari.setBorder(null);
        inputCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCariActionPerformed(evt);
            }
        });
        getContentPane().add(inputCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 410, 400, 40));

        btnTambah.setBackground(new java.awt.Color(125, 39, 34));
        btnTambah.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(255, 204, 0));
        btnTambah.setText("Tambah");
        btnTambah.setBorder(null);
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        getContentPane().add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 110, 220, 50));

        btnUbah.setBackground(new java.awt.Color(125, 39, 34));
        btnUbah.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        btnUbah.setForeground(new java.awt.Color(255, 204, 0));
        btnUbah.setText("Ubah");
        btnUbah.setBorder(null);
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        getContentPane().add(btnUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 180, 220, 50));

        btnHapus.setBackground(new java.awt.Color(125, 39, 34));
        btnHapus.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(255, 204, 0));
        btnHapus.setText("Hapus");
        btnHapus.setBorder(null);
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 250, 220, 50));

        btnKeluar.setBackground(new java.awt.Color(125, 39, 34));
        btnKeluar.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        btnKeluar.setForeground(new java.awt.Color(255, 204, 0));
        btnKeluar.setText("Keluar");
        btnKeluar.setBorder(null);
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });
        getContentPane().add(btnKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 320, 220, 50));

        btnCari.setBackground(new java.awt.Color(125, 39, 34));
        btnCari.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        btnCari.setForeground(new java.awt.Color(255, 204, 0));
        btnCari.setText("Cari");
        btnCari.setBorder(null);
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });
        getContentPane().add(btnCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 410, 220, 50));

        tabelAnggota.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        tabelAnggota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Anggota", "Nama Anggota", "Nomor HP Anggota", "Prodi", "Fakultas", "Alamat", "Tahun Masuk"
            }
        ));
        tabelAnggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelAnggotaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelAnggota);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 477, 1300, 250));

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DATA ANGGOTA.png"))); // NOI18N
        getContentPane().add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputIDAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputIDAnggotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputIDAnggotaActionPerformed

    private void inputNamaAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNamaAnggotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNamaAnggotaActionPerformed

    private void inputNomorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNomorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNomorActionPerformed

    private void inputProdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputProdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputProdiActionPerformed

    private void inputFakultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputFakultasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputFakultasActionPerformed

    private void inputAlamatAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputAlamatAnggotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputAlamatAnggotaActionPerformed

    private void inputTahunMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputTahunMasukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputTahunMasukActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        
        try {
            String sqlUpdate = "UPDATE anggota SET namaAnggota = ?, nomorHPAnggota = ?, prodi = ?, "
                + "fakultas = ?, alamat = ?, tahunMasuk = ? WHERE idAnggota = ?";

            ConnectionDatabase koneksidatabase = ConnectionDatabase.getInstance();
            Connection connect = koneksidatabase.getConnection();
            PreparedStatement ps = connect.prepareStatement(sqlUpdate);

            ps.setString(1, inputNamaAnggota.getText());
            ps.setString(2, inputNomor.getText());
            ps.setString(3, inputProdi.getText());
            ps.setString(4, inputFakultas.getText());
            ps.setString(5, inputAlamatAnggota.getText());
            ps.setString(6, inputTahunMasuk.getText());
            ps.setString(7, inputIDAnggota.getText());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data anggota berhasil diubah!");
            kosongkanForm();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        try {
            String sqlDelete = "DELETE FROM anggota WHERE idAnggota = ?";

            ConnectionDatabase koneksidatabase = ConnectionDatabase.getInstance();
            Connection connect = koneksidatabase.getConnection();
            PreparedStatement ps = connect.prepareStatement(sqlDelete);

            ps.setString(1, inputIDAnggota.getText());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Data anggota berhasil dihapus!");
            kosongkanForm();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        frameMenu menu = new frameMenu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void tabelAnggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelAnggotaMouseClicked
        // TODO add your handling code here:

        int row = tabelAnggota.getSelectedRow();
        
        if (row == -1){
            return;
        
        }
        

        String idAnggota = (String) tabelAnggota.getValueAt(row, 1);
        inputIDAnggota.setText(idAnggota);
        
        String namaAnggota = (String) tabelAnggota.getValueAt(row, 2);
        inputNamaAnggota.setText(namaAnggota);
        
        String nomor = (String) tabelAnggota.getValueAt(row, 3);
        inputNomor.setText(nomor);
        
        String prodi = (String) tabelAnggota.getValueAt(row, 4);
        inputProdi.setText(prodi);
        
        String fakultas = (String) tabelAnggota.getValueAt(row, 5);
        inputFakultas.setText(fakultas);
        
        String alamatAnggota = (String) tabelAnggota.getValueAt(row, 6);
        inputAlamatAnggota.setText(alamatAnggota);
        
        String tahunMasuk = (String) tabelAnggota.getValueAt(row, 7);
        inputTahunMasuk.setText(tahunMasuk);
        
        tampilkanData();
        kosongkanForm();
    }//GEN-LAST:event_tabelAnggotaMouseClicked

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        
        try {
            String sql = "INSERT INTO anggota VALUES (?, ?, ?, ?, ?, ?, ?)";

            ConnectionDatabase koneksidatabase = ConnectionDatabase.getInstance();
            Connection connect = koneksidatabase.getConnection();
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setString(1, inputIDAnggota.getText());
            ps.setString(2, inputNamaAnggota.getText());
            ps.setString(3, inputNomor.getText());
            ps.setString(4, inputProdi.getText());
            ps.setString(5, inputFakultas.getText());
            ps.setString(6, inputAlamatAnggota.getText());
            ps.setString(7, inputTahunMasuk.getText());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data anggota berhasil ditambahkan!");
            kosongkanForm();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        
        tampilkanData(); 
    }//GEN-LAST:event_btnCariActionPerformed

    private void inputCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputCariActionPerformed

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
            java.util.logging.Logger.getLogger(frameAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frameAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frameAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frameAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frameAnggota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JTextField inputAlamatAnggota;
    private javax.swing.JTextField inputCari;
    private javax.swing.JTextField inputFakultas;
    private javax.swing.JTextField inputIDAnggota;
    private javax.swing.JTextField inputNamaAnggota;
    private javax.swing.JTextField inputNomor;
    private javax.swing.JTextField inputProdi;
    private javax.swing.JTextField inputTahunMasuk;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelAnggota;
    // End of variables declaration//GEN-END:variables
}
