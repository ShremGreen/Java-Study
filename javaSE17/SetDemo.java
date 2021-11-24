package Collection;
/*
Set接口
存储无序的不可重复的数据
Set没有新方法，都是用的Collection中方法

无序：并不是随机。而是顺序与哈希码有关
不可重复：需要保证在按照equals方法判断时不能返回true，即：相同元素不能重复
*/

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {
    @Test
    public void test1() {
        Set set = new HashSet();
        set.add("lrc");
        set.add(456);
        set.add(456);
        set.add(999);
        set.add(new User("LRC",22));

        System.out.println(set);//[User{name='LRC', age=22}, 999, 456, lrc] 可见，顺序并不一致
        set.add(new User("LRC",22));
        System.out.println(set);
        //未重写HashCode   [User{name='LRC', age=22}, 999, User{name='LRC', age=22}, 456, lrc]
        //重写HashCode    [999, 456, User{name='LRC', age=22}, lrc]
    }
}

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}
