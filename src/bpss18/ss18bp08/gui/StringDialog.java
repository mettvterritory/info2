package bpss18.ss18bp08.gui;

import bpss18.ss18bp08.data.Colour;
import java.awt.Dialog;
import java.awt.Frame;
import java.util.Observer;
import java.util.Observable;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Color;

public class StringDialog extends Dialog implements Observer {
    private static final long serialVersionUID = 1L;
    private Label lRed, lGreen, lBlue;

    public StringDialog(Frame owner) {
	super(owner);
	setUndecorated(true);
	setLayout(new GridLayout(2, 3));

	add(new Label("Red",Label.CENTER));
	add(new Label("Green",Label.CENTER));
	add(new Label("Blue",Label.CENTER));

	lRed = new Label();
	lRed.setAlignment(Label.CENTER);
	add(lRed);

	lGreen = new Label();
	lGreen.setAlignment(Label.CENTER);
	add(lGreen);

	lBlue = new Label();
	lBlue.setAlignment(Label.CENTER);
	add(lBlue);

	Colour colour = Colour.instance();
	colour.addObserver(this);
	setStrings();

	setSize(200, 100);
	setVisible(true);
    }

    @Override
    public void update(Observable o, Object obj) {
	setStrings();
    }

    private void setStrings() {
	Colour colour = Colour.instance();
	Color c = colour.getColour();
	lRed.setText("" + c.getRed());
	lGreen.setText("" + c.getGreen());
	lBlue.setText("" + c.getBlue());
    }
}