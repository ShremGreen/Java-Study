package fruit.DAO.impl;

import fruit.DAO.FruitDAO;
import fruit.pojo.Fruit;
import myssm.base.BaseDAO;
import java.util.List;

public class FruitDAOImpl extends BaseDAO<Fruit> implements FruitDAO {
    @Override
    public List<Fruit> getFruitList() {
        return super.executeQuery("select * from t_fruit");
    }
}
