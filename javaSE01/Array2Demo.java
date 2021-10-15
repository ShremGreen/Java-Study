/*
定义一个二位数组
*/

class Array2Demo {
	public static void main(String[] args) {
		int[][] arr = new int [3][];
		System.out.println(arr);//[[I@3a1af2bc(这是标记加地址值，地址值是3a1af2bc)
		System.out.println(arr[0]);//null
		System.out.println(arr[1]);//null
		System.out.println(arr[2]);//null
		
		arr[0] = new int[2];
		arr[1] = new int[3];
		arr[2] = new int[1];
		System.out.println(arr[0]);//[[I@3a1af2bc
		System.out.println(arr[1]);//[I@7f29b922
		System.out.println(arr[2]);//[I@c39a867
		
	}
}