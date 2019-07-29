package com.itea.maksymApp.repository;

import java.sql.SQLException;

public class TraiderShareActions extends BaseTable implements TableOperation{
    public TraiderShareActions() throws SQLException {
        super("traderShareActions");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS traderShareActions("+
                "id BIGINT AUTO_INCREMENT PRIMARY KEY,"+
                "operation BIGINT,"+
                "traider BIGINT,"+
                "shareRate BIGINT,"+
                "amount BIGINT)", "Створена таблиця " + table);
    }

    @Override
    public void createForeignKeys() throws SQLException {
        super.executeSqlStatement("ALTER TABLE TRADERSHAREACTIONS ADD FOREIGN KEY " +
                "(TRAIDER) REFERENCES TRAIDERS(ID)", "Додано зовнішній ключ 1 " +
                "до табилиці " + table);
        super.executeSqlStatement("ALTER TABLE TRADERSHAREACTIONS ADD FOREIGN KEY " +
                "(SHARERATE) REFERENCES SHARERATES(ID)", "Додано зовнішній ключ 2 " +
                "до табилиці " + table);
    }
}
