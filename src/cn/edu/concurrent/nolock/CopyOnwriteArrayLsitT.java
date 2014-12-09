package cn.edu.concurrent.nolock;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CopyOnwriteArrayLsitT {
	public static void main(String[] args)  {
		char[] chars = new char[3];
		System.out.println(chars.length);
		for(int i=0;i<chars.length;i++){
			System.out.println("hehe");
			System.out.println((int)chars[i]);
		}
		for(char c:chars){
			System.out.println((char)c);
		}
	}
	
	public static void modify(List<Integer> list){
		list.add(1000);
	} 
	
	public static void test(){
		int a = 0;
		{
		}
	}
}	
