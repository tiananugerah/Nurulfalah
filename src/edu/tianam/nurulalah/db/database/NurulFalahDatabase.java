/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tianam.nurulalah.db.database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import edu.tianam.nurulalah.db.impl.GuruDaoImpl;
import edu.tianam.nurulalah.db.impl.SantriDaoImpl;
import edu.tianam.nurulalah.db.service.GuruDao;
import edu.tianam.nurulalah.db.service.SantriDao;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author THOSHIBA
 */
public class NurulFalahDatabase {

    private static Connection connection;
    private static SantriDao santridao;
    private static GuruDao gurudao;

    public static Connection getConnection() throws SQLException {
        if (connection == null) {

            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://localhost:3306/csv_db");
            dataSource.setUser("root");
            dataSource.setPassword("");
            connection = dataSource.getConnection();
        }

        return connection;
    }

    public static SantriDao getSantriDao() throws SQLException {
        if (santridao == null) {
            santridao = new SantriDaoImpl(getConnection());
        }
        return santridao;
    }

    public static GuruDao getGuruDao() throws SQLException {
        if (gurudao == null) {
            gurudao =  new GuruDaoImpl(getConnection());
        }
        return gurudao;
    }

}
