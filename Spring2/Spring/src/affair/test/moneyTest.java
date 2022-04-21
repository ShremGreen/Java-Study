package affair.test;

import affair.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class moneyTest {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("affairs.xml");
        AccountService accountService = context.getBean("accountService", AccountService.class);
        accountService.accountMoney();
    }
}


