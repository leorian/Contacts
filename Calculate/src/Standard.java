import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerListModel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class Standard extends javax.swing.JFrame {
	private String sb;//存储在文本域中显示的字符串
	private StringBuffer sb1 = new StringBuffer();//存储文本域第一行显示的字符串
	private StringBuffer sb2 = new StringBuffer();//存储文本域第二行显示的字符串
	private String sb3 = "";
	private int jinzhi = 10;//默认进行十进制运算
	private Number ls1,ls2,ls3;//十进制存储两个临时变量
	private int yunsuan = 0;//代表不同的运算
	private int equal = 0;
	private int du = 0;//0代表角度
	private Sanjiao sj = null;//三角函数
	private int zhengfu = 0;//正负号的点击次数
	
	
	/***********************以下为本程序中所有的组件*************/
	private JButton jButton5;
	private JButton jButton4;
	private JButton jButton3;
	private JButton jButton2;
	private JMenuBar jMenuBar1;
	private JMenuItem jMenuItem9;
	private JButton jButton1;
	private JButton jButton43;
	private JButton jButton42;
	private JButton jButton41;
	private JButton jButton40;
	private JButton jButton39;
	private JButton jButton38;
	private JButton jButton37;
	private JButton jButton36;
	private JButton jButton35;
	private JButton jButton34;
	private JButton jButton33;
	private JRadioButton jRadioButton6;
	private JRadioButton jRadioButton5;
	private JButton jButton32;
	private JTextArea jTextArea2; 
	private JScrollPane jScrollPane;
	private JButton jButton31;
	private JLabel jLabel4;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JSpinner jSpinner3;
	private JSpinner jSpinner2;
	private JSpinner jSpinner1;
	private JPanel jPanel1;
	private JButton jButton26;
	private JButton jButton28;
	private JButton jButton30;
	private JButton jButton29;
	private JButton jButton27;
	private JButton jButton25;
	private JButton jButton24;
	private JButton jButton23;
	private JButton jButton22;
	private JButton jButton21;
	private JButton jButton20;
	private JButton jButton19;
	private JButton jButton18;
	private JButton jButton17;
	private JButton jButton16;
	private JButton jButton15;
	private JButton jButton14;
	private JButton jButton13;
	private JButton jButton12;
	private JButton jButton11;
	private JButton jButton10;
	private JButton jButton9;
	private JButton jButton8;
	private JButton jButton7;
	private JButton jButton6;
	private JRadioButton jRadioButton4;
	private JRadioButton jRadioButton3;
	private JRadioButton jRadioButton2;
	private JRadioButton jRadioButton1;
	private JTextArea jTextArea1;
	private JMenuItem jMenuItem8;
	private JMenu jMenu3;
	private JMenuItem jMenuItem7;
	private JMenuItem jMenuItem6;
	private JMenu jMenu2;
	private JMenuItem jMenuItem5;
	private JMenuItem jMenuItem3;
	private JMenuItem jMenuItem2;
	private JMenuItem jMenuItem1;
	private JMenu jMenu1;
	/*************************************************************************/

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Standard inst = new Standard();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Standard() {
		super();
		initGUI();
	}
	
	private ActionListener listener1 = new ActionListener() {
		//为所有的数字添加监听器（不包括0）
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();//获取事件源，就是被点击的按钮
			if(equal==1) {//如果已经点击过“=”号，则什么都不做，等号不能被连续点击
				ls1 = null;
				ls2 = null;
				sb1 = new StringBuffer("");
				sb2 = new StringBuffer("");
				yunsuan = 0;
				equal = 0;
			}
			if(sb2.toString().startsWith("0")) {
				sb2 = new StringBuffer("");
			}
			sb2 = sb2.append(btn.getText());
			if(yunsuan==3 || yunsuan==4) {
				sb = sb3+"\n"+sb2.toString();
			} else {
				sb = sb1.toString()+"\n"+sb2.toString();
			}
			jTextArea1.setText(sb);
		}
	};
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u9ad8\u7cbe\u5ea6\u8ba1\u7b97\u5668\uff08\u6807\u51c6\u7248\uff09");
			this.setJMenuBar(jMenuBar1);
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu1 = new JMenu();
					jMenuBar1.add(jMenu1);
					jMenu1.setText("\u67e5\u770b");
					{
						jMenuItem1 = new JMenuItem();
						jMenu1.add(jMenuItem1);
						jMenuItem1.setText("\u6807\u51c6\u578b");
						jMenuItem1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Standard.this.setSize(275, 326);
								Standard.this.setTitle("高精度计算器（标准版）");
								jTextArea1.setText("\n0");
								ls1 = null;
								ls2 = null;
								ls3 = null;
								sb1 = new StringBuffer("");
								sb2 = new StringBuffer("");
								jRadioButton1.setEnabled(true);
								jRadioButton2.setEnabled(true);
								jRadioButton4.setEnabled(true);
								jButton27.setEnabled(false);
								jTextArea1.setSize(264, 43);
							}
						});
					}
					{
						jMenuItem2 = new JMenuItem();
						jMenu1.add(jMenuItem2);
						jMenuItem2.setText("\u52a0\u5f3a\u578b");
						jMenuItem2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Standard.this.setSize(397, 326);
								Standard.this.setTitle("高进度计算器（加强版）");
								jRadioButton3.setSelected(true);
								jRadioButton5.setSelected(true);
								jRadioButton1.setSelected(false);
								jRadioButton1.setEnabled(false);
								jRadioButton2.setSelected(false);
								jRadioButton2.setEnabled(false);
								jRadioButton4.setSelected(false);
								jRadioButton4.setEnabled(false);
								jButton6.setEnabled(true);
								jButton7.setEnabled(true);
								jButton8.setEnabled(true);
								jButton9.setEnabled(false);
								jButton11.setEnabled(true);
								jButton12.setEnabled(true);
								jButton13.setEnabled(true);
								jButton14.setEnabled(false);
								jButton16.setEnabled(true);
								jButton17.setEnabled(true);
								jButton18.setEnabled(true);
								jButton19.setEnabled(false);
								jButton21.setEnabled(true);
								jButton22.setEnabled(false);
								jButton23.setEnabled(false);
								jButton24.setEnabled(false);
								jinzhi = 10;
								ls1 = null;
								ls2 = null;
								ls3 = null;
								sb1 = new StringBuffer("");
								sb2 = new StringBuffer("");
								jTextArea1.setText("\n0");
								jTextArea1.setSize(383, 43);
							}
						});
					}
					{
						jMenuItem3 = new JMenuItem();
						jMenu1.add(jMenuItem3);
						jMenuItem3.setText("\u5386\u53f2\u8bb0\u5f55");
						jMenuItem3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								jPanel1.setVisible(true);
							}
						});
					}
					{
						jMenuItem5 = new JMenuItem();
						jMenu1.add(jMenuItem5);
						jMenuItem5.setText("\u8fd4\u56de\u8ba1\u7b97\u5668");
						jMenuItem5.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								jPanel1.setVisible(false);
							}
						});
					}
				}
				{
					jMenu2 = new JMenu();
					jMenuBar1.add(jMenu2);
					jMenu2.setText("\u7f16\u8f91");
					{
						jMenuItem6 = new JMenuItem();
						jMenu2.add(jMenuItem6);
						jMenuItem6.setText("\u590d\u5236");
					}
					{
						jMenuItem7 = new JMenuItem();
						jMenu2.add(jMenuItem7);
						jMenuItem7.setText("\u7c98\u8d34");
					}
				}
				{
					jMenu3 = new JMenu();
					jMenuBar1.add(jMenu3);
					jMenu3.setText("\u5e2e\u52a9");
					{
						jMenuItem8 = new JMenuItem();
						jMenu3.add(jMenuItem8);
						jMenuItem8.setText("\u67e5\u770b\u5e2e\u52a9");
					}
					{
						jMenuItem9 = new JMenuItem();
						jMenu3.add(jMenuItem9);
						jMenuItem9.setText("\u5173\u4e8e\u8ba1\u7b97\u5668");
					}
				}
			}
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBounds(-3, 1, 268, 268);
				jPanel1.setLayout(null);
				jPanel1.setVisible(false);
				/********************以下为日期选择空间******************/
				{
					SpinnerListModel jSpinner1Model = 
							new SpinnerListModel(
									new String[] { "2012", "2013" , "2014" , "2015" , "2016" , "2017" , "2018" });
					jSpinner1 = new JSpinner();
					jPanel1.add(jSpinner1);
					jSpinner1.setModel(jSpinner1Model);
					jSpinner1.setBounds(11, 4, 47, 23);
					jSpinner1.getEditor().setPreferredSize(new java.awt.Dimension(28, 19));
				}
				{
					SpinnerListModel jSpinner2Model = 
							new SpinnerListModel(
									new String[] { "01", "02" , "03" , "04" , "05" , "06" , "07", "08" , "09" , "10" , "11" , "12"});
					jSpinner2 = new JSpinner();
					jPanel1.add(jSpinner2);
					jSpinner2.setModel(jSpinner2Model);
					jSpinner2.setBounds(78, 5, 35, 21);
				}
				{
					SpinnerListModel jSpinner3Model = 
							new SpinnerListModel(
									new String[] { "01", "02" , "03" , "04" , "05" , "06" , "07", "08" , "09" , "10" , "11" , "12","13", "14" , "15" , "16" , "17" , "18" , "19", "20" , "21" , "22" , "23" , "24", "25", "26" , "27" , "28" , "29" , "30", "31"});
					jSpinner3 = new JSpinner();
					jPanel1.add(jSpinner3);
					jSpinner3.setModel(jSpinner3Model);
					jSpinner3.setBounds(132, 6, 34, 19);
					jSpinner3.getEditor().setPreferredSize(new java.awt.Dimension(22, 15));
				}
				/************************************************************/
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("\u5e74");
					jLabel1.setBounds(61, 8, 24, 15);
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2);
					jLabel2.setText("\u6708");
					jLabel2.setBounds(115, 8, 24, 15);
				}
				{
					jLabel4 = new JLabel();
					jPanel1.add(jLabel4);
					jLabel4.setText("\u65e5");
					jLabel4.setBounds(167, 8, 24, 15);
				}
				{
					jButton31 = new JButton();
					jPanel1.add(jButton31);
					jButton31.setText("\u67e5\u8be2");
					jButton31.setBounds(197, 4, 61, 22);
					jButton31.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							//字符串s用于存储当前日期时间
							String s = jSpinner1.getValue().toString()+"-"+jSpinner2.getValue().toString()+"-"+jSpinner3.getValue().toString();
							//使用日期过滤读取历史记录
							String ss =FioStream.readFromtxt(s);
							jTextArea2.setText(ss);
						}
					});
				}
				{
					jTextArea2 = new JTextArea();
					jScrollPane= new JScrollPane(jTextArea2);
					jScrollPane.setBounds(3, 34, 258, 232);
					jPanel1.add(jScrollPane);
				}
			}
			{
				jTextArea1 = new JTextArea();
				getContentPane().add(jTextArea1);
				jTextArea1.setFont(new java.awt.Font("华文细黑",0,16));
				jTextArea1.setBounds(-3, 1, 260, 43);
				jTextArea1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				jTextArea1.setText("\n0");
				jTextArea1.setVisible(true);
			}
			{//二进制单选按钮
				jRadioButton1 = new JRadioButton();
				getContentPane().add(jRadioButton1);
				jRadioButton1.setText("\u4e8c\u8fdb\u5236");
				jRadioButton1.setBounds(6, 47, 59, 19);
				jRadioButton1.setFont(new java.awt.Font("宋体",0,10));
				jRadioButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String str1="";//代表ls1中二进制的表示
						String str2 = "";//代表当前符号
						String str3 = "";//代表ls2中二进制的表示
						if(ls1!=null) {
							str1 = ls1.getEr();
						}else{
							str1 = "";
						}
						switch (yunsuan) {
						case 0:str2 = "";break;
						case 1:str2 = "+";break;
						case 2:str2 = "－";break;
						case 3:str2 = "×";break;
						case 4:str2 = "÷";break;
						}
						if(ls2!=null) {
							str3 = ls2.getEr();
						}else{
							str3 = "";
						}
						if(equal==1) {
							sb2 = new StringBuffer(ls3.getEr()) ;
						}else {
							sb2 = new StringBuffer("");
						}
						sb = str1+str2+str3+"\n"+sb2.toString();
						if("\n".equals(sb)) {
							jTextArea1.setText("\n0");
						} else {
							jTextArea1.setText(sb);
						}
						jRadioButton2.setSelected(false);
						jRadioButton3.setSelected(false);
						jRadioButton4.setSelected(false);
						jButton6.setEnabled(false);
						jButton7.setEnabled(false);
						jButton8.setEnabled(false);
						jButton9.setEnabled(false);
						jButton11.setEnabled(false);
						jButton12.setEnabled(false);
						jButton13.setEnabled(false);
						jButton14.setEnabled(false);
						jButton16.setEnabled(true);
						jButton17.setEnabled(false);
						jButton18.setEnabled(false);
						jButton19.setEnabled(false);
						jButton21.setEnabled(true);
						jButton22.setEnabled(false);
						jButton23.setEnabled(false);
						jButton24.setEnabled(false);
						jinzhi = 2;
					}
				});
			}
			//8进制
			{
				jRadioButton2 = new JRadioButton();
				getContentPane().add(jRadioButton2);
				jRadioButton2.setText("\u516b\u8fdb\u5236");
				jRadioButton2.setBounds(68, 47, 62, 19);
				jRadioButton2.setFont(new java.awt.Font("宋体",0,10));
				jRadioButton2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String str1,str2="",str3;
						if(ls1!=null) {
							str1 = ls1.getBa();
						}else{
							str1 = "";
						}
						switch (yunsuan) {
						case 0:str2 = "";break;
						case 1:str2 = "+";break;
						case 2:str2 = "－";break;
						case 3:str2 = "×";break;
						case 4:str2 = "÷";break;
						}
						if(ls2!=null) {
							str3 = ls2.getBa();
						}else{
							str3 = "";
						}
						if(equal==1) {
							sb2 = new StringBuffer(ls3.getBa()) ;
						}else {
							sb2 = new StringBuffer("");
						}
						sb = str1+str2+str3+"\n"+sb2.toString();
						if("\n".equals(sb)) {
							jTextArea1.setText("\n0");
						} else {
							jTextArea1.setText(sb);
						}
						jinzhi = 8;
						jRadioButton1.setSelected(false);
						jRadioButton3.setSelected(false);
						jRadioButton4.setSelected(false);
						jButton6.setEnabled(true);
						jButton7.setEnabled(false);
						jButton8.setEnabled(false);
						jButton9.setEnabled(false);
						jButton11.setEnabled(true);
						jButton12.setEnabled(true);
						jButton13.setEnabled(true);
						jButton14.setEnabled(false);
						jButton16.setEnabled(true);
						jButton17.setEnabled(true);
						jButton18.setEnabled(true);
						jButton19.setEnabled(false);
						jButton21.setEnabled(true);
						jButton22.setEnabled(false);
						jButton23.setEnabled(false);
						jButton24.setEnabled(false);
					}
				});
			}
			//十进制
			{
				jRadioButton3 = new JRadioButton();
				getContentPane().add(jRadioButton3);
				jRadioButton3.setText("\u5341\u8fdb\u5236");
				jRadioButton3.setBounds(131, 47, 59, 19);
				jRadioButton3.setFont(new java.awt.Font("宋体",0,10));
				jRadioButton3.setSelected(true);
				jRadioButton3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String str1,str2="",str3;
						if(ls1!=null) {
							str1 = ls1.getShi();
						}else{
							str1 = "";
						}
						switch (yunsuan) {
						case 0:str2 = "";break;
						case 1:str2 = "+";break;
						case 2:str2 = "－";break;
						case 3:str2 = "×";break;
						case 4:str2 = "÷";break;
						}
						if(ls2!=null) {
							str3 = ls2.getShi();
						}else{
							str3 = "";
						}
						if(equal==1) {
							sb2 = new StringBuffer(ls3.getShi()) ;
						}else {
							sb2 = new StringBuffer("");
						}
						sb = str1+str2+str3+"\n"+sb2.toString();
						if("\n".equals(sb)) {
							jTextArea1.setText("\n0");
						} else {
							jTextArea1.setText(sb);
						}
						jinzhi = 10;
						jRadioButton1.setSelected(false);
						jRadioButton2.setSelected(false);
						jRadioButton4.setSelected(false);
						jButton6.setEnabled(true);
						jButton7.setEnabled(true);
						jButton8.setEnabled(true);
						jButton9.setEnabled(false);
						jButton11.setEnabled(true);
						jButton12.setEnabled(true);
						jButton13.setEnabled(true);
						jButton14.setEnabled(false);
						jButton16.setEnabled(true);
						jButton17.setEnabled(true);
						jButton18.setEnabled(true);
						jButton19.setEnabled(false);
						jButton21.setEnabled(true);
						jButton22.setEnabled(false);
						jButton23.setEnabled(false);
						jButton24.setEnabled(false);
					}
				});
			}
			//十六进制
			{
				jRadioButton4 = new JRadioButton();
				getContentPane().add(jRadioButton4);
				jRadioButton4.setText("\u5341\u516d\u8fdb\u5236");
				jRadioButton4.setBounds(190, 46, 66, 19);
				jRadioButton4.setFont(new java.awt.Font("宋体",0,10));
				jRadioButton4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String str1,str2="",str3;
						if(ls1!=null) {
							str1 = ls1.getShiliu();
						}else{
							str1 = "";
						}
						switch (yunsuan) {
						case 0:str2 = "";break;
						case 1:str2 = "+";break;
						case 2:str2 = "－";break;
						case 3:str2 = "×";break;
						case 4:str2 = "÷";break;
						}
						if(ls2!=null) {
							str3 = ls2.getShiliu();
						}else{
							str3 = "";
						}
						if(equal==1) {
							sb2 = new StringBuffer(ls3.getShiliu()) ;
						}else {
							sb2 = new StringBuffer("");
						}
						sb = str1+str2+str3+"\n"+sb2.toString();
						if("\n".equals(sb)) {
							jTextArea1.setText("\n0");
						} else {
							jTextArea1.setText(sb);
						}
						jinzhi = 16;
						jRadioButton1.setSelected(false);
						jRadioButton2.setSelected(false);
						jRadioButton3.setSelected(false);
						jButton6.setEnabled(true);
						jButton7.setEnabled(true);
						jButton8.setEnabled(true);
						jButton9.setEnabled(true);
						jButton11.setEnabled(true);
						jButton12.setEnabled(true);
						jButton13.setEnabled(true);
						jButton14.setEnabled(true);
						jButton16.setEnabled(true);
						jButton17.setEnabled(true);
						jButton18.setEnabled(true);
						jButton19.setEnabled(true);
						jButton21.setEnabled(true);
						jButton22.setEnabled(true);
						jButton23.setEnabled(true);
						jButton24.setEnabled(true);
					}
				});
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("\u2190");
				jButton1.setBounds(6, 69, 46, 28);
				jButton1.setFont(new java.awt.Font("宋体",0,12));
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if("".equals(sb2.toString())) {
							sb = sb1.toString()+"\n0";
							jTextArea1.setText(sb);
						}else {
							sb2 = new StringBuffer(sb2.toString().substring(0, sb2.length()-1));
							if("".equals(sb2.toString())) {
								sb = sb1.toString()+"\n0";
							}else {
								sb = sb1.toString()+"\n"+sb2.toString();
							}
								jTextArea1.setText(sb);
						}
					}
				});
			}
			//复位键
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2);
				jButton2.setText("C");
				jButton2.setFont(new java.awt.Font("仿宋",0,12));
				jButton2.setBounds(57, 69, 46, 28);
				jButton2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ls1 = null;
						ls2 = null;
						yunsuan = 0;
						equal = 0;
						sb1 = new StringBuffer("");
						sb2 = new StringBuffer("");
						sb = "";
						sb3 = "";
						jTextArea1.setText("\n0");
					}
				});
			}
			//归零
			{
				jButton3 = new JButton();
				getContentPane().add(jButton3);
				jButton3.setText("CE");
				jButton3.setFont(new java.awt.Font("宋体",0,12));
				jButton3.setBounds(108, 69, 46, 28);
				jButton3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(equal==1) {
							ls1 = null;
							ls2 = null;
							yunsuan = 0;
							equal = 0;
							sb1 = new StringBuffer("");
							sb2 = new StringBuffer("");
							sb = "";
							sb3 = "";
							jTextArea1.setText("\n0");
						} else {
							sb2 = new StringBuffer("");
							sb = sb1.toString()+"\n0";
							jTextArea1.setText(sb);
						}
					}
				});
			}
			{
				jButton4 = new JButton();
				getContentPane().add(jButton4);
				jButton4.setText("M-");
				jButton4.setFont(new java.awt.Font("宋体",0,12));
				jButton4.setBounds(159, 69, 46, 28);
				jButton4.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						yunsuan = 2;//代表减法
						equal = 0;
						sb1 = sb2;
						ls1 = ls3;
						sb2 = new StringBuffer("");
						sb1.append("-");
						sb = sb1.toString()+"\n"+"0";
						jTextArea1.setText(sb);
					}
				});
			}
			{
				jButton5 = new JButton();
				getContentPane().add(jButton5);
				jButton5.setText("M+");
				jButton5.setFont(new java.awt.Font("宋体",0,12));
				jButton5.setBounds(210, 69, 46, 28);
				jButton5.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						yunsuan = 1;//代表加法
						equal = 0;
						sb1 = sb2;
						ls1 = ls3;
						sb2 = new StringBuffer("");
						sb1.append("+");
						sb = sb1.toString()+"\n"+"0";
						jTextArea1.setText(sb);
					}
				});
			}
			{
				jButton6 = new JButton();
				getContentPane().add(jButton6);
				jButton6.setText("7");
				jButton6.setFont(new java.awt.Font("宋体",0,12));
				jButton6.setBounds(6, 102, 46, 28);
			}
			{
				jButton7 = new JButton();
				getContentPane().add(jButton7);
				jButton7.setText("8");
				jButton7.setFont(new java.awt.Font("宋体",0,12));
				jButton7.setBounds(57, 102, 46, 28);
			}
			{
				jButton8 = new JButton();
				getContentPane().add(jButton8);
				jButton8.setText("9");
				jButton8.setFont(new java.awt.Font("宋体",0,12));
				jButton8.setBounds(108, 102, 46, 28);
			}
			{
				jButton9 = new JButton();
				getContentPane().add(jButton9);
				jButton9.setText("A");
				jButton9.setFont(new java.awt.Font("仿宋",0,12));
				jButton9.setBounds(159, 102, 46, 28);
				jButton9.setEnabled(false);
			}
			//开平方根
			{
				jButton10 = new JButton();
				getContentPane().add(jButton10);
				jButton10.setText("\u221a");
				jButton10.setFont(new java.awt.Font("宋体",0,12));
				jButton10.setBounds(210, 102, 46, 28);
				jButton10.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(jinzhi==10) {
							ls3 = new Number(Double.parseDouble(sb2.toString()));
						} else {
							ls3 = new Number(JinzhiUtil.toshi(sb2.toString(), jinzhi));
						}
						String s = "sqrt("+sb2.toString()+")=";
						zhengfu = 0;
						ls3 = new Number(Math.sqrt(ls3.getNum()));
						switch(jinzhi) {
						case 2: {
							sb1 = new StringBuffer("("+"sqrt("+sb2.toString());
							sb2 = new StringBuffer(ls3.getEr());
							s += sb2.toString();
							FioStream.inputtoTxt(s);
							jTextArea1.setText(sb1.toString()+ "\n"+sb2.toString());
							break;
						}
						case 8: {
							sb1 = new StringBuffer("("+"sqrt("+sb2.toString());
							sb2 = new StringBuffer(ls3.getBa());
							s += sb2.toString();
							FioStream.inputtoTxt(s);
							jTextArea1.setText(sb1.toString()+"\n"+sb2.toString());
							break;
						}
						case 10: {
							sb1 = new StringBuffer("("+"sqrt("+sb2.toString());
							sb2 = new StringBuffer(ls3.getShi());
							s += sb2.toString();
							FioStream.inputtoTxt(s);
							jTextArea1.setText(sb1.toString()+"\n"+sb2.toString());
							break;
						}
						case 16: {
							sb1 = new StringBuffer("("+"sqrt("+sb2.toString());
							sb2 = new StringBuffer(ls3.getShiliu());
							s += sb2.toString();
							FioStream.inputtoTxt(s);
							jTextArea1.setText(sb1.toString()+"\n"+sb2.toString());
							break;
						}
						}
					}
				});
			}
			{
				jButton11 = new JButton();
				getContentPane().add(jButton11);
				jButton11.setText("4");
				jButton11.setFont(new java.awt.Font("宋体",0,12));
				jButton11.setBounds(6, 135, 46, 28);
			}
			{
				jButton12 = new JButton();
				getContentPane().add(jButton12);
				jButton12.setText("5");
				jButton12.setFont(new java.awt.Font("宋体",0,12));
				jButton12.setBounds(57, 135, 46, 28);
			}
			{
				jButton13 = new JButton();
				getContentPane().add(jButton13);
				jButton13.setText("6");
				jButton13.setFont(new java.awt.Font("宋体",0,12));
				jButton13.setBounds(108, 135, 46, 28);
			}
			{
				jButton14 = new JButton();
				getContentPane().add(jButton14);
				jButton14.setText("B");
				jButton14.setFont(new java.awt.Font("仿宋",0,12));
				jButton14.setBounds(159, 135, 46, 28);
				jButton14.setEnabled(false);
			}
			{
				jButton15 = new JButton();
				getContentPane().add(jButton15);
				jButton15.setText("x2");
				jButton15.setFont(new java.awt.Font("宋体",0,12));
				jButton15.setBounds(210, 135, 46, 28);
				jButton15.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(jinzhi==10) {
							ls3 = new Number(Double.parseDouble(sb2.toString()));
						} else {
							ls3 = new Number(JinzhiUtil.toshi(sb2.toString(), jinzhi));
						}
						zhengfu = 0;
						String s = "pow("+sb2.toString()+",2)=";
						ls3 = new Number(Math.pow(ls3.getNum(),2));
						switch(jinzhi) {
						case 2: {
							sb1 = new StringBuffer("("+"pow("+sb2.toString()+",2");
							sb2 = new StringBuffer(ls3.getEr());
							s += sb2.toString();
							FioStream.inputtoTxt(s);
							jTextArea1.setText(sb1.toString()+"\n"+sb2.toString());
							break;
						}
						case 8: {
							sb1 = new StringBuffer("("+"pow("+sb2.toString()+",2");
							sb2 = new StringBuffer(ls3.getBa());
							s += sb2.toString();
							FioStream.inputtoTxt(s);
							jTextArea1.setText(sb1.toString()+"\n"+sb2.toString());
							break;
						}
						case 10: {
							sb1 = new StringBuffer("("+"pow("+sb2.toString()+",2");
							sb2 = new StringBuffer(ls3.getShi());
							s += sb2.toString();
							FioStream.inputtoTxt(s);
							jTextArea1.setText(sb1.toString()+"\n"+sb2.toString());
							break;
						}
						case 16: {
							sb1 = new StringBuffer("("+"pow("+sb2.toString()+",2");
							sb2 = new StringBuffer(ls3.getShiliu());
							s += sb2.toString();
							FioStream.inputtoTxt(s);
							jTextArea1.setText(sb1.toString()+"\n"+sb2.toString());
							break;
						}
						}
					}
				});
			}
			{
				jButton16 = new JButton();
				getContentPane().add(jButton16);
				jButton16.setText("1");
				jButton16.setFont(new java.awt.Font("宋体",0,12));
				jButton16.setBounds(6, 168, 46, 28);
			}
			{
				jButton17 = new JButton();
				getContentPane().add(jButton17);
				jButton17.setText("2");
				jButton17.setFont(new java.awt.Font("宋体",0,12));
				jButton17.setBounds(57, 168, 46, 28);
			}
			{
				jButton18 = new JButton();
				getContentPane().add(jButton18);
				jButton18.setText("3");
				jButton18.setFont(new java.awt.Font("宋体",0,12));
				jButton18.setBounds(108, 168, 46, 28);
			}
			{
				jButton19 = new JButton();
				getContentPane().add(jButton19);
				jButton19.setText("C");
				jButton19.setFont(new java.awt.Font("仿宋",0,12));
				jButton19.setBounds(159, 168, 46, 28);
				jButton19.setEnabled(false);
			}
			{
				jButton20 = new JButton();
				getContentPane().add(jButton20);
				jButton20.setText("×");
				jButton20.setFont(new java.awt.Font("宋体",0,12));
				jButton20.setBounds(210, 168, 46, 28);
				jButton20.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//为×添加监听器
						if(equal==1) {
							equal=0;
						}
						yunsuan = 3;//代表乘法
						sb1 = sb2;
						zhengfu = 0;
						sb3 = "×"+sb2.toString();
						if(jinzhi==10) {
							ls1 = new Number(Double.parseDouble(sb2.toString()));
						} else {
							ls1 = new Number(JinzhiUtil.toshi(sb2.toString(), jinzhi));
						}
						sb2 = new StringBuffer("");
						sb = sb3+"\n"+"0";
						sb1.append("×");
						jTextArea1.setText(sb);
					}
				});
			}
			{
				jButton21 = new JButton();
				getContentPane().add(jButton21);
				jButton21.setText("0");
				jButton21.setFont(new java.awt.Font("宋体",0,12));
				jButton21.setBounds(6, 201, 46, 28);
				jButton21.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!"0".equals(sb2.toString())) {
							sb2 = sb2.append("0");
							sb = sb1.toString()+"\n"+sb2.toString();
							jTextArea1.setText(sb);
						}
					}
				});
			}
			{
				jButton22 = new JButton();
				getContentPane().add(jButton22);
				jButton22.setText("F");
				jButton22.setFont(new java.awt.Font("仿宋",0,12));
				jButton22.setBounds(57, 201, 46, 28);
				jButton22.setEnabled(false);
			}
			{
				jButton23 = new JButton();
				getContentPane().add(jButton23);
				jButton23.setText("E");
				jButton23.setFont(new java.awt.Font("宋体",0,12));
				jButton23.setBounds(108, 201, 46, 28);
				jButton23.setEnabled(false);
			}
			{
				jButton24 = new JButton();
				getContentPane().add(jButton24);
				jButton24.setText("D");
				jButton24.setFont(new java.awt.Font("宋体",0,12));
				jButton24.setBounds(159, 201, 46, 28);
				jButton24.setEnabled(false);
			}
			{
				jButton25 = new JButton();
				getContentPane().add(jButton25);
				jButton25.setText("÷");
				jButton25.setFont(new java.awt.Font("宋体",0,12));
				jButton25.setBounds(210, 201, 46, 28);
				jButton25.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//为÷添加监听器
						if(equal==1) {
							equal=0;
						}
						yunsuan = 4;//代表除法
						sb1 = sb2;
						zhengfu = 0;
						sb3 = "÷"+sb2.toString();
						if(jinzhi==10) {
							ls1 = new Number(Double.parseDouble(sb2.toString()));
						} else {
							ls1 = new Number(JinzhiUtil.toshi(sb2.toString(), jinzhi));
						}
						sb2 = new StringBuffer("");
						sb = sb3+"\n"+"0";
						sb1.append("÷");
						jTextArea1.setText(sb);
					}
				});
			}
			{
				jButton26 = new JButton();
				getContentPane().add(jButton26);
				jButton26.setText("±");
				jButton26.setFont(new java.awt.Font("宋体",0,12));
				jButton26.setBounds(6, 234, 46, 28);
				jButton26.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//为小数点添加监听器
						if(zhengfu == 0) {
							sb2.insert(0, "-");
							zhengfu = 1;
							sb = sb1.toString()+"\n"+sb2.toString();
							jTextArea1.setText(sb);
							return;
						}
						if(zhengfu == 1) {
							sb2.replace(0, 1, "");
							zhengfu = 0;
							sb = sb1.toString()+"\n"+sb2.toString();
							jTextArea1.setText(sb);
							return;
						}
					}
				});
			}
			{
				jButton27 = new JButton();
				getContentPane().add(jButton27);
				jButton27.setText("·");
				jButton27.setFont(new java.awt.Font("仿宋",0,12));
				jButton27.setBounds(57, 234, 46, 28);
				jButton27.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//为小数点添加监听器
						if(!"".equals(sb2.toString())){
							sb = sb1.toString()+"\n"+"."+sb2.toString();
							sb2 = new StringBuffer(sb2.toString()+".");
							jTextArea1.setText(sb);
						}
					}
				});
			}
			{
				jButton28 = new JButton();
				getContentPane().add(jButton28);
				jButton28.setText("\uff0b");
				jButton28.setFont(new java.awt.Font("宋体",0,12));
				jButton28.setBounds(108, 234, 46, 28);
				jButton28.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//为+添加监听器
						if(equal==1) {
							equal=0;
						}
						yunsuan = 1;//代表加法
						sb1 = sb2;
						zhengfu = 0;
						if(jinzhi==10) {
							ls1 = new Number(Double.parseDouble(sb2.toString()));
						} else {
							ls1 = new Number(JinzhiUtil.toshi(sb2.toString(), jinzhi));
						}
						sb2 = new StringBuffer("");
						sb1.append("+");
						sb = sb1.toString()+"\n"+"0";
						jTextArea1.setText(sb);
					}
				});
			}
			{
				jButton29 = new JButton();
				getContentPane().add(jButton29);
				jButton29.setText("\uff0d");
				jButton29.setFont(new java.awt.Font("宋体",0,12));
				jButton29.setBounds(159, 234, 46, 28);
				jButton29.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//为-添加监听器
						if(equal==1) {
							equal=0;
						}
						yunsuan = 2;//代表减法
						sb1 = sb2;
						zhengfu = 0;
						if(jinzhi==10) {
							ls1 = new Number(Double.parseDouble(sb2.toString()));
						} else {
							ls1 = new Number(JinzhiUtil.toshi(sb2.toString(), jinzhi));
						}
						sb2 = new StringBuffer("");
						sb1.append("-");
						sb = sb1.toString()+"\n"+"0";
						jTextArea1.setText(sb);
					}
				});
			}
			{
				jButton30 = new JButton();
				getContentPane().add(jButton30);
				jButton30.setText("=");
				jButton30.setFont(new java.awt.Font("宋体",0,12));
				jButton30.setBounds(210, 234, 46, 28);
				jButton30.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//为=号添加监听器
						if(equal!=1) {//不能连续按下等于号
						equal = 1;
						sb1 = sb1.append(sb2);
						sb3 = sb2.toString()+sb3; 
						zhengfu = 0;
						if(jinzhi==10) {
							ls2 = new Number(Double.parseDouble(sb2.toString()));
						} else {
							ls2 = new Number(JinzhiUtil.toshi(sb2.toString(), jinzhi));
						}
						switch(yunsuan) {
							case 1:{
								ls3 = new Number(ls1.getNum()+ls2.getNum());
								if(jinzhi==10) {
									
									String str = Double.toString(ls3.getNum());
									if(str.endsWith(".0")) {
										str = str.substring(0, str.length()-2);
									}
									sb2 = new StringBuffer(str);
								} else {
									sb2 = new StringBuffer(JinzhiUtil.fromshi(ls3.getNum(), jinzhi));
								}
								sb = sb1.toString()+"\n"+sb2.toString();
								jTextArea1.setText(sb);
								FioStream.inputtoTxt(sb1.toString()+"="+sb2.toString());
								break;
							}
							case 2:{
								ls3 = new Number(ls1.getNum()-ls2.getNum());
								if(jinzhi==10) {
									String str = Double.toString(ls3.getNum());
									if(str.endsWith(".0")) {
										str = str.substring(0, str.length()-2);
									}
									sb2 = new StringBuffer(str);
								} else {
									sb2 = new StringBuffer(JinzhiUtil.fromshi(ls3.getNum(), jinzhi));
								}
								sb = sb1.toString()+"\n"+sb2.toString();
								jTextArea1.setText(sb);
								FioStream.inputtoTxt(sb1.toString()+"="+sb2.toString());
								break;
							}
							case 3:{
								ls3 = new Number(ls1.getNum()*ls2.getNum());
								if(jinzhi==10) {
									String str = Double.toString(ls1.getNum()*ls2.getNum());
									if(str.endsWith(".0")) {
										str = str.substring(0, str.length()-2);
									}
									sb2 = new StringBuffer(str);
								} else {
									sb2 = new StringBuffer(JinzhiUtil.fromshi(ls1.getNum()*ls2.getNum(), jinzhi));
								}
								sb = sb3+"\n"+sb2.toString();
								jTextArea1.setText(sb);
								FioStream.inputtoTxt(sb1.toString()+"="+sb2.toString());
								break;
							}
							case 4:{
								ls3 = new Number(ls1.getNum()/ls2.getNum());
								if(jinzhi==10) {
									String str = Double.toString(ls1.getNum()/ls2.getNum());
									if(str.endsWith(".0")) {
										str = str.substring(0, str.length()-2);
									}
									sb2 = new StringBuffer(str);
								} else {
									sb2 = new StringBuffer(JinzhiUtil.fromshi(ls1.getNum()/ls2.getNum(), jinzhi));
								}
								sb = sb3+"\n"+sb2.toString();
								jTextArea1.setText(sb);
								FioStream.inputtoTxt(sb1.toString()+"="+sb2.toString());
								break;
							}
							case 5:{
								ls3 = new Number(Math.pow(ls1.getNum(), ls2.getNum()));
								if(jinzhi==10) {
									String str = Double.toString(Math.pow(ls1.getNum(), ls2.getNum()));
									if(str.endsWith(".0")) {
										str = str.substring(0, str.length()-2);
									}
									sb2 = new StringBuffer(str);
								} else {
									sb2 = new StringBuffer(JinzhiUtil.fromshi(Math.pow(ls1.getNum(), ls2.getNum()), jinzhi));
								}
								sb = sb3+"\n"+sb2.toString();
								jTextArea1.setText(sb);
								FioStream.inputtoTxt(sb1.toString()+"="+sb2.toString());
								break;
							}
							case 6:{
								ls3 = new Number(Maths.A(ls1.getNum().intValue(), ls2.getNum().intValue()));
								if(jinzhi==10) {
									String str = Double.toString(Maths.A(ls1.getNum().intValue(), ls2.getNum().intValue()));
									if(str.endsWith(".0")) {
										str = str.substring(0, str.length()-2);
									}
									sb2 = new StringBuffer(str);
								} else {
									sb2 = new StringBuffer(JinzhiUtil.fromshi(Maths.A(ls1.getNum().intValue(), ls2.getNum().intValue()), jinzhi));
								}
								sb = "("+"A("+ls1.getNum()+","+ls2.getNum()+"\n"+sb2.toString();
								jTextArea1.setText(sb);
								FioStream.inputtoTxt("A("+ls1.getNum()+","+ls2.getNum()+")"+"="+sb2.toString());
								break;
							}
							case 7:{
								ls3 = new Number(Maths.C(ls1.getNum().intValue(), ls2.getNum().intValue()));
								if(jinzhi==10) {
									String str = Double.toString(Maths.C(ls1.getNum().intValue(), ls2.getNum().intValue()));
									if(str.endsWith(".0")) {
										str = str.substring(0, str.length()-2);
									}
									sb2 = new StringBuffer(str);
								} else {
									sb2 = new StringBuffer(JinzhiUtil.fromshi(Maths.C(ls1.getNum().intValue(), ls2.getNum().intValue()), jinzhi));
								}
								sb = "("+"C("+ls1.getNum()+","+ls2.getNum()+"\n"+sb2.toString();
								jTextArea1.setText(sb);
								FioStream.inputtoTxt("C("+ls1.getNum()+","+ls2.getNum()+")"+"="+sb2.toString());
								break;
							}
						}
					}
				}
				});
			}
			{
				jButton32 = new JButton();
				getContentPane().add(jButton32);
				jButton32.setText("sin");
				jButton32.setFont(new java.awt.Font("宋体",0,12));
				jButton32.setBounds(261, 69, 56, 28);
				jButton32.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						double d = Double.parseDouble(sb2.toString());
						sj = new Sanjiao(d,du);
						
						sb1 = new StringBuffer("("+"sin("+sb2.toString());
						double result = Maths.sinh(sj);
						sb2 = new StringBuffer(Double.toString(result));
						jTextArea1.setText(sb1.toString()+"\n"+sb2.toString());
						FioStream.inputtoTxt("sin("+d+")="+sb2.toString());
					}
				});
			}
			//角度制
			{
				jRadioButton5 = new JRadioButton();
				getContentPane().add(jRadioButton5);
				jRadioButton5.setText("\u89d2\u5ea6");
				jRadioButton5.setFont(new java.awt.Font("宋体",0,10));
				jRadioButton5.setBounds(269, 46, 45, 19);
				jRadioButton5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(!"".equals(sb2.toString())&& sb2!=null) {
							double d = Double.parseDouble(sb2.toString());
							sj = new Sanjiao(d,du);
							sb2 = new StringBuffer(Double.toString(sj.getA()));
						}
						du = 0;
						jRadioButton6.setSelected(false);
						jTextArea1.setText("\n"+sb2.toString());
					}
				});
			}
			//弧度制
			{
				jRadioButton6 = new JRadioButton();
				getContentPane().add(jRadioButton6);
				jRadioButton6.setText("\u5f27\u5ea6");
				jRadioButton6.setFont(new java.awt.Font("宋体",0,10));
				jRadioButton6.setBounds(327, 46, 47, 19);
				jRadioButton6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(!"".equals(sb2.toString())&& sb2!=null) {
							double d = Double.parseDouble(sb2.toString());
							sj = new Sanjiao(d,du);
							sb2 = new StringBuffer(Double.toString(sj.getB()));
						}
						du = 1;
						jRadioButton5.setSelected(false);
						jTextArea1.setText("\n"+sb2.toString());
					}
				});
			}
			{//sin
				jButton33 = new JButton();
				getContentPane().add(jButton33);
				jButton33.setText("tan");
				jButton33.setFont(new java.awt.Font("宋体",0,12));
				jButton33.setBounds(261, 102, 56, 28);
				jButton33.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						double d = Double.parseDouble(sb2.toString());
						sj = new Sanjiao(d,du);
						
						sb1 = new StringBuffer("("+"tan("+sb2.toString());
						double result = Maths.tanh(sj);
						sb2 = new StringBuffer(Double.toString(result));
						jTextArea1.setText(sb1.toString()+"\n"+sb2.toString());
						FioStream.inputtoTxt("tan("+d+")="+sb2.toString());
					}
				});
			}
			{
				jButton34 = new JButton();
				getContentPane().add(jButton34);
				jButton34.setText("sec");
				jButton34.setFont(new java.awt.Font("宋体",0,12));
				jButton34.setBounds(261, 135, 56, 28);
				jButton34.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						double d = Double.parseDouble(sb2.toString());
						sj = new Sanjiao(d,du);
						
						sb1 = new StringBuffer("("+"sec("+sb2.toString());
						double result = Maths.sech(sj);
						sb2 = new StringBuffer(Double.toString(result));
						jTextArea1.setText(sb1.toString()+"\n"+sb2.toString());
						FioStream.inputtoTxt("sec("+d+")="+sb2.toString());
					}
				});
			}
			{
				jButton35 = new JButton();
				getContentPane().add(jButton35);
				jButton35.setText("ln");
				jButton35.setFont(new java.awt.Font("宋体",0,12));
				jButton35.setBounds(261, 168, 56, 28);
				jButton35.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						double d = Double.parseDouble(sb2.toString());
						
						sb1 = new StringBuffer("("+"ln("+sb2.toString());
						double result = Math.log(d);
						sb2 = new StringBuffer(Double.toString(result));
						jTextArea1.setText(sb1.toString()+"\n"+sb2.toString());
						FioStream.inputtoTxt("ln("+d+")="+sb2.toString());
					}
				});
			}
			{
				jButton36 = new JButton();
				getContentPane().add(jButton36);
				jButton36.setText("x^n");
				jButton36.setFont(new java.awt.Font("宋体",0,12));
				jButton36.setBounds(261, 201, 56, 28);
				jButton36.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//为^添加监听器
						if(equal==1) {
							equal=0;
						}
						yunsuan = 5;//代表乘法
						sb1 = sb2;
						sb3 = "^"+sb2.toString();
						if(jinzhi==10) {
							ls1 = new Number(Double.parseDouble(sb2.toString()));
						} else {
							ls1 = new Number(JinzhiUtil.toshi(sb2.toString(), jinzhi));
						}
						sb2 = new StringBuffer("");
						sb = sb3+"\n"+"0";
						sb1.append("^");
						jTextArea1.setText(sb);
					}
				});
			}
			{
				jButton37 = new JButton();
				getContentPane().add(jButton37);
				jButton37.setText("A");
				jButton37.setFont(new java.awt.Font("宋体",0,12));
				jButton37.setBounds(261, 234, 56, 28);
				jButton37.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//为=号添加监听器
						if(equal==1) {
							equal=0;
						}
						yunsuan = 6;//代表乘法
						sb1 = sb2;
						sb3 = sb2.toString();
						if(jinzhi==10) {
							ls1 = new Number(Double.parseDouble(sb2.toString()));
						} else {
							ls1 = new Number(JinzhiUtil.toshi(sb2.toString(), jinzhi));
						}
						sb2 = new StringBuffer("");
						sb = sb3+"\n"+"0";
						sb1.append("");
						jTextArea1.setText(sb);
					}
				});
			}
			{
				jButton38 = new JButton();
				getContentPane().add(jButton38);
				jButton38.setText("cos");
				jButton38.setFont(new java.awt.Font("宋体",0,12));
				jButton38.setBounds(322, 69, 56, 28);
				jButton38.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						double d = Double.parseDouble(sb2.toString());
						sj = new Sanjiao(d,du);
						
						sb1 = new StringBuffer("("+"cos("+sb2.toString());
						double result = Maths.cosh(sj);
						sb2 = new StringBuffer(Double.toString(result));
						jTextArea1.setText(sb1.toString()+"\n"+sb2.toString());
						FioStream.inputtoTxt("cos("+d+")="+sb2.toString());
					}
				});
			}
			{
				jButton39 = new JButton();
				getContentPane().add(jButton39);
				jButton39.setText("cot");
				jButton39.setFont(new java.awt.Font("宋体",0,12));
				jButton39.setBounds(322, 102, 56, 28);
				jButton39.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						double d = Double.parseDouble(sb2.toString());
						sj = new Sanjiao(d,du);
						
						sb1 = new StringBuffer("("+"cot("+sb2.toString());
						double result = Maths.coth(sj);
						sb2 = new StringBuffer(Double.toString(result));
						jTextArea1.setText(sb1.toString()+"\n"+sb2.toString());
						FioStream.inputtoTxt("cot("+d+")="+sb2.toString());
					}
				});
			}
			{
				jButton40 = new JButton();
				getContentPane().add(jButton40);
				jButton40.setText("csc");
				jButton40.setFont(new java.awt.Font("宋体",0,12));
				jButton40.setBounds(322, 135, 56, 28);
				jButton40.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						double d = Double.parseDouble(sb2.toString());
						sj = new Sanjiao(d,du);
						
						sb1 = new StringBuffer("("+"csc("+sb2.toString());
						double result = Maths.csch(sj);
						sb2 = new StringBuffer(Double.toString(result));
						jTextArea1.setText(sb1.toString()+"\n"+sb2.toString());
						FioStream.inputtoTxt("csc("+d+")="+sb2.toString());
					}
				});
			}
			{
				jButton41 = new JButton();
				getContentPane().add(jButton41);
				jButton41.setText("lg");
				jButton41.setFont(new java.awt.Font("宋体",0,12));
				jButton41.setBounds(322, 168, 56, 28);
				jButton41.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						double d = Double.parseDouble(sb2.toString());

						sb1 = new StringBuffer("("+"lg("+sb2.toString());
						double result = Math.log10(d);
						sb2 = new StringBuffer(Double.toString(result));
						jTextArea1.setText(sb1.toString()+"\n"+sb2.toString());
						FioStream.inputtoTxt("lg("+d+")="+sb2.toString());
					}
				});
			}
			{
				jButton42 = new JButton();
				getContentPane().add(jButton42);
				jButton42.setText("n!");
				jButton42.setFont(new java.awt.Font("宋体",0,12));
				jButton42.setBounds(322, 201, 56, 28);
				jButton42.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//为=号添加监听器
						double d = Double.parseDouble(sb2.toString());
						
						sb1 = new StringBuffer(sb2.toString()+"!");
						double result = Maths.jiecheng(Double.valueOf(d).intValue());
						sb2 = new StringBuffer(Double.toString(result));
						jTextArea1.setText(sb1.toString()+"\n"+sb2.toString());
						FioStream.inputtoTxt(d+"!="+sb2.toString());
					}
				});
			}
			{
				jButton43 = new JButton();
				getContentPane().add(jButton43);
				jButton43.setText("C");
				jButton43.setFont(new java.awt.Font("宋体",0,12));
				jButton43.setBounds(322, 234, 56, 28);
				jButton43.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//为=号添加监听器
						if(equal==1) {
							equal=0;
						}
						yunsuan = 7;//代表乘法
						sb1 = sb2;
						sb3 = sb2.toString();
						if(jinzhi==10) {
							ls1 = new Number(Double.parseDouble(sb2.toString()));
						} else {
							ls1 = new Number(JinzhiUtil.toshi(sb2.toString(), jinzhi));
						}
						sb2 = new StringBuffer("");
						sb = sb3+"\n"+"0";
						sb1.append("");
						jTextArea1.setText(sb);
					}
				});
			}
			{//数字按钮添加监听器
				jButton6.addActionListener(listener1);
				jButton7.addActionListener(listener1);
				jButton8.addActionListener(listener1);
				jButton9.addActionListener(listener1);
				jButton11.addActionListener(listener1);
				jButton12.addActionListener(listener1);
				jButton13.addActionListener(listener1);
				jButton14.addActionListener(listener1);
				jButton16.addActionListener(listener1);
				jButton17.addActionListener(listener1);
				jButton18.addActionListener(listener1);
				jButton19.addActionListener(listener1);
				jButton22.addActionListener(listener1);
				jButton23.addActionListener(listener1);
				jButton24.addActionListener(listener1);
			}
			pack();
			this.setSize(275, 326);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
