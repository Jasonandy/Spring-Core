package spring;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config/spring-test-core.xml" })
//@TransactionConfiguration(transactionManager = "jdbcTransactionManager",defaultRollback = false)
public class BaseTest {
	

}
