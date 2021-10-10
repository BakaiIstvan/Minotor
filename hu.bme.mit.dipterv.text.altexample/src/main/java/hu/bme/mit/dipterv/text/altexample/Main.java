package hu.bme.mit.dipterv.text.altexample;

public class Main {
	public static void foo(boolean b) {
		System.out.println(b);
	}
	
	public static void main(String[] args) {
		Bank bank = new Bank();
		foo(false == true);
	}
}
