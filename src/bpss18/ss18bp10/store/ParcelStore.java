package bpss18.ss18bp10.store;

import bpss18.ss18bp10.data.InvalidTrackingNumberException;
import bpss18.ss18bp10.data.InvalidWeightClassException;
import bpss18.ss18bp10.data.Parcel;
import bpss18.ss18bp10.data.ParcelAlreadyExistsException;
import bpss18.ss18bp10.data.ParcelContainer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * <Filename>
 *
 * Copyright (c) 20/06/2018
 *
 * @author: Samuel Luft
 */
public class ParcelStore {

  private String filename;

  public ParcelStore(String filename) throws StoreException {
	if (filename == null) {
	  throw new StoreException("no filename", null);
	}
	this.filename = filename;
  }

  public void load(ParcelContainer container) throws StoreException {
	try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
	  Parcel newParcel = null;

	  String newTrackingNumber;
	  int newWeightClass;
	  String newStatus;

	  String line = reader.readLine();
	  if (line == null) {
		return;
	  }
	  while (!line.equals("end")) {
		if (line.equals("new")) {
		  try {

			line = reader.readLine();
			if (line == null) {
			  throw new StoreException("Invalid fomat", null);
			}
			newTrackingNumber = line;

			line = reader.readLine();
			if (line == null) {
			  throw new StoreException("Invalid fomat", null);
			}
			newWeightClass = Integer.parseInt(line);

			line = reader.readLine();
			if (line == null) {
			  throw new StoreException("Invalid fomat", null);
			}
			newStatus = line;

			newParcel = new Parcel(newTrackingNumber);
			newParcel.setWeightClass(newWeightClass);
			newParcel.setStatus(newStatus);
			container.linkParcel(newParcel);


		  } catch (InvalidTrackingNumberException ex) {
			System.out.println(ex.getMessage());
			throw new StoreException(ex.getMessage(), ex);
		  } catch (InvalidWeightClassException ex) {
			System.out.println(ex.getMessage());
			throw new StoreException(ex.getMessage(), ex);
		  } catch (ParcelAlreadyExistsException ex) {
			System.out.println(ex.getMessage());
			throw new StoreException(ex.getMessage(), ex);
		  }
		  line = reader.readLine();
		  if (line == null) {
			throw new StoreException("invalid format", null);
		  }
		} else {
		  throw new StoreException("invalid format", null);
		}
	  }
	} catch (IOException ex) {
	  System.out.println("There was an Error reading from File. " + ex.getMessage());
	  throw new StoreException(ex.getMessage(), ex);
	}
  }

  public void save(ParcelContainer container) throws StoreException {
	File f = new File(filename);
	try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(f)))) {
	  for (Parcel iterate : container) {
		writer.println("new");
		writer.println(iterate.getTrackingNumber());
		writer.println(iterate.getWeightClass());
		writer.println(iterate.getStatus());
	  }
	  writer.println("end");
	}catch (IOException ex){
	  System.out.println("Writing to file failed: "+ ex.getMessage());
	}

  }
}



