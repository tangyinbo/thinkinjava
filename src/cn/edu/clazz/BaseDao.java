package cn.edu.clazz;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class BaseDao<T extends Object> {
	{
		ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();
		Class clazz=(Class) type.getActualTypeArguments()[0];
		System.out.println(clazz.getName());
		System.out.println(clazz.isLocalClass());
		System.out.println(clazz.isMemberClass());
	}
	public static <C> C get(C c){return null;}
	
	public static void f(List<String> s){
		
	}
	public static void main(String[] args) {
		f(New.<String>getList());
	}
}

class New{
	public static <T> List<T>  getList(){
		return new ArrayList<T>();
	}
}
