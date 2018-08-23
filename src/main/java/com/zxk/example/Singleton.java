package com.zxk.example;

public class Singleton {

	/**
	 * 懒汉模式
	 * 线程不安全
	 */
	private Singleton() {
		
	}

	private static Singleton instance = null;
	
	public static Singleton getInstance() {
		if(instance == null){
			instance = new Singleton();	
		}
		return instance;
	}
}	
