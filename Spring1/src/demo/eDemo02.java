package demo;

import org.junit.Test;

public class eDemo02 {
    //创建属性
    private String bname;
    private String bauthor;
    //创建属性对应的 set 方法
    public void setBname(String bname) {
        this.bname = bname;
    }
    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }
    @Test
    public void test() {
        System.out.println(bname + "123" + bauthor);
    }
}
