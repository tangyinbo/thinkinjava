package cn.edu.packages.p2;

public class Person {
	
	private static int b = f();
	private static int  f(){
		System.out.println("person f..........");
		return 10;
	}
	private String name="person";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
