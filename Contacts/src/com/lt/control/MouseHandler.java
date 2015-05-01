package com.lt.control;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import com.lt.model.DBManager;
import com.lt.model.Group;
import com.lt.res.PopupRes;

public class MouseHandler extends MouseAdapter {
	DBManager db = new DBManager();
	@Override
	public void mouseReleased(MouseEvent e) {
		super.mouseReleased(e);
		if(e.getButton()==MouseEvent.BUTTON3)
		{
			PopupRes.CELLPHONE_TEXT = ((JButton)e.getSource()).getText();
			PopupRes.newInstance().transitionGroup.removeAll();
			ArrayList<Group> list = db.getAllGroup();
			JMenuItem[] jmi = new JMenuItem[list.size()];
			for (int i=0; i< list.size();i++)
			{
				jmi[i] = new JMenuItem(list.get(i).getGroupname());
				jmi[i].setForeground(Color.RED);
				jmi[i].addActionListener(new PopupMenuItemHandler());
			}
			for (int i=0; i<jmi.length;i++)
			{
				PopupRes.newInstance().transitionGroup.add(jmi[i]);
			}
			PopupRes.newInstance().transitionGroup.updateUI();
			PopupRes.newInstance().jPopupMenu.show(e.getComponent(),e.getX(),e.getY());
		}
	}
	
}
