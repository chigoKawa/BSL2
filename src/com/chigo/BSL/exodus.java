package com.chigo.BSL;

public class exodus extends Thread {
	Consumer cons = new Consumer();
	
	public synchronized void run() {
		cons.start();
	}
	
	public void close() {
		try {
			cons.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cons.stop4();
	}

}
