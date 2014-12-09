package cn.edu.proxy;

import java.lang.reflect.Method;
import java.util.Arrays;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ProxyFactory<T> implements MethodInterceptor{
	private T t;
	
	public ProxyFactory(T t) {
		this.t = t;
	}
	
	public T getInstance(){
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(t.getClass());
		enhancer.setCallback(this);
		return (T) enhancer.create();
	}

	@Override
	public Object intercept(Object arg0, Method method, Object[] arg2, MethodProxy arg3) throws Throwable {
		System.out.println("-----interceptor before-------");
		System.out.println("method:"+method.getName());
		System.out.println("arg2:"+Arrays.toString(arg2));
		System.out.println("arg3:"+arg3);
		return method.invoke(t, arg2);
	}

	
	public static void main(String[] args) {
		ProxyFactory<ShopBook> s= new ProxyFactory(new ShopBook());
		ShopBook book =s.getInstance();
		book.sellBook();
	}
}
