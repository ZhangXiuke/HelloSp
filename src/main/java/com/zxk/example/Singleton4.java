package com.zxk.example;

public class Singleton4 {
/**
 * 饿汉模式线程安全
 * 执行顺序	
 */
	private Singleton4() {
		
	}
	//1
	private static Singleton4 instance = null;
	//2
	static {
		instance = new Singleton4();
	}
	

	public static Singleton4 getInstance() {

		return instance;
	}
	
	public static void main(String[] args) {
		System.out.println(Singleton4.getInstance().hashCode());
		System.out.println(Singleton4.getInstance().hashCode());
	}
}	
