package DAO;



import bin.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;



public class UserDAO extends AbstCrud <User> {


    public UserDAO(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM users";
    }

    @Override
    public String getSelectOneElementByIdQuery() {
        return "SELECT * FROM users WHERE user_id = ?";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO users (login, password) \n" +
                "VALUES (?, ?)";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE users SET login=?, password=? WHERE user_id=?";
    }

    @Override
    public String getDeleteElementQuery() {
        return "DELETE FROM users WHERE user_id=?";
    }

    @Override
    public List parseResultSet(ResultSet resultSet) {
        List list = new LinkedList();
        try {
            while (resultSet.next()){
                User user = new User();
                user.setUserid(resultSet.getInt("user_id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                list.add(user);
            }
        } catch (SQLException e) {
            System.out.println("error parse resultSet!!");
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void statementCreateInsert(PreparedStatement statement, User object) {
        try {
            statement.setString(1, object.getLogin());
            statement.setString(2, object.getPassword());
        } catch (SQLException e) {
            System.out.println("error statmentCreateInsert");
            e.printStackTrace();
        }
    }

    @Override
    public void statementUpdateInsert(PreparedStatement statement, User object, int id) {
        try {
            statement.setString(1, object.getLogin());
            statement.setString(2, object.getPassword());
            statement.setInt(3, id);
        } catch (SQLException e) {
            System.out.println("error statmentUpdateInsert");
            e.printStackTrace();
        }
    }


}
