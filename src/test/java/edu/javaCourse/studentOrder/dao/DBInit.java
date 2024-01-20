package edu.javaCourse.studentOrder.dao;

import org.junit.BeforeClass;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

public class DBInit {
    @BeforeClass
    public static void testString() throws IOException, URISyntaxException, SQLException {
        URL url = DictionaryDaoImpl.class.getClassLoader().getResource("student_project.sql");
        List<String> strings = Files.readAllLines(Paths.get(url.toURI()));
        String sql = strings.stream().collect(Collectors.joining());
        try (Connection con = BuilderConnection.getConnect();
             Statement stmt = con.createStatement()) {
            stmt.executeUpdate(sql);
        }
    }
}
