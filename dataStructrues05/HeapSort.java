package Sort;

import java.util.Arrays;
/*
堆排序：

 */

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4,6,8,5,9};
        heapSort(arr);
    }

    public static void heapSort(int[] arr) {
        int temp = 0;

        //从非叶子节点开始，从右往左，从下往上
        for(int i = arr.length / 2 + 1; i >= 0; i --) {
            adjustHeap(arr, i, arr.length);
        }

        for(int j = arr.length - 1; j > 0; j --) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
        //System.out.println(Arrays.toString(arr));
    }

    /**
     *
     * @param arr       存储二叉树的数组
     * @param i         开始调整的节点号
     * @param length    对多少个元素进行调整
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for(int k = i*2+1; k < length; k = k*2+1) {
            if(k+1 < length && arr[k] < arr[k+1]) {//左孩子小于右孩子
                k ++;//指向最大的节点
            }
            if(arr[k] > temp) {//子节点大于父节点
                arr[i] = arr[k];
                i = k;//将索引指向当前位置
            } else {
                break;
            }
        }
        //for循环结束后，将最大值放在堆顶，指针位于交换处的位置
        arr[i] = temp;//将temp放在调整后的位置
    }

    public static void getTime() {
        int[] arr = new int[30000];
        for(int i = 0; i < 30000; i ++) {
            arr[i] = (int) (Math.random()*100000);//强转是截断，不是四舍五入
        }

        long t1 = System.currentTimeMillis();
        heapSort(arr);
        long t2 = System.currentTimeMillis();
        System.out.println("堆排序总时长" + (t2-t1) + "ms");
    }
}
