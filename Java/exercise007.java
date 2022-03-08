/*
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
请注意，必须在不复制数组的情况下原地对数组进行操作。

示例 1:
输入: nums = [0,1,0,3,12]
输出: [1,3,12,0,0]
 */
public class exercise007 {
    public void moveZeroes(int[] nums) {
        int fast = 0;
        int slow = 0;
        int length = nums.length - 1;

        for(; fast <= length; fast ++) {
            if(nums[fast] != 0) {
                nums[slow] = nums[fast];
                if(fast != slow) nums[fast] = 0;
                slow ++;
            }
        }
    }
}
