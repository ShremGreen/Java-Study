package Sort;

import java.util.Arrays;

/*
选择排序：
每次循环，找出当前最小值及其索引，将本次的首元素和该元素交换
即，第一次循环后，第一个元素为最小值；第二次后，第二个元素为次最小值

[5, 62, -6, 33, 1, 29]
[5, -6, 33, 1, 29, 62]
[-6, 5, 1, 29, 33, 62]
[-6, 1, 5, 29, 33, 62]
[-6, 1, 5, 29, 33, 62]
 */
public class SelectSort {
    public static void main(String[] args) {
        //int[] arr = {5,62,-6,33,1,29};
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
    }
    public static void selectSort(int[] array) {
        int length = array.length;

        for(int i = 0; i < length - 1; i ++) {
            int index = i;
            int temp = array[i];
            for(int j = i + 1; j < length; j ++) {
                if(array[index] > array[j]) {
                    index = j;
                }
            }
            if(index != i) {
                temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
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
        selectSort(arr);
        long t2 = System.currentTimeMillis();
        System.out.println("选择排序总时长" + (t2-t1) + "ms");
    }
}
