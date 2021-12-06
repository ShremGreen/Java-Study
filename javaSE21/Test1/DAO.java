package Generic.Test1;

import java.util.*;

public class DAO<T> {
    private Map<String,T> map = new HashMap<String,T>();

    //save方法    key为id  value为entity
    public void save(String id, T entity) {
        map.put(id,entity);
    }

    //get方法     输入key获取value
    public T get(String id) {
        return map.get(id);
    }

    //update方法  修改key位置的value
    public void update(String id,T entity) {
        if(map.containsKey(id)) {//先判断key对应位置上是否有元素
            map.put(id,entity);//通过put直接替换该位置键值对
        }
    }

    //list方法    返回map中所有对象
    public List<T> list() {
        //方法一   错误，多态中只能对本身进行向下转型
        //Collection<T> values = map.values();
        //return (List<T>) values;//这里是由父类直接向子类转型

        //方法二
        Collection<T> values = map.values();
        List list = new ArrayList();
        for(T t : values) {
            list.add(values);
        }
        return list;
    }

    //remove方法
    public void remove(String id) {
        map.remove(id);
    }
}