package bpss18.ss18bp10.data;

public class InvalidWeightClassException extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidWeightClassException(int wc) {
	super("Invalid weight class " + wc);
    }
}