package cn.edu.innerclass.p1;

public class OutClass {
	public OutClass(){
		CountOut.count++;
	}
	private String name="tangyinbo";
	public class InnerClass1{
		private String name="tangtang";
		public void say(){
			System.out.println("I'm InnerClass1..."+OutClass.this.name);
		}
	}
	class InnerClass2{
		public void say(){
			System.out.println("I'm InnerClass2...");
		}
	}
	
	public static int getCount(){
		return CountOut.getCount();
	}
	
	private static class CountOut{
		private static int count;
		public static int getCount(){
			return count;
		}
	}
	
	public static InnerClass1 getInnerClass1(){
		return new OutClass().new InnerClass1();
	}
	public static InnerClass2 getInnerClass2(){
		return new OutClass().new InnerClass2();
	}
}
