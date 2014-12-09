package cn.edu.concurrent.myConnectionPool;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TT {
	public static void main(String[] args) throws Exception {
		ScheduledExecutorService scheduleService =Executors.newScheduledThreadPool(1);
		ExecutorService service = Executors.newFixedThreadPool(5);
		final DelayQueue<MyConnection> queue = new DelayQueue<>();

		scheduleService.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				if(queue.size()<2){
					MyConnection connection = new MyConnection();
					System.out.println("check    put:   "+connection);
					queue.put(connection);
				}
			}
		}, 1, 2, TimeUnit.SECONDS);
		
		service.execute(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					try {
						Thread.currentThread().sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					MyConnection connection = new MyConnection();
					System.out.println("put:   "+connection);
					queue.put(connection);
				}
			}
		});
		
		
		
		service.execute(new Runnable() {
			@Override
			public void run() {
				while(true){
					try {
						System.out.println("take:\t"+queue.take());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

	}
}
