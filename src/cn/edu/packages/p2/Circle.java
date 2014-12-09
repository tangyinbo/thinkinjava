package cn.edu.packages.p2;

public class Circle extends Shap{
	public Circle( int i) {
		System.out.println("constructor...");
		this.i = i;
	}
	private int is = init();
	private int init(){
		System.out.println("init i");
		return 2;
	}
	
	
	private int i=1;
	@Override
	public void draw(){
		System.out.println("circle radius --"+i);
	}
	
	public static void main(String[] args) {
		/*Shap s = new Circle(5);*/
		Circle c = new Circle(2);
		System.out.println(c.is);
	}
	
}
