package bpss18.ss18bp10.data;

public class InvalidTrackingNumberException extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidTrackingNumberException() {
	super("Tracking number must not be empty");
    }
}