package com.zxk.example.aqs;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {

			@Override
			public String call() throws Exception {
				System.out.println("do something in callable!");
				return "result";
			}
		});
		
		new Thread(futureTask).start();
		Thread.sleep(1000);
		String ret = futureTask.get();
		System.out.println("====="+ ret);
	}

}
