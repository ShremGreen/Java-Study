/*
A每天存钱2.5元.
当天数为5的倍数时，A花掉6元.
问：
   多少天后A有超过100元.
*/

class CunQian {
	public static void main(String[] args) {
		int day = 1;
		double dailyMoney = 2.5;
		double moneySum = 0;
		
		while(true) {
			moneySum += dailyMoney;
			System.out.println("第" + day + "天有" + moneySum + "元");
			
			if(moneySum >= 100) {
				break;
			}
			if(day%5 == 0) {
				moneySum -= 6;
			}
			
			day ++;
		}
		System.out.println("第" + day + "天超过100元");
	}
}
