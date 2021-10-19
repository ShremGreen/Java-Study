package JavaSE.API;
/*
冒泡排序
 */
public class bubbleSort {
    public static void main(String[] args) {
        int[] arr = {26,95,78,11,63};
        for(int x = 0; x < arr.length - 1; x ++) {
            for(int y = 0; y < arr.length - 1 - x; y ++) {
                if(arr[y] > arr[y + 1]) {
                    int temp = arr[y + 1];
                    arr[y + 1] = arr[y];
                    arr[y] = temp;
                }
            }
        }
        for(int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i] + "  ");
        }
    }
}
