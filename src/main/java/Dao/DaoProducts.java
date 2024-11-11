package Dao;

import DaoConfig.DataSourceFactory;
import DaoConfig.ProductsDao;
import model.ARTICLE;
import model.PRODUCTS;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DaoProducts implements ProductsDao {

    private DaoProducts(){
    }
    private static class SingletonHelper{
        private static final DaoProducts INSTANCE = new DaoProducts();
    }
    public static DaoProducts getInstance(){
        return DaoProducts.SingletonHelper.INSTANCE;
    }

    @Override
    public Optional<PRODUCTS> find(ARTICLE article) throws SQLException {
        String sql = "SELECT ARTICLE,PRODUCTS FROM PRODUCTS WHERE ARTICLE = ?";
        int ARTICLE = 0;
        String PRODUCTS = "";
        Connection conn = DataSourceFactory.getConnection();

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, ARTICLE);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()){
            ARTICLE = resultSet.getInt("ARTICLE");
            PRODUCTS = resultSet.getString("PRODUCTS");
        }
        return Optional.of(new PRODUCTS(ARTICLE,PRODUCTS));

    }

    @Override
    public List<PRODUCTS> findAll() throws SQLException {
        List<PRODUCTS> listProducts = new ArrayList<>();
        String sql = "SELECT ARTICLE,PRODUCTS FROM PRODUCTS";

        Connection conn = DataSourceFactory.getConnection();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            int ARTICLE = resultSet.getInt("ARTICLE");
            String PRODUCTS = resultSet.getString("PRODUCTS");

            PRODUCTS Products = new PRODUCTS();
            listProducts.add(Products);
        }
        return listProducts;
    }

    @Override
    public boolean sava(PRODUCTS Products) throws SQLException {
        String sql = "INSERT into PRODUCTS (ARTICLE,PRODUCTS) VALUES (?,?)";
        boolean rowInserted = false;
        Connection conn = DataSourceFactory.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1,Products.getARTICLE());
        statement.setString(2,Products.getPRODUCTS());
        return rowInserted;
    }

    @Override
    public boolean update(PRODUCTS Products) throws SQLException {
        String sql = "UPDATE PRODUCTS SET ARTICLE = ?,PRODUCTS = ?";
        sql += "WHERE ARTICLE = ?";
        boolean rowUpdated = false;
        Connection conn = DataSourceFactory.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1,Products.getARTICLE());
        statement.setString(2, Products.getPRODUCTS());
        return false;
    }

    @Override
    public boolean delete(PRODUCTS Products) throws SQLException {
        String sql = "DELETE FROM PRODUCTS where ARTICLE = ?,PRODUCTS = ?";
        boolean rowDeleted = false;
        Connection conn = DataSourceFactory.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1,Products.getARTICLE());
        statement.setString(2, Products.getPRODUCTS());
        rowDeleted = statement.executeUpdate() > 0;
        return rowDeleted;
    }
}
