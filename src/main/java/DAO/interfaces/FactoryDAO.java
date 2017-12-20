package DAO.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface FactoryDAO {

    Connection getConnection () throws SQLException;
}
