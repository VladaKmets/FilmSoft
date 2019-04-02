package com.vladaprojects.films.repositories;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTemplate {

    @SneakyThrows
    private static Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            throw e;
        }

        System.out.println("MySQL JDBC Driver Registered!");
        try {
            return DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/mkyongcom", "root", "password");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            throw e;
        }

    }
}
