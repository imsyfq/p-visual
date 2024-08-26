/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jobsheet08;

import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tb12as
 */
public class Percobaan2 {

    public Percobaan2() {

        try {
            DriverManager.registerDriver(new Driver());
            System.out.println("Driver MySQL berhasil diregister / diload");
        } catch (SQLException e) {
            System.err.println("Driver MySQL tidak ditemukan");
        }
    }

    public static void main(String[] args) {
        new Percobaan2();
    }
}
