package cn.edu.generics;

public class Trangle extends BaseTrangle implements Shape ,BasicShape{

	@Override
	public void draw(String s) {
		System.out.println("...draw...");
	}

	@Override
	public void basicDraw(String s) {
		System.out.println("...basicdraw...");
	}

}
