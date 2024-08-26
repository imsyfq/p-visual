/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jobsheet08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author tb12as
 */
public class Percobaan4 {

    public Percobaan4() {
        try {
            // step 1: register or load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver berhasil diregister / diload");

            // step 2 : create connection
            String url = "jdbc:mysql://localhost/polnep";
            String user = "root";
            String password = "root";
            Connection koneksi = DriverManager.getConnection(url, user, password);

            // step 3 : create statement
            Statement perintah = koneksi.createStatement();

            // step 4 : query execution
            System.out.println("Sebelum proses insert");
            ResultSet rs = perintah.executeQuery("SELECT * FROM jurusan");
            int i = 1;
            while (rs.next()) {
                System.out.println("Data ke-" + i++);
                System.out.println("Kode jurusan \t: "
                        + rs.getString("kode_jurusan"));
                System.out.println("Jurusan \t: "
                        + rs.getString("nama_jurusan"));
                System.out.println("");
            }

            perintah.executeUpdate("INSERT INTO jurusan VALUES "
                    + "('08', 'Teknologi Komputer')");
            System.out.println("Setelah proses insert");
            rs = perintah.executeQuery("SELECT * FROM jurusan");
            i = 1;
            while (rs.next()) {
                System.out.println("Data ke-" + i++);
                System.out.println("Kode jurusan \t: "
                        + rs.getString("kode_jurusan"));
                System.out.println("Jurusan \t: "
                        + rs.getString("nama_jurusan"));
                System.out.println("");
            }

            // step 5 : close the connection
            koneksi.close();
        } catch (ClassNotFoundException e) {
            System.err.println("Driver tidak ditemukan");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println("Error connection to database");
        }
    }

    public static void main(String[] args) {
        new Percobaan4();
    }

}
