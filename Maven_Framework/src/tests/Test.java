package tests;

public class Test {
	public static void main(String[] args) {
		long num = 252;
		for (int i = 0; i <= 100; i++) {	
			long num1=1;
			for (int j = 0; j <= i; j++) {
				num1=num1*num;
			}
			System.out.println(num1);
		}
	}
}
