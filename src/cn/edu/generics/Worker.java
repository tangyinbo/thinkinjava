package cn.edu.generics;

import java.util.ArrayList;
import java.util.List;

import cn.edu.packages.p2.Shap;

public class Worker<T extends Trangle  & BasicShape & Shape> {
	
	public static void main(String[] args) {
		List<? super Trangle> list = new ArrayList<Trangle>();
		list.add(new SonTrangle());
		list.add(new Trangle());
		System.out.println(list.get(0));
		System.out.println(list.get(1));
	}
	
	public static void test(List<? super Trangle> list){
		//list.add(new BaseTrangle());
		list.add(new Trangle());
		list.add(new SonTrangle());
	}
	
}
