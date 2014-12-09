package cn.edu.printnetwork;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;

public class LocalNetWork {
	public static void main(String[] args) throws SocketException {
		Enumeration<NetworkInterface> networks=NetworkInterface.getNetworkInterfaces();
		
		for(NetworkInterface n : Collections.list(networks)){
			printAddr(n);
		}
	}
	
	public static void printAddr(NetworkInterface netinter){
		Enumeration<InetAddress> address=netinter.getInetAddresses();
		for(InetAddress a:Collections.list(address)){
			System.out.println(a);
		}
	}
}
