package base;

import com.ee.EBlog.StartUpApp;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author E.E. (liangruilin@joyy.sg)
 * @description
 * @date 2021/9/7
 */
@SpringBootTest(classes= StartUpApp.class)
@RunWith(SpringRunner.class)
public class AppTest {

    @Test
    public void isEqual() {
        Assert.assertEquals("EE", "EE");
    }

    @Test
    public void notEqual() {
        Assert.assertEquals("EE1", "EE");
    }


    private static final Logger logger = LoggerFactory.getLogger(AppTest.class);

    /**
     * 默认debug是不开启的
     * 在运行命令后加入--debug标志，如：$ java -jar springTest.jar --debug
     *
     *
     */
    @Test
    public void logTest() {
        logger.debug("debug");
        logger.info("info");
        logger.error("error");
    }

}
