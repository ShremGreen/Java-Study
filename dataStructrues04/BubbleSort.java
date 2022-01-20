package Sort;
/*
冒泡排序，设从小到大
每次循环，找当前最大的数，并将当前数与下一位数比较和交换（或不交换）
即：第一次排序后，最后一个数为最大值；第二次，倒数第二个数为次最大值......

优化：如果某次循环始终没有交换位置，则直接跳出

[5, 62, -6, 33, 1, 29]

[5, -6, 33, 1, 29, 62]
[-6, 5, 1, 29, 33, 62]
[-6, 1, 5, 29, 33, 62]
 */

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
    }
    public static void bubbleSort(int[] array) {
        int temp = 0;
        boolean flag = false;
        for(int i = 0; i < array.length - 1; i ++) {
            for(int j = 0; j < array.length - 1 - i; j ++) {
                if(array[j] > array[j + 1]) {
                    flag = true;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            System.out.println("第" + (i+1) + "次排序后结果： " + Arrays.toString(array));
            if(!flag) {//优化
                break;
            }
            flag = false;
        }
        //System.out.println(Arrays.toString(array));
    }

    public static void getTime() {
        int[] arr = new int[30000];
        for(int i = 0; i < 30000; i ++) {
            arr[i] = (int) (Math.random()*100000);//强转是截断，不是四舍五入
        }

        long t1 = System.currentTimeMillis();
        bubbleSort(arr);
        long t2 = System.currentTimeMillis();
        System.out.println("冒泡排序总时长" + (t2-t1) + "ms");
    }
}
