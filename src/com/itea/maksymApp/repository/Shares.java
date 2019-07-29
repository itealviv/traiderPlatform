package com.itea.maksymApp.repository;

import java.sql.SQLException;

public class Shares extends BaseTable implements TableOperation {
    public Shares() throws SQLException {
        super("Shares");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS shares("+
                "id BIGINT AUTO_INCREMENT PRIMARY KEY,"+
                "name VARCHAR(255) NOT NULL,"+
                "changeProbability INTEGER NOT NULL,"+
                "delta INTEGER NOT NULL)", "Створена таблиця " + table);
    }

    @Override
    public void createForeignKeys() throws SQLException {

    }
}
