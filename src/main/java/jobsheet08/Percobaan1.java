/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jobsheet08;

/**
 *
 * @author tb12as
 */
public class Percobaan1 {

    public Percobaan1() {
        // metode 1 : menggunakan Class.forName()

        try {
            // com.mysql.cj.jdbc.Driver
            //Class.forName("com.mysql.jdbc.Driver"); // deprecated
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver MySQL berhasil diregister / diload");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver MySQL tidak ditemukan");
        }
    }

    public static void main(String[] args) {
        new Percobaan1();
    }
}
