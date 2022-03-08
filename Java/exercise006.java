/*
给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true。#代表退格字符。
注意：如果对空文本输入退格字符，文本继续为空。

 */
public class exercise006 {
    //方法一
    public boolean backspaceCompare1(String s, String t) {
        return convert(s).equals(convert(t));
    }

    public String convert(String str) {
        StringBuffer s = new StringBuffer();//存储处理后的字符串
        for(int i = 0; i < str.length(); i ++) {
            if(str.charAt(i) != '#') {
                s.append(str.charAt(i));
            } else {
                if(s.length() > 0) s.deleteCharAt(s.length() - 1);
            }
        }
        return s.toString();
    }

    //方法二
    public boolean backspaceCompare2(String s, String t) {
        int i1 = s.length() - 1;
        int i2 = t.length() - 1;
        int flag1 = 0;
        int flag2 = 0;

        while(i1 >= 0 || i2 >= 0) {
            while(i1 >= 0) {
                if(s.charAt(i1) == '#') {//当前为#，flag标记
                    flag1 ++;
                    i1 --;
                } else if(flag1 > 0) {//当前为#前第一个字符
                    flag1 --;
                    i1 --;
                } else break;//普通情况,直接跳出，进行比较
            }
            while(i2 >= 0) {
                if(t.charAt(i2) == '#') {
                    flag2 ++;
                    i2 --;
                } else if(flag2 > 0) {
                    flag2 --;
                    i2 --;
                } else break;
            }
            if(i1 >= 0 && i2 >= 0) {
                if(s.charAt(i1) != t.charAt(i2)) {
                    return false;
                }
            } else {
                if(i1 >= 0 || i2 >= 0) return false;
            }
            i1 --;
            i2 --;
        }
        return true;
    }
}
