/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package kasir_warteg;

import java.io.File; //libraries untuk keperluan file
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

//libraries untuk keperluan laporan
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Ahmad Fachri Albar
 */
public class menu_inventory extends javax.swing.JFrame { //kelas utama 

    //membuat variabel 
    private DefaultTableModel model = null; //untuk mode tabel 
    private PreparedStatement stat; //untuk query sql
    private ResultSet rs; //untuk menyimpan hasil query
    koneksi k = new koneksi(); //untuk menghubungkan ke database(AGREGASI)

    /**
     * Creates new form menu_makanan
     */
    public menu_inventory() { //konstruktor
        initComponents(); //inisialisasi komponen GUI
        k.connect(); //memanggil koneksi
        refreshTable(); //memperbarui tampilan tabel
    }

    //INHERINTANCE/PEWARISAN
    //
    class inventory extends menu_inventory {

        //deklarasi atribut
        int id_barang;
        int harga = 0, sisa_stok = 0;
        String nama_barang, kategori, pemasok;

        //konstruktor untuk mengambil inputan dr textfield
        public inventory() {
            this.nama_barang = text_nama_barang.getText(); //mengambil  nama barang dr GUI
            this.kategori = combo_kategori.getSelectedItem().toString(); ///ambil kategori
            this.pemasok = text_pemasok.getText(); //ambil pemasok
            // validasi text field kosong sebelum mengurai
            String hargaText = text_harga.getText();
            if (!hargaText.isEmpty()) { // Periksa apakah text field tidak kosong
                try {
                    this.harga = Integer.parseInt(hargaText);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Harga harus berupa angka");
                    this.harga = 0;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Field harga tidak boleh kosong");
                this.harga = 0;
            }

            // Validasi input stok harus berupa angka
            String stokText = text_sisa_stok.getText();
            if (!stokText.isEmpty()) { // Periksa apakah text field tidak kosong
                try {
                    this.sisa_stok = Integer.parseInt(stokText);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Sisa Stok harus berupa angka.");
                    this.sisa_stok = 0;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Field sisa stok tidak boleh kosong");
                this.sisa_stok = 0;
            }
        }

    }

    public void refreshTable() {
        //menambahkan kolom pada tabel
        model = new DefaultTableModel();
        model.addColumn("ID Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Kategori");
        model.addColumn("Pemasok");
        model.addColumn("Harga");
        model.addColumn("Sisa stok");
        table_inven.setModel(model);  //menghubungkan model dengan table di GUI
        try {
            //untuk memanggil syntax sql pake prepared statmnet 
            this.stat = k.getCon().prepareStatement("select *from inventory order by id_barang");
            this.rs = this.stat.executeQuery(); //menjalankan query
            while (rs.next()) {
                Object[] data = {
                    rs.getInt("id_barang"),
                    rs.getString("nama_barang"),
                    rs.getString("kategori"),
                    rs.getString("pemasok"),
                    rs.getInt("harga"),
                    rs.getInt("sisa_stok")
                };
                model.addRow(data); //menambahkan data ke tabel
                //ketika ada data di dalam tabel inven
                //akan diambil lalu dijadikan array dlm baris
                //kemudian baris dimasukan ke dlam default model lalu dimasukan ke gui
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); //pesan jika ada eror
        }
       // Kosongkan textfield 
        text_id_barang.setText("");
        text_nama_barang.setText("");
        text_pemasok.setText("");
        text_harga.setText("");
        text_sisa_stok.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        text_id_barang = new javax.swing.JTextField();
        text_nama_barang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        combo_kategori = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_inven = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btn_input = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        text_pemasok = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btn_cetak_laporan = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        text_harga = new javax.swing.JTextField();
        text_sisa_stok = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("MENU INVENTORY");

        jLabel2.setText("ID Barang");

        text_id_barang.setEnabled(false);
        text_id_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_id_barangActionPerformed(evt);
            }
        });

        jLabel3.setText("Nama Barang");

        jLabel5.setText("Kategori");

        combo_kategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bumbu", "Bahan Keirng", "Bahan Beku", "Bahan Segar", " ", " " }));
        combo_kategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_kategoriActionPerformed(evt);
            }
        });

        table_inven.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_inven.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_invenMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_inven);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_input.setBackground(new java.awt.Color(255, 0, 0));
        btn_input.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btn_input.setText("INPUT");
        btn_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inputActionPerformed(evt);
            }
        });

        btn_update.setBackground(new java.awt.Color(204, 0, 0));
        btn_update.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btn_update.setText("UPDATE");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setBackground(new java.awt.Color(255, 0, 0));
        btn_delete.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btn_delete.setText("DELETE");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_input, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_update, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
            .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btn_input)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_update)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_delete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_logout.setBackground(new java.awt.Color(204, 0, 0));
        btn_logout.setText("LOGOUT");
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        jLabel7.setText("Pemasok");

        jLabel8.setText("Harga ");

        btn_cetak_laporan.setBackground(new java.awt.Color(255, 0, 0));
        btn_cetak_laporan.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btn_cetak_laporan.setText("CETAK LAPORAN");
        btn_cetak_laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetak_laporanActionPerformed(evt);
            }
        });

        jLabel9.setText("Sisa Stok");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(text_pemasok)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(text_id_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(text_nama_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(combo_kategori, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(text_harga)
                                            .addComponent(text_sisa_stok, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_cetak_laporan, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))))
                        .addGap(2, 2, 2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btn_cetak_laporan))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(text_id_barang)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(text_nama_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(combo_kategori)
                                .addGap(12, 12, 12)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(text_pemasok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(text_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(text_sisa_stok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_logout)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //coding input
    private void btn_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inputActionPerformed
        // TODO add your handling code here:
        try {
            inventory inven = new inventory();
            this.stat = k.getCon().prepareStatement("insert into inventory values(?,?,?,?,?,?)");//query untuk menambahkan data
            stat.setInt(1, 0);//auto increment
            stat.setString(2, inven.nama_barang);
            stat.setString(3, inven.kategori);
            stat.setString(4, inven.pemasok);
            stat.setInt(5, inven.harga);
            stat.setInt(6, inven.sisa_stok);
            int rowsAffected = stat.executeUpdate(); ///menjalankan lalu memasukan data dari gui ke sql
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan.");
            } else {
                JOptionPane.showMessageDialog(null, "Data tidak ada.");
            }
            refreshTable();//memperbarui tampilan tabel 

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btn_inputActionPerformed

    //coding update
    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        try {
            inventory inven = new inventory(); //membuat objek baru
            inven.id_barang = Integer.parseInt(text_id_barang.getText()); //mengambil id barang
            this.stat = k.getCon().prepareStatement("update inventory set nama_barang =?,kategori =?, pemasok=?, harga=?, sisa_stok=? where id_barang=?"); //query untuk update data
            stat.setString(1, inven.nama_barang);
            stat.setString(2, inven.kategori);
            stat.setString(3, inven.pemasok);
            stat.setInt(4, inven.harga);
            stat.setInt(5, inven.sisa_stok);
            stat.setInt(6, inven.id_barang);
            int rowsAffected = stat.executeUpdate(); //menjelankan lalu memasukan data dari gui ke sql
            if (rowsAffected > 0) { //jika data berhasil diupdate atau tidak
                JOptionPane.showMessageDialog(null, "Data berhasil diubah.");
            } else {
                JOptionPane.showMessageDialog(null, "Data tidak ada.");
            }
            refreshTable(); //memperbarui tampilan tabel 

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); //pesan jika ada eror 
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    //codingan delete
    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        try {
            inventory inven = new inventory(); //membuat objek bernama inven
            inven.id_barang = Integer.parseInt(text_id_barang.getText()); //mengambil id barang dari textfield
            this.stat = k.getCon().prepareStatement("delete from inventory where id_barang=?");
            stat.setInt(1, inven.id_barang);
           int rowsAffected = stat.executeUpdate(); //menjelankan query untuk hapus data
            if (rowsAffected > 0) { //jika data berhasil dihapus atau tidak
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus.");
            } else {
                JOptionPane.showMessageDialog(null, "Data tidak ada.");
            }
            refreshTable(); //memperbarui tampilan tabel

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); //pesan jika ada eror
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_cetak_laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetak_laporanActionPerformed
        // TODO add your handling code here:
        try {
            File namafile = new File("src/laporan2/laporan_inventory.jasper"); //menentukan lokasi file laporan inventory jasper
            JasperPrint jasper = JasperFillManager.fillReport(namafile.getPath(), null, k.getCon()); // Mengisi laporan JasperReports dengan data dari database
            JasperViewer.viewReport(jasper, false); // Menampilkan laporan menggunakan JasperViewer
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); //pesan jika aada eror
        }
    }//GEN-LAST:event_btn_cetak_laporanActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        login.setVisible(true); //membuka menu login
        this.setVisible(false); //menutup menu inventory
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void combo_kategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_kategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_kategoriActionPerformed

    private void table_invenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_invenMouseClicked
       // Mengisi textfield berdasarkan data yang dipilih/di klik di tabel
        text_id_barang.setText(model.getValueAt(table_inven.getSelectedRow(), 0).toString());
        text_nama_barang.setText(model.getValueAt(table_inven.getSelectedRow(), 1).toString());
        text_pemasok.setText(model.getValueAt(table_inven.getSelectedRow(), 3).toString());
        text_harga.setText(model.getValueAt(table_inven.getSelectedRow(), 4).toString());
        text_sisa_stok.setText(model.getValueAt(table_inven.getSelectedRow(), 5).toString());

    }//GEN-LAST:event_table_invenMouseClicked

    private void text_id_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_id_barangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_id_barangActionPerformed

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
            java.util.logging.Logger.getLogger(menu_inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu_inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu_inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu_inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu_inventory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_cetak_laporan;
    public javax.swing.JButton btn_delete;
    public javax.swing.JButton btn_input;
    public javax.swing.JButton btn_logout;
    public javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> combo_kategori;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable table_inven;
    private javax.swing.JTextField text_harga;
    private javax.swing.JTextField text_id_barang;
    private javax.swing.JTextField text_nama_barang;
    private javax.swing.JTextField text_pemasok;
    private javax.swing.JTextField text_sisa_stok;
    // End of variables declaration//GEN-END:variables

}
