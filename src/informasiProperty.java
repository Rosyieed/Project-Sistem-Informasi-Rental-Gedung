
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author user
 */

public class informasiProperty extends javax.swing.JFrame {

    /**
     * Creates new form menuUtama
     */
    public informasiProperty() {
        initComponents();
        getData();
        autoNumber();
    }
    
    private void clear(){
        tf_namaProperty.setText("");
        tf_idProperty.setText("");
        tf_stokProperty.setText("");
    }
    
    private void autoNumber(){
        try {
            String sql = "select max(right(id_property,4)) as no_auto from tb_property";
            Connection conn = koneksiDatabase.getKoneksi();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.next()){
                String no_auto, nol_plus;
                int p;
                no_auto = Integer.toString(rs.getInt(1)+1);
                p = no_auto.length();
                nol_plus = "";
                for(int i = 1; i <= 4-p; i++){
                    nol_plus = nol_plus + "0";
                }
                tf_idProperty.setText("6"+nol_plus+no_auto);
            }
        } catch (Exception e) {
        }
    }
    
    private void getData(){
        try {
            Connection conn = koneksiDatabase.getKoneksi();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from tb_property order by id_property asc;");
            
            DefaultTableModel model = new DefaultTableModel();  
            model.addColumn("ID Property");
            model.addColumn("Nama Property");
            model.addColumn("Stok");
            
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
                      
            while (rs.next()){
                Object[] data = {
                    rs.getString("id_property"),
                    rs.getString("nama_property"),
                    rs.getString("stok"),
                };
                model.addRow(data);
                tb_infoProperty.setModel(model);
                }
        } catch (SQLException ex) {
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
        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        bt_tambahData = new javax.swing.JButton();
        bt_ubahData = new javax.swing.JButton();
        bt_hapusData = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_infoProperty = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        bt_kembali = new javax.swing.JButton();
        bt_clear = new javax.swing.JButton();
        tf_idProperty = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_namaProperty = new javax.swing.JTextField();
        tf_stokProperty = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Sewa Gedung");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel5.setText("APLIKASI SEWA GEDUNG");

        jLabel15.setFont(new java.awt.Font("Consolas", 1, 20)); // NOI18N
        jLabel15.setText("PT SEMOGA SEJAHTERA SELALU");

        jLabel16.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel16.setText("JL. Asia Pasifik No. 13 Bekasi");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16))
                    .addComponent(jLabel17))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        bt_tambahData.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bt_tambahData.setText("Tambah Data");
        bt_tambahData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_tambahDataActionPerformed(evt);
            }
        });

        bt_ubahData.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bt_ubahData.setText("Ubah Data");
        bt_ubahData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ubahDataActionPerformed(evt);
            }
        });

        bt_hapusData.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bt_hapusData.setText("Hapus Data");
        bt_hapusData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_hapusDataActionPerformed(evt);
            }
        });

        tb_infoProperty.setAutoCreateRowSorter(true);
        tb_infoProperty.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Property", "Nama Property", "Stok"
            }
        ));
        tb_infoProperty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_infoPropertyMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_infoProperty);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INFORMASI PROPERTY");

        bt_kembali.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bt_kembali.setText("Kembali");
        bt_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_kembaliActionPerformed(evt);
            }
        });

        bt_clear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bt_clear.setText("Clear");
        bt_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_clearActionPerformed(evt);
            }
        });

        jLabel2.setText("ID Property");

        jLabel3.setText("Nama Property");

        jLabel4.setText("Stok");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bt_kembali)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_clear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_tambahData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_ubahData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_hapusData))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_stokProperty, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_namaProperty, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_idProperty, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_idProperty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tf_namaProperty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_stokProperty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_tambahData)
                            .addComponent(bt_clear)
                            .addComponent(bt_kembali)
                            .addComponent(bt_ubahData)
                            .addComponent(bt_hapusData))
                        .addContainerGap(184, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_kembaliActionPerformed
        // TODO add your handling code here:
        menuUtama mu = new menuUtama();
        mu.setVisible(true);
        mu.pack();
        mu.setLocationRelativeTo(null);
        mu.setDefaultCloseOperation(informasiGedung.EXIT_ON_CLOSE);
        dispose();
    }//GEN-LAST:event_bt_kembaliActionPerformed

    private void bt_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_clearActionPerformed
        // TODO add your handling code here:
        clear();
        getData();
        autoNumber();
    }//GEN-LAST:event_bt_clearActionPerformed

    
    private void bt_tambahDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_tambahDataActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Connection conn = koneksiDatabase.getKoneksi();
            Statement st = conn.createStatement();
            String sql = "insert into tb_property VALUES ('" + tf_idProperty.getText() + "','" + tf_namaProperty.getText() + "','" + tf_stokProperty.getText()  + "');";

            if (tf_idProperty.getText().equals("") || tf_namaProperty.getText().equals("") || tf_stokProperty.getText().equals("") ){
                JOptionPane.showMessageDialog(rootPane, "Tambah data Tidak Berhasil\nMohon Masukan Form dengan benar!");
                autoNumber();
            }
            else{
                st.executeUpdate(sql);
                st.close();
                JOptionPane.showMessageDialog(rootPane, "Tambah Data Berhasil");
                clear();
                getData();
                autoNumber();
            }

        }   catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "Mohon Masukan Form dengan Benar!");
                autoNumber();
        }
    }//GEN-LAST:event_bt_tambahDataActionPerformed

    private void bt_ubahDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ubahDataActionPerformed
        // TODO add your handling code here:
        try {
            Connection conn = koneksiDatabase.getKoneksi();
            Statement st = conn.createStatement();
            String sqlUpdate = "update tb_property set nama_property = '" + tf_namaProperty.getText() + 
                            "', stok = '" + tf_stokProperty.getText() +
                            "' where id_property = '" + tf_idProperty.getText() + "'";
            
            if(bt_ubahData.getText().equals("Ubah Data"))
            {
                st.executeUpdate(sqlUpdate);
                JOptionPane.showMessageDialog(rootPane, "Data Berhasil Diupdate");
                clear();
                getData();
                autoNumber();
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Mohon Masukan Form dengan Benar!");
        }
    }//GEN-LAST:event_bt_ubahDataActionPerformed

    private void bt_hapusDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_hapusDataActionPerformed
        // TODO add your handling code here:
        try {
            Connection conn = koneksiDatabase.getKoneksi();
            Statement st;
            
            int jawab = JOptionPane.showConfirmDialog(rootPane, "Apa anda yakin?", "apakah anda yakin?", JOptionPane.OK_CANCEL_OPTION);
            if (jawab == JOptionPane.OK_OPTION){
                try {
                    st = conn.createStatement();
                    String sqlDelete = "delete from tb_property where id_property = '" + tf_idProperty.getText() +"'";
                    st.executeUpdate(sqlDelete);
                    JOptionPane.showMessageDialog(rootPane, "Data berhasil dihapus");
                    getData();
                    clear();
                    autoNumber();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "Mohon Masukan Data dengan Benar!");
                    autoNumber();
                }}
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Mohon Masukan Data dengan Benar!");
            autoNumber();
        }
    }//GEN-LAST:event_bt_hapusDataActionPerformed

    private void tb_infoPropertyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_infoPropertyMouseClicked
        // TODO add your handling code here:
        tf_idProperty.setText(tb_infoProperty.getValueAt(tb_infoProperty.getSelectedRow(), 0).toString());
        tf_namaProperty.setText(tb_infoProperty.getValueAt(tb_infoProperty.getSelectedRow(), 1).toString());
        tf_stokProperty.setText(tb_infoProperty.getValueAt(tb_infoProperty.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_tb_infoPropertyMouseClicked

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
            java.util.logging.Logger.getLogger(menuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new informasiProperty().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_clear;
    private javax.swing.JButton bt_hapusData;
    private javax.swing.JButton bt_kembali;
    private javax.swing.JButton bt_tambahData;
    private javax.swing.JButton bt_ubahData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_infoProperty;
    private javax.swing.JTextField tf_idProperty;
    private javax.swing.JTextField tf_namaProperty;
    private javax.swing.JTextField tf_stokProperty;
    // End of variables declaration//GEN-END:variables
}
