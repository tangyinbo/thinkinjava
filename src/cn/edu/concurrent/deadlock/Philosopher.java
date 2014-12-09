package cn.edu.concurrent.deadlock;

import java.util.Random;
import java.util.concurrent.TimeUnit;

//哲学家
public class Philosopher implements Runnable {
	private ChopStick left;
	private ChopStick right;
	private int id;
	private int ponder;
	private Random random = new Random();

	public Philosopher() {
		super();
	}

	public Philosopher(ChopStick left, ChopStick right, int id,int ponder) {
		super();
		this.left = left;
		this.right = right;
		this.id = id;
		this.ponder = ponder;
	}

	private void pause() throws InterruptedException{
		TimeUnit.MILLISECONDS.sleep(random.nextInt(ponder*1));
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				// 拿起左手的筷子
				System.out.println(this+" thinking......");
				pause();
				left.take();
				//拿起右手的筷子
				right.take();
				System.out.println(this+" eat......");
				pause();
				left.drop();
				right.drop();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return "philosopher ["+id+"]\t";
	}

}
