package uebung12.Aufgabe47.a_original;

public class IntValue {
	
	public int value = 0;
	public void inc() {
		value += 1;
	}
	public void dec() {
		value -= 10;
	}
	public void print() {
		System.out.print(value);
	}

	public static void main(String[] args) {
		IntValue v = new IntValue();
		Thread1 t1 = new Thread1(v);
		Thread2 t2 = new Thread2(v);
		t1.start();
		t2.start();
		v.print();
	}
}
