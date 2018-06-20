package bpss18.ss18bp10.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import bpss18.ss18bp10.store.StoreException;
import bpss18.ss18bp10.store.ParcelStore;

public class ParcelContainer implements Iterable<Parcel> {
    private static ParcelContainer unique = null;
    private List<Parcel> parcels;
    private ParcelStore store = null;

    private ParcelContainer() {
	parcels = new ArrayList<Parcel>();
    }

    public static ParcelContainer instance() {
	if (unique == null)
	    unique = new ParcelContainer();
	return unique;
    }

    public void linkParcel(Parcel p) throws ParcelAlreadyExistsException {
	if (parcels.contains(p))
	    throw new ParcelAlreadyExistsException(p.getTrackingNumber());
	parcels.add(p);
    }

    public void unlinkParcel(Parcel p) throws ParcelNotFoundException {
	if (!parcels.contains(p))
	    throw new ParcelNotFoundException(p.getTrackingNumber());
	parcels.remove(p);
    }

    public void loadParcels(String file) throws StoreException {
	store = new ParcelStore(file);
	ArrayList<Parcel> backup = new ArrayList<Parcel>(parcels);
	parcels.clear();
	try {
	    store.load(unique);
	} catch (StoreException e) {
	    parcels = backup;
	    throw e;
	}
    }

    public void saveParcels(String file) throws StoreException {
	store = new ParcelStore(file);
	store.save(unique);
    }

    public Parcel getParcelByIndex(int pos) {
	return parcels.get(pos);
    }

    public Parcel getParcelByTrackingNumber(String trackingNumber) {
	for (Parcel p : parcels) {
	    if (p.getTrackingNumber().equals(trackingNumber))
		return p;
	}
	return null;
    }

    public Iterator<Parcel> iterator() {
	return parcels.iterator();
    }
}