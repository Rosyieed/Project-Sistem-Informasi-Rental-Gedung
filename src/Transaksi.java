import java.awt.print.PrinterException;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author user
 */
public class Transaksi extends javax.swing.JFrame {

    /**
     * Creates new form menuUtama
     */
    public Transaksi() {
        initComponents();
        getDataGedung();
        getDataProperty();
        autoNumber();
    }
    
    private void getData(){
        try {
            Connection conn = koneksiDatabase.getKoneksi();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select nama, from tb_transaksi order by id_transaksi asc;");
            
            DefaultTableModel model = new DefaultTableModel();  
            model.addColumn("ID Transaksi");
            model.addColumn("Nama");
            model.addColumn("KTP");
            model.addColumn("NO. HP");
            model.addColumn("ID Gedung");
            model.addColumn("ID Property");
            model.addColumn("Jml. Property");
            model.addColumn("Check In");
            model.addColumn("Check Out");
            model.addColumn("Harga");
            
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
                      
            while (rs.next()){
                Object[] data = {
                    rs.getString("id_transaksi"),
                    rs.getString("nama_penyewa"),
                    rs.getString("ktp"),
                    rs.getString("no_hp"),
                    rs.getString("id_gedung"),
                    rs.getString("id_property"),
                    rs.getString("j_property"),
                    rs.getDate("check_in"),
                    rs.getDate("check_out"),
                    rs.getString("harga"),
                };
                model.addRow(data);
//                tb_Data.setModel(model);
                }
        } catch (SQLException ex) {
        }
    }
    
    private void clear(){
        tf_idTransaksi.setText(null);
        tf_namaPenyewa.setText(null);
        tf_ktp.setText(null);
        tf_hp.setText(null);
        tf_idGedung.setText(null);
        TF_idProperty.setText(null);
        tf_jumlahProperty.setText(null);
        dt_checkin.setCalendar(null);
        dt_checkout.setCalendar(null);
        tf_hargaBayar.setText(null);
    }
    
    private void autoNumber(){
        try {
            String sql = "select max(right(id_transaksi,4)) as no_auto from tb_transaksi";
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
                tf_idTransaksi.setText("1"+nol_plus+no_auto);
            }
        } catch (Exception e) {
        }
    }
    
    private void getDataGedung(){
        try {
            Connection conn = koneksiDatabase.getKoneksi();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from tb_gedung order by id_gedung asc;");
            
            DefaultTableModel model = new DefaultTableModel();  
            model.addColumn("ID GEDUNG");
            model.addColumn("Nama Gedung");
            model.addColumn("Status");
            
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
                      
            while (rs.next()){
                Object[] data = {
                    rs.getString("id_gedung"),
                    rs.getString("nama_gedung"),
                    rs.getString("status"),
                };
                model.addRow(data);
                tb_infoGd.setModel(model);
                }
        } catch (SQLException ex) {
        }
    }
    
    private void getDataProperty(){
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

        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        bt_submit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bt_kembali = new javax.swing.JButton();
        bt_clear = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tf_ktp = new javax.swing.JTextField();
        tf_hp = new javax.swing.JTextField();
        tf_jumlahProperty = new javax.swing.JTextField();
        tf_idTransaksi = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tf_hargaBayar = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        dt_checkin = new com.toedter.calendar.JDateChooser();
        dt_checkout = new com.toedter.calendar.JDateChooser();
        tf_namaPenyewa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_infoGd = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_infoProperty = new javax.swing.JTable();
        TF_idProperty = new javax.swing.JTextField();
        tf_idGedung = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Sewa Gedung");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel5.setText("APLIKASI SEWA GEDUNG");

        jLabel15.setFont(new java.awt.Font("Consolas", 1, 20)); // NOI18N
        jLabel15.setText("PT SEMOGA SEJAHTERA SELALU");

        jLabel16.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel16.setText("JL. Asia Pasifik No. 13 Bekasi");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(326, 326, 326)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
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
                    .addComponent(jLabel17)
                    .addComponent(jLabel13))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        bt_submit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bt_submit.setText("Submit");
        bt_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_submitActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Transaksi");

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

        jLabel2.setText("Nama Penyewa");

        jLabel3.setText("No. KTP");

        jLabel4.setText("No. HP");

        jLabel6.setText("Check Out");

        jLabel7.setText("ID Transaksi");

        jLabel8.setText("ID Gedung");

        jLabel9.setText("ID Property");

        jLabel10.setText("Jml. Property");

        tf_ktp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_ktpFocusLost(evt);
            }
        });

        tf_hp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_hpFocusLost(evt);
            }
        });

        jLabel11.setText("Check In");

        jLabel12.setText("Harga Bayar");

        tb_infoGd.setAutoCreateRowSorter(true);
        tb_infoGd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Gedung", "Nama Gedung", "Status"
            }
        ));
        tb_infoGd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_infoGdMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_infoGd);

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
        jScrollPane2.setViewportView(tb_infoProperty);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(45, 45, 45)
                        .addComponent(tf_idTransaksi))
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_hp)
                            .addComponent(tf_ktp, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_namaPenyewa, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_hargaBayar)
                            .addComponent(dt_checkout, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(dt_checkin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TF_idProperty)
                            .addComponent(tf_jumlahProperty)
                            .addComponent(tf_idGedung, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bt_kembali)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_clear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_submit)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tf_idTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(tf_namaPenyewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_ktp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_hp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tf_idGedung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(TF_idProperty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(tf_jumlahProperty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dt_checkin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dt_checkout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_hargaBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_kembali)
                            .addComponent(bt_clear)
                            .addComponent(bt_submit)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(35, 35, 35))
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

    private void bt_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_clearActionPerformed
        // TODO add your handling code here:
        clear();
        autoNumber();
    }//GEN-LAST:event_bt_clearActionPerformed

    private void bt_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_kembaliActionPerformed
        // TODO add your handling code here:
        menuUtama mu = new menuUtama();
        mu.setVisible(true);
        mu.pack();
        mu.setLocationRelativeTo(null);
        mu.setDefaultCloseOperation(informasiGedung.EXIT_ON_CLOSE);
        dispose();
    }//GEN-LAST:event_bt_kembaliActionPerformed

    private void bt_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_submitActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String checkIn = dateFormat.format(dt_checkin.getDate());
        String checkOut = dateFormat.format(dt_checkout.getDate());
        
        try {
            // TODO add your handling code here:
            Connection conn = koneksiDatabase.getKoneksi();
            Statement st = conn.createStatement();
            String sql = "insert into tb_transaksi VALUES ('" + tf_idTransaksi.getText() + "','" + tf_namaPenyewa.getText() + "','" 
                    + tf_ktp.getText() + "','" + tf_hp.getText() + "','" + tf_idGedung.getText() + "','" + TF_idProperty.getText() + "','" + tf_jumlahProperty.getText() +
                    "','" + checkIn + "','" + checkOut+ "','" + tf_hargaBayar.getText() + "');";
            
                st.executeUpdate(sql);
                st.close();
                JOptionPane.showMessageDialog(rootPane, "Transaksi Berhasil");
                clear();
                autoNumber();
                getDataProperty();
                rincianSewaGedung rs = new rincianSewaGedung();
                rs.tb_Data.print();
  
        }   catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "Mohon Masukan Form dengan Benar!");
        } catch (PrinterException ex) {
            Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_submitActionPerformed

    private void tb_infoGdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_infoGdMouseClicked
        // TODO add your handling code here:
        tf_idGedung.setText(tb_infoGd.getValueAt(tb_infoGd.getSelectedRow(), 0).toString());
    }//GEN-LAST:event_tb_infoGdMouseClicked

    private void tb_infoPropertyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_infoPropertyMouseClicked
        // TODO add your handling code here:
        TF_idProperty.setText(tb_infoProperty.getValueAt(tb_infoProperty.getSelectedRow(), 0).toString());
    }//GEN-LAST:event_tb_infoPropertyMouseClicked

    private void tf_ktpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_ktpFocusLost
        // TODO add your handling code here:
        String inputKTP = tf_ktp.getText();
        try {
            Long.parseLong(inputKTP);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Isi No. KTP dengan Angka!");
            tf_ktp.requestFocus();
        }
    }//GEN-LAST:event_tf_ktpFocusLost

    private void tf_hpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_hpFocusLost
        // TODO add your handling code here:
        String inputHP = tf_hp.getText();
        try {
            Long.parseLong(inputHP);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Isi No. HP dengan Angka!");
            tf_ktp.requestFocus();
        }
    }//GEN-LAST:event_tf_hpFocusLost

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
                new Transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TF_idProperty;
    private javax.swing.JButton bt_clear;
    private javax.swing.JButton bt_kembali;
    private javax.swing.JButton bt_submit;
    private javax.swing.ButtonGroup buttonGroup2;
    private com.toedter.calendar.JDateChooser dt_checkin;
    private com.toedter.calendar.JDateChooser dt_checkout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tb_infoGd;
    private javax.swing.JTable tb_infoProperty;
    private javax.swing.JTextField tf_hargaBayar;
    private javax.swing.JTextField tf_hp;
    private javax.swing.JTextField tf_idGedung;
    private javax.swing.JTextField tf_idTransaksi;
    private javax.swing.JTextField tf_jumlahProperty;
    private javax.swing.JTextField tf_ktp;
    private javax.swing.JTextField tf_namaPenyewa;
    // End of variables declaration//GEN-END:variables
}
