package cn.edu.concurrent.countdownlatch;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTt {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newCachedThreadPool();
	  Future<String> f=service.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "tangyinbo";
			}
		});
	  System.out.println(f.get());
	}
}
