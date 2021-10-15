/*
打印杨辉三角
*/

import java.util.Scanner;
class ArrayTest3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int[][] arr = new int[a][a];
		
		//输出第一列和对角线元素
		for(int i = 0; i < a; i ++) {
			arr[i][0] = 1;
			arr[i][i] = 1;
		}
		
		//输出中间元素
		for(int i = 1; i < a; i ++) {
			for(int j = 1; j < a; j ++){
				arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
			}
		}
		
		//打印数组
	    for(int i = 0; i < arr.length; i ++) {
			for(int j = 0; j <= i; j ++){
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println(" ");
		}
	}
}