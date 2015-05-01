package com.lt.res;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.border.BevelBorder;

import com.lt.control.PopupMenuGroupItemHandler;
import com.lt.control.PopupMenuItemHandler;
import com.lt.model.DBManager;

public final class PopupRes {
	DBManager db = new DBManager();
	public static PopupRes popup = null;
	public JPopupMenu jPopupMenu = null;
	public JMenuItem seeingInfo = null;//查看详细
	public JMenu transitionGroup = null;//移动到其它分组
	public JMenuItem deletePerson = null;//删除联系人
	public JMenuItem modifyPerson = null;//修改资料
	public JMenuItem addPerson = null;//添加联系人
	public static String CELLPHONE_TEXT = null;
	
	public JPopupMenu groupPopup = null;
	public JMenuItem addNewGroup = null;
	public JMenuItem deleteGroup = null;
	public JMenuItem renameGroup = null;
	public static String GROUP_NAME = null;
	private PopupRes()
	{
		jPopupMenu = new JPopupMenu();
		seeingInfo = new JMenuItem("查看资料");
		transitionGroup = new JMenu("移动到其它分组");
		deletePerson = new JMenuItem("删除联系人");
		modifyPerson = new JMenuItem("修改资料");
		addPerson = new JMenuItem("添加新的联系人");
		jPopupMenu.add(seeingInfo);
		jPopupMenu.addSeparator();
		jPopupMenu.add(transitionGroup);
		jPopupMenu.addSeparator();
		jPopupMenu.add(deletePerson);
		jPopupMenu.addSeparator();
		jPopupMenu.add(modifyPerson);
		jPopupMenu.addSeparator();
		jPopupMenu.add(addPerson);
		jPopupMenu.setBorder(new BevelBorder(BevelBorder.RAISED));
		seeingInfo.setForeground(Color.BLUE);
		transitionGroup.setForeground(Color.BLUE);
		deletePerson.setForeground(Color.BLUE);
		modifyPerson.setForeground(Color.BLUE);
		addPerson.setForeground(Color.BLUE);
		seeingInfo.addActionListener(new PopupMenuItemHandler());
		deletePerson.addActionListener(new PopupMenuItemHandler());
		modifyPerson.addActionListener(new PopupMenuItemHandler());
		addPerson.addActionListener(new PopupMenuItemHandler());
		
		groupPopup = new JPopupMenu();
		addNewGroup = new JMenuItem("添加新分组");
		deleteGroup = new JMenuItem("删除分组(级联删除)");
		renameGroup = new JMenuItem("重命名");
		groupPopup.add(addNewGroup);
		groupPopup.addSeparator();
		groupPopup.add(deleteGroup);
		groupPopup.addSeparator();
		groupPopup.add(renameGroup);
		groupPopup.setBorder(new BevelBorder(BevelBorder.RAISED));
		addNewGroup.setForeground(Color.RED);
		deleteGroup.setForeground(Color.RED);
		renameGroup.setForeground(Color.RED);
		addNewGroup.addActionListener(new PopupMenuGroupItemHandler());
		deleteGroup.addActionListener(new PopupMenuGroupItemHandler());
		renameGroup.addActionListener(new PopupMenuGroupItemHandler());
	}
	public static PopupRes newInstance()
	{
		if(popup == null)
		{
			popup = new PopupRes();
		}
		return popup;
	}
}
