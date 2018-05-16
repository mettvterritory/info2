package bpss18.ss18bp05;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.zip.DataFormatException;

/**
 * <Filename>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class TodoDialog extends Dialog {
  private Button okButton;
  private Label textLabel;
  public TodoDialog(TodoManager owner, Task task) {
	super(owner);
	this.setLocation(400, 300);
	this.setSize(100, 50);
	if (task == null) {
	  setTitle("Free Time");
	  textLabel = new Label("Nothing to do!");
	} else {
	  setTitle("Next task");
	  switch (task.getPriorityType()){
		case 1:	textLabel = new Label("Universität: "+ task.getDescription());
		break;
		case 2:	textLabel = new Label("Privat: "+ task.getDescription());
	  }
	}
	this.add(textLabel, BorderLayout.NORTH);
	okButton = new Button("OK");
	okButton.addActionListener(new ActionListener() {
	  @Override
	  public void actionPerformed(ActionEvent e) {
		dispose();
	  }
	});
	this.add(okButton, BorderLayout.SOUTH);
	pack();
	this.setVisible(true);
  }

  public TodoDialog(TodoManager owner, DataFormatException dfe) {
	super(owner);
	this.setLocation(400, 300);
	this.setSize(100, 50);
	setTitle("Exception");
	textLabel = new Label(dfe.getMessage());
	this.add(textLabel, BorderLayout.NORTH);
	okButton = new Button("OK");
	okButton.addActionListener(new ActionListener() {
	  @Override
	  public void actionPerformed(ActionEvent e) {
		dispose();
	  }
	});
	this.add(okButton, BorderLayout.SOUTH);
	pack();
	this.setVisible(true);


  }


}
