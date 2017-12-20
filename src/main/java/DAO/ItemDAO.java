package DAO;

import bin.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ItemDAO extends AbstCrud<Item> {
    public ItemDAO(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM items";
    }

    @Override
    public String getSelectOneElementByIdQuery() {
        return "SELECT * FROM items WHERE id=?";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO users (name, uniqueKey) \n" +
                "VALUES (?, ?)";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE items SET name=?, uniqueKey=? WHERE id=?";
    }

    @Override
    public String getDeleteElementQuery() {
        return "DELETE FROM items WHERE id=?";
    }

    @Override
    public List<Item> parseResultSet(ResultSet resultSet) {
        List list = new LinkedList();
        try {
            while (resultSet.next()){
                Item item = new Item();
                item.setName(resultSet.getString("name"));
                item.setUniqueKeyItem(resultSet.getInt("uniqueKey"));
                list.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void statementCreateInsert(PreparedStatement statement, Item object) {
        try {
            statement.setString(1, object.getName());
            statement.setInt(2, object.getUniqueKeyItem());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void statementUpdateInsert(PreparedStatement statement, Item object, int id) {
        try {
            statement.setString(1, object.getName());
            statement.setInt(2, object.getUniqueKeyItem());
            statement.setInt(3, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
