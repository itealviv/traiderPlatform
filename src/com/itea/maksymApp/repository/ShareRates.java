package com.itea.maksymApp.repository;

import java.sql.SQLException;

public class ShareRates extends BaseTable implements TableOperation{
    public ShareRates() throws SQLException {
        super("shareRates");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS shareRates("+
                "id BIGINT AUTO_INCREMENT PRIMARY KEY,"+
                "operDate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,"+
                "share BIGINT,"+
                "rate DECIMAL)", "Створена таблиця " + table);
    }

    @Override
    public void createForeignKeys() throws SQLException {
        super.executeSqlStatement("ALTER TABLE shareRates ADD FOREIGN KEY " +
                        "(SHARE) REFERENCES shares(id)",
                "Доданbq зовнішній ключ в " + table);
    }
}
