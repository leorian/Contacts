package com.lt.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.lt.model.DBManager;
import com.lt.model.MultiCommponent;
import com.lt.model.PanelFactory;
import com.lt.res.AddJTFRes;
import com.lt.res.Strings;

public class DeleteModifyHandler implements ActionListener{
	DBManager db = new DBManager();
	@Override
	public void actionPerformed(ActionEvent e) {
		if(((JButton)e.getSource()).getText().equals(Strings.DELETE_TEXT_JB))
		{
			db.deletePersonByCell(AddJTFRes.PERSON);
			MultiCommponent.newInstance().returnJB(1).setText(Strings.T_LEFT_TEXT+"("+db.getPersonCount()+")");
			PanelFactory.newInstance().createPanel(MultiCommponent.newInstance().returnJB(1).getText());
		}
		else if(((JButton)e.getSource()).getText().equals(Strings.MODIFY_TEXT_JB))
		{
			PanelFactory.newInstance().createModifyDisplayPanel(AddJTFRes.PERSON);
		}
	}

}
