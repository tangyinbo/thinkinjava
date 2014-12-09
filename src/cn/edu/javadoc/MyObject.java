package cn.edu.javadoc;
import static java.lang.System.*;
/**
 * 
 * @author Tangyinbo
 *
 */
public class MyObject {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public static  boolean b1(){
		System.out.println("--b1--");
		return false;
	}
	
	public static boolean b2(){
		System.out.println("--b2--");
		return true;
	}
/*	@Override
	public boolean equals(Object obj) {
		if(obj==null)return false;
		if(!(obj instanceof MyObject))return false;
		return this.name == ((MyObject)obj).getName();
	}*/
	public static void main(String[] args) {
		System.out.println(1<<1);
		
	}
	 
}
