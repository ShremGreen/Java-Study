package Sort;

import java.util.Arrays;

public class MergetSort {
    public static void main(String[] args) {
        int[] arr = {5,62,6,33,1,29,45};
        int[] temp = new int[arr.length];
        mergeRecursion(arr,0,arr.length - 1,temp);
        System.out.println(Arrays.toString(arr));
    }

    //每次的分合，需要递归
    public static void mergeRecursion(int[] array, int left, int right, int[] temp) {
        if(left < right) {
            int mid = (left + right) / 2;
            mergeRecursion(array, left, mid, temp);//向左递归
            mergeRecursion(array, mid + 1, right, temp);//向右递归
            mergetSort(array, left, mid, right, temp);
        } //return;
    }

    //一共有2^n-1次排序，每次的left、right、mid均不同
    public static void mergetSort(int[] array, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int index = 0;

        //将左右数据按照从小到大的顺序写入temp
        while(i <= mid && j <= right) {
            if(array[i] <= array[j]) {
                temp[index] = array[i];
                i ++;
                index ++;
            }else {
                temp[index] = array[j];
                j ++;
                index ++;
            }
        }

        //剩余数据写入temp
        while(i <= mid) {
            temp[index] = array[i];
            i ++;
            index ++;
        }
        while(j <= right) {
            temp[index] = array[j];
            j ++;
            index ++;
        }

        //temp数据转移到array。2^n-1次，每次转移一部分
        index = 0;
        for(int l = left; l <= right; l ++, index ++) {
            array[l] = temp[index];
        }
    }
    public static void getTime() {
        int[] arr = new int[30000];
        for(int i = 0; i < 30000; i ++) {
            arr[i] = (int) (Math.random()*100000);//强转是截断，不是四舍五入
        }

        long t1 = System.currentTimeMillis();
        int[] temp = new int[arr.length];
        mergeRecursion(arr,0,arr.length - 1,temp);
        long t2 = System.currentTimeMillis();
        System.out.println("归并排序总时长" + (t2-t1) + "ms");
    }
}
