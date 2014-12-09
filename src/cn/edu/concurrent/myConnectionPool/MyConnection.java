package cn.edu.concurrent.myConnectionPool;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class MyConnection implements Connection,Delayed{
	private static int count =0;
	
	private long delayed=System.nanoTime()+TimeUnit.SECONDS.toNanos(5);
	
	private int id;
	
	public void start(){System.out.println("connection:  "+id+"\tstart");}
	public void stop(){System.out.println("connection:  "+id+"\tstop");}
	public MyConnection() {
		super();
		this.id = count++;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	@Override
	public int compareTo(Delayed o) {
		if(o instanceof MyConnection){
			MyConnection other = (MyConnection) o;
			return Integer.valueOf((TimeUnit.NANOSECONDS.toSeconds(this.getDelayed()) - TimeUnit.NANOSECONDS.toSeconds(other.getDelayed()))+"");
		}
		return -1;
	}
	
	
	@Override
	public long getDelay(TimeUnit unit) {
		return delayed - System.nanoTime();
	}
	public long getDelayed() {
		return delayed;
	}
	public void setDelayed(long delayed) {
		this.delayed = delayed;
	};
	
	@Override
	public String toString() {
		return "=====connection:"+id+" \t delayed:"+delayed +"\tcurrent:"+System.nanoTime();
	}
	
	
}
