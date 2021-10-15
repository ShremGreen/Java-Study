/*
键盘录入一个数字，在数组中查找，找到返回索引
*/
import java.util.Scanner;
class ArrayText1 {
	public static void main(String[] args) {
		int[] arr = {5,6,9,2,4};
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		int add = getIndex(arr,x);
		System.out.println("索引值是" + add);
		
		int add1 = getIndex(arr,x);
		System.out.println("索引值是" + add1);
	}
	
	public static int getIndex(int[] arr, int value) {
		for(int i = 0; i < arr.length; i ++) {
			if(arr[i] == value) {
				return i;
	}	
   }
        return -1;//如果返回值没有数据时，一般返回一个“-1”
  }
  
    //方法2：
	public static int getIndex1(int[] arr, int value) {
		int index = -1;
		for(int i = 0; i < arr.length; i ++) {
			if(arr[i] == value) {
				index = i;
				break;
			}
		}
		return index;
	}		
}