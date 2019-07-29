package com.itea.maksymApp.repository;

import com.itea.maksymApp.StockExchangeDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseTable {
    private Connection connection;
    public String table;

    public BaseTable(String table) throws SQLException {
        this.table = table;
        this.connection = StockExchangeDB.getConnection();
    }

    public void close() {
        try {
            if(connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong with close connection");
        }
    }

    void executeSqlStatement(String query, String message) throws SQLException{
        reopenConnection();
        Statement statement = connection.createStatement();
        statement.execute(query);
        statement.close();
        if(message != null)
            System.out.println(message);
    }

    void reopenConnection() throws SQLException {
        if(connection == null || connection.isClosed()) {
            connection = StockExchangeDB.getConnection();
        }
    }
}
