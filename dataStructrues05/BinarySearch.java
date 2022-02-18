package Search;

import java.util.Arrays;

/*
二分查找：
原理  每次二分，比较当前索引处元素和要查找处元素，并选择向左或向右递归
核心：mid = (left + right) / 2
 */
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1,3,4,6,7,8,10};
        System.out.println(binarySearch(arr, 0, arr.length - 1, 4));
    }

    public static int binarySearch(int[] array, int left, int right, int findValue) {
        if(left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midValue = array[mid];

        if(findValue > midValue) {
            return binarySearch(array, mid + 1, right, findValue);
        } else if(findValue < midValue) {
            return binarySearch(array, left, mid - 1, findValue);
        } else {
            return mid;
        }
    }
}
