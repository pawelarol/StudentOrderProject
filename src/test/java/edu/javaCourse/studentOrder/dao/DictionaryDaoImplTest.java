package edu.javaCourse.studentOrder.dao;
import edu.javaCourse.studentOrder.Exceptions.DaoException;
import edu.javaCourse.studentOrder.domian.CountryStruct;
import edu.javaCourse.studentOrder.domian.PassportOffice;
import edu.javaCourse.studentOrder.domian.RegisterOffice;
import edu.javaCourse.studentOrder.domian.Street;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
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

public class DictionaryDaoImplTest {
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


    @Test
    public void testStreet() throws DaoException {
        List<Street> liststr = new DictionaryDaoImpl().findStreet("a");
        Assert.assertTrue(liststr.size() == 4);
        System.out.println("Test street is done");

    }

    @Test
    public void testRegister() throws DaoException {
        List<PassportOffice> po = new DictionaryDaoImpl().findPassportOffice("020010010001");
        Assert.assertTrue(po.size() == 1);

        List<RegisterOffice> ro = new DictionaryDaoImpl().findRegisterOffice("010020000000");
        Assert.assertTrue(ro.size() == 1);
        System.out.println("Test register is done");
    }

    @Test
    public void testCountry() throws DaoException {
        List<CountryStruct> cs = new DictionaryDaoImpl().findArea("");
        Assert.assertTrue(cs.size() == 2);

        List<CountryStruct> cs1 = new DictionaryDaoImpl().findArea("0200000000");
        Assert.assertTrue(cs1.size() == 1);

        List<CountryStruct> cs2 = new DictionaryDaoImpl().findArea("020010000000");
        Assert.assertTrue(cs2.size() == 2);

        List<CountryStruct> cs3 = new DictionaryDaoImpl().findArea("020010010000");
        Assert.assertTrue(cs3.size() == 2);
        System.out.println("Test country is done");
    }
}