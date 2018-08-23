package com.zxk.example;

public class Singleton5 {
	
	/**
	 * 枚举模式 ：最安全的
	 */
	
	private Singleton5(){
		
	}
	public static Singleton5 getInstance(){
		return Singleton.INSTANCE.getInstance();
	}
	
	private enum Singleton{
		INSTANCE;
		private Singleton5 singleton;
		Singleton(){
			singleton = new Singleton5();
		}
		public Singleton5 getInstance(){
			return singleton;
		}
	} 
}	
