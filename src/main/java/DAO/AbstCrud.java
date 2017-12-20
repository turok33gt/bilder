package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public abstract class AbstCrud <T> {

    private Connection connection;

    public AbstCrud(Connection connection){
        this.connection = connection;
    }

    public abstract String getSelectAllQuery();

    public abstract String getSelectOneElementByIdQuery();

    public abstract String getCreateQuery();

    public abstract String getUpdateQuery();

    public abstract String getDeleteElementQuery();

    public abstract List<T> parseResultSet(ResultSet resultSet);

    public abstract void statementCreateInsert(PreparedStatement statement, T object);

    public abstract void statementUpdateInsert(PreparedStatement statement, T object, int id);


    public List<T> getAll(){
        List<T> list = null;
        String sql = getSelectAllQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);

        } catch (SQLException e) {
            System.out.println("error statment");
            e.printStackTrace();
        }
        return list;
    }

    public List<T> getElemetById(int id){
        List<T> list = null;
        String sql = getSelectOneElementByIdQuery();
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            list = parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void createElement(T object){
        String sql = getCreateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statementCreateInsert(statement, object);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error statment");
            e.printStackTrace();
        }
    }

    public void UpdateElement(T object, int id){
        String sql = getUpdateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statementUpdateInsert(statement,object, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteElement(int id){
        String sql = getDeleteElementQuery();
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    }


