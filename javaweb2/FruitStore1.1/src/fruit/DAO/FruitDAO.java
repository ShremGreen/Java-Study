package fruit.DAO;
import fruit.pojo.Fruit;

import java.util.List;

public interface FruitDAO {
    //获取所有库存列表的信息
    List<Fruit> getFruitList();
}
