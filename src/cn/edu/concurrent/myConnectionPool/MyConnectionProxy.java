package cn.edu.concurrent.myConnectionPool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyConnectionProxy implements InvocationHandler {
	private long lastused;//最后是用时间
	
	private Connection target;

	public MyConnectionProxy(Connection target) {
		super();
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("invoke.....");
		return method.invoke(target, args);
	}
	
	public Connection getInstance(){
		return (Connection) Proxy.newProxyInstance(MyConnectionProxy.class.getClassLoader(), target.getClass().getInterfaces(), this);
	}

}
