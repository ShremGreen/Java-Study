/*
公司年销售额求和
某公司技照季度和月份统计的数据如下:单位(万元)
第一季度: 22,66,44
第二季度: 77,33,88
第三季度: 25,45,65 
第四季度: 11,66,99
*/

class Array2Test2 {
	public static void main(String[] args) {
		int[][] arr = {{22,66,44},{77,33,88},{25,45,56},{11,45,37}};
		int sum = 0;
		for(int i = 0; i < arr.length; i ++) {
			for(int j = 0; j < arr[i].length; j ++) {
				sum += arr[i][j];
			}
		}
		System.out.println("总收入是：" + sum);
	}
}