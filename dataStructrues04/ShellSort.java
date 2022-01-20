package Sort;

import java.util.Arrays;
/*
[8, 9, 1, 7, 2, 3, 5, 4, 6, 0]

[3, 5, 1, 6, 0, 8, 9, 4, 7, 2]
[0, 2, 1, 4, 3, 5, 7, 6, 9, 8]
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
 */

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        shellSort(arr);

    }

    //希尔排序（加入插入排序）
    public static void shellSort(int[] array) {
        int length = array.length;
        int count = 0;

        for(int i = length / 2; i > 0; i /= 2) {//二分法，i为每次的间隔
            for(int j = i; j < length; j ++) {//循环
                int temp = array[j];
                int k = j - i;
                for(; k >= 0 && array[k] > temp; k -= i) {//组内插入排序,
                    array[k + i] = array[k];
                }
                array[k + i] = temp;
            }
            //System.out.println("第" + (++ count) + "次排序后结果： " + Arrays.toString(array));
        }
    }

    public static void getTime() {
        int[] arr = new int[30000];
        for(int i = 0; i < 30000; i ++) {
            arr[i] = (int) (Math.random() * 100000);//强转是截断，不是四舍五入
        }

        long t1 = System.currentTimeMillis();
        shellSort(arr);
        long t2 = System.currentTimeMillis();
        System.out.println("希尔排序总时长" + (t2-t1) + "ms");
    }
}
