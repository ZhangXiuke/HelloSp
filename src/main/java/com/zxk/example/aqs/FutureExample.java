package com.zxk.example.aqs;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.sun.xml.internal.ws.api.Cancelable;

public class FutureExample{
	static class MyCallable implements Callable<String>{
		@Override
		public String call() throws Exception {
			Thread.sleep(5000);;
			System.out.println("do something in callable");
			return "Down";
		}
		
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService exec = Executors.newCachedThreadPool();
		Future<String> future = exec.submit(new MyCallable());
		Thread.sleep(1000);
		String result = future.get();
		System.out.println(result);
		exec.shutdown();
	}
}
