package com.lt.model;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import com.lt.control.*;
import com.lt.res.*;
public class PanelFactory {
	
	DBManager db = new DBManager();
	private static PanelFactory panelFactory= null;
	private static JPanel panel = new JPanel();
	public static PanelFactory newInstance()
	{
		if(panelFactory == null)
		{
			panelFactory = new PanelFactory();
		}
		return panelFactory;
	}
	/**
	 * 此处还未完善,属于软件的欢迎界面
	 */
	private PanelFactory()
	{
		panel.setBackground(Style.WHOLEBG);
		MultiCommponent.newInstance().returnJB(1).setText(Strings.T_LEFT_TEXT+"("+db.getPersonCount()+")");
		MultiCommponent.newInstance().returnJB(2).setText(Strings.T_MIDDLE_TEXT+"("+db.getGroupCount()+")");
		JLabel jt = new JLabel("<html><h3 color='white'>欢迎使用洛天工作室通讯录</h3></html>");
		JLabel image = new JLabel(new ImageIcon(this.getClass().getResource("zhuti.jpg")));
		image.setBorder(BorderFactory.createLineBorder(Color.RED));
		panel.add(jt);
		panel.add(image);
	}
	
	/**
	 * @param str
	 * @return JPanel
	 * 创建所有联系人列表项
	 * 和
	 * 所有组名称的列表项
	 */
	public JPanel createPanel(String str)
	{
		
		
		if(str == MultiCommponent.newInstance().returnJB(1).getText())
		{
			MultiCommponent.newInstance().returnJB(2).setText(Strings.T_MIDDLE_TEXT+"("+db.getGroupCount()+")");
			panel.removeAll();
			ArrayList<Person> list = db.getAllResult();//得到全部的联系人
			String[][] info = new String[list.size()][2];
			JButton[] jButton = new JButton[list.size()];
			JPanel temp = new JPanel();
			if(list.size() < 8)
			{
				temp.setLayout(new GridLayout(8, 1));
			}
			else
			{
				temp.setLayout(new GridLayout(list.size(), 1));
			}
			for(int i=0; i<info.length;i++)
			{
				info[i][0] = list.get(i).getName();
				info[i][1] = list.get(i).getCellphone();
				jButton[i] = new JButton("<html>"+info[i][0]+"<br>"+info[i][1]+"<html>",
						new ImageIcon(this.getClass().getResource("ico.png")));
				jButton[i].setBackground(Style.PERSONBG);
				jButton[i].setHorizontalAlignment(JButton.LEFT);
				jButton[i].addActionListener(new PersonInfoDisplayHandler());
				jButton[i].addMouseListener(new MouseHandler());
				temp.add(jButton[i]);
			 jButton[i].setPreferredSize(new Dimension(280, 40));//有效的设置按钮的大小
			} 
			temp.setBackground(Style.WHOLEBG);
			JScrollPane jsp = new JScrollPane(temp);
			panel.setLayout(null);
			jsp.setBounds(0, 0, panel.getWidth(), panel.getHeight());
			panel.add(jsp);
		}
		if(str == MultiCommponent.newInstance().returnJB(2).getText())
		{
			MultiCommponent.newInstance().returnJB(2).setText(Strings.T_MIDDLE_TEXT+"("+db.getGroupCount()+")");
			panel.removeAll();
			ArrayList<Group> list = db.getAllGroup();
			String[] info = new String[list.size()];
			JButton[] jButton = new JButton[list.size()];
			JPanel temp = new JPanel();
			if(list.size() < 8)
			{
				temp.setLayout(new GridLayout(8, 1,3,3));
			}
			else
			{
				temp.setLayout(new GridLayout(list.size(), 1,3,3));
			}
			for(int i=0; i<info.length;i++)
			{
				 info[i] = list.get(i).getGroupname();
				jButton[i] = new JButton(info[i]+"("+db.getSingleGroupCount(info[i])+")   >>",
						new ImageIcon(this.getClass().getResource("group.png")));
				jButton[i].setBackground(Style.BG);
				jButton[i].addActionListener(new SmallButtonHandler());
				jButton[i].setHorizontalAlignment(JButton.LEFT);
				jButton[i].setForeground(Color.BLUE);
				temp.add(jButton[i]);
			 jButton[i].setPreferredSize(new Dimension(280, 40));//有效的设置按钮的大小
			 jButton[i].addMouseListener(new MouseGroupHandler());
			}  
			JScrollPane jsp = new JScrollPane(temp);
			temp.setBackground(Style.WHOLEBG);
			panel.setLayout(null);
			jsp.setBounds(0, 0, panel.getWidth(), panel.getHeight());
			panel.add(jsp);
		}
		panel.updateUI();
		return panel;
	}
	
	/**
	 * @return JPanel
	 * 创建各个分组的联系人列表项
	 * 
	 */
	public JPanel createGroupPanel(String str)
	{
		panel.removeAll();
		ArrayList<Person> list = db.getInnerGroup(str);//得到全部的联系人
		String[][] info = new String[list.size()][2];
		JButton[] jButton = new JButton[list.size()];
		JPanel temp = new JPanel();
		if(list.size() < 8)
		{
			temp.setLayout(new GridLayout(8, 1));
		}
		else
		{
			temp.setLayout(new GridLayout(list.size(), 1));
		}
		for(int i=0; i<info.length;i++)
		{
			info[i][0] = list.get(i).getName();
			info[i][1] = list.get(i).getCellphone();
			jButton[i] = new JButton("<html>"+info[i][0]+"<br>"+info[i][1]+"<html>",
					new ImageIcon(this.getClass().getResource("ico.png")));
			jButton[i].setBackground(Style.PERSONBG);
			jButton[i].setHorizontalAlignment(JButton.LEFT);
			jButton[i].addActionListener(new PersonInfoDisplayHandler());
			jButton[i].addMouseListener(new MouseHandler());
			temp.add(jButton[i]);
		 jButton[i].setPreferredSize(new Dimension(280, 40));//有效的设置按钮的大小
		} 
		temp.setBackground(Style.WHOLEBG);
		JScrollPane jsp = new JScrollPane(temp);
		panel.setLayout(null);
		jsp.setBounds(0, 0, panel.getWidth(), panel.getHeight());
		panel.add(jsp);
		panel.updateUI();
		return panel;
	}
	
	/**
	 * @param str
	 * @return
	 * 初始化联系人搜索面板
	 */
	public JPanel createSearchPanel(String str)
	{
		MultiCommponent.newInstance().returnJB(2).setText(Strings.T_MIDDLE_TEXT+"("+db.getGroupCount()+")");
		panel.removeAll();
		panel.setLayout(null);
		 
		MultiCommponent.newInstance().returnJTF(1).setBounds(30, 10, 150, 30);
		MultiCommponent.newInstance().returnJB(7).setBounds(190, 10, 100, 30);
		panel.add(MultiCommponent.newInstance().returnJTF(1));
		panel.add(MultiCommponent.newInstance().returnJB(7));
		panel.updateUI();
		return panel;
	}
	
	/**
	 * @param str
	 * @return JPanel
	 * 搜索联系人结果面板
	 */
	public JPanel createSearchResultPanel(String str)
	{
		if(str.matches("\\d*"))
		{
			MultiCommponent.newInstance().returnJP(1).removeAll();
			ArrayList<Person> list = db.getSearchResultByCellPhone(str);
			String[][] info = new String[list.size()][2];
			JButton[] jButton = new JButton[list.size()];
			JPanel temp = new JPanel();
			temp.setBackground(Style.WHOLEBG);
			if(list.size() < 8)
			{
				temp.setLayout(new GridLayout(7, 1));
			}
			else
			{
				temp.setLayout(new GridLayout(list.size(), 1));
			}
			for(int i=0; i<info.length;i++)
			{
				info[i][0] = list.get(i).getName();
				info[i][1] = list.get(i).getCellphone();
				jButton[i] = new JButton("<html>"+info[i][0]+"<br>"+info[i][1]+"<html>",
						new ImageIcon(this.getClass().getResource("ico.png")));
				jButton[i].setBackground(Style.PERSONBG);
				jButton[i].setHorizontalAlignment(JButton.LEFT);
				jButton[i].addActionListener(new PersonInfoDisplayHandler());
				jButton[i].addMouseListener(new MouseHandler());
				temp.add(jButton[i]);
			 jButton[i].setPreferredSize(new Dimension(280, 40));//有效的设置按钮的大小
			} 
			JScrollPane jsp = new JScrollPane(temp);
			jsp.setBounds(5,5,  305, 305);
			MultiCommponent.newInstance().returnJP(1).setLayout(null);
			MultiCommponent.newInstance().returnJP(1).add(jsp);
			MultiCommponent.newInstance().returnJP(1).updateUI();
		}
		else
		{
			MultiCommponent.newInstance().returnJP(1).removeAll();
			ArrayList<Person> list = db.getSearchResultByName(str);
			String[][] info = new String[list.size()][2];
			JButton[] jButton = new JButton[list.size()];
			JPanel temp = new JPanel();
			temp.setBackground(Style.WHOLEBG);
			if(list.size() < 8)
			{
				temp.setLayout(new GridLayout(7, 1));
			}
			else
			{
				temp.setLayout(new GridLayout(list.size(), 1));
			}
			for(int i=0; i<info.length;i++)
			{
				info[i][0] = list.get(i).getName();
				info[i][1] = list.get(i).getCellphone();
				jButton[i] = new JButton("<html>"+info[i][0]+"<br>"+info[i][1]+"<html>",
						new ImageIcon(this.getClass().getResource("ico.png")));
				jButton[i].setBackground(Style.PERSONBG);
				jButton[i].setHorizontalAlignment(JButton.LEFT);
			 
				temp.add(jButton[i]);
			 jButton[i].setPreferredSize(new Dimension(280, 40));//有效的设置按钮的大小
			} 
			JScrollPane jsp = new JScrollPane(temp);
			jsp.setBounds(5,5,  305, 305);
			MultiCommponent.newInstance().returnJP(1).setLayout(null);
			MultiCommponent.newInstance().returnJP(1).add(jsp);
			MultiCommponent.newInstance().returnJP(1).updateUI();
		}
		MultiCommponent.newInstance().returnJP(1).setBounds(0, 40, 320, 380);
		panel.add(MultiCommponent.newInstance().returnJP(1));
		panel.updateUI();
		return panel;
	}
	/**
	 * @return JPanel
	 * 添加联系人面板制作
	 */
	public JPanel createADDPersonPanel()
	{
		panel.removeAll();
		panel.setLayout(null);
		JLabel nameJL = new JLabel("姓名 :");
		JLabel sexJL = new JLabel("性别 :");//单选按钮实现
			JRadioButton boy = new JRadioButton("男",true);
			JRadioButton girl = new JRadioButton("女");
			ButtonGroup sexGroup = new ButtonGroup();
			sexGroup.add(boy);
			AddJTFRes.SEX = boy.getText();
			boy.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					AddJTFRes.SEX = ((JRadioButton)e.getSource()).getText();
				}
			});
			sexGroup.add(girl);
			girl.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					AddJTFRes.SEX = ((JRadioButton)e.getSource()).getText();					
				}
			});
		JLabel cellJL = new JLabel("手机号 :");
		JLabel qqJL = new JLabel("QQ :");
		JLabel EmailJL = new JLabel("Email :");
		JLabel fenzuJL = new JLabel("分组 :");//下拉列表实现
		ArrayList<Group> list = db.getAllGroup();
		String[] items = new String[list.size()];
		for(int i=0; i<items.length;i++)
		{
			items[i] = list.get(i).getGroupname();
		}
		JComboBox<String> fenzu = new JComboBox<String>(items);
		AddJTFRes._GROUP_NAME =   (String) fenzu.getSelectedItem();
		fenzu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				AddJTFRes._GROUP_NAME = (String) ((JComboBox<?>)arg0.getSource()).getSelectedItem();
			}
		});
		nameJL.setBounds(60, 30, 60, 30);
		AddJTFRes.newInstance().USEARNAME.setBounds(120, 30, 120, 30);
		sexJL.setBounds(60, 70, 60, 30);
		boy.setBounds(120, 70, 60, 30);
		girl.setBounds(180, 70, 60, 30);
		cellJL.setBounds(60, 110, 60, 30);
		AddJTFRes.newInstance().CELLPHONE.setBounds(120, 110, 120, 30);
		qqJL.setBounds(60, 150, 60, 30);
		AddJTFRes.newInstance().QQNUMBER.setBounds(120, 150, 120, 30);
		EmailJL.setBounds(60, 190, 60, 30);
		AddJTFRes.newInstance().EMAIL.setBounds(120, 190, 120, 30);
		fenzuJL.setBounds(60, 230, 60, 30);
		fenzu.setBounds(120, 230, 120, 30);
		AddJTFRes.newInstance().SAVE.setBounds(80, 280, 140, 40);
		panel.add(nameJL);
		panel.add(AddJTFRes.newInstance().USEARNAME);
		panel.add(sexJL);
		panel.add(boy);
		panel.add(girl);
		panel.add(cellJL);
		panel.add(AddJTFRes.newInstance().CELLPHONE);
		panel.add(qqJL);
		panel.add(AddJTFRes.newInstance().QQNUMBER);
		panel.add(EmailJL);
		panel.add(AddJTFRes.newInstance().EMAIL);
		panel.add(fenzuJL);
		panel.add(fenzu);
		panel.add(AddJTFRes.newInstance().SAVE);
		panel.updateUI();
		return panel;
	}
	/**
	 * @return JPanel
	 * 添加分组面板制作
	 */
	public JPanel createADDGroupPanel()
	{
		panel.removeAll();
		panel.setLayout(null);
		JLabel groupJL = new JLabel("分组名称",JLabel.CENTER);
		groupJL.setBounds(90, 100, 140, 40);
		AddJTFRes.newInstance().NEWGROUP.setBounds(90, 140, 140, 30);
		AddJTFRes.newInstance().SAVAGROUP.setBounds(90, 180, 140, 40);
		panel.add(groupJL);
		panel.add(AddJTFRes.newInstance().NEWGROUP);
		panel.add(AddJTFRes.newInstance().SAVAGROUP);
		panel.updateUI();
		return panel;
	}
	
	/**
	 * @return JPanel
	 * 软件版权面板制作
	 */
	public JPanel createSoftWareCopyright()
	{
		panel.removeAll();
		panel.setLayout(null);
		JLabel title = new JLabel("<html><h1>洛天工作室</h1><html>",JLabel.CENTER);
		title.setForeground(new Color(0xffffff));
		JLabel biaozhi = new JLabel("工作室成员：");
		biaozhi.setForeground(Color.white);
		JLabel member = new JLabel("<html>谢中贵<br><br>张&nbsp;&nbsp;&nbsp;&nbsp;中&nbsp;(设计)<br><br>李宏亮<br><br>陈星群<br><br>奚&nbsp;&nbsp;&nbsp;&nbsp;飞</html>");
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
		JLabel time = new JLabel("现在时间："+df.format(new Date()));
		member.setForeground(Color.WHITE);
		time.setForeground(Color.white);
		title.setBounds(60, 10, 200, 60);
		biaozhi.setBounds(90, 100, 150, 30);
		member.setBounds(180, 95, 80, 180);
		time.setBounds(140, 300, 180, 40);
		title.updateUI();
		biaozhi.updateUI();
		member.updateUI();
		time.updateUI();
		panel.add(title);
		panel.add(biaozhi);
		panel.add(member);
		panel.add(time);
		panel.updateUI();
		return panel;
	}
	/**
	 * @param str
	 * @return JPanel
	 * 显示单个联系人的详细信息
	 * 需要修饰
	 */
	public JPanel createPersonInfoDisplay(String str)
	{
		 
		AddJTFRes.PERSON = str;
		Person person = db.getOnePersonInfo(str);
		panel.removeAll();
		panel.setLayout(null);
		JLabel nameJL = new JLabel("<html><h3>姓&nbsp;&nbsp;&nbsp;&nbsp;名 :</h3></html>");
		JLabel sexJL = new JLabel("<html><h3>性&nbsp;&nbsp;&nbsp;&nbsp;别 :</h3></html>"); 
		JLabel cellJL = new JLabel("<html><h3>手机号 :</h3></html>");
		JLabel qqJL = new JLabel("<html><h3>Q&nbsp;&nbsp;&nbsp;&nbsp;Q :</h3></html>");
		JLabel EmailJL = new JLabel("<html><h3>Email :</h3></html>");
		JLabel fenzuJL = new JLabel("<html><h3>分&nbsp;&nbsp;&nbsp;&nbsp;组 :</h3></html>");
		JLabel name = new JLabel("<html><h3>"+person.getName()+"</h3></html>");
		JLabel sex = new JLabel("<html><h3>"+person.getSex()+"</h3></html>");
		JLabel cell = new JLabel("<html><h3>"+person.getCellphone()+"</h3></html>");
		JLabel qq = new JLabel("<html><h3>"+person.getQq()+"</h3></html>");
		JLabel Email = new JLabel("<html><h3>"+person.getEmail()+"</h3></html>");
		JLabel fenzu = new JLabel("<html><h3>"+ db.getGroupName(person.getGroupnum())+"</h3></html>");
		nameJL.setBounds(50, 30, 60, 30);
		name.setBounds(120, 30, 120, 30);
		sexJL.setBounds(50, 70, 60, 30);
		sex.setBounds(120, 70, 120, 30);
		cellJL.setBounds(50, 110, 60, 30);
		cell.setBounds(120, 110, 120, 30);
		qqJL.setBounds(50, 150, 60, 30);
		qq.setBounds(120, 150, 120, 30);
		EmailJL.setBounds(50, 190, 60, 30);
		Email.setBounds(120, 190, 180, 30);
		fenzuJL.setBounds(50, 230, 60, 30);
		fenzu.setBounds(120, 230, 120, 30);
		MultiCommponent.newInstance().returnJB(8).setBounds(60, 280, 100, 30);
		MultiCommponent.newInstance().returnJB(9).setBounds(170, 280, 100, 30);
		name.setForeground(Color.magenta);
		sex.setForeground(Color.magenta);
		cell.setForeground(Color.magenta);
		qq.setForeground(Color.magenta);
		Email.setForeground(Color.magenta);
		fenzu.setForeground(Color.magenta);
		panel.add(nameJL);
		panel.add(name);
		panel.add(sexJL);
		panel.add(sex);
		panel.add(cellJL);
		panel.add(cell);
		panel.add(qqJL);
		panel.add(qq);
		panel.add(EmailJL);
		panel.add(Email);
		panel.add(fenzuJL);
		panel.add(fenzu);
		panel.add(MultiCommponent.newInstance().returnJB(8));
		panel.add(MultiCommponent.newInstance().returnJB(9));
		panel.updateUI();
		return panel;
	}
	
	/**
	 * @param str
	 * @return JPanel
	 * 初始化修改信息面板通过手机号码的形式
	 */
	public JPanel createModifyDisplayPanel(String str)//bug源头
	{ 
		ModifyJTFRes.PERSON = str;
		panel.removeAll();
		panel.setLayout(null);
		Person person = db.getOnePersonInfo(str);
		JLabel nameJL = new JLabel("<html><h3>姓&nbsp;&nbsp;&nbsp;&nbsp;名 :</h3></html>");
		JLabel sexJL = new JLabel("<html><h3>性&nbsp;&nbsp;&nbsp;&nbsp;别 :</h3></html>"); 
		JLabel cellJL = new JLabel("<html><h3>手机号 :</h3></html>");
		JLabel qqJL = new JLabel("<html><h3>Q&nbsp;&nbsp;&nbsp;&nbsp;Q :</h3></html>");
		JLabel EmailJL = new JLabel("<html><h3>Email :</h3></html>");
		JLabel fenzuJL = new JLabel("<html><h3>分&nbsp;&nbsp;&nbsp;&nbsp;组 :</h3></html>");
		nameJL.setBounds(50, 30, 60, 30);
		ModifyJTFRes.newInstance().USEARNAME.setBounds(120, 30, 120, 30);
		sexJL.setBounds(50, 70, 60, 30);
		JRadioButton boy = new JRadioButton("男");
		JRadioButton girl = new JRadioButton("女");
		if(person.getSex().equals("男"))
		{
			 
			boy.setSelected(true);
			ModifyJTFRes.SEX = "男";
			 
		}
		else
		{
			girl.setSelected(true);
			ModifyJTFRes.SEX = "女";
		 
		}
		boy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ModifyJTFRes.SEX = ((JRadioButton)e.getSource()).getText();
			}
		});
		girl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ModifyJTFRes.SEX = ((JRadioButton)e.getSource()).getText(); 
			}
		});
		ButtonGroup sexGroup = new ButtonGroup();
		sexGroup.add(boy);
		sexGroup.add(girl);
		boy.setBounds(120, 70, 60, 30);
		girl.setBounds(180, 70, 60, 30);
		cellJL.setBounds(50, 110, 60, 30);
		ModifyJTFRes.newInstance().CELLPHONE.setBounds(120, 110, 120, 30);
		qqJL.setBounds(50, 150, 60, 30);
		ModifyJTFRes.newInstance().QQNUMBER.setBounds(120, 150, 120, 30);
		EmailJL.setBounds(50, 190, 60, 30);
		ModifyJTFRes.newInstance().EMAIL.setBounds(120, 190, 180, 30);
		fenzuJL.setBounds(50, 230, 60, 30);
		ArrayList<Group> list = db.getAllGroup();
		String[] items = new String[list.size()];
		for(int i=0; i<items.length;i++)
		{
			items[i] = list.get(i).getGroupname();
		}
		JComboBox<String> fenzu = new JComboBox<String>(items);
		fenzu.setSelectedItem(db.getGroupName(person.getGroupnum()));
		ModifyJTFRes._GROUP_NAME_ = db.getGroupName(person.getGroupnum());
		fenzu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ModifyJTFRes._GROUP_NAME_ = (String) ((JComboBox<?>)arg0.getSource()).getSelectedItem();
			}
		});
		fenzu.setBounds(120, 230, 120, 30);
		ModifyJTFRes.newInstance().USEARNAME.setText(person.getName());
		ModifyJTFRes.newInstance().CELLPHONE.setText(person.getCellphone());
		ModifyJTFRes.newInstance().QQNUMBER.setText(person.getQq());
		ModifyJTFRes.newInstance().EMAIL.setText(person.getEmail());
		MultiCommponent.newInstance().returnJB(10).setBounds(60, 280, 100, 30);
		MultiCommponent.newInstance().returnJB(11).setBounds(170, 280, 100, 30);
		panel.add(nameJL);
		panel.add(ModifyJTFRes.newInstance().USEARNAME);
		panel.add(sexJL);
		panel.add(boy);
		panel.add(girl);
		panel.add(cellJL);
		panel.add(ModifyJTFRes.newInstance().CELLPHONE);
		panel.add(qqJL);
		panel.add(ModifyJTFRes.newInstance().QQNUMBER);
		panel.add(EmailJL);
		panel.add(ModifyJTFRes.newInstance().EMAIL);
		panel.add(fenzuJL);
		panel.add(fenzu);
		panel.add(MultiCommponent.newInstance().returnJB(10));
		panel.add(MultiCommponent.newInstance().returnJB(11));
		panel.updateUI();
		return panel;
	}
	/**
	 * 批量删除联系人
	 */
	public void createChoseDeletePersonPanel() {
		panel.removeAll();
		panel.setLayout(null);
		ArrayList<Person> list = db.getAllResult();
		JCheckBox[] jcb = new JCheckBox[list.size()];
		JPanel[] jp = new JPanel[list.size()];
		JPanel temp = new JPanel();
		temp.setBackground(Style.BG);
		if(list.size()<7)
		{
			temp.setLayout(new GridLayout(7,1));
		}
		else
		{
			temp.setLayout(new GridLayout(0,1));
		}
		for(int i=0; i<list.size(); i++)
		{
			jcb[i] = new JCheckBox("<html><h4>&nbsp;&nbsp;&nbsp;"+list.get(i).getName()+"&nbsp;&nbsp;&nbsp;"+list.get(i).getCellphone()+"</h4></html>");
			jcb[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(((JCheckBox)e.getSource()).isSelected())
					{
						String str = ((JCheckBox)e.getSource()).getText();
						str = str.substring(str.length()-23,str.length()-12);
						DataSave.LIST.add(str);
					}
					else
					{
						String str = ((JCheckBox)e.getSource()).getText();
						str = str.substring(str.length()-23,str.length()-12);
						DataSave.LIST.remove(str);
					}
				}
			});
			jp[i] = new JPanel();
			jp[i].setLayout(new GridLayout(1, 1));
			jp[i].add(jcb[i]);
			jp[i].setBackground(Style.PERSONBG);
			jp[i].setBorder(BorderFactory.createRaisedBevelBorder());
			jcb[i].setBackground(Style.PERSONBG);
			jcb[i].setForeground(Color.RED);
			jp[i].setPreferredSize(new Dimension(270,40));
			temp.add(jp[i]);
			temp.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		}
		JScrollPane jsp = new JScrollPane(temp);
		jsp.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		jsp.setBounds(2, 2, 310, 280);
		MultiCommponent.newInstance().returnJB(12).setBounds(60, 300, 70, 40);
		MultiCommponent.newInstance().returnJB(13).setBounds(150, 300, 70, 40);
		panel.add(jsp);
		panel.add(MultiCommponent.newInstance().returnJB(12));
		panel.add(MultiCommponent.newInstance().returnJB(13));
		panel.updateUI();
	}
	public void createChoseDeleteGroupPanel() {
		panel.removeAll();
		panel.setLayout(null);
		ArrayList<Group> list = db.getAllGroup();
		JCheckBox[] jcb = new JCheckBox[list.size()];
		JPanel[] jp = new JPanel[list.size()];
		JPanel temp = new JPanel();
		temp.setBackground(Style.BG);
		if(list.size()<7)
		{
			temp.setLayout(new GridLayout(7,1));
		}
		else
		{
			temp.setLayout(new GridLayout(0,1));
		}
		for(int i=0; i<list.size(); i++)
		{
			jcb[i] = new JCheckBox("<html><h4>&nbsp;"+list.get(i).getGroupname()+"&nbsp;("+db.getSingleGroupCount(list.get(i).getGroupname())+")</h4></html>");
			jcb[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(((JCheckBox)e.getSource()).isSelected())
					{
						String str = e.getActionCommand();
						DataSave.GLIST.add(str.split("&nbsp;")[1]);
					}
					else
					{
						String str = e.getActionCommand();
						DataSave.GLIST.remove(str.split("&nbsp;")[1]);
					}
				}
			});
			jp[i] = new JPanel();
			jp[i].setLayout(new GridLayout(1, 1));
			jp[i].add(jcb[i]);
			jp[i].setBackground(Style.PERSONBG);
			jp[i].setBorder(BorderFactory.createRaisedBevelBorder());
			jcb[i].setBackground(Style.PERSONBG);
			jcb[i].setForeground(Color.BLUE);
			jp[i].setPreferredSize(new Dimension(270,40));
			temp.add(jp[i]);
			temp.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		}
		JScrollPane jsp = new JScrollPane(temp);
		jsp.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		jsp.setBounds(2, 2, 310, 280);
		MultiCommponent.newInstance().returnJB(14).setBounds(60, 300, 70, 40);
		MultiCommponent.newInstance().returnJB(15).setBounds(150, 300, 70, 40);
		panel.add(jsp);
		panel.add(MultiCommponent.newInstance().returnJB(14));
		panel.add(MultiCommponent.newInstance().returnJB(15));
		panel.updateUI();
		
	}
}
