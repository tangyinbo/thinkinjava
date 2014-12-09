package cn.edu.flow;

import java.util.Date;

public class Student extends Person {

	
	public Student() {
		/*this("name",12);
		this(new Date());*/
	}
	public Student(String name, int age) {
		super(name, age);
	}
	
	public Student(Date date){}
	
	public void i(int a){
		System.out.println("int...."+a);
	}
	
	public void i(byte b){
		System.out.println("byte...."+b);
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("cliean student instance...");
	}
	
	public static void main(String[] args) {
		new Student().i(1);
	}

}
