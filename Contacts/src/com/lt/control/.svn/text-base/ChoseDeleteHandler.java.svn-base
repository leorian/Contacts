package com.lt.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.lt.model.DBManager;
import com.lt.model.MultiCommponent;
import com.lt.model.PanelFactory;
import com.lt.res.DataSave;
import com.lt.res.Strings;

public class ChoseDeleteHandler implements ActionListener {
DBManager db = new DBManager();
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == MultiCommponent.newInstance().returnJB(12))
		{
			for(int i=0; i<DataSave.LIST.size();i++)
			{
				db.deletePersonByCell(DataSave.LIST.get(i));
			}
			DataSave.LIST.clear();
			MultiCommponent.newInstance().returnJB(1).setText(Strings.T_LEFT_TEXT+"("+db.getPersonCount()+")");
			PanelFactory.newInstance().createPanel(MultiCommponent.newInstance().returnJB(1).getText());
		}
		if(arg0.getSource() == MultiCommponent.newInstance().returnJB(13))
		{
			DataSave.LIST.clear();
			MultiCommponent.newInstance().returnJB(1).setText(Strings.T_LEFT_TEXT+"("+db.getPersonCount()+")");
			PanelFactory.newInstance().createPanel(MultiCommponent.newInstance().returnJB(1).getText());
		}
		if(arg0.getSource() == MultiCommponent.newInstance().returnJB(14))
		{
			for(int i=0; i<DataSave.GLIST.size();i++)
			{
				db.deleteGroupRelativePerson(DataSave.GLIST.get(i));
			}
			DataSave.GLIST.clear();
			MultiCommponent.newInstance().returnJB(2).setText(Strings.T_MIDDLE_TEXT+"("+db.getGroupCount()+")");
			MultiCommponent.newInstance().returnJB(1).setText(Strings.T_LEFT_TEXT+"("+db.getPersonCount()+")");
			PanelFactory.newInstance().createPanel(MultiCommponent.newInstance().returnJB(2).getText());
		}
		if(arg0.getSource() == MultiCommponent.newInstance().returnJB(15))
		{
			DataSave.GLIST.clear();
			MultiCommponent.newInstance().returnJB(2).setText(Strings.T_MIDDLE_TEXT+"("+db.getGroupCount()+")");
			PanelFactory.newInstance().createPanel(MultiCommponent.newInstance().returnJB(2).getText());
		}

	}

}
