package cn.edu.concurrent.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class St {
	
	public static void main(String[] args) {
		Semaphore a = new Semaphore(2, true);
		ExecutorService service = Executors.newCachedThreadPool();
		for(int i=0;i<10;i++){
			service.execute(new Person(a,i));
		}
		service.shutdown();
	}
}
