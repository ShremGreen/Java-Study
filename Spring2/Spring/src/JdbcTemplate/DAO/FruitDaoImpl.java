package JdbcTemplate.DAO;

import JdbcTemplate.entity.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FruitDaoImpl implements FruitDao {
    //注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(Fruit fruit) {
        //sql语句
        String sql = "insert into t_fruit value(?,?,?,?,?)";
        //调用方法实现
        Object[] args = {fruit.getFid(), fruit.getFname(), fruit.getPrice(), fruit.getFcount(), fruit.getRemark()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println("更改了" + update + "行");
    }

    @Override
    public void update(Fruit fruit) {
        String sql = "update t_fruit set fname=?, fcount=?, fprice=? where fid=?";
        Object[] args = {fruit.getFname(), fruit.getFcount(), fruit.getPrice(), fruit.getFid()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }

    @Override
    public void delete(Integer fid) {
        String sql = "delete from t_fruit where fid=?)";
        int update = jdbcTemplate.update(sql, fid);
        System.out.println(update);
    }
}
