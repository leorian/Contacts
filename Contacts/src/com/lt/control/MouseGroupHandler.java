package com.lt.control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import com.lt.res.PopupRes;

public class MouseGroupHandler extends MouseAdapter{

	@Override
	public void mouseReleased(MouseEvent e) {
		super.mouseReleased(e);
		if(e.getButton()==MouseEvent.BUTTON3)
		{
			String str = ((JButton)e.getSource()).getText();
			PopupRes.GROUP_NAME = str.substring(0, str.lastIndexOf("("));
			PopupRes.newInstance().groupPopup.show(e.getComponent(), e.getX(), e.getY());
		}
	}
	
}
