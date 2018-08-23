package com.zxk.example;

public class Singleton3 {

	/**
	 * 双重验证模式
	 * 线程不安全
	 * 单线程运行情况下
	 * 1、memory = allocate(); 分配对象的内存空间
	 * 2、ctorInstance(); 初始化对象
	 * 3、instance = memory 设置instance 指向刚分配的内存
	 * 
	 * 多线程运行情况下
	 * JVM和cpu优化   发生了指令重拍
	 * 1、memory = allocate(); 分配对象的内存空间
	 * 3、instance = memory 设置instance 指向刚分配的内存
	 * 2、ctorInstance(); 初始化对象
	 */
	private static Singleton3 instance = null;
	private Singleton3() {
		
	}
	public static Singleton3 getInstance() {
		if(instance == null){
			synchronized (Singleton3.class) {
				if(instance == null){
					instance = new  Singleton3();
				}
			}
		}
		return instance;
	}
}	
