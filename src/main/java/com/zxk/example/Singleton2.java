package com.zxk.example;

public class Singleton2 {

	/**
	 * 双重验证模式
	 * 线程安全
	 * 单线程运行情况下
	 * 1、memory = allocate(); 分配对象的内存空间
	 * 2、ctorInstance(); 初始化对象
	 * 3、instance = memory 设置instance 指向刚分配的内存
	 * 
	 * volatile + 双重检测机制
	 */
	private static volatile Singleton2 instance = null;
	private Singleton2() {
		
	}
	public static Singleton2 getInstance() {
		if(instance == null){
			synchronized (Singleton2.class) {
				//双重检测机制
				if(instance == null){
					instance = new  Singleton2();
				}
			}
		}
		return instance;
	}
}	
