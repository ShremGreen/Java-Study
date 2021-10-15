/*
String[] args×Ö·û´®Êä³öÊ¾Àý
*/

class MainDemo {
	public static void main(String[] args) {
		System.out.println(args);//Ljava.lang.String;@2ab600af
		System.out.println(args.length);//0
		
		for(int x = 0; x < args.length; x ++) {
			System.out.print(args[x]);
		}
	}
}