package JavaSE.API;
/*
StringBuffer的添加功能：
    public StringBuffer append(String str)
    public StringBuffer insert(int offset,String str)
StringBuffer的删除功能：
    public StringBuffer deleteCharAt(int index)
    public StringBuffer delete(int start,int end)
StringBuffer的替换功能：
    public StringBuffer replace(int start,int end,String str)
StringBuffer的反转功能：
    public StringBuffer reverse()
StringBuffer的截取功能：
    public String substring (int start)
    public String substring (int start, int end)

 */
public class StringBufferDemo02 {
    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer();
        //append
        StringBuffer sb2 = sb1.append("lrc");
        System.out.println(sb1 == sb2);//true   说明地址值相同，没有新创建空间

        //链式编程
        sb1.append("java").append(true).append(123).append(56.289);
        System.out.println(sb1);//lrcjavatrue12356.289

        //insert
        sb1.insert(3,"study");
        System.out.println(sb1);//lrcstudyjavatrue12356.289

        //delete
        sb1.deleteCharAt(3);
        System.out.println(sb1);//lrctudyjavatrue12356.289  说明StringBuffer不建立新的对象，只是对自己进行操作
        sb1.delete(1,6);
        System.out.println(sb1);//lyjavatrue12356.289

        //replace
        sb1.replace(1,5,"abcd");
        System.out.println(sb1);//labcdatrue12356.289   说明只取到第4号字符。Java中都是取左不取右

        //reverse
        sb2.reverse();
        System.out.println(sb2);//982.65321eurtadcbal

        //subString     注意返回值是String，结果不会对原StringBuffer造成影响
        String s1 = sb2.substring(1,5);
        System.out.println(s1);//82.6
        String s2 = sb1.substring(5);
        System.out.println(s2);//5321eurtadcbal
    }
}
