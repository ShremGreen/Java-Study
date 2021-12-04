package Generic.Test;
/*
在这里模拟数据库
数据库中存储有多种数据

增删改查功能
*/

import java.util.List;

public class DAO<T> {
    //增
    public void add(T t) {

    }
    //删
    public boolean delete() {
        return false;
    }
    //改
    public void update() {

    }
    //查1
    public T getIndex(int index) {
        return null;
    }
    //查2
    public List<T> getList(int start, int end) {
        return null;
    }
}
