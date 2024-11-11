package Dao;

import DaoConfig.DataSourceFactory;
import DaoConfig.SalesDao10000;
import model.SALAS;
import model.SALAS10000;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DaoSalas10000 implements SalesDao10000 {

    private DaoSalas10000(){
    }
    private static class SingletonHelper{
        private static final DaoSalas10000 INSTANCE = new DaoSalas10000();
    }
    public static DaoSalas10000 getInstance(){
        return DaoSalas10000.SingletonHelper.INSTANCE;
    }

    @Override
    public Optional<SALAS10000> find(NAME name) throws SQLException {
        String sql = "SELECT NAME,MANY FROM SALAS10000 WHERE NAME = ?";
        int MANY = 0;
        String NAME = "";
        Connection conn = DataSourceFactory.getConnection();

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, NAME);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()){
            NAME = resultSet.getString("NAME");
            MANY = resultSet.getInt("MANY");
        }
        return Optional.of(new SALAS10000(NAME,MANY));
    }

    @Override
    public List<SALAS10000> findAll() throws SQLException {
        List<SALAS10000> listsale10000 = new ArrayList<>();
        String sql = "SELECT NAME,MANY FROM SALAS10000";

        Connection conn = DataSourceFactory.getConnection();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            String NAME = resultSet.getString("NAME");
            String MANY = resultSet.getString("MANY");

            SALAS10000 sale10000 = new SALAS10000();
            listsale10000.add(sale10000);
        }
        return listsale10000;
    }

    @Override
    public boolean sava(SALAS10000 Salas10000) throws SQLException {
        String sql = "INSERT into SALAS10000 (NAME,MANY) VALUES (?,?,?,?,?)";
        boolean rowInserted = false;
        Connection conn = DataSourceFactory.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,Salas10000.getNAME());
        statement.setInt(2,Salas10000.getMANY());
        return rowInserted;
    }

    @Override
    public boolean update(SALAS10000 Sales10000) throws SQLException {
        String sql = "UPDATE SKIRTS SET NAME = ?,MANY = ?";
        sql += "WHERE NAME = ?";
        boolean rowUpdated = false;
        Connection conn = DataSourceFactory.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1,Sales10000.getMANY());
        statement.setString(2, Sales10000.getNAME());
        return false;
    }

    @Override
    public boolean delete(SALAS10000 Sales10000) throws SQLException {
        String sql = "DELETE FROM SALAS10000  where NAME = ?, MANY = ?";
        boolean rowDeleted = false;
        Connection conn = DataSourceFactory.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,Sales10000.getNAME());
        statement.setInt(2, Sales10000.getMANY());
        rowDeleted = statement.executeUpdate() > 0;
        return rowDeleted;
    }
}
