import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by robertsikora on 22.02.2016.
 */

@ContextConfiguration(value = "classpath:test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class testIT {


    @Before
    public void setup() {
        System.out.print("");
    }

    @Test
    public void test1() {
        System.out.print("");
    }
}
