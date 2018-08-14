package com.zxk.thread;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MyQueue {

	// 1、需要一个装元素的集合
	private final LinkedList<Object> list = new LinkedList<Object>();
	// 2、需要一个计数器
	private AtomicInteger count = new AtomicInteger(0); 
	// 3、需要制定上限和下限长度
	private final int minSize = 0;
	private final int maxSize;
	
	public MyQueue(int size){
		this.maxSize = size;
	}
	//创建一个枷锁的对象
	private final Object lock = new Object();
	
	public void put(Object obj){
		synchronized (lock) {
			while(count.get() ==  this.maxSize){
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			//添加元素
			list.add(obj);
			System.out.println("新加入的元素"+ obj);
			//计数器累加
			count.incrementAndGet();
			lock.notify();
		}
	}
	public Object take(){
		Object ret = null;
		synchronized (lock) {
			while(count.get() == this.minSize){
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			//集合减并返回结果
			ret = list.removeFirst();
			//计数器减
			count.decrementAndGet();
			//唤醒另外一个线程
			lock.notify();
		}
		return ret;
	}
	
	public int getSize(){
		return count.get();
	}

	public static void main(String[] args) {
		final MyQueue mq = new MyQueue(5);
		mq.put("a");
		mq.put("b");
		mq.put("c");
		mq.put("d");
		mq.put("e");
		
		System.out.println("========="+mq.getSize());
		
		Thread t1 = new Thread(new Runnable() {
			
			public void run() {
				mq.put("f");
				mq.put("g");
				
			}
		},"t1");
		
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			
			public void run() {
				Object o1 = mq.take();
				System.out.println("移除元素"+o1);
				Object o2 = mq.take();
				System.out.println("移除的元素"+o2);
				
			}
		},"t2");
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t2.start();
	}
}
