package IDEA_code;

public class StringDemo3 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        System.out.println("sb:" + sb);
        System.out.println("length:" + sb.length());

        StringBuilder s = new StringBuilder("Li Rongchun");
        System.out.println("sb:" + s);
        System.out.println("length:" + s.length());

        StringBuilder sb1 = sb.append("java");
        StringBuilder sb2 = new StringBuilder();
        System.out.println("sb:" + sb + "，sb1:" + sb1);

        sb.append(" li rongchun");
        sb.append(100);
        System.out.println("sb:" + sb);
        //链式编程（效果同上）：
        sb2.append("java").append(" li rongchun").append(100);
        System.out.println("sb2:" + sb2);

        sb.reverse();
        System.out.println("sb:" + sb);
    }
}
