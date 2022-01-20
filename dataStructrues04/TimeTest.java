package Sort;
/*
30000个数的排序下，不同排序方式的速度比较

 */
public class TimeTest {
    public static void main(String[] args) {
        BubbleSort.getTime();
        SelectSort.getTime();
        InsertSort.getTime();
        ShellSort.getTime();
        QuickSort.getTime();
        RadixSort.getTime();
        MergetSort.getTime();
    }
}
