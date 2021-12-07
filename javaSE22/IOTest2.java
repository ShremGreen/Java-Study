package IO;

import org.junit.Test;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
通过Map统计一个txt文件中各个字符的出现次数并写入另一个文件
*/

public class IOTest2 {
    @Test
    public void test() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader("C:\\Users\\10627\\Desktop\\dbcp.txt");
            fw = new FileWriter("C:\\Users\\10627\\Desktop\\统计.txt");

            Map<Character,Integer> map = new HashMap<Character, Integer>();
            int count;
            while((count = fr.read()) != -1) {
                char ch = (char) count;
                //判断该字符是否第一次出现
                if(map.containsKey(ch)) {
                    map.put(ch,map.get(ch)+1);
                } else {
                    map.put(ch,1);
                }
            }
            //将map数据存放到文件中
            //遍历map     1.Set接收entrySet()返回值，并通过泛型将该返回值定义为Entry类型
            //           2.for循环将Set集合的元素依次读入Map.Entry类型的变量中
            //           3.entry.getKey()     entry.getValue()
            Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
            for(Map.Entry<Character,Integer> entry : entrySet) {
                switch(entry.getKey()) {
                    case ' ':
                        fw.write("空格\t\t" + entry.getValue());
                        break;
                    case '\t':
                        fw.write("tab\t\t" + entry.getValue());
                        break;
                    case '\n':
                        fw.write("换行\t\t" + entry.getValue());
                        break;
                    case '\r':
                        fw.write("Enter\t\t" + entry.getValue());
                        break;
                    default:
                        fw.write(entry.getKey() + "\t\t" + entry.getValue());
                        break;
                }
                fw.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
