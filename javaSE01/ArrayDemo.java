/*
数组的动态初始化
格式：
int[] arr = new int[];
*/

class ArrayDemo {
	public static void main(String[] args) {
		int[] arr = new int[3];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		
		System.out.println("地址值是： " + arr);
		for(int i = 0; i <= 2; i ++) {
			System.out.println(arr[i]);
		}
		
		int[] arr1 = arr;//数组arr1定义时地址为arr
		
		arr1[0] = 5;//通过数组arr1修改数组arr的元素
		arr1[1] = 6;
		
		System.out.println("地址值是： " + arr1);
		for(int i = 0; i <= 2; i ++) {
			System.out.println(arr1[i]);
		}
	}
}