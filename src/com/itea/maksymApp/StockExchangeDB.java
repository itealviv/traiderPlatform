package com.itea.maksymApp;

import com.itea.maksymApp.repository.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StockExchangeDB {

    public static final String DB_URL = "jdbc:h2:/E:/Java/MaxymApp/db/stockExchange";
    public static final String DB_Driver = "org.h2.Driver";


    private Traiders traiders;
    private Shares shares;
    private ShareRates shareRates;
    private TraiderShareActions traiderShareActions;

    public StockExchangeDB() throws SQLException, ClassNotFoundException {
        Class.forName(DB_Driver);
        this.traiders = new Traiders();
        this.shares = new Shares();
        this.shareRates = new ShareRates();
        this.traiderShareActions = new TraiderShareActions();
    }

    private void createTeblesAndForeignKeys() throws SQLException {
        shares.createTable();
        shareRates.createTable();
        traiders.createTable();
        traiderShareActions.createTable();

        shareRates.createForeignKeys();
        traiderShareActions.createForeignKeys();
    }


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }



    public static void main(String[] args) throws SQLException, ClassNotFoundException{

        try{
	        StockExchangeDB stockExchangeDB = new StockExchangeDB();
	        stockExchangeDB.createTeblesAndForeignKeys();
        } catch (ClassNotFoundException e) {
	        e.printStackTrace();
            System.out.println("JDBC driver not found");
        } catch (SQLException e) {
	        e.printStackTrace();
            System.out.println("SQL error");
        }
    }
}
