package IO;

import org.junit.Test;

import java.io.*;

/*
对象流：
将基本数据类型或对象进行读写

序列化：将内存中的Java对象保存到磁盘中或通过网络传输出去
反序列化：将磁盘上的文件还原为内存中的Java对象

注意：
当读入一个引用类型的对象时，该对象需要
1.实现Serializable接口
2.引入一个全局常量（序列号） serialVersionUID
*/
public class IODemo8 {
    //序列化过程
    @Test
    public void testObjectOutputStream() {
        ObjectOutputStream oot = null;
        try {
            oot = new ObjectOutputStream(new FileOutputStream("cde.dat"));
            oot.writeObject(new String("JavaLrc嘎嘎"));
            oot.flush();
            oot.writeObject(new Person("李荣春",22));
            oot.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oot != null) {
                try {
                    oot.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //反序列化过程
    @Test
    public void testObjectInputStream() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("cde.dat"));
            Object o = ois.readObject();
            String str = (String) o;
            System.out.println(str);
            Person p = (Person) ois.readObject();
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Person implements Serializable {

    public static final long serialVersionUID = 12345789L;

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}