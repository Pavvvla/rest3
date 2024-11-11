package Dao;

import DaoConfig.ArticleDao;
import DaoConfig.DataSourceFactory;
import model.ARTICLE;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DaoArticle implements ArticleDao {
    private DaoArticle(){
    }
    private static class SingletonHelper{
        private static final DaoArticle INSTANCE = new DaoArticle();
    }
    public static DaoArticle getInstance(){
        return SingletonHelper.INSTANCE;
    }

    @Override
    public Optional<ARTICLE> find(ARTICLE article) throws SQLException {

        String sql = "SELECT ARTICLE,NAME FROM ARTICLE WHERE ARTICLE = ?";
        int ARTICLE = 0;
        String NAME = "";
        Connection conn = DataSourceFactory.getConnection();
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, ARTICLE);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()){
            ARTICLE = resultSet.getInt("ARTICLE");
            NAME = resultSet.getString("NAME");
        }
        return Optional.of(new ARTICLE(ARTICLE,NAME));
    }

        @Override
    public List<ARTICLE> findAll() throws SQLException {
        List<ARTICLE> listArticle = new ArrayList<>();
        String sql = "SELECT ARTICLE,NAME FROM ARTICLE";

        Connection conn = DataSourceFactory.getConnection();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            int ARTICLE = resultSet.getInt("ARTICLE");
            String NAME = resultSet.getString("NAME");

            ARTICLE Article = new ARTICLE();
            listArticle.add(Article);
        }
        return listArticle;
    }

    @Override
    public boolean sava(ARTICLE Article) throws SQLException {
        String sql = "INSERT into ARTICLE (ARTICLE,NAME) VALUES (?,?,?,?,?,?)";
        boolean rowInserted = false;
        Connection conn = DataSourceFactory.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1,Article.getARTICLE());
        statement.setString(2,Article.getNAME());
        return rowInserted;
    }

    @Override
    public boolean update(ARTICLE Article) throws SQLException {
        String sql = "UPDATE ARTICLE SET ARTICLE = ?,NAME = ?";
        sql += "WHERE ARTICLE = ?";
        boolean rowUpdated = false;
        Connection conn = DataSourceFactory.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1,Article.getARTICLE());
        statement.setString(2, Article.getNAME());
        return false;
    }

    @Override
    public boolean delete(ARTICLE Article) throws SQLException {
        String sql = "DELETE FROM ARTICLE where ARTICLE = ?,NAME = ?";
        boolean rowDeleted = false;
        Connection conn = DataSourceFactory.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1,Article.getARTICLE());
        statement.setString(2, Article.getNAME());
        rowDeleted = statement.executeUpdate() > 0;
        return rowDeleted;
    }
}
