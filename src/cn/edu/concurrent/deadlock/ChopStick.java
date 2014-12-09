package cn.edu.concurrent.deadlock;

/**
 * 哲学家的筷子
 * @author canton_cowboy
 *
 */
public class ChopStick {
	//筷子的状态,放下,或者被拿起
	private boolean token;
	
	//拿起筷子
	public synchronized void take() throws InterruptedException{
		//如果拿起了筷子的话,那么其他的哲学家就不能拿起这个筷子了
		while(token){
			wait();
		}
		//被拿起
		token=true;
	}
	
	public synchronized void drop(){
		//筷子被放下
		token = false;
		notifyAll();
	}
}
