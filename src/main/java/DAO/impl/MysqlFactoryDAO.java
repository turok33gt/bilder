package DAO.impl;


import DAO.interfaces.FactoryDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// поправить клас дописать закрытие конекта или добавить пул конектов.
public class MysqlFactoryDAO implements FactoryDAO {

    private String urldb = "jdbc:mysql://localhost:3306/music";
    private String user = "root";
    private String password = "Ser837gy";

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(urldb, user, password);
    }


}
