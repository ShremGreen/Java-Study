/*
强制转换：从大的数据类型转为小的数据类型。
格式：    目标数据类型 变量 = （目标数据类型） （被转换数据）；
*/
class DataTypeDemo1 {
	public static void main(String[] args) {
		byte a = 3;
		int b = 4;

		byte c = (byte) (a + b);
		float d = (float) 12.1;
		System.out.println(c);
		System.out.println(d);
	}
}