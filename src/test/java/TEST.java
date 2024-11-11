import org.junit.*;
import java.sql.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TEST {
    //Проверяем, что мы получили подключение к БД

    //Метод получения подключения
    private Connection getNewConnection () throws SQLException {
        String url = "jdbc:h2:mem:test;";
        String user = "sa";
        String passwd = "sa";
        return DriverManager.getConnection(url, user, passwd);
    }

    //Тест для этого метода, который проверит, что подключение действительно устанавливается
    @Test
    public void shouldGetJdbcConnection () throws SQLException {
        try (Connection connection = getNewConnection()) {
            assertTrue(connection.isValid(1));
            assertFalse(connection.isClosed());
        }
    }

    public class test1 {
        private static Connection connection;// Поле которое хранит JDBC подключение для тестов

        @Before
        public void init() throws SQLException {
            connection = getNewConnection();
        }


        @After
        public void close() throws SQLException {
            connection.close();
        }
    }
}
