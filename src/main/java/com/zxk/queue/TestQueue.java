package com.zxk.queue;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TestQueue {
	public static void main(String[] args) {
		ArrayBlockingQueue<String> str = new ArrayBlockingQueue<String>(5);
		LinkedBlockingQueue<String> q = new LinkedBlockingQueue<String>();
		str.add("a");
		str.add("b");
		str.add("c");
		str.add("d");
		str.add("e");
		//str.add("f");
		System.out.println(str.size());
		for (Iterator iterator = str.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println("======="+string);
		}
		
		
	}
}
