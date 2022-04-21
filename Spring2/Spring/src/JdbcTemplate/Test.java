package JdbcTemplate;

import JdbcTemplate.entity.Fruit;
import JdbcTemplate.service.FruitService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Jdbc.xml");
        FruitService fruitService = context.getBean("fruitService", FruitService.class);

        Fruit fruit = new Fruit();
        /*fruit.setFcount(10);
        fruit.setFid(9);
        fruit.setFname("仙人掌");
        fruit.setPrice(3);
        fruit.setRemark("绿绿");

        fruitService.addFruit(fruit);*/

        fruitService.deleteFruit(7);
    }
}
