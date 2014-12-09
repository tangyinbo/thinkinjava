package cn.edu.flow;

public class Person {
	private String name;
	private int age;
	
	protected void sayHi(){
		System.out.println("..sayHi..");
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
