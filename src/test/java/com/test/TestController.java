package com.test;

public class TestController {

	/*public static void main(String[] args) {
		Thread t = new Thread(){
			public void run(){
				pong();
			}
		};
		t.run();
		System.out.println("ping");
	}
	static void pong(){
		System.out.println("pong");
	}*/
	
	//good and gbc
	/*String str = new String("good");
	char[] ch = {'a','b','c'};
	public static void main(String[] args) {
		TestController em = new TestController();
		em.change(em.str, em.ch);
		System.out.println(em.str + "and");
		System.out.println(em.ch);
	} 
	public void change(String str,char ch[]){
		str = "test ok";
		ch[0] = 'g';
	}*/
	public static void main(String[] args) {
		String[][] tt = new String[4][4];
		tt[0][0] = "11";
		tt[0][1] = "22";
		tt[0][2] = "33";
		tt[0][3] = "44";
		//int j = 0;
		//System.out.println("111");
		for(int i=0,j=0;i<tt.length;){
			System.out.println(tt[i][j]);
			j++;
			if( j >= tt[i].length){
				i++;
				j = 0;
			}
		}
	}
}
