package com.lt.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.lt.model.DBManager;
import com.lt.model.MultiCommponent;
import com.lt.model.PanelFactory;
import com.lt.res.DataSave;
import com.lt.res.Strings;

/**
 * @author Administrator
 *对“全部”和“分组”按钮事件进行处理
 */
public class BigButtonHandler implements ActionListener{
	 DBManager db = new DBManager();
	public BigButtonHandler()
	{}
	@Override
	public void actionPerformed(ActionEvent e) {
		DataSave.LIST.clear();
		DataSave.GLIST.clear();
		if(e.getSource() == MultiCommponent.newInstance().returnJB(1))//全部
		{
			MultiCommponent.newInstance().returnJB(1).setText(Strings.T_LEFT_TEXT + "("+db.getPersonCount()+")");
			MultiCommponent.newInstance().returnJB(2).setText(Strings.T_MIDDLE_TEXT+"("+db.getGroupCount()+")");
			this.getClass().getResource("fenzu.png");
			MultiCommponent.newInstance().returnJB(2).setIcon(new ImageIcon(this.getClass().getResource("fenzu.png")));
			MultiCommponent.newInstance().returnJB(4).setText(Strings.B_LEFT_TEXT);
			MultiCommponent.newInstance().returnJB(6).setText(Strings.B_RIGHT_TEXT);	
			PanelFactory.newInstance().createPanel(((JButton)e.getSource()).getText());
		}
		if(e.getSource() == MultiCommponent.newInstance().returnJB(2))//分组
		{
			MultiCommponent.newInstance().returnJB(1).setText(Strings.T_LEFT_TEXT + "("+db.getPersonCount()+")");
			MultiCommponent.newInstance().returnJB(2).setText(Strings.T_MIDDLE_TEXT+"("+db.getGroupCount()+")");
			MultiCommponent.newInstance().returnJB(2).setIcon(new ImageIcon(this.getClass().getResource("fenzu.png")));
			MultiCommponent.newInstance().returnJB(4).setText(Strings.B_LEFT_TEXT_2);
			MultiCommponent.newInstance().returnJB(6).setText(Strings.B_RIGHT_TEXT_2);
			PanelFactory.newInstance().createPanel(((JButton)e.getSource()).getText());
		}
		if(e.getSource() == MultiCommponent.newInstance().returnJB(3))//搜索
		{
			MultiCommponent.newInstance().returnJB(1).setText(Strings.T_LEFT_TEXT + "("+db.getPersonCount()+")");
			MultiCommponent.newInstance().returnJB(2).setText(Strings.T_MIDDLE_TEXT+"("+db.getGroupCount()+")");
			MultiCommponent.newInstance().returnJB(2).setIcon(new ImageIcon(this.getClass().getResource("fenzu.png")));
			MultiCommponent.newInstance().returnJB(4).setText(Strings.B_LEFT_TEXT);
			MultiCommponent.newInstance().returnJB(6).setText(Strings.B_RIGHT_TEXT);
			PanelFactory.newInstance().createSearchPanel(((JButton)e.getSource()).getText());
		}
		if(e.getSource() == MultiCommponent.newInstance().returnJB(4))//新增联系人or新增分组
		{
			MultiCommponent.newInstance().returnJB(1).setText(Strings.T_LEFT_TEXT + "("+db.getPersonCount()+")");
			MultiCommponent.newInstance().returnJB(2).setText(Strings.T_MIDDLE_TEXT+"("+db.getGroupCount()+")");
			if(((JButton)e.getSource()).getText().equals(Strings.B_LEFT_TEXT))
				PanelFactory.newInstance().createADDPersonPanel();
			else if(((JButton)e.getSource()).getText().equals(Strings.B_LEFT_TEXT_2))
				PanelFactory.newInstance().createADDGroupPanel();
		}
		if(e.getSource() == MultiCommponent.newInstance().returnJB(5))//软件版权
		{
			MultiCommponent.newInstance().returnJB(1).setText(Strings.T_LEFT_TEXT + "("+db.getPersonCount()+")");
			MultiCommponent.newInstance().returnJB(2).setText(Strings.T_MIDDLE_TEXT+"("+db.getGroupCount()+")");
			PanelFactory.newInstance().createSoftWareCopyright();
		}
		if(e.getSource() == MultiCommponent.newInstance().returnJB(6))//功能扩展
		{
			MultiCommponent.newInstance().returnJB(1).setText(Strings.T_LEFT_TEXT + "("+db.getPersonCount()+")");
			MultiCommponent.newInstance().returnJB(2).setText(Strings.T_MIDDLE_TEXT+"("+db.getGroupCount()+")");
			if(((JButton)e.getSource()).getText().equals(Strings.B_RIGHT_TEXT))
			{
				PanelFactory.newInstance().createChoseDeletePersonPanel();
			}
			else if(((JButton)e.getSource()).getText().equals(Strings.B_RIGHT_TEXT_2))
			{
				PanelFactory.newInstance().createChoseDeleteGroupPanel();
			}
		}
	}

}
