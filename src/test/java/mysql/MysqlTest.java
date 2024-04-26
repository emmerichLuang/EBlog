package mysql;

import com.ee.EBlog.StartUpApp;
import com.ee.EBlog.dao.MySqlUserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
*  这个demo是单数据源。 如果是mysql，application.properties用mysql数据源
*
 * @author E.E. (liangruilin@joyy.sg)
 * @description
 * @date 2021/10/14
 */
@SpringBootTest(classes= StartUpApp.class)
@RunWith(SpringRunner.class)
public class MysqlTest {

	@Autowired
	private MySqlUserDao dao;

	@Test
	public void mysqlBatchCreate() {
		for(int i=0; i<10;i++){
			int id = dao.create("druidTest:"+ UUID.randomUUID().toString());
			System.err.println(id);
		}
	}

}

