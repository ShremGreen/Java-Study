/*
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
请必须使用时间复杂度为 O(log n) 的算法。

示例 1:
输入: nums = [1,3,5,6], target = 5
输出: 2
 */

public class exercise003 {
    public int searchInsert(int[] nums, int target) {
        if(target < nums[0]) {
            return 0;
        } else if(target > nums[nums.length - 1]) {
            return nums.length;
        } else {//二分查找
            int l = 0;
            int r = nums.length -1;

            while(l <= r) {
                int mid = (l + r) / 2;
                if(target < nums[mid]) {//左移
                    if(target > nums[mid - 1]) {
                        return mid;
                    }
                    r = mid - 1;
                } else if(target > nums[mid]) {//右移
                    if(target < nums[mid + 1]) {
                        return mid + 1;
                    }
                    l = mid + 1;
                } else {//找到
                    return mid;
                }
            }
            return -1;
        }
    }
}
