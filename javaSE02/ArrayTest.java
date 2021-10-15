/*
静态调用和非静态调用

需求：
1.遍历数组
2.求最大值
*/

class ArrayTest {
	public static void main(String[] args) {
		int[] arr = new int[]{2,6,4,5,9};
		
		//在测试类中新建一个类，采用非静态调用
		/*
		ArrayDemo ad = new ArrayDemo();
	    ad.printArr(arr);
		*/
	    
		//通过类名调用静态方法
	    ArrayDemo.printArr(arr);
		
		int max = ArrayDemo.getMax(arr);
		System.out.println("Max:" + max);
		
		int num = 5;
		int index = ArrayDemo.getIndex(arr, num);
		System.out.println("Index:" + index);
	}
	
	//最好不要在测试类中创建无关类
	/*
	
	public static void printArr(int[] arr) { //注意这里用静态方法定义
		for(int i = 0; i < arr.length; i ++) {
			if(i == arr.length - 1) {
				System.out.println(arr[i]);
			} else {
				System.out.print(arr[i] + "  ");
			}
		}
	}
	*/
}

