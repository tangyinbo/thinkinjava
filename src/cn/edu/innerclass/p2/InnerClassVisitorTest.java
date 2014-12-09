package cn.edu.innerclass.p2;

import cn.edu.innerclass.p1.OutClass;
import cn.edu.innerclass.p1.OutClass.InnerClass1;

public class InnerClassVisitorTest {
	public static void main(String[] args) {
		/*
		 * OutClass.InnerClass1 c1 =OutClass.getInnerClass1(); c1.say();
		 * //OutClass.getInnerClass2().say();;
		 */OutClass o1 = new OutClass();
		OutClass o2 = new OutClass();
		OutClass o3 = new OutClass();
		System.out.println(OutClass.getCount());
	}
}
