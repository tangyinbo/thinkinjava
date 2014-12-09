package cn.edu.flow;

public class StaticTest {
	public static Mon mon2;
	public static Mon mon  = new Mon(1);
	static{
		mon2 = new Mon(2);
	}
	public static void main(String[] args) {
		Mon m = new Mon(1);
		m.t();
	}
}

class Mon{
	public Mon(int i){
		System.out.println("Mon:\t"+i);
	}
	
	public void t(int... args){
		System.out.println("first varables ....");
	}
	public void t(){
		System.out.println("second ....");
	}
}
