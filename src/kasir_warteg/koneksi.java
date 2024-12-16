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
    private static final String URL = "jdbc:mysql://localhost:3306/db_warteg";
    private static final String USER = "root";
    private static final String PASSWORD = "" ;
    private Connection con;
    
    public void connect(){
        try{
            con = DriverManager.getConnection(URL,USER, PASSWORD);
            System.out.println("Koneksi berhasil");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public Connection getCon(){
        return con;
    }
}
