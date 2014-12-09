package cn.edu.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest implements MyInterface {
	public static void main(String[] args) {
		MyInterface proxyTest =(MyInterface) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(),new Class[]{MyInterface.class},new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println(proxy);
				System.out.println(method);
				System.out.println(args);
				method.invoke(new ProxyTest(), args);
				return null;
			};
		});
		proxyTest.say("hehe");
	}

	@Override
	public void say(String s) {
		System.out.println("hello:"+s);
	}
}
