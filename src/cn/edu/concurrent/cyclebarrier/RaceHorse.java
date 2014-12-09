package cn.edu.concurrent.cyclebarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class RaceHorse implements Runnable{
	Random random = new Random();
	private CyclicBarrier barrier;
	private int id;
	
	public RaceHorse(CyclicBarrier barrier,int id) {
		this.barrier = barrier;
		this.id = id;
	}

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(random.nextInt(5));
			System.out.println("horse->"+id+"->is ready....");
			barrier.await();
			System.out.println("horse ->"+id +"-> is run...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

}
