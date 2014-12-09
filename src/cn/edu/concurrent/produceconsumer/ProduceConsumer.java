package cn.edu.concurrent.produceconsumer;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ProduceConsumer {
	public static void main(String[] args) {
		ProductFactory factory = new ProductFactory();
		ExecutorService service = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++){
			service.execute(new Producter(factory));
			service.execute(new Consumer(factory));
		}
	}
}

class Product implements Runnable{
	private final int id = ++count;
	private static int count;
	@Override
	public void run() {
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		return this.id+"\t has be productd....";
	}
}
class ProductFactory{
	
	private  BlockingQueue<Product> queue = new ArrayBlockingQueue<Product>(10);
	
	public  void product(){
		queue.add(new Product());
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public Product take(){
		try {
			return queue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
}

class Producter implements Runnable{
	private static int count;
	ProductFactory factory;

	public Producter(ProductFactory factory) {
		super();
		this.factory = factory;
	}

	@Override
	public void run() {
		while(true){
			System.out.println(++count+"===========");
			factory.product();
		}
	}
	
}


class Consumer implements Runnable{
	ProductFactory factory;

	public Consumer(ProductFactory factory) {
		this.factory = factory;
	}

	@Override
	public void run() {
		while(true){
			factory.take().run();
		}
	}
}
