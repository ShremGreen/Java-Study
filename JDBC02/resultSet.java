/*
ResultSet

需求：查询表中数据，表将其封装进Arraylist集合
*/

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class resultSet {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql:///mydatabase?useSSL=false";
        String username = "root";
        String password = "951esz753";
        Connection connect = DriverManager.getConnection(url,username,password);

        String sql = "select * from bank";

        Statement statement = connect.createStatement();

        ResultSet result = statement.executeQuery(sql);

        ArrayList<account> list = new ArrayList<account>();
        while(result.next()) {
            account user = new account();

            int id = result.getInt(1);
            String name = result.getString(2);
            double money = result.getDouble(3);

            user.setId(id);
            user.setName(name);
            user.setMoney(money);

            list.add(user);
        }
        System.out.println(list);

        result.close();
        statement.close();
        connect.close();
    }
}

class account {//用于存储表中每一行的信息
    private int id;
    private String name;
    private double money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}