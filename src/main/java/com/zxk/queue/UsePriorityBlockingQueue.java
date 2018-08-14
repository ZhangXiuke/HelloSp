package com.zxk.queue;

import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

public class UsePriorityBlockingQueue {

	public static void main(String[] args) {
		PriorityBlockingQueue<Task> q = new PriorityBlockingQueue<Task>();
		
		Task t1 = new Task();
		t1.setId(1);
		t1.setName("任务1");
		Task t2 = new Task();
		t2.setId(2);
		t2.setName("任务2");
		Task t3 = new Task();
		t3.setId(5);
		t3.setName("任务5");
		
		q.add(t3);
		q.add(t2);
		q.add(t1);
		
		System.out.println(q);
		try {
			System.out.println(q.take());
			System.out.println(q);
			System.out.println(q.take());
			System.out.println(q);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*for (Iterator iterator = q.iterator(); iterator.hasNext();) {
			Task task = (Task) iterator.next();
			System.out.println("---------"+task.getName());
		}*/
	}

}
