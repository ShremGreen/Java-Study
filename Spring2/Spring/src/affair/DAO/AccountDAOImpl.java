package affair.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
    //注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addMoney() {
        String sql = "update bank set money=money-? where id=?";
        int update = jdbcTemplate.update(sql, 100, 1);
        int i = 100/0;
        System.out.println(update);
    }

    @Override
    public void delMoney() {
        String sql = "update bank set money=money+? where id=?";
        int update = jdbcTemplate.update(sql, 100, 2);
        System.out.println(update);
    }
}
