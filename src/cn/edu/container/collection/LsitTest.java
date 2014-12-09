package cn.edu.container.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LsitTest {
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.push(1);
		list.push(2);
		list.push(3);
		System.out.println(list.poll());
	} 
}
