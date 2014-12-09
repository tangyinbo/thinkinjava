package cn.edu.pattern;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pt1 {
	public static void main(String[] args) throws ClassNotFoundException {
	/*	String s = "abc def abcdef fsfed";
		Matcher m = Pattern.compile("a(b(c))\\w*").matcher(s);
		System.out.println(m.groupCount());
		while(m.find()){
			for( int i=0;i<m.groupCount();i++)
				System.out.print(m.group(i)+"\t");
			System.out.println();
		}*/
		//Class p =Person.class;
		Class.forName("cn.edu.pattern.Person");
	}

	private static void test1() {
		Pattern p = Pattern.compile("\\w+");
		Matcher m =p.matcher("every thing is the full of the's golve");
		while(m.find()){
			System.out.print(m.group()+"  "+m.start()+"---"+m.end()+"\t");
		}
		
		System.out.println();
		int i=0;
		while(m.find(i++)){
			System.out.print(m.group()+"\t");
		}
	}
}

class Person{
	static{
		System.out.println("person is init...");
	}
}
