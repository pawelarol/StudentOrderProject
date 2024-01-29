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
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DictionaryDaoImplTest {

    private static final Logger logger = LoggerFactory.getLogger(DictionaryDaoImplTest.class);
    @BeforeClass
    public static void testString() throws IOException, URISyntaxException, SQLException {
      DBInit.testString();
    }

    @Test
    public void testStreet() throws DaoException {
        LocalDateTime lc = LocalDateTime.now();
        logger.info("Test logging {} ", lc);
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