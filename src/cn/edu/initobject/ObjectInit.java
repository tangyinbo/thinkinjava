package cn.edu.initobject;

public class ObjectInit {
	private String name;
	static{
		System.out.println("init instance by static...");
	}
	{
		this.name = "tangyinbo";
		System.out.println("init instance by class construction");
	}

	public ObjectInit() {
		System.out.println("init instance by construction");
	}
	
	public static void main(String[] args) {
		ObjectInit o=new ObjectInit();
		System.out.println(o.name);
	}
	
}
