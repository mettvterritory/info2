package bpss18.ss18bp05;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Scrollbar;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.zip.DataFormatException;

/**
 * <TodoManager - BP05>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class TodoManager extends Frame {

  private Button addTaskButton;
  private Button getTaskButton;
  private TaskManager manager;
  private int priority = 1;
  private Scrollbar prioritySlider;
  private TextField descriptionBox;
  private Choice typeChoice;
  private Label priorityLabel;

  public TodoManager() {
	super("TodoManager");
	manager = new TaskManager();
	this.setLocation(300, 200);
	this.setSize(900, 200);
	this.setLayout(new GridLayout(4, 2, 4, 4));

	//Description and Textbox

	this.add(new Label("Description:"));
	descriptionBox = new TextField();
	this.add(descriptionBox);

	//Priority Slider

	priorityLabel = new Label("Priority: " + priority);
	this.add(priorityLabel);
	prioritySlider = new Scrollbar(Scrollbar.HORIZONTAL, 1, 1, 1, 6);
	prioritySlider.setBackground(Color.white);
	prioritySlider.setForeground(Color.blue);
	prioritySlider.addAdjustmentListener(new AdjustmentListener() {
	  @Override
	  public void adjustmentValueChanged(AdjustmentEvent e) {
		priority = prioritySlider.getValue();
		priorityLabel.setText("Priority: " + priority);
	  }
	});
	this.add(prioritySlider);

	//Type Selector
	this.add(new Label("Type:"));
	typeChoice = new Choice();
	typeChoice.add("Universität");
	typeChoice.add("Privat");
	this.add(typeChoice);

	//Panel for Buttons
	addTaskButton = new Button("add Task");
	getTaskButton = new Button("get Task");
	getTaskButton.addActionListener(new ActionListener() {
	  @Override
	  public void actionPerformed(ActionEvent e) {
		new TodoDialog(TodoManager.this, manager.getMostUrgent());
	  }
	});
	addTaskButton.addActionListener(new ActionListener() {
	  @Override
	  public void actionPerformed(ActionEvent e) {
		try {
		  if (typeChoice.getSelectedItem().equals("Universität")) {
			manager.addTask(new UniversityTask(descriptionBox.getText(), priority));
		  } else if (typeChoice.getSelectedItem().equals("Privat")) {
			manager.addTask((new PrivateTask(descriptionBox.getText(), priority)));
		  } else {
			//TODO: this shouldn't happen
		  }
		} catch (DataFormatException ex) {
		  new TodoDialog(TodoManager.this, ex);
		}
		//descriptionBox.setText("");
		priority = 1;
		priorityLabel.setText("Priorität: " + priority);
		prioritySlider.setValue(1);
		typeChoice.select("Universität");

	  }
	});
	this.add(addTaskButton);
	this.add(getTaskButton);
	//WindowCloser
	this.addWindowListener(new WindowAdapter() {
	  @Override
	  public void windowClosing(WindowEvent e) {
		dispose();
	  }
	});
	this.setVisible(true);

  }


}
