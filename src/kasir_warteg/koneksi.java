/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kasir_warteg;
import java.sql.*;
import javax.swing.JOptionPane;
 
/**
 *
 * @author Ahmad Fachri Albar
 */
public class koneksi {
    
    private static final String URL = "jdbc:mysql://localhost:3306/db_warteg"; // URL database yang menunjukkan alamat database MySQL yang akan diakses
    private static final String USER = "root";
    private static final String PASSWORD = "" ;
    private Connection con; //variabel untuk menyimpan koneksi ke datbase
    
    public void connect(){//metod membuat koneksi ke database
        try{ //blok untuk menangani eror
            con = DriverManager.getConnection(URL,USER, PASSWORD); // Membuat koneksi ke database menggunakan DriverManager
            System.out.println("Koneksi berhasil"); // Menampilkan pesan di konsol jika koneksi berhasil
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage()); //pesam jika ada eror
        }
    }
    
    public Connection getCon(){ //untuk mendapatkan koneksi yang sudah dibuat tadi
        return con;
    }
}
