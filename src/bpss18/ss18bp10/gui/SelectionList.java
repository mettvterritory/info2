package bpss18.ss18bp10.gui;

import java.awt.List;

public class SelectionList extends List {
    private static final long serialVersionUID = 1L;

    public String getCheckedSelectedItem() throws NoSelectionException {
	String tmp = super.getSelectedItem();
	if (tmp == null)
	    throw new NoSelectionException(this);
	return tmp;
    }

    public int getCheckedSelectedIndex() throws NoSelectionException {
	int tmp = super.getSelectedIndex();
	if (tmp == -1)
	    throw new NoSelectionException(this);
	return tmp;
    }
}