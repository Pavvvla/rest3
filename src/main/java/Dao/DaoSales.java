package Dao;

import DaoConfig.DataSourceFactory;
import DaoConfig.SalesDao;
import model.ARTICLE;
import model.DRESS;
import model.SALAS;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DaoSales implements SalesDao {

    private DaoSales(){
    }
    private static class SingletonHelper{
        private static final DaoSales INSTANCE = new DaoSales();
    }
    public static DaoSales getInstance(){
        return DaoSales.SingletonHelper.INSTANCE;
    }

    @Override
    public Optional<SALAS> find(NAME name) throws SQLException {
        String sql = "SELECT NAME,MANY FROM SALAS WHERE NAME = ?";
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
        return Optional.of(new SALAS(NAME,MANY));

    }

    @Override
    public List<SALAS> findAll() throws SQLException {
        List<SALAS> listsale = new ArrayList<>();
        String sql = "SELECT NAME,MANY FROM SALAS";

        Connection conn = DataSourceFactory.getConnection();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            String NAME = resultSet.getString("NAME");
            String MANY = resultSet.getString("MANY");

            SALAS sale = new SALAS();
            listsale.add(sale);
        }
        return listsale;

    }

    @Override
    public boolean sava(SALAS Salas) throws SQLException {
        String sql = "INSERT into SALAS (NAME,MANY) VALUES (?,?,?,?,?,?)";
        boolean rowInserted = false;
        Connection conn = DataSourceFactory.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,Salas.getNAME());
        statement.setInt(2,Salas.getMANY());
        return rowInserted;

    }

    @Override
    public boolean update(SALAS Sales) throws SQLException {
        String sql = "UPDATE SKIRTS SET NAME = ?,MANY = ?";
        sql += "WHERE NAME = ?";
        boolean rowUpdated = false;
        Connection conn = DataSourceFactory.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1,Sales.getMANY());
        statement.setString(2, Sales.getNAME());
        return false;
    }

    @Override
    public boolean delete(SALAS Sales) throws SQLException {
        String sql = "DELETE FROM SALAS  where NAME = ?, MANY = ?";
        boolean rowDeleted = false;
        Connection conn = DataSourceFactory.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,Sales.getNAME());
        statement.setInt(2, Sales.getMANY());
        rowDeleted = statement.executeUpdate() > 0;
        return rowDeleted;
    }
    }

