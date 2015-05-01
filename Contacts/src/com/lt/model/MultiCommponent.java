package com.lt.model;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.lt.control.ChoseDeleteHandler;
import com.lt.control.DeleteModifyHandler;
import com.lt.control.ModifyHandler;
import com.lt.control.SearchButtonHandler;
import com.lt.res.Strings;
import com.lt.res.Style;

public class MultiCommponent {
	private static MultiCommponent jbfactory = null;
	private JButton T_LEFT = null;
	private JButton T_MIDDLE = null; 
	private JButton T_RIGHT = null;  
	private JButton B_LEFT = null;
	private JButton B_MIDDLE = null; 
	private JButton B_RIGHT = null;
	private JTextField SEARCH_JTF = null;
	private JButton SEARCH_JB = null;
	private JPanel SEARCH_RESULT_JP = null;
	private JButton DELETE_JB = null;
	private JButton MODIFY_JB = null;
	private JButton MODIFY_SAVE_JB = null;
	private JButton MODIFY_CANCEL_JB = null;
	private JButton CHOSE_DEL_P_S_JB = null;
	private JButton CHOSE_DEL_P_C_JB = null;
	private JButton CHOSE_DEL_G_S_JB = null;
	private JButton CHOSE_DEL_G_C_JB = null;
	private MultiCommponent(){
		ImageIcon all = new ImageIcon(this.getClass().getResource("all.png"));
		ImageIcon fenzu = new ImageIcon(this.getClass().getResource("fenzu.png"));
		ImageIcon search = new ImageIcon(this.getClass().getResource("search.png"));
		T_LEFT = new JButton(Strings.T_LEFT_TEXT);
		T_MIDDLE = new JButton(Strings.T_MIDDLE_TEXT);
		T_RIGHT = new JButton(Strings.T_RIGHT_TEXT);
		B_LEFT = new JButton(Strings.B_LEFT_TEXT);
		B_MIDDLE = new JButton(Strings.B_MIDDLE_TEXT);
		B_RIGHT = new JButton(Strings.B_RIGHT_TEXT);
		SEARCH_JTF = new JTextField();
		SEARCH_JB = new JButton(Strings.SEARCH_JB_TEXT);
		SEARCH_RESULT_JP = new JPanel();
		SEARCH_JB.addActionListener(new SearchButtonHandler());
		DELETE_JB = new JButton(Strings.DELETE_TEXT_JB);
		MODIFY_JB = new JButton(Strings.MODIFY_TEXT_JB);
		MODIFY_SAVE_JB = new JButton(Strings.MODIFY_SAVE_TEXT);
		MODIFY_CANCEL_JB = new JButton(Strings.MODIFY_CANCEL_TEXT);
		DELETE_JB.addActionListener(new DeleteModifyHandler());
		MODIFY_JB.addActionListener(new DeleteModifyHandler());
		MODIFY_SAVE_JB.addActionListener(new ModifyHandler());
		MODIFY_CANCEL_JB.addActionListener(new ModifyHandler());
		T_LEFT.setIcon(all);
		T_MIDDLE.setIcon(fenzu);
		T_RIGHT.setIcon(search);
		B_LEFT.setForeground(Color.BLUE);
		B_MIDDLE.setForeground(Color.BLUE);
		B_RIGHT.setForeground(Color.BLUE);
		T_LEFT.setForeground(Color.BLUE);
		T_MIDDLE.setForeground(Color.BLUE);
		T_RIGHT.setForeground(Color.BLUE);
		T_LEFT.setBackground(Style.BG);
		T_MIDDLE.setBackground(Style.BG);
		T_RIGHT.setBackground(Style.BG);
		B_LEFT.setBackground(Style.BG);
		B_MIDDLE.setBackground(Style.BG);
		B_RIGHT.setBackground(Style.BG);
		CHOSE_DEL_P_S_JB = new JButton("删除");
		CHOSE_DEL_P_C_JB = new JButton("取消");
		CHOSE_DEL_G_S_JB = new JButton("删除");
		CHOSE_DEL_G_C_JB = new JButton("取消");
		CHOSE_DEL_P_S_JB.addActionListener(new ChoseDeleteHandler());
		CHOSE_DEL_P_C_JB.addActionListener(new ChoseDeleteHandler());
		CHOSE_DEL_G_S_JB.addActionListener(new ChoseDeleteHandler());
		CHOSE_DEL_G_C_JB.addActionListener(new ChoseDeleteHandler());
	}
	public static MultiCommponent newInstance()
	{
		if(jbfactory == null)
		{
			jbfactory = new MultiCommponent();
		}
		return jbfactory;
	}
	
	/**
	 * @param n
	 * @return JButton
	 * 函数功能：主要是为了给外界提供统一的接口
	 * 提供程序共享的按钮
	 */
	public JButton returnJB(int n)
	{
		JButton value = null;
		switch (n) {
		case 1:
			value =  T_LEFT;
			break;
		case 2:
			value = T_MIDDLE;
			break;
		case 3:
			value = T_RIGHT;
			break;
		case 4:
			value = B_LEFT;
			break;
		case 5:
			value = B_MIDDLE;
			break;
		case 6:
			value = B_RIGHT;
			break;
		case 7:
			value = SEARCH_JB;
			break;
		case 8:
			value = DELETE_JB;
			break;
		case 9:
			value = MODIFY_JB;
			break;
		case 10:
			value = MODIFY_SAVE_JB;
			break;
		case 11:
			value = MODIFY_CANCEL_JB;
			break;
		case 12:
			value = CHOSE_DEL_P_S_JB;
			break;
		case 13:
			value = CHOSE_DEL_P_C_JB;
			break;
		case 14:
			value = CHOSE_DEL_G_S_JB;
			break;
		case 15:
			value = CHOSE_DEL_G_C_JB;
			break;
		default:
			break;
		}
		return value;
	}
	/**
	 * @param n
	 * @return JTextField
	 */
	public JTextField returnJTF(int n)
	{
		JTextField value = null;
		switch (n) {
		case 1:
			value = SEARCH_JTF;
			break;

		default:
			break;
		}
		return value;
	}
	public JPanel returnJP(int n)
	{
		JPanel value = null;
		switch (n) {
		case 1:
			value = SEARCH_RESULT_JP;
			break;

		default:
			break;
		}
		return value;
	}
}
