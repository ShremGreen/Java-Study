package Sort;

import java.util.Arrays;
/*
桶排序是用内存换速度的经典算法

基数排序是桶排序的代表
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {5,62,6,33,1,29};
        radixSort(arr);
    }

    public static void radixSort(int[] array) {
        int max = array[0];
        for(int i = 0; i < array.length; i ++) {//找到最大数
            if(array[i] > max) {
                max = array[i];
            }
        }
        int valueLength = (max + "").length();//返回最大长度

        int[][] bucket = new int[10][array.length];//十个桶，每个代表0-9的一个数
        int[] eleNum = new int[10];//存放每个桶中的元素个数,索引对应桶的索引

        for(int i = 0, n = 1; i < valueLength; i ++, n *= 10) {
            for(int j = 0; j < array.length; j ++) {//入桶
                int digit = array[j] /n % 10;//获取当前位数的数值
                bucket[digit][eleNum[digit]] = array[j];//
                eleNum[digit] ++;
            }
            int index = 0;
            for(int k = 0; k < eleNum.length; k ++) {//出桶
                if(eleNum[k] != 0) {
                    for(int x = 0; x < eleNum[k]; x ++) {
                        array[index] = bucket[k][x];
                        index ++;
                    }
                }
                eleNum[k] = 0;
            }

            //System.out.println("第" + (i+1) + "次排序后结果： " + Arrays.toString(array));
        }
    }

    public static void getTime() {
        int[] arr = new int[30000];
        for(int i = 0; i < 30000; i ++) {
            arr[i] = (int) (Math.random()*100000);//强转是截断，不是四舍五入
        }

        long t1 = System.currentTimeMillis();
        radixSort(arr);
        long t2 = System.currentTimeMillis();
        System.out.println("基数排序总时长" + (t2-t1) + "ms");
    }
}
