package cn.edu.container.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class SetTest {
	public static void main(String[] args) {
		for( Iterator<Map.Entry<String, String>> it=System.getenv().entrySet().iterator();it.hasNext();){
			Map.Entry<String, String> entry = it.next();
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}

	private static void aa() {
		//List<Integer> list = Arrays.asList(1,23,435,6565,12,3,6,4,54,23,664,12,3);
		//Queue queue = new LinkedList<Integer>(list);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i=0;i<10;i++){
			int a= new Random().nextInt(i+10);
			pq.offer(a);
			System.out.print(a+",");
		}
		print(pq);
		
		PriorityQueue<String> pqs = new PriorityQueue<String>();
		String[] s = new String("a g e g g e g b h q b").split("\\W");
		System.out.println(s.length);
		pqs.addAll(Arrays.asList(s));
		print(pqs);
		
	
		PriorityQueue<Person> persons = new PriorityQueue<Person>();
		persons.add(new Person(2, "tangyinbo2"));
		persons.add(new Person(1, "tangyinbo1"));
		persons.add(new Person(3, "tangyinbo3"));
		print(persons);
		//System.out.println(queue);
		//System.out.println(pq);
	}
	
	public static void print(Queue queue){
		System.out.println();
		while(queue.peek()!=null){
			Object a = queue.poll();
			System.out.print(a+",");
		}
		System.out.println();
	}
}

class Person implements Comparable<Person>{
	private int id;
	private String name;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public boolean equals(Object obj) {
		return true;
	}
	
	@Override
	public int hashCode() {
		return 1;
	}
	@Override
	public int compareTo(Person o) {
		return this.id-o.id>0?1:this.id==o.id?0:-1;
	}
	@Override
	public String toString() {
		return this.id+"--"+this.name;
	}
	
	
}