package cn.edu.container;

import java.util.HashMap;
import java.util.Map;

public class TM {
	public static void main(String[] args) {
		 Map<String,String> m = new HashMap<String,String>();
		 m.put("name", "tangyinbo");
		 m.put("age", "12");
		 for(Map.Entry<String, String> s : m.entrySet()){
			 System.out.println(s.getKey());
			 System.out.println(s.getValue());
		 }
	}
}
