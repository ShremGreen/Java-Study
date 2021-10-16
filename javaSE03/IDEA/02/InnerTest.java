package JavaSE.InnerClass;

public class InnerTest {
    public static void main(String[] args) {
        PeopleDemo pd = new PeopleDemo();
        //多态
        People p = new Student();
        pd.showStudy(p);

        //采用匿名内部类的方法
        //匿名内部类的本质是继承的子类对象（多态）或实现了接口的实现类对象
        //优点在于匿名，节省内存
        pd.showStudy(new People() {
            @Override
            public void study() {
                System.out.println("学习中&&&这是匿名内部类");
            }
        });
    }
}
