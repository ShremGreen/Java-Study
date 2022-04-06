/*
给定一个正整数num，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
进阶：不要使用任何内置的库函数，如sqrt。

示例 1：
输入：num = 16
输出：true
示例 2：
输入：num = 14
输出：false
 */
public class exercise015 {
    public boolean isPerfectSquare(int num) {
        int l = 0;
        int r = num;
        int mid;
        long sqrt;

        //找到这个数所在的区间，前后两个整数
        while(l <= r) {
            mid = (l + r) / 2;
            sqrt = (long) mid * mid;
            if(sqrt > num) {//左二分
                r = mid - 1;
            } else if(sqrt < num) {//右二分
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
