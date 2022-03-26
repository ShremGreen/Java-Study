import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class exercise011 {
    @Test
    public void test() {
        String s = "a";
        String t = "a";
        String str = minWindow(s,t);
        System.out.println(str);
    }

    Map<Character,Integer> mapS = new HashMap<Character,Integer>();
    Map<Character,Integer> mapT = new HashMap<Character,Integer>();

    public String minWindow(String s, String t) {
        for(int i = 0; i < t.length(); i ++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        int l = 0;
        int r = 0;
        int minLength = s.length();
        int markL = -1;
        int markR = -1;

        while(r < s.length()) {
            //右滑动
            if(mapT.containsKey(s.charAt(r))) {
                mapS.put(s.charAt(r), mapS.getOrDefault(s.charAt(r),0) + 1);
            }
            r ++;

            //左滑动
            while(judge()) {
                if((r - l) < minLength) {
                    minLength = r - l;
                    markL = l;
                    markR = r;
                }
                if(mapT.containsKey(s.charAt(l))) {
                    mapS.put(s.charAt(l), mapS.getOrDefault(s.charAt(l),0) - 1);
                }
                l ++;
            }
        }

        return markL == -1 ? "" : s.substring(markL,markR);
    }

    public boolean judge() {
        for(Character ch : mapT.keySet()) {
            if(mapT.get(ch) > mapS.getOrDefault(ch, 0)) return false;
        }
        return true;
    }
}
