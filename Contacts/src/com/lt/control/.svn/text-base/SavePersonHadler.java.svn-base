package com.lt.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.lt.model.DBManager;
import com.lt.model.MultiCommponent;
import com.lt.model.PanelFactory;
import com.lt.model.Person;
import com.lt.res.AddJTFRes;
import com.lt.res.Strings;

public class SavePersonHadler implements ActionListener{
	DBManager db = new DBManager();
	@Override
	public void actionPerformed(ActionEvent e) {
		Person p = new Person();
		p.setName(AddJTFRes.newInstance().USEARNAME.getText());
		p.setSex(AddJTFRes.SEX);
		p.setCellphone(AddJTFRes.newInstance().CELLPHONE.getText());
		p.setQq(AddJTFRes.newInstance().QQNUMBER.getText());
		p.setEmail(AddJTFRes.newInstance().EMAIL.getText());
		p.setGroupnum(db.getGroupIDbyGroupName(AddJTFRes._GROUP_NAME));
		if(AddJTFRes.newInstance().USEARNAME.getText().equals("")||AddJTFRes.newInstance().USEARNAME.getText().equals("用户名不能为空"))
		{
			AddJTFRes.newInstance().USEARNAME.setText("用户名不能为空");
		}
		else if (AddJTFRes.newInstance().CELLPHONE.getText().equals("")||AddJTFRes.newInstance().CELLPHONE.getText().equals("手机号码不能为空"))
		{
			AddJTFRes.newInstance().CELLPHONE.setText("手机号码不能为空");
			
		}
		else if(!AddJTFRes.newInstance().CELLPHONE.getText().matches("\\d{11}"))
		{
			AddJTFRes.newInstance().CELLPHONE.setText("手机号码11位");
		}
		else
		{
			boolean flag = db.InsertInfo(p);//只考虑插入成功
			if(flag)
			{
				MultiCommponent.newInstance().returnJB(1).setText(Strings.T_LEFT_TEXT+"("+db.getPersonCount()+")");
				PanelFactory.newInstance().createPanel(MultiCommponent.newInstance().returnJB(1).getText());
			}
		}
		
	}
}
