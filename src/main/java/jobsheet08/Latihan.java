package jobsheet08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author tb12as
 */
public class Latihan {

    Connection connection = null;
    Scanner scanner = new Scanner(System.in);
    String[] tables = {"prodi", "mhs", "jurusan"};

    public Latihan() {

        while (true) {
            System.out.println("\nPilihan menu");
            System.out.println("1. Tampilkan semua data");
            System.out.println("2. Tambah data");
            System.out.println("3. Ubah data");
            System.out.println("4. Hapus data");
            System.out.println("0. Keluar");
            System.out.println("");
            System.out.print("Pilih menu : ");
            int option = scanner.nextInt();

            // show all (read)
            if (option == 1) {
                int index = this.selectTable();
                this.getAllData(tables[index]);
            }

            // create 
            if (option == 2) {
                try {
                    int index = this.selectTable();
                    Statement st = this.createStatement();
                    ResultSet rs = st.executeQuery("desc " + tables[index]);

                    String values = "";
                    scanner.nextLine(); // consume unused enter

                    while (rs.next()) {
                        System.out.print(rs.getString("Field") + " : ");
                        String val = scanner.nextLine();
                        values += "'" + val + "'";
                        if (!rs.isLast()) {
                            values += ",";
                        }
                    }
                    String query = "insert into "
                            + tables[index] + " values (" + values + ");";
                    st.executeUpdate(query);
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                    break;
                }
            }

            // edit
            if (option == 3) {
                try {
                    int index = this.selectTable();
                    this.getAllData(tables[index]);

                    // get table columns
                    ResultSet rs = this.createStatement()
                            .executeQuery("desc " + tables[index]);

                    // save columns as array
                    ArrayList<String> columns = new ArrayList<String>();
                    while (rs.next()) {
                        columns.add(rs.getString("Field"));
                    }

                    // get first column of table, and assume it as primary key
                    String col = columns.get(0);

                    System.out.println("");
                    System.out.print("Pilih " + col + " : ");
                    scanner.nextLine(); // consume unused enter

                    String key = scanner.nextLine();
                    String set = "";

                    for (int i = 0; i < columns.size(); i++) {
                        String column = columns.get(i);
                        System.out.print(column + " : ");
                        String val = scanner.nextLine();
                        set += column + " = '" + val + "'";
                        if (i < columns.size() - 1) {
                            set += ", ";
                        }
                    }

                    String query = "update " + tables[index] + " set "
                            + set + " where " + col + " = '" + key + "'";
                    this.createStatement().executeUpdate(query);
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }

            // delete
            if (option == 4) {
                try {
                    int index = this.selectTable();
                    this.getAllData(tables[index]);

                    ResultSet rs = this
                            .createStatement()
                            .executeQuery("desc " + tables[index]);
                    // get first column of table, assmue it as primary key
                    rs.next();
                    String col = rs.getString("Field");
                    System.out.print("\nPilih " + col + " : ");

                    scanner.nextLine(); // consume unused enter4
                    
                    String key = scanner.nextLine();
                    this.createStatement().executeUpdate("delete from "
                            + tables[index]
                            + " where " + col + " = " + key);
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }

            if (option == 0) {
                break;
            }
        }

        // close scanner and conneaction to database
        this.scanner.close();
        this.closeConnectionIfExists();
    }

    /**
     * Print all tables, ask the user to select one of them.
     *
     * @return int Index
     */
    private int selectTable() {
        System.out.println("Pilih table: ");
        for (int x = 0; x < tables.length; x++) {
            System.out.println(x + 1 + ". " + tables[x] + " ");
        }
        System.out.println("");
        System.out.print("Pilih table : ");

        int index = scanner.nextInt() - 1;
        // if (index < 0) index = 0, if (index > 2) index = 2
        return Integer.min(Integer.max(index, 0), 2);
    }

    /**
     * Get all data from given table name
     *
     * @param table
     */
    private void getAllData(String table) {
        try {
            ResultSet rs = this.createStatement().executeQuery("select * from " + table);
            ResultSetMetaData meta = rs.getMetaData();
            int i = 0;
            while (rs.next()) {
                System.out.println("Data ke-" + ++i);
                for (int c = 1; c <= meta.getColumnCount(); c++) {
                    String extra = "\t";
                    if (meta.getColumnName(c).length() <= 6) {
                        extra += "\t";
                    }
                    System.out.println(meta.getColumnName(c) + extra
                            + " : " + rs.getString(c)
                    );
                }
                System.out.println("");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Create statement
     *
     * @return Statement
     */
    private Statement createStatement() {
        String url = "jdbc:mysql://localhost/polnep";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.closeConnectionIfExists();
            this.connection = DriverManager.getConnection(url, "root", "root");

            return this.connection.createStatement();
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
            return null;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    /**
     * Close connection to database if connection already created before
     *
     * @return void
     */
    private void closeConnectionIfExists() {
        try {
            if (this.connection != null) {
                this.connection.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new Latihan();
    }
}
