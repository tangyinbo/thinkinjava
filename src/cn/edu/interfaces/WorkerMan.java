package cn.edu.interfaces;

import java.util.Scanner;

public class WorkerMan implements Worker {

	@Override
	public void run() {
		System.out.println("work is run...");
	}

	@Override
	public void work() {
		System.out.println("work working....");
	}

	public static void main(String[] args) {
		Human human  = new WorkerMan();
		System.out.println(human instanceof WorkerMan);
	}

	private static void tt() {
		Human h = new WorkerMan();
		h.run();
		Worker w = new WorkerMan();
		w.work();
		Scanner s = new Scanner(System.in);
		String y = s.nextLine();
		System.out.println(y);
	}
}
