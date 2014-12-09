package cn.edu.decimal;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class MyInteger {
	public static String toBinaryString(int n){
		return toUnSignString(n,1);
	}
	
	
	public static String toHexString(int n){
		return toUnSignString(n,4);
	}
	
	public static String toOctString(int n){
		return toUnSignString(n,3);
	}
	
	public static String toUnSignString(int n,int m){
		char[] buf = new char[32];
		int pos=32;
		int radix = 1<<m;
		int mask = radix -1;
		while(n!=0){
			buf[--pos] = digits[n&mask];
			n>>>=m;
		}
		return new String(buf,pos,(32-pos));
	}
	
	public static void main(String[] args) {
	 System.out.println(toHexString(125));
	}
	
	public static void test(byte t){
	}
	
	final static char[] digits={'0','1','2','3','4','5','6','7','8',
		'9','a','b','c','d','e','f'};
}
