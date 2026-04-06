package org.example.ss02.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnect {

    // DRIVER
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    // URL
    private static final String URL = "jdbc:mysql://localhost:3307/hn_k24_cntt4?createDatabaseIfNotExist=true";
    // USER
    private static final String USER = "root";
    // PASS
    private static final String PASS = "123456";

    // Tạo kết nối
    public static Connection openConnect() {
        Connection con;
        try {
            // Khai báo Driver
            Class.forName(DRIVER);
            // Mở kết nối database
            con = DriverManager.getConnection(URL, USER, PASS);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }

}
