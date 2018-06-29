package uebung12.Aufgabe47.a_ii;

public class Thread1 extends Thread {
	private IntValue iv;
	public Thread1(IntValue iv) {
		this.iv = iv;
	}
	public void run() {
		iv.inc();
	}
}
