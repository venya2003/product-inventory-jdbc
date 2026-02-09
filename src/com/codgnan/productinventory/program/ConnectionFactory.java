package com.codgnan.productinventory.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String url ="jdbc:mysql://localhost:3306/chichuu";
    private static final String username = "root";
    private static final String password = "chichuu19";
    
    public static Connection getConnection() throws SQLException {
    	return DriverManager.getConnection(url, username, password);
    }
}
