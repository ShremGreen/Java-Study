package Sort;

import java.util.Arrays;

/*
插入排序
第i次循环，将0-i号元素排序（即，将i号元素插入0到i-1的数组中）

[5, 62, -6, 33, 1, 29]

[5, 62, -6, 33, 1, 29]
[-6, 5, 62, 33, 1, 29]
[-6, 5, 33, 62, 1, 29]
[-6, 1, 5, 33, 62, 29]

 */
public class InsertSort {
    public static void main(String[] args) {
        //int[] arr = {5,62,-6,33,1,29};
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
    }
    public static void insertSort(int[] array) {
        int length = array.length;


        for(int i = 1; i < length; i ++) {
            int temp = array[i];//储存i处元素
            int index = i - 1;
            for(; index >= 0 && array[index] > temp; index --) {
                array[index + 1] = array[index];
            }
            /*while(index >=0 && array[index] > temp) {//while总体比for循环稍慢
                array[index + 1] = array[index];
                index --;
            }*/
            array[index + 1] = temp;//由于找到对应位置后索引又多减了一次，所以当前指针在前一个位置

            System.out.println(Arrays.toString(array));
        }
        //System.out.println(Arrays.toString(array));
    }

    public static void getTime() {
        int[] arr = new int[30000];
        for(int i = 0; i < 30000; i ++) {
            arr[i] = (int) (Math.random()*100000);//强转是截断，不是四舍五入
        }

        long t1 = System.currentTimeMillis();
        insertSort(arr);
        long t2 = System.currentTimeMillis();
        System.out.println("插入排序总时长" + (t2-t1) + "ms");
    }
}
