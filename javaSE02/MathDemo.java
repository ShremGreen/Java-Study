/*
使用帮助文档，运用math类
可见：math方法在java.lang包中，不需要导包
*/

class MathDemo {
	public static void main(String[] args) {
		//获取一个随机数
		double d = Math.random();
		
		for(int i = 0; i < 100; i ++) {
		//默认数据类型是double型，强制转换为int型
			int x = (int) (Math.random() * 100 + 1);
			System.out.println(x);
		}
	}
}