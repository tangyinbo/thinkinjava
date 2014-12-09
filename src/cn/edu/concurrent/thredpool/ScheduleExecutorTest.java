package cn.edu.concurrent.thredpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleExecutorTest {
	public static void main(String[] args) {
		ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
		//service.scheduleAtFixedRate(new MyTask(), 2, 2, TimeUnit.SECONDS);
		service.scheduleWithFixedDelay(new MyTask(), 2, 2, TimeUnit.SECONDS);
		

	}

	static class MyTask implements Runnable {

		@Override
		public void run() {
			System.out.println("task is run: " + System.currentTimeMillis() / 1000);
		}

	}
}
