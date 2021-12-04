package Generic.Test;

import java.util.List;

/*
测试类
 */
public class Test {
    public static void main(String[] args) {
        CustomerDAO dao = new CustomerDAO();
        dao.add(new Customer());
        List<Customer> list = dao.getList(1,2);

        StudentDAO dao1 = new StudentDAO();
        dao1.add(new Student());
        List<Student> list1 = dao1.getList(3,4);
    }
}
