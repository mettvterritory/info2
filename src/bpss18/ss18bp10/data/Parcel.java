package bpss18.ss18bp10.data;

public class Parcel {
    private String trackingNumber;
    private int weightClass;
    private String status;

    public Parcel(String trackingNumber) throws InvalidTrackingNumberException {
	setTrackingNumber(trackingNumber);
    }

    public String getTrackingNumber() {
	return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
	this.trackingNumber = trackingNumber;
    }

    public String toString() {
	return getTrackingNumber() + " (weight class: " + getWeightClass() + " - status: " + getStatus() + ")";
    }

    public boolean equals(Object o) {
	if (o != null) {
	    if (o.getClass().equals(getClass())) {
		Parcel s = (Parcel) o;
		return s.getTrackingNumber().equals(this.getTrackingNumber());
	    }
	}
	return false;
    }

    public int getWeightClass() {
	return weightClass;
    }

    public void setWeightClass(int weightClass) throws InvalidWeightClassException {
	if (weightClass < 1 || weightClass > 3)
	    throw new InvalidWeightClassException(weightClass);
	this.weightClass = weightClass;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	if (status == null || status.equals(""))
	    this.status = "invalid";
	else
	    this.status = status;
    }
}