package com.zxk.example.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchExample2 {

	private final static int threadCount = 200;
	
	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
		
		for(int i=0; i<threadCount; i++){
			final int threadNum = i;
			exec.execute(() ->{
				try {
					test(threadNum);
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					countDownLatch.countDown();
				}
			});
		}
		countDownLatch.await(10,TimeUnit.MILLISECONDS);
		System.out.println("执行完成！");
		exec.shutdown();
	}

	private static void test(int threadNum) throws InterruptedException{
		Thread.sleep(100);
		System.out.println(threadNum);
	}
}
