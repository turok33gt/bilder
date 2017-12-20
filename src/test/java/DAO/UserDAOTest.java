package DAO;

import DAO.impl.MysqlFactoryDAO;
import bin.User;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

public class UserDAOTest {

    MysqlFactoryDAO mysqlFactoryDAO = new MysqlFactoryDAO();

    @Test
    public void testSelectAll() throws SQLException {
        UserDAO userdao = new UserDAO(mysqlFactoryDAO.getConnection());
        List list = userdao.getAll();
        User user;
        for (int i = 0; i < list.size(); i++) {
            user = (User) list.get(i);
            System.out.println(user.toString());
        }
    }

    @Test
    public void testCreateElement() throws SQLException {
        User user = new User("noc","admin");
        UserDAO userdao = new UserDAO(mysqlFactoryDAO.getConnection());
        userdao.createElement(user);
        testSelectAll();
    }

    @Test
    public void testgetElemetById() throws SQLException {
        UserDAO userDAO = new UserDAO(mysqlFactoryDAO.getConnection());
        List<User> list = userDAO.getElemetById(1);
        for (int i = 0; i < list.size(); i++) {
            User user;
            user = list.get(i);
            System.out.println(user.toString());
        }
    }

    @Test
    public void testUpdateElement() throws SQLException {
        testgetElemetById();
        User user = new User("turok","Biks");
        UserDAO userDAO = new UserDAO(mysqlFactoryDAO.getConnection());
        userDAO.UpdateElement(user, 2);
        testgetElemetById();
    }

    @Test
    public void testDeleteElement() throws SQLException {
        UserDAO user = new UserDAO(mysqlFactoryDAO.getConnection());
        user.DeleteElement(1);

    }

}
