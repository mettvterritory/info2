package bpss18.ss18bp10.data;

public class ParcelNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public ParcelNotFoundException(String tn) {
	super("There is no parcel with tracking number " + tn);
    }
}