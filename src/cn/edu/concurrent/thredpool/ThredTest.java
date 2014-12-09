package cn.edu.concurrent.thredpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.xml.ws.Service;

public class ThredTest {
	public static void main(String[] args) {
		
		ExecutorService service  =Executors.newCachedThreadPool();
		service.execute(new MyThread());
		service.execute(new MyThread());
		service.execute(new MyThread());
		service.execute(new MyThread());
	}
}
class MyThread implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
	
}
