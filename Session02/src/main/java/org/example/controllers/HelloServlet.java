package org.example.ss02.controllers;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.ss02.utils.DataConnect;

// Đây là định nghĩa URL
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello CNTT4";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        // Lấy dữ liệu từ database
        try (Connection con = DataConnect.openConnect()) {
            String sql = "SELECT * FROM persons";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                System.out.println("ID: "+rs.getInt("id"));
                System.out.println("Full Name: "+rs.getString("full_name"));
                System.out.println("Age: "+rs.getInt("age"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // phương thức điều hướng
        request.getRequestDispatcher("/views/students.jsp").forward(request, response);
    }

    public void destroy() {
    }
}