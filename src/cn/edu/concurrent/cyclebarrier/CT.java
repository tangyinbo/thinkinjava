package cn.edu.concurrent.cyclebarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CT {
	public static void main(String[] args) {
		
		CyclicBarrier cb = new CyclicBarrier(3, new Runnable() {
			@Override
			public void run() {
				System.out.println("===================");
			}
		});
		ExecutorService service = Executors.newCachedThreadPool();
		for(int i=1;i<=3;i++){
			service.execute(new RaceHorse(cb,i));
		}
		service.shutdown();
	}
}
