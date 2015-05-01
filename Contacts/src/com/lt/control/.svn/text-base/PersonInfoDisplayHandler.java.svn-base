package com.lt.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.lt.model.PanelFactory;

public class PersonInfoDisplayHandler implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String str =((JButton)e.getSource()).getText();
		str = str.replace("<html>", ".");
		str = str.replace("<br>", ".");
		str = str.split("\\.")[2];
		PanelFactory.newInstance().createPersonInfoDisplay(str);
	}

}
