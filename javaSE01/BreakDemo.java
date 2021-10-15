/*
控制跳转语句：
break：中断
continue：继续
return：返回
*/

class BreakDemo {
	public static void main(String[] args) {
		//break跳出单层循环
		for(int i=0; i<10; i++) {
			if(i ==3) {
				break;
			}
			System.out.println(i);
		}
		
		//break跳出多层循环
		wc:for(int x=0; x<3; x++) {
			nc:for(int y=0; y<4; y++) {
				if(y == 2) {
					//break nc;跳出小for循环语句
					break wc;//跳出大for语句
			}
			System.out.print("*");
	}
	System.out.println();
	}
	System.out.println("break over");
	
	//continue
	for(int a=0; a<5; a++) {
		if(a == 3) {
			continue;
		}
		System.out.println(a);
	}
	System.out.println("continue over");
	
	//return
	for(int a=0; a<5; a++) {
		if(a == 3) {
			return;
		}
		System.out.println(a);
	}
	System.out.println("return over");
}
}	