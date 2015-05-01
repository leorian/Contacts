package com.lt.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.lt.model.MultiCommponent;
import com.lt.model.PanelFactory;

public class SearchButtonHandler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String str = MultiCommponent.newInstance().returnJTF(1).getText();
		PanelFactory.newInstance().createSearchResultPanel(str);
	}

}
