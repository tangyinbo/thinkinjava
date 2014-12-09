package cn.edu.concurrent.deadlock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadLockTest {
	
	public static void main(String[] args) {
		List<ChopStick> chopsticks = new ArrayList<ChopStick>();
		ExecutorService service = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++){
			chopsticks.add(new ChopStick());
		}
		for(int i=0;i<5;i++){
			service.execute(new Philosopher(chopsticks.get(i), chopsticks.get((i+1)%5), i+1, 100));
		}
		
	}
}	
