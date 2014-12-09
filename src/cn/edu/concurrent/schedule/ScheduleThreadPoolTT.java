package cn.edu.concurrent.schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadPoolTT {
	private static ScheduledExecutorService service = new ScheduledThreadPoolExecutor(10);

	public static void main(String[] args) {
		service.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println("run...");
			}
		}, 1,1, TimeUnit.SECONDS);
		//service.shutdown();
	}
}
