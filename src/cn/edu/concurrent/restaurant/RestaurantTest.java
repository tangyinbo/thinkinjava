/*package cn.edu.concurrent.restaurant;

public class RestaurantTest {

}

class Order {
	private static int count;
	private final int id = count++;
	private final Customer customer;
	private final Food food;
	private final WaitPerson waitPerson;

	public Order(Customer customer, Food food, WaitPerson waitPerson) {
		this.customer = customer;
		this.food = food;
		this.waitPerson = waitPerson;
	}

	public static int getCount() {
		return count;
	}

	public int getId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Food getFood() {
		return food;
	}

	public WaitPerson getWaitPerson() {
		return waitPerson;
	}

	@Override
	public String toString() {
		return "Order :\t" + id + "\tfor:\t" + customer + "\t server by\t" + waitPerson;
	}

}

class Plate {
	private final Order order;
	private final Food food;

	public Plate(Order order, Food food) {
		super();
		this.order = order;
		this.food = food;
	}

	public Order getOrder() {
		return order;
	}

	public Food getFood() {
		return food;
	}

	@Override
	public String toString() {
		return this.food.toString();
	}
}

class Customer implements Runnable{
	private static int count;
	//private final int id;
	

	@Override
	public void run() {
		
	}

}

*/