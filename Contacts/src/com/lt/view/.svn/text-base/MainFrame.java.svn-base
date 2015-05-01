package com.lt.view;

import java.awt.*;
import javax.swing.*;
import com.lt.control.*;
import com.lt.model.*;

public class MainFrame extends JFrame{
	/**
	 * @author Administrator
	 */
	private static final long serialVersionUID = 1L;
	 
	private TopPanel top = new TopPanel(MultiCommponent.newInstance().returnJB(1),
			MultiCommponent.newInstance().returnJB(2),
			MultiCommponent.newInstance().returnJB(3));
	private BottomPanel bottom = new BottomPanel(MultiCommponent.newInstance().returnJB(4),
			MultiCommponent.newInstance().returnJB(5),
			MultiCommponent.newInstance().returnJB(6));
	private JPanel middle = PanelFactory.newInstance().createPanel(null);//面板工厂提供不同的面板
	public MainFrame()
	{
		setSize(320, 480);
		middle.setPreferredSize(new Dimension(320,380));
		getContentPane().add(top, BorderLayout.NORTH);
		getContentPane().add(middle, BorderLayout.CENTER);
		getContentPane().add(bottom,BorderLayout.SOUTH);
		
		MultiCommponent.newInstance().returnJB(1).addActionListener(new BigButtonHandler());
		MultiCommponent.newInstance().returnJB(2).addActionListener(new BigButtonHandler());
		MultiCommponent.newInstance().returnJB(3).addActionListener(new BigButtonHandler());
		MultiCommponent.newInstance().returnJB(4).addActionListener(new BigButtonHandler());
		MultiCommponent.newInstance().returnJB(5).addActionListener(new BigButtonHandler());
		MultiCommponent.newInstance().returnJB(6).addActionListener(new BigButtonHandler());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	public static void main(String args[])
	{
		new MainFrame();
	}
}
