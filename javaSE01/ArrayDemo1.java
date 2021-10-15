/*
数组的静态初始化
两种格式：
int[] arr = new int[]{1,2,3};
或：
int[] arr = {1,2,3};
*/

class ArrayDemo1 {
	public static void main(String[] args) {
		//定义数组
		int[] arr = new int[]{1,2,3};
		int[] arr1 = {5,2,3};
		
		for(int i = 0; i <= 2; i ++) {
			System.out.println(arr[i]);
		for(int i = 0; i <= 2; i ++) {
			System.out.println(arr1[i]);
		}
	}
}