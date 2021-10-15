/*
1.使用length获取数组长度，并使用两种输出形式呈现。
2.输出数组arr1中最大值。
3.逆序输出arr1。
*/

class ArrayDemo2 {
	public static void main(String[] args) {
		int[] arr = new int[5];
		int[] arr1 = {2,5,3,4,1};
		
		printArr(arr);
		System.out.println("---------------");
		printArr1(arr1);
	    System.out.println("---------------");
		//输出最大值
		System.out.println(compare(arr1));
		System.out.println("---------------");
		//先调用逆序，再调用输出
		reverse(arr1);
		printArr(arr1);
	}
	//定义一个打印数组方法
	public static void printArr(int[] arr) {
		for(int i = 0; i < arr.length; i ++) {
			System.out.println(arr[i]);
		}
	}
	//第二种打印方法
	public static void printArr1(int[] arr) {
		System.out.print("[");
		
		for(int i = 0; i < arr.length; i ++) {
			if(i == arr.length - 1) {
				System.out.println(arr[i] + "]");
			} else {
				System.out.print(arr[i] + ",");
			}
		}
	}
	//定义一个输出最大值方法
	public static int compare(int[] arr) {
		int max = arr[0];
		for(int i = 1; i < arr.length; i ++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		return max;//一定不要忘了返回值！！！
	}
	//定义一个逆序输出方法
	public static void reverse(int[] arr) {
		for(int i = 0; i < arr.length/2; i ++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
	}
}
}