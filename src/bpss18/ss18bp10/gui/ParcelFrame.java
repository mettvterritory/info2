package bpss18.ss18bp10.gui;

import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.TextField;
import java.awt.Panel;
import java.awt.GridLayout;
import java.awt.Button;
import java.awt.FileDialog;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import bpss18.ss18bp10.data.InvalidTrackingNumberException;
import bpss18.ss18bp10.data.InvalidWeightClassException;
import bpss18.ss18bp10.data.Parcel;
import bpss18.ss18bp10.data.ParcelAlreadyExistsException;
import bpss18.ss18bp10.data.ParcelContainer;
import bpss18.ss18bp10.data.ParcelNotFoundException;
import bpss18.ss18bp10.store.StoreException;

import java.awt.event.ActionEvent;

public class ParcelFrame extends Frame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private NonEmptyTextField trackingNumberTextField;
    private ChoiceOtherThan weightClassChoice;
    private ChoiceOtherThan statusChoice;
    private SelectionList parcelList;
    private TextField statusTextField;
    private ParcelContainer container;
    private Parcel subject;

    public ParcelFrame() {
	super("Parcel Management");
	container = ParcelContainer.instance();

	MenuBar frameMb = new MenuBar();
	Menu fileM = new Menu("File");
	MenuItem loadMi = new MenuItem("Load...");
	loadMi.addActionListener(this);
	fileM.add(loadMi);
	MenuItem saveMi = new MenuItem("Save...");
	saveMi.addActionListener(this);
	fileM.add(saveMi);
	frameMb.add(fileM);
	setMenuBar(frameMb);

	Panel controlPanel = new Panel();
	controlPanel.setLayout(new GridLayout(0, 4));
	Button b;
	Panel p;
	b = new Button("New");
	b.addActionListener(this);
	controlPanel.add(b);
	p = new Panel();
	p.add(new Label("Tracking Number"));
	trackingNumberTextField = new NonEmptyTextField(12);
	trackingNumberTextField.setEnabled(false);
	p.add(trackingNumberTextField);
	controlPanel.add(p);
	p = new Panel();
	p.add(new Label("Weight Class"));
	weightClassChoice = new ChoiceOtherThan(0);
	weightClassChoice.addItem("");
	weightClassChoice.addItem("1");
	weightClassChoice.addItem("2");
	weightClassChoice.addItem("3");
	weightClassChoice.setEnabled(false);
	p.add(weightClassChoice);
	controlPanel.add(p);
	p = new Panel();
	p.add(new Label("Status"));
	statusChoice = new ChoiceOtherThan(0);
	statusChoice.addItem("");
	statusChoice.addItem("announced");
	statusChoice.addItem("in centre");
	statusChoice.addItem("on delivery");
	statusChoice.addItem("delivered");
	statusChoice.setEnabled(false);
	p.add(statusChoice);
	controlPanel.add(p);
	b = new Button("Select");
	b.addActionListener(this);
	controlPanel.add(b);
	b = new Button("Update");
	b.addActionListener(this);
	controlPanel.add(b);
	b = new Button("Add");
	b.addActionListener(this);
	controlPanel.add(b);
	b = new Button("Delete");
	b.addActionListener(this);
	controlPanel.add(b);
	parcelList = new SelectionList();
	parcelList.addActionListener(this);
	refreshParcelList();
	statusTextField = new TextField("Hit a button");
	setLayout(new BorderLayout());
	add(controlPanel, BorderLayout.NORTH);
	add(parcelList, BorderLayout.CENTER);
	add(statusTextField, BorderLayout.SOUTH);
	addWindowListener(new WindowAdapter() {
	    public void windowClosing(WindowEvent e) {
		dispose();
		System.exit(0);
	    }
	});
	pack();
	setVisible(true);
    }

    private void setMessage(String s) {
	if (s != null)
	    statusTextField.setText(s);
	else
	    statusTextField.setText("");
    }

    private void refreshParcelList() {
	parcelList.removeAll();
	for (Parcel p : container)
	    parcelList.add(p.toString());
    }

    private void enableUserInput(boolean status) {
	this.trackingNumberTextField.setEnabled(status);
	this.weightClassChoice.setEnabled(status);
	this.statusChoice.setEnabled(status);
    }

    private void clearUserInput() {
	trackingNumberTextField.setEmptyText();
	;
	weightClassChoice.selectInvalid();
	;
	statusChoice.selectInvalid();
    }

    public void actionPerformed(ActionEvent e) {
	if (e.getActionCommand().equals("Load..."))
	    onLoad();
	else if (e.getActionCommand().equals("Save..."))
	    onSave();
	else {
	    boolean isNew = e.getActionCommand().equals("New");
	    boolean isAdd = e.getActionCommand().equals("Add");
	    boolean isSelect = e.getActionCommand().equals("Select") || e.getSource().equals(parcelList);
	    boolean isUpdate = e.getActionCommand().equals("Update");
	    boolean isDelete = e.getActionCommand().equals("Delete");
	    setMessage(null);
	    try {
		if (isNew) {
		    clearUserInput();
		    enableUserInput(true);
		    setMessage("Add new parcel");
		}
		if (isAdd) {
		    subject = new Parcel(trackingNumberTextField.getCheckedText());
		    subject.setWeightClass(weightClassChoice.getCheckedSelectedIndex());
		    subject.setStatus(statusChoice.getCheckedSelectedItem());
		    container.linkParcel(subject);
		    clearUserInput();
		    enableUserInput(false);
		    refreshParcelList();
		    setMessage("Parcel " + subject.getTrackingNumber() + " added");
		}

		if (isSelect) {
		    subject = container.getParcelByIndex(parcelList.getCheckedSelectedIndex());
		    trackingNumberTextField.setText(subject.getTrackingNumber());
		    enableUserInput(true);
		    trackingNumberTextField.setEnabled(false);
		    weightClassChoice.select(Integer.toString(subject.getWeightClass()));
		    statusChoice.select(subject.getStatus());
		    setMessage("Parcel " + subject.getTrackingNumber() + " selected");
		}

		if (isUpdate) {
		    subject = container.getParcelByTrackingNumber(trackingNumberTextField.getCheckedText());
		    subject.setWeightClass(weightClassChoice.getCheckedSelectedIndex());
		    subject.setStatus(statusChoice.getSelectedItem());
		    clearUserInput();
		    enableUserInput(false);
		    refreshParcelList();
		    setMessage("Parcel " + subject.getTrackingNumber() + " updated");
		}

		if (isDelete) {
		    subject = container.getParcelByIndex(parcelList.getCheckedSelectedIndex());
		    container.unlinkParcel(subject);
		    clearUserInput();
		    enableUserInput(false);
		    refreshParcelList();
		    setMessage("Parcel " + subject.getTrackingNumber() + " deleted");
		}
	    } catch (EmptyTextException error) {
		setMessage("Tracking number must not be empty");
	    } catch (NonValidIndexException error) {
		if (error.getSource() == weightClassChoice)
		    setMessage("Weight class must be selected");
		if (error.getSource() == statusChoice)
		    setMessage("Status must be selected");
	    } catch (ParcelAlreadyExistsException error) {
		setMessage("Tracking number already exists");
	    } catch (NoSelectionException error) {
		setMessage("No parcel selected");
	    } catch (ParcelNotFoundException error) {
		setMessage("No parcel existing with this tracking number");
	    } catch (InvalidTrackingNumberException error) {
		setMessage("Tracking number is invalid");
	    } catch (InvalidWeightClassException error) {
		setMessage("Weight class is invalid");
	    }
	}
    }

    private void onLoad() {
	FileDialog fd = new FileDialog(this, "Load Parcels...", FileDialog.LOAD);
	fd.setVisible(true);
	if (fd.getFile() != null) {
	    String file = fd.getDirectory() + fd.getFile();
	    try {
		container.loadParcels(file);
		setMessage("Parcels loaded successfully");
	    } catch (StoreException e) {
		setMessage("Load error: " + e.getMessage());
	    } finally {
		refreshParcelList();		
	    }
	} else
	    setMessage("No file selected for loading!!!");
    }

    private void onSave() {
	FileDialog fd = new FileDialog(this, "Save Parcels...", FileDialog.SAVE);
	fd.setVisible(true);
	if (fd.getFile() != null) {
	    String file = fd.getDirectory() + fd.getFile();
	    try {
		container.saveParcels(file);
		setMessage("Parcels saved successfully");
	    } catch (StoreException e) {
		setMessage("Save error: " + e.getMessage());
	    }
	} else
	    setMessage("No file selected for saving!!!");
    }
}