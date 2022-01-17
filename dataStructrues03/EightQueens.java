package Recursion;
import org.junit.Test;
/*
八皇后
 */

public class EightQueens {
    int[] arr = new int[8];//一维数组用于存储棋子位置，索引为横坐标，值为纵坐标
    int count = 0;

    @Test
    public void test() {
        chess(0);
        System.out.println("共" + count + "个解法");
    }

    //放置棋子(递归)
    public void chess(int n) {
        if(n == 8) {//如果到最后，就结束
            print();
            return;
        }else {
            for(int i = 0; i < 8; i ++) {
                //从第一个棋子开始放置
                arr[n] = i;//1-8循环检测
                if(check(n)) {//判断该棋子位置是否正确
                    chess(n+1);//正确，则放下一个棋子
                }//不正确，则进入下一个for循环
            }
        }
    }

    //检测位置是否正确(同一行、同一列、同一斜线)
    public boolean check(int n) {
        for(int i = 0; i < n; i ++) {
            if(arr[i] == arr[n] || Math.abs(arr[n] - arr[i]) == Math.abs(n - i)) {
                return false;
            }
        }
        return true;
    }

    //遍历
    public void print() {
        count ++;
        System.out.print("解法" + count + ":\t");
        for(int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
