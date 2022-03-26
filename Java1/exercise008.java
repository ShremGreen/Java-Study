public class exercise008 {
    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        //int i = minSubArrayLen1(7, arr);
        int i = minSubArrayLen2(7, arr);
        System.out.println(i);
    }
    public static int minSubArrayLen1(int target, int[] nums) {
        int length = 0;//存放求和结果
        int sum;
        int i = 0;
        int j;

        while(i < nums.length - 1) {
            sum = 0;
            j = i;
            while(sum < target) {
                sum += nums[j];
                j ++;
                if(j == nums.length && sum < target) {
                    return length;
                }
            }
            if((j-i) < length || length == 0) {
                length = j - i;
            }
            i ++;
        }
        return length;
    }

    public static int minSubArrayLen2(int target, int[] nums) {
        //滑动窗口
        int i = 0;
        int j = 0;
        int sum = 0;
        int length = 0;

        while(i < nums.length) {
            while(sum < target) {//找到窗口右侧
                if(i >= nums.length) {//右窗口到达末端，直接退出循环
                    return length;
                }
                sum += nums[i];
                i ++;
            }
            while(sum >= target) {//找到当前最小子串
                sum -= nums[j];
                j ++;
            }//此时子串前索引应为j-1
            if((i-j+1) < length || length == 0) {
                length = i - j + 1;
            }
        }
        return length;
    }
}
