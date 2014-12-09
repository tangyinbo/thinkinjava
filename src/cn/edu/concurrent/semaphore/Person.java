package cn.edu.concurrent.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Person implements Runnable{

	private Semaphore semaphore;
	private int id;
	
	public Person(Semaphore semaphore, int id) {
		super();
		this.semaphore = semaphore;
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("person ->"+id+"\tis  waiting");
		try {
			semaphore.acquire();
			TimeUnit.SECONDS.sleep(1);
			System.out.println("person ->"+id+"\tis finished");
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
