package cn.edu.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BWT {
	public static void main(String[] args) {
/*		CountDownLatch latch = new CountDownLatch(2);
		ExecutorService service = Executors.newCachedThreadPool();
		Worker w1 = new Worker(latch, "work1");
		Worker w2 = new Worker(latch, "work1");
		Boss b = new Boss(latch);
		service.execute(w1);
		service.execute(w2);
		service.execute(b);
		service.shutdown();*/
		
		Test t = new Test();
		System.out.println(t.a);
	}
	
	
}

class Test{
	public String name;
	public Integer age;
	public Long money;
	public int a;
}