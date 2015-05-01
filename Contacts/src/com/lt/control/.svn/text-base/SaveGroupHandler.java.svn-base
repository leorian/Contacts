package com.lt.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.lt.model.DBManager;
import com.lt.model.Group;
import com.lt.model.MultiCommponent;
import com.lt.model.PanelFactory;
import com.lt.res.AddJTFRes;

public class SaveGroupHandler implements ActionListener {
	DBManager db = new DBManager();
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Group g = new Group();
		if(AddJTFRes.newInstance().NEWGROUP.getText().equals("")||AddJTFRes.newInstance().NEWGROUP.getText().equals("名称不能为空")
				)
		{
			AddJTFRes.newInstance().NEWGROUP.setText("名称不能为空");
			AddJTFRes.newInstance().NEWGROUP.updateUI();
		}
		else
		{
			g.setId(db.getGroupCount()+1);
			g.setGroupname(AddJTFRes.newInstance().NEWGROUP.getText());
			ArrayList<Group> list = db.getAllGroup();
			boolean flag = true;
			for(int i=0; i<list.size();i++)
			{
				if(list.get(i).getGroupname().equals(g.getGroupname().trim()))
				{
					flag = false;
					break;
				}
			}
			if(flag){
				db.InsertNewFenLei(g);
				PanelFactory.newInstance().createPanel(MultiCommponent.newInstance().returnJB(2).getText());
			}
			else
			{
				AddJTFRes.newInstance().NEWGROUP.setText("名称不能重复");
				AddJTFRes.newInstance().NEWGROUP.updateUI();
			}
		}
	}

}
