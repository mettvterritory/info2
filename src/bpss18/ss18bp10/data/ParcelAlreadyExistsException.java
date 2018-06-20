package bpss18.ss18bp10.data;

public class ParcelAlreadyExistsException extends Exception {
    private static final long serialVersionUID = 1L;

    public ParcelAlreadyExistsException(String tn) {
	super("Existing parcel with tracking number " + tn);
    }
}