package bpss18.ss18bp10.gui;

import java.awt.Choice;

public class ChoiceOtherThan extends Choice {
    private static final long serialVersionUID = 1L;
    private int invalidIndex;

    public ChoiceOtherThan(int invalidIndex) {
	super();
	this.invalidIndex = invalidIndex;
    }

    public int getCheckedSelectedIndex() throws NonValidIndexException {
	int tmp = super.getSelectedIndex();
	if (tmp == invalidIndex)
	    throw new NonValidIndexException(this);
	return tmp;
    }

    public String getCheckedSelectedItem() throws NonValidIndexException {
	if (super.getSelectedIndex() == invalidIndex)
	    throw new NonValidIndexException(this);
	return super.getSelectedItem();
    }

    public void selectInvalid() {
	super.select(invalidIndex);
    }
}