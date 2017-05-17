package com.lesfurets.db.dao;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConnectionManager {
    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/livecoding-jooq", "sa", "");
     }

    public static void init(Connection connection) throws Exception {
        try(Statement statement = connection.createStatement()) {
            String sql = getSql();
            if(sql != null) {
                statement.execute(sql);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getSql() throws URISyntaxException {
        Path path = Paths.get(ClassLoader.getSystemResource("schema.sql").toURI());
        String sql = null;
        try (Stream<String> stream = Files.lines(path, Charset.forName("UTF-8"))) {
            sql = stream.collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sql;
    }
}
