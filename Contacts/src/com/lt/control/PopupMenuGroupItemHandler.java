package com.lt.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.lt.model.DBManager;
import com.lt.model.MultiCommponent;
import com.lt.model.PanelFactory;
import com.lt.res.PopupRes;
import com.lt.res.Strings;

public class PopupMenuGroupItemHandler implements ActionListener {
	DBManager db = new DBManager();
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == PopupRes.newInstance().addNewGroup)
		{
			PanelFactory.newInstance().createADDGroupPanel();
		}
		if(arg0.getSource() == PopupRes.newInstance().deleteGroup)
		{
			db.deleteGroupRelativePerson(PopupRes.GROUP_NAME);
			MultiCommponent.newInstance().returnJB(1).setText(Strings.T_LEFT_TEXT+"("+db.getPersonCount()+")");
			PanelFactory.newInstance().createPanel(MultiCommponent.newInstance().returnJB(2).getText());
		}
		if(arg0.getSource() == PopupRes.newInstance().renameGroup)
		{
			String groupName = JOptionPane.showInputDialog("新的组名：");
			if(groupName!=null  && !groupName.equals(""))
					{
						db.renameGroupName(PopupRes.GROUP_NAME,groupName);
					}
			MultiCommponent.newInstance().returnJB(2).setText("分组"+"("+db.getGroupCount()+")");
			PanelFactory.newInstance().createPanel(MultiCommponent.newInstance().returnJB(2).getText());
		}
	}

}
