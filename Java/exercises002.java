/*
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
如果数组中不存在目标值 target，返回 [-1, -1]。

示例 1：
输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]
 */

public class exercises002 {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) {
            return new int[]{-1,-1};
        }
        int l = 0, r = n - 1;

        //找左边界
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }//此时，l指向第一个值
        if (nums[l] != target) {
            return new int[]{-1, -1};
        }

        int k = l;//存放左指针
        r = n - 1;
        //找右边界
        while (l < r) {
            int mid = (l + r + 1) / 2;//必须加1，防止死循环
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return new int[]{k,r};
    }
}
