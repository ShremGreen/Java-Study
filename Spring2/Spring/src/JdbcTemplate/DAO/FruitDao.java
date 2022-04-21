package JdbcTemplate.DAO;

import JdbcTemplate.entity.Fruit;

public interface FruitDao {
    public void add(Fruit fruit);
    public void delete(Integer fid);
    public void update(Fruit fruit);
}
