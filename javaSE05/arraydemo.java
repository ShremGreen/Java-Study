package JavaSE.API;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
Arrays:针对数组进行操作的工具类。比如说排序和查找。
    public static String toString(int[] a)              把数组转成字符串
    public static void sort (int[] a)                   对数组进行排序
    public static int binarySearch(int[] a,int key)     二分查找

 */
public class arraydemo {
    public static void main(String[] args) {
        int[] arr = {26,95,78,11,63};

        System.out.println("before  " + Arrays.toString(arr));//before  [26, 95, 78, 11, 63]
        Arrays.sort(arr);//返回值是void
        System.out.println("after   " + Arrays.toString(arr));//after   [11, 26, 63, 78, 95]
        System.out.println("search  " + Arrays.binarySearch(arr,26));//1
        System.out.println("search  " + Arrays.binarySearch(arr,24));//-2
    }
/*
    public static String toString(int[] a) {
        if (a == null)
            return "null";
        int iMax = a.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }
 */
}
