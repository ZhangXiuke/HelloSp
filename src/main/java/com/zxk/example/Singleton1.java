package com.zxk.example;

public class Singleton1 {

	/**
	 * 饿汉模式
	 * 线程安全
	 */
	private final static Singleton1 instance = new Singleton1() ;
	private Singleton1() {
		
	}

	public static Singleton1 getInstance() {

		return instance;
	}
}	
