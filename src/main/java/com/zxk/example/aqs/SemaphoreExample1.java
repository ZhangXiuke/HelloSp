package com.zxk.example.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreExample1 {

	private final static int threadCount = 200;
	
	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		final Semaphore semaphore = new Semaphore(10);
		
		for(int i=0; i<threadCount; i++){
			final int threadNum = i;
			exec.execute(() ->{
				try {
					semaphore.acquire();
					test(threadNum);
					semaphore.release();
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
		
		System.out.println("执行完成！");
		exec.shutdown();
	}

	private static void test(int threadNum) throws InterruptedException{
		Thread.sleep(1000);
		System.out.println(threadNum);
	}
}
