package com.zxk.thread;

public class GetInstance {

	//最好使的单例模式
	private static class Singletion{
		private static Singletion single = new Singletion();
	}
	
	public static Singletion getInstance(){
		return Singletion.single;
	}
}
