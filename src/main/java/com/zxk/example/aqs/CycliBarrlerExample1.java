package com.zxk.example.aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CycliBarrlerExample1 {

	private static CyclicBarrier cyclicBarrier =new CyclicBarrier(5);
	
	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		
		for(int i=0; i<10; i++){
			final int threadNum = i;
			Thread.sleep(1000);
			exec.execute(() ->{
				try {
					test(threadNum);
					} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
	}

	private static void test(int threadNum){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(threadNum);
		try {
			cyclicBarrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("===:"+ threadNum);
		
	}
}
