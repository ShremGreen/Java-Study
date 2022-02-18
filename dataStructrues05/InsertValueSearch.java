package Search;
/*
插值查找算法:即按比例查找
适用于数组中元素较为连续的大量数据的元素的查找，但对于数组中元素太分散的元素的查找，效果可能不如二分查找，

mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left])
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int arr[] = {1,3,4,6,7,8,10};
        System.out.println(insertValueSearch(arr, 0, arr.length - 1, 7));
    }

    public static int insertValueSearch(int[] array, int left, int right, int value) {
        if(left > right || value < array[0] || value > array[array.length - 1]) {//即左右不能出界
            return -1;
        }
        int mid = left + (right - left) * (value - array[left]) / (array[right] - array[left]);
        int midValue = array[mid];
        if(value > midValue) {
            return insertValueSearch(array,mid + 1,right,value);
        } else if(value < midValue) {
            return insertValueSearch(array,left,mid - 1,value);
        } else {
            return mid;
        }
    }
}
