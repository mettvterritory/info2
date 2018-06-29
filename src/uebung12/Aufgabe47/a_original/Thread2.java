package uebung12.Aufgabe47.a_original;

public class Thread2 extends Thread {
	private IntValue iv;
	public Thread2(IntValue iv) {
		this.iv = iv;
	}
	public void run() {
		iv.dec();
	}
}