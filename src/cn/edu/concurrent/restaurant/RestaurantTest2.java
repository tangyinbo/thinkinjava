package cn.edu.concurrent.restaurant;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class RestaurantTest2 {
}

class Restaurant {
	protected int id;
	protected String name;
	private static int count;
	{
		this.id = ++count;
	}
	private LinkedBlockingDeque<Order> orders = new LinkedBlockingDeque<Order>();
	private LinkedBlockingDeque<Order> delivers = new LinkedBlockingDeque<Order>();
	private List<Chef> chefs;
	private List<WaitPerson> waitPersons;

	public void putOrder(Order order) {
		try {
			orders.put(order);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Order tackOrder() {
		try {
			return orders.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void putDelivers(Order order) {
		try {
			delivers.put(order);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Order tackDelivers() {
		try {
			return delivers.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

class Order {
	protected int id;
	protected String name;
	private List<Food> foods;
	private Customer customer;
	private WaitPerson waitPerson;
	private Chef chef;
	private static int count;
	{
		this.id = ++count;
	}
	
	@Override
	public String toString() {
		return "Food:"+id+"\t"+Arrays.toString(foods.toArray());
	}
}

class Food {
	protected int id;
	protected String name;
	private static int count;
	{
		this.id = ++count;
	}
}

class Chef implements Runnable {
	protected int id;
	protected String name;
	private Restaurant rest;
	private static int count;
	{
		this.id = ++count;
	}

	public Chef(Restaurant rest) {
		super();
		this.rest = rest;
	}

	private Order tackOrder() {
		return rest.tackOrder();
	}
	
	private void putDelivers(Order order){
		rest.putDelivers(order);
	}

	@Override
	public void run() {
		while (!Thread.interrupted()) {
			Order order = tackOrder();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			putDelivers(order);
			System.out.println(this+"----finished the Order:"+order);
		}
	}
	@Override
	public String toString() {
		return "Chef:"+this.id;
	}

}

class WaitPerson implements Runnable{
	protected int id;
	protected String name;
	private static int count;
	{
		this.id = ++count;
	}
	private Restaurant rest;
	
	public WaitPerson(Restaurant rest) {
		this.rest = rest;
	}

	private void putOrder(Order order){
		rest.putOrder(order);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}

class Customer {
	protected int id;
	protected String name;
	private static int count;
	{
		this.id = ++count;
	}
	private Restaurant rest;

}
