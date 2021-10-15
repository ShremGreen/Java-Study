/**
*这是针对数组的操作的工具类
*@author 李荣春
*@version V0.0
*/

public class ArrayDemo {
	//把构造方法私有，外界就不能创建对象，只能通过类名调用静态方法
	/**
	*这是私有构造
	*/
	private ArrayDemo() {}
	
	/**
	*这是遍历数组的方法，遍历后的格式是：元素1  元素2  元素3...
	*@param arr 这是要被遍历的数组
	*/
	public static void printArr(int[] arr) { //注意这里用静态方法定义
		for(int i = 0; i < arr.length; i ++) {
			if(i == arr.length - 1) {
				System.out.println(arr[i]);
			} else {
				System.out.print(arr[i] + "  ");
			}
		}
	}
	
	/**
	*这是获取数组中最大值的方法
	*@param arr 这是要操作的数组
	*@return 返回数组中的最大值
	*/
	public static int getMax(int[] arr) {
		int max = arr[0];
		int i = 0;
		
		while(i < arr.length) {
			if(arr[i] > max) {
				max = arr[i];
			}
			i ++;
		}
		return max;
	}
	/**
	*这是获取元素位置的方法
	*@param arr 这是要操作的数组
	*@param num 这是要输入的数
	*/
	public static int getIndex(int[] arr, int num) {
		int index = -1;
		for(int i = 0; i < arr.length; i ++) {
			if(arr[i] == num) {
				index = i;
			}
		}
		return index;
	}
}