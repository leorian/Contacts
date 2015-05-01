package com.lt.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import com.lt.model.DBManager;
import com.lt.model.MultiCommponent;
import com.lt.model.PanelFactory;
import com.lt.res.PopupRes;
import com.lt.res.Strings;

public class PopupMenuItemHandler implements ActionListener {
	DBManager db = new DBManager();
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String str = PopupRes.CELLPHONE_TEXT;
		str = str.replace("<html>", ".");
		str = str.replace("<br>", ".");
		if(arg0.getSource()==PopupRes.newInstance().seeingInfo)
		{
			PanelFactory.newInstance().createPersonInfoDisplay(str.split("\\.")[2]);
		}
		else if(arg0.getSource()==PopupRes.newInstance().deletePerson)
		{
			db.deletePersonByCell(str.split("\\.")[2]);
			MultiCommponent.newInstance().returnJB(2).setIcon(new ImageIcon(this.getClass().getResource("fenzu.png")));
			MultiCommponent.newInstance().returnJB(1).setText(Strings.T_LEFT_TEXT+"("+db.getPersonCount()+")");
			PanelFactory.newInstance().createPanel(MultiCommponent.newInstance().returnJB(1).getText());
		}
		else if(arg0.getSource() == PopupRes.newInstance().modifyPerson)
		{
			PanelFactory.newInstance().createModifyDisplayPanel(str.split("\\.")[2]);
		}
		else if(arg0.getSource() == PopupRes.newInstance().addPerson)
		{
			PanelFactory.newInstance().createADDPersonPanel();
		}
		else
		{
			MultiCommponent.newInstance().returnJB(2).setIcon(new ImageIcon(this.getClass().getResource("return.png")));
			db.changeGroup(str.split("\\.")[2],arg0.getActionCommand());
			MultiCommponent.newInstance().returnJB(2).setText(arg0.getActionCommand()+"("+db.getSingleGroupCount(arg0.getActionCommand())+")");
			PanelFactory.newInstance().createGroupPanel(arg0.getActionCommand());
		}
	}

}
