package Dao;

import DaoConfig.DataSourceFactory;
import DaoConfig.SkirtsDao;
import model.DRESS;
import model.SKIRTS;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DaoSkirts implements SkirtsDao {

    private DaoSkirts(){
    }
    private static class SingletonHelper{
        private static final DaoSkirts INSTANCE = new DaoSkirts();
    }
    public static DaoSkirts getInstance(){
        return DaoSkirts.SingletonHelper.INSTANCE;
    }

    @Override
    public Optional<SKIRTS> find(NAME name) throws SQLException {

        String sql = "SELECT NAME,BRAND FROM SKIRTS WHERE NAME = ?";
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
        return Optional.of(new SKIRTS(NAME,BRAND));
            }

    @Override
    public List<SKIRTS> findAll() throws SQLException {
        List<SKIRTS> listskirts = new ArrayList<>();
        String sql = "SELECT NAME,BRAND FROM SKIRTS";

        Connection conn = DataSourceFactory.getConnection();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            String NAME = resultSet.getString("NAME");
            String BRAND = resultSet.getString("BRAND");

            SKIRTS skirts = new SKIRTS();
            listskirts.add(skirts);
        }
        return listskirts;

            }

    @Override
    public boolean sava(SKIRTS Skirts) throws SQLException {
        String sql = "INSERT into SKIRTS (NAME,BRAND) VALUES (?,?,?)";
        boolean rowInserted = false;
        Connection conn = DataSourceFactory.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,Skirts.getBRAND());
        statement.setString(2,Skirts.getNAME());
        return rowInserted;
    }

    @Override
    public boolean update(SKIRTS Skirts) throws SQLException {
        String sql = "UPDATE SKIRTS SET NAME = ?,BRAND = ?";
        sql += "WHERE NAME = ?";
        boolean rowUpdated = false;
        Connection conn = DataSourceFactory.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,Skirts.getBRAND());
        statement.setString(2, Skirts.getNAME());
        return false;
    }

    @Override
    public boolean delete(SKIRTS Skirts) throws SQLException {
        String sql = "DELETE FROM SKIRTS  where NAME = ?, BRAND = ?";
        boolean rowDeleted = false;
        Connection conn = DataSourceFactory.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,Skirts.getNAME());
        statement.setString(2, Skirts.getBRAND());
        rowDeleted = statement.executeUpdate() > 0;
        return rowDeleted;
    }
    }

