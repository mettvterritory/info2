package bpss18.ss18bp06;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * <Betreutes Programmieren 06 - Lottery>
 *
 * Copyright (c) $today.year
 *
 * @author: Samuel Luft
 */
public class Lottery extends Frame implements ActionListener {

  private LotteryButton fields[];
  private int counter;
  private TextField message;

  public Lottery() {
	super("Lottery");
	this.setSize(500, 500);
	this.setLocation(200, 300);
	counter = 0;

	Button playButton = new Button("Play");
	this.add(playButton, BorderLayout.NORTH);
	playButton.addActionListener(this);

	//Panel lotteryButtons
	Panel buttonPanel = new Panel();
	buttonPanel.setLayout(new GridLayout(7, 7, 3, 3));
	fields = new LotteryButton[49];
	for (int i = 0; i < 49; i++) {
	  buttonPanel.add(fields[i] = new LotteryButton((i + 1)));
	  fields[i].addActionListener(this);
	  fields[i].setFont(new Font("Arial", 5, 18));
	}
	this.add(buttonPanel, BorderLayout.CENTER);

	//output message label
	message = new TextField();
	message.setEditable(false);
	this.add(message, BorderLayout.SOUTH);

	this.addWindowListener(new WindowHandler());
	this.setVisible(true);
  }


  @Override
  public void actionPerformed(ActionEvent e) {
	if (e.getSource() instanceof LotteryButton) {
	  //Case 1: LotteryButton Event
	  if (((LotteryButton) e.getSource()).getLabel().equals("X")) {
		// Case 1.1: Click on active LotteryButton
		((LotteryButton) e.getSource()).setLabel("" + ((LotteryButton) e.getSource()).getNumber());
		((LotteryButton) e.getSource()).setForeground(Color.BLACK);
		message.setText("UserInput: Nummer " + ((LotteryButton) e.getSource()).getNumber()
			+ " nicht mehr ausgewaehlt");
		counter--;
	  } else {
		//Case 1.2: Click on inactive LotteryButton
		if (counter >= 6) {
		  //Case 1.2.1: max active LotteryButtons
		  message.setText("Fehler: Maximal 6 aus 49");
		} else {
		  //Case 1.2.2: below max active LotteryButtons
		  ((LotteryButton) e.getSource()).setLabel("X");
		  ((LotteryButton) e.getSource()).setForeground(Color.BLUE);
		  message.setText("UserInput: Nummer " + ((LotteryButton) e.getSource()).getNumber()
			  + "  ist jetzt ausgewaehlt");
		  counter++;
		}
	  }
	} else {
	  //Case 2: PlayButton Event
	  if (counter < 6) {
		//Case 2.1: Too few active LotteryButtons
		message.setText("Fehler: zum Spielen werden 6 Zahlen benoetigt");


	  } else {
		//Case 2.2: valid number of active LotteryButtons
		int lotteryParams[] = new int[6];
		int j = 0;
		for (LotteryButton tmp : fields) {
		  if (tmp.getLabel().equals("X")) {
			lotteryParams[j] = tmp.getNumber();
			j++;
		  }
		}
		message.setText("Gratuliere. Es wurden " + playLottery(lotteryParams) + " aus 49 getroffen");
	  }
	}

  }

  private int playLottery(int lotteryParams[]) {
	int hits = 0;
	int[] rands = new int[6];

	//generating unique random ints
	for (int i = 0; i < 6; ) {
	  int tmp = (int) ((java.lang.Math.random()) * 6 + 1);
	  for (int k : rands) {
		if ((k == 0)) {
		  rands[i] = tmp;
		  i++;
		  break;
		} else if (k == tmp) {
		  break;
		}
	  }

	}
	for (int i = 0; i < 6; i++) {
	    System.out.println("Random number at index: "+ i + " "+ rands[i]);
	}
	for (int checkFor : lotteryParams) {
//	  System.out.println("Layer 1: CheckFor: "+ checkFor);
	  for (int checkAgainst : rands) {
//	    System.out.println("Layer 2: CheckFor: "+ checkFor+ " checkAgainst: "+ checkAgainst);
		if (checkFor == checkAgainst) {
//		  System.out.println("Layer 3: CheckFor: "+ checkFor+ " checkAgainst: "+ checkAgainst);
		  hits++;
		}
	  }
	}
	return hits;

  }


  private class WindowHandler extends WindowAdapter {

	@Override
	public void windowClosing(WindowEvent e) {
	  dispose();
	}
  }

  private class LotteryButton extends Button {

	private int number;

	private LotteryButton(int number) {
	  super("" + number);
	  this.number = number;
	}

	private int getNumber() {
	  return this.number;
	}
  }

  public static void main(String args[]) {
	new Lottery();
  }
}
