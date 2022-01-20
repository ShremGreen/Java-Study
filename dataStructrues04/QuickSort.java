package Sort;

import java.util.Arrays;
/*
快速排序

 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {6,1,2,5,4,3,9,7,10,8};

        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] array, int left, int right) {

        if(left > right) {
            return;
        }

        int base = array[left];
        int i = left;
        int j = right;

        while(i != j) {
            //小while，即从左往右和从右往左分别移动，并检测
            while(array[j] >= base && i < j) {
                j --;
            }
            while(array[i] <= base && i < j) {
                i ++;
            }

            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        //大while结束，即i和j索引相遇，将头元素和该相遇点元素交换
        array[left] = array[i];
        array[i] = base;

        quickSort(array,left,i - 1);
        quickSort(array,j + 1,right);
    }

    public static void getTime() {
        int[] arr = new int[30000];
        for(int i = 0; i < 30000; i ++) {
            arr[i] = (int) (Math.random()*100000);//强转是截断，不是四舍五入
        }

        long t1 = System.currentTimeMillis();
        quickSort(arr,0,arr.length - 1);
        long t2 = System.currentTimeMillis();
        System.out.println("快速排序总时长" + (t2-t1) + "ms");
    }
}
