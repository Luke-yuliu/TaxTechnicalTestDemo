import org.aeonbits.owner.ConfigFactory;
import org.junit.Before;
import org.junit.Test;



public class EnvironmentTest {

    Environment testEnvironment;

//    @Before
//    @Parameters({"environment"})
//    public void before(String environment) {
//        ConfigFactory.setProperty("env", environment);
//        testEnvironment = ConfigFactory.create(Environment.class);
//    }

    @Before
    public void setUp() {
        testEnvironment = ConfigFactory.create(Environment.class);
    }

    @Test
    public void functionalTest() {
        System.out.println(testEnvironment.homepage());
        System.out.println(testEnvironment.getDBHostname());
        System.out.println(testEnvironment.getDBPassword());
    }
}