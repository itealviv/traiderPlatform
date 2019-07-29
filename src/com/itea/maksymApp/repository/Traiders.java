package com.itea.maksymApp.repository;

import java.sql.SQLException;

public class Traiders extends BaseTable implements TableOperation {

    public Traiders() throws SQLException {
        super("traiders");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS traiders("+
                "id BIGINT AUTO_INCREMENT PRIMARY KEY,"+
                "name VARCHAR(255) NOT NULL,"+
                "sfreqTick INT(11),"+
                "cash DECIMAL(15,2) NOT NULL DEFAULT 1000,"+
                "traidingMethod INT(11),"+
                "changeProbability INT(11) DEFAULT 50,"+
                "about VARCHAR(255) NOT NULL DEFAULT '0.00')", "Створена таблиця "
                + table);

        super.executeSqlStatement("ALTER TABLE traiders ADD CONSTRAINT " +
                        "check_traiders_traidingMethod CHECK (TRAIDINGMETHOD in (1,2,3))",
                "Доданио 1 обмеження в " + table);
        super.executeSqlStatement("ALTER TABLE traiders ADD CONSTRAINT " +
                        "check_traiders_changeProbability CHECK (CHANGEPROBABILITY <= 100 and" +
                        " CHANGEPROBABILITY > 0)",
                "Доданио 2 обмеження в " + table);

        //
    }

    @Override
    public void createForeignKeys() throws SQLException {

    }
}
