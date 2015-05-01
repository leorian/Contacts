package com.lt.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.lt.model.DBManager;
import com.lt.model.MultiCommponent;
import com.lt.model.PanelFactory;
import com.lt.model.Person;
import com.lt.res.ModifyJTFRes;
import com.lt.res.Strings;

public class ModifyHandler implements ActionListener {
	DBManager db = new DBManager();
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(Strings.MODIFY_CANCEL_TEXT))
		{
			MultiCommponent.newInstance().returnJB(1).setText(Strings.T_LEFT_TEXT+"("+db.getPersonCount()+")");
			PanelFactory.newInstance().createPanel(MultiCommponent.newInstance().returnJB(1).getText());
		}
		else if(e.getActionCommand().equals(Strings.MODIFY_SAVE_TEXT))
		{
			Person person = new Person();
			person.setCellphone(ModifyJTFRes.newInstance().CELLPHONE.getText());
			person.setEmail(ModifyJTFRes.newInstance().EMAIL.getText());
			person.setGroupnum(db.getGroupIDbyGroupName(ModifyJTFRes._GROUP_NAME_));//’‚¿Ô”–bug
			person.setName(ModifyJTFRes.newInstance().USEARNAME.getText());
			person.setQq(ModifyJTFRes.newInstance().QQNUMBER.getText());
			person.setSex(ModifyJTFRes.SEX);
			db.modifyPersonByCell(ModifyJTFRes.PERSON,person);
			MultiCommponent.newInstance().returnJB(2).setText(db.getGroupName(person.getGroupnum())+"("+db.getSingleGroupCount(db.getGroupName(person.getGroupnum()))+")");
			PanelFactory.newInstance().createPersonInfoDisplay(person.getCellphone());
		}
	}

}
