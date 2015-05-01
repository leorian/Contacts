package com.lt.res;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.lt.control.SaveGroupHandler;
import com.lt.control.SavePersonHadler;
public final class AddJTFRes {
	private static AddJTFRes addJTFRes = null;
	public JTextField USEARNAME = null;
	public static String SEX = null;
	public JTextField CELLPHONE = null;
	public JTextField QQNUMBER = null;
	public JTextField EMAIL = null;
	public static String _GROUP_NAME = null;
	public JButton SAVE = null;
	
	public JTextField NEWGROUP = null;
	public JButton SAVAGROUP = null;
	
	public static String PERSON = null;
	private AddJTFRes()
	{
		 USEARNAME = new JTextField(20);
		 USEARNAME.setForeground(Color.RED);
		 CELLPHONE = new JTextField(20);
		 CELLPHONE.setForeground(Color.RED);
		 QQNUMBER = new JTextField(20);
		 QQNUMBER.setForeground(Color.RED);
		 EMAIL = new JTextField(20);
		 EMAIL.setForeground(Color.RED);
		 SAVE = new JButton("保存联系人信息");
		 NEWGROUP = new JTextField(20);
		 NEWGROUP.setForeground(Color.RED);
		 SAVAGROUP  = new JButton("保存分组");
		 SAVE.addActionListener(new SavePersonHadler());
		 SAVAGROUP.addActionListener(new SaveGroupHandler());
	}
	
	public static AddJTFRes newInstance()
	{
		if(addJTFRes == null)
		{
			addJTFRes = new AddJTFRes();
		}
		return addJTFRes;
	}
}
