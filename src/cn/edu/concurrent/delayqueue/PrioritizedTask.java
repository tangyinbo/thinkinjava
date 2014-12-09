package cn.edu.concurrent.delayqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class PrioritizedTask implements Comparable<PrioritizedTask>, Runnable{
	private int priority;
	private static List<PrioritizedTask> sequence = new ArrayList<PrioritizedTask>();
	private static int count=0;
	private final int id = count++;
	
	private long timestamp = System.currentTimeMillis();
	
	public PrioritizedTask() {
		super();
	}

	public PrioritizedTask(int priority) {
		this.priority = priority;
		sequence.add(this);
	}

	@Override
	public int compareTo(PrioritizedTask o) {
		return this.priority<o.priority?1:(this.priority>o.priority?-1:0);
	}
	
	@Override
	public String toString() {
		return "Task ["+this.priority+"]"+"\t"+id+"\t"+this.timestamp;
	}
	
	public static void main(String[] args) {
		PriorityBlockingQueue<Runnable> queue = new PriorityBlockingQueue<Runnable>();
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(new PriorityTaskProducer(queue,service));
		service.execute(new PriorityTaskConsumer(queue));
		service.execute(new PriorityTaskConsumer(queue));
		service.execute(new PriorityTaskConsumer(queue));
	}
	
	public String summary(){
		return id+"--"+priority+"\t"+this.timestamp;
	}

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(new Random().nextInt(3));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this);
	}
	
	public static class SentinelTask extends PrioritizedTask{
		private ExecutorService service;

		public SentinelTask(ExecutorService service) {
			super(-1);
			this.service = service;
		}

		@Override
		public void run() {
			int count =0;
			for(PrioritizedTask t:sequence){
				System.out.println(t.summary());
			}
			System.out.println("Call shutdown....");
			service.shutdown();
		}
	}
}


class PriorityTaskProducer implements Runnable{
	private Queue<Runnable> queue;
	private ExecutorService service;
	private int count;
	
	public PriorityTaskProducer(Queue<Runnable> queue, ExecutorService service) {
		super();
		this.queue = queue;
		this.service = service;
	}

	public PriorityTaskProducer() {
		super();
	}

	@Override
	public void run() {
	/*		for(int i=0;i<10;i++){
				queue.add(new PrioritizedTask(new Random().nextInt(10)));
				Thread.yield();
			}
			
			for(int i=0;i<10;i++){
				queue.add(new PrioritizedTask(20));
			}
			
			for(int i=0;i<10;i++){
				queue.add(new PrioritizedTask(i));
			}*/
		int a = 0;
		while(true&&count++<100){
			a = new Random().nextInt(100);
			queue.add(new PrioritizedTask(a));
			System.out.println("---add---"+a);
			Thread.yield();
		}
			
			queue.add(new PrioritizedTask.SentinelTask(service));
	}
	
}

class PriorityTaskConsumer implements Runnable{
	private PriorityBlockingQueue<Runnable> queue;

	public PriorityTaskConsumer(PriorityBlockingQueue<Runnable> queue) {
		this.queue = queue;
	}
	@Override
	public void run() {
		while(!Thread.interrupted()){
			try {
				queue.take().run();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Finished PriorityTaskConsumer...");
	}
}


