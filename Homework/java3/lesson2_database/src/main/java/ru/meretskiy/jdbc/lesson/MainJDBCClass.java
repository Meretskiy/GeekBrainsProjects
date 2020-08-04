package ru.meretskiy.jdbc.lesson;

import java.sql.*;

public class MainJDBCClass {

    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;

    public static void main(String[] args) {

        try {
            connect();
            DeleteAllRecords();
            dropTable();
            createTable();
//            updateData();
//            initPrepareStatments();
//            updateDataPrepareStatements();
//            updateDataPrepareStatementsBatch();

//            long start = System.currentTimeMillis();
//            performInsertIntoDB();
//            System.out.println(System.currentTimeMillis() - start);

            updateDataSavepoint();

            readRecords();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    private static void updateDataSavepoint() throws SQLException {
        statement.executeUpdate("INSERT INTO student (name, score) Values ('alex 1', 10);");
        Savepoint savepoint = connection.setSavepoint();
        statement.executeUpdate("INSERT INTO student (name, score) Values ('alex 2', 20);");
        connection.rollback(savepoint); //неявно делается connection.setAutocommit(false);
        statement.executeUpdate("INSERT INTO student (name, score) Values ('alex 3', 30);");
        connection.commit();
    }

    private static void performInsertIntoDB() throws SQLException {
        connection.setAutoCommit(false);
        for (int i = 0; i < 100_000; i++) {
            statement.executeUpdate(
                    "INSERT INTO student (name, score) VALUES ('alex" + i + "' , " + i * 10 % 100 + ");");
            if (i % 1000 == 0) {
                connection.commit();
            }
        }
        connection.commit(); //connection.setAutoCommit(true);
    }

    private static void updateDataPrepareStatementsBatch() throws SQLException {
        for (int i = 0; i < 1000; i++) {
            preparedStatement.setString(1, "alex " + i);
            preparedStatement.setInt(2, i * 10 % 100);
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
    }

    private static void updateDataPrepareStatements() throws SQLException {
        for (int i = 0; i < 10; i++) {
            preparedStatement.setString(1, "alex " + i);
            preparedStatement.setInt(2, i * 10 % 100);
            preparedStatement.execute();
        }
    }

    private static void readRecords() throws SQLException {
        //подгружать в память на всю таблицу, как по умолчанию, а по 200 записей
        //statement.setFetchSize(200);
        ResultSet rs = statement.executeQuery("SELECT * FROM student;");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " "
                    + rs.getString("name") + " "
                    + rs.getInt("score"));
        }
    }

    private static void updateData() throws SQLException {
        statement.executeUpdate("INSERT INTO student (id, name, score) VALUES (1, 'alex1', 60);");
        statement.executeUpdate("UPDATE student SET score = 55 WHERE id = 1;");
    }

    private static void createTable() throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS student (\n" +
                "    id    INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    name  TEXT,\n" +
                "    score INTEGER\n" +
                ");\n");
    }

    private static void dropTable() throws SQLException {
        //удаляем таблицу, только если она есть
        statement.executeUpdate("DROP TABLE IF EXISTS student;");
    }

    private static void DeleteAllRecords() throws SQLException {
        statement.executeUpdate("DELETE FROM student;");
    }

    public static void connect() throws ClassNotFoundException, SQLException {
        //регистрация нового драйвера
        Class.forName("org.sqlite.JDBC");
        //подключение базы через драйвер менеджер
        connection = DriverManager.getConnection("jdbc:sqlite:mainLesson3_2.db");
        statement = connection.createStatement();
    }

    public static void initPrepareStatments() throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO student (name, score) VALUES (?, ?);");
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
