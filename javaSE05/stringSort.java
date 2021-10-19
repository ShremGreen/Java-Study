package JavaSE.API;
/*
对字符串进行排序
 */
public class stringSort {
    public static void main(String[] args) {
        String s = "lrcstudy";
        char[] ch = s.toCharArray();

        for(int x=0; x<ch.length-1; x++) {
            for(int y=0; y<ch.length-1-x; y++) {
                if(ch[y]>ch[y+1]) {
                    char temp = ch[y+1];
                    ch[y+1] = ch[y];
                    ch[y] = temp;
                }
            }
        }
        System.out.println(String.valueOf(ch));//cdlrstuy
    }
}
