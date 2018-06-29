package uebung12.Aufgabe46;

public class PrintThread extends Thread {

	private boolean stop = false;
	private String ausgabe;
	
	public PrintThread(String ausgabe) {
		this.ausgabe = ausgabe;
	}
	public void run() {
		while(!stop) {
			System.out.println(ausgabe);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				System.out.println("Thread unterbrochen");
			}
		}
	}
	
	public void kill() {
		stop = true;
		System.out.println("Thread angehalten");
	}
}
