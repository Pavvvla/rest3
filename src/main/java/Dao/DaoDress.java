package Dao;

import DaoConfig.DataSourceFactory;
import DaoConfig.DressDao;
import model.ARTICLE;
import model.DRESS;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DaoDress implements DressDao {
    private DaoDress(){
    }
    private static class SingletonHelper{
        private static final DaoDress INSTANCE = new DaoDress();
    }
    public static DaoDress getInstance(){
        return DaoDress.SingletonHelper.INSTANCE;
    }

    @Override
    public Optional<DRESS> find(NAME name) throws SQLException {
        String sql = "SELECT NAME,BRAND FROM DRESS WHERE NAME = ?";
        String NAME = "";
        String BRAND = "";
        Connection conn = DataSourceFactory.getConnection();

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, NAME);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()){
            NAME = resultSet.getString("NAME");
            BRAND = resultSet.getString("BRAND");

        }
        return Optional.of(new DRESS(NAME,BRAND));

    }

    @Override
    public List<DRESS> findAll() throws SQLException {
        List<DRESS> listdress = new ArrayList<>();
        String sql = "SELECT NAME,BRAND FROM DRESS";

        Connection conn = DataSourceFactory.getConnection();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            String NAME = resultSet.getString("NAME");
            String BRAND = resultSet.getString("BRAND");

            DRESS dress = new DRESS();
            listdress.add(dress);
        }
        return listdress;

    }

    @Override
    public boolean sava(DRESS Dress) throws SQLException {
        String sql = "INSERT into DRESS (NAME,BRAND) VALUES (?,?,?)";
        boolean rowInserted = false;
        Connection conn = DataSourceFactory.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,Dress.getBRAND());
        statement.setString(2,Dress.getNAME());
        return rowInserted;

    }

    @Override
    public boolean update(DRESS Dress) throws SQLException {
        String sql = "UPDATE DRESS SET NAME = ?,BRAND = ?";
        sql += "WHERE NAME = ?";
        boolean rowUpdated = false;
        Connection conn = DataSourceFactory.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,Dress.getBRAND());
        statement.setString(2, Dress.getNAME());
        return false;
    }

    @Override
    public boolean delete(DRESS Dress) throws SQLException {
        String sql = "DELETE FROM DRESS  where NAME = ?, BRAND = ?";
        boolean rowDeleted = false;
        Connection conn = DataSourceFactory.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,Dress.getNAME());
        statement.setString(2, Dress.getBRAND());
        rowDeleted = statement.executeUpdate() > 0;
        return rowDeleted;
    }
}
