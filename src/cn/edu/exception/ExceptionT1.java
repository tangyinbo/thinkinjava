package cn.edu.exception;

import java.sql.SQLException;
import java.util.Formatter;

import javax.management.RuntimeErrorException;

public class ExceptionT1 {
	
	public static void main(String[] args) {
				Formatter f = new Formatter(System.out);
				f.format("my name is %-15s %10.2f\n", "tangyinbo",1f);
				//f.format("my name is %15s %10.2f\n", "tfsfsfsfsfsf",100000);
				//f.format("my name is %-15s %10.2f\n", "t1",1);
	}
}

class Person{
	public Person() throws Exception{}
	public Person say() throws Exception{
		return new Person();
	}
}

class Student extends Person{

	public Student() throws Exception{
	}

	@Override
	public Student say() throws Exception{
		return new Student();
	}
	
}
