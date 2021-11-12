package API;

import org.junit.Test;

/*
面试题
debug查看
*/
public class DebugDemo {

    @Test
    public void testStringBuffer(){
        String str = null;
        StringBuffer sb = new StringBuffer( );
        sb.append(str);
        System.out.println(sb.length());//4
        System.out.println(sb);//"null"
        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);//抛异常
    }

}
