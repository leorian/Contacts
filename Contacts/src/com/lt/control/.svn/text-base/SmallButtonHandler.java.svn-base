package com.lt.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import com.lt.model.MultiCommponent;
import com.lt.model.PanelFactory;
import com.lt.res.Strings;

/**
 * @author Administrator
 *对各个组按钮事件进行处理
 */
public class SmallButtonHandler implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		MultiCommponent.newInstance().returnJB(4).setText(Strings.B_LEFT_TEXT);
		MultiCommponent.newInstance().returnJB(6).setText(Strings.B_RIGHT_TEXT);
		String string =e.getActionCommand().substring(0, e.getActionCommand().lastIndexOf(")")+1);
		MultiCommponent.newInstance().returnJB(2).setText(string);
		MultiCommponent.newInstance().returnJB(2).setIcon(new ImageIcon(this.getClass().getResource("return.png")));
		String str = e.getActionCommand().substring(0, e.getActionCommand().lastIndexOf("("));
		PanelFactory.newInstance().createGroupPanel(str);
	}

}
