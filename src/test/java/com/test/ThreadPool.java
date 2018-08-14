package com.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool implements Runnable{

	public void run() {
		synchronized(this) { 
            try{
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
          } 
	}
	
	public static void main(String[] args) {
		//BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
		BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(4);
		ThreadPoolExecutor  executor = new ThreadPoolExecutor (2, 6, 1, TimeUnit.DAYS, queue);
        for (int i = 0; i < 11; i++) { 
        	executor.execute(new Thread(new ThreadPool(),"TestThread".concat(" " + i)));
        	int threadSize = queue.size();
        	System.out.println("线程队列大小为----》"+threadSize);
        }
        executor.shutdown();
	}

}
