package JdbcTemplate.service;

import JdbcTemplate.DAO.FruitDao;
import JdbcTemplate.entity.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FruitService {
    //注入DAO
    @Autowired
    private FruitDao FruitDao;

    //添加方法
    public void addFruit(Fruit fruit) {
        FruitDao.add(fruit);
    }

    //修改方法
    public void updateFruit(Fruit fruit) {
        FruitDao.update(fruit);
    }

    //删除方法
    public void deleteFruit(Integer fid) {
        FruitDao.delete(fid);
    }
}
