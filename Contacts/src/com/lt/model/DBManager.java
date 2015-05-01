package com.lt.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lt.res.AddJTFRes;

/**
 * @author Administrator
 *
 */
public class DBManager {
	private Connection conn = null;
	private Statement stmt = null;
	/**
	 * @return void
	 * Description 与数据库建立连接
	 */
	public void getConn()
	{
		try {
			//加载数据库驱动
			Class.forName(DBConst.CLASSNAME).newInstance(); 
			//开始连接数据库
			conn = DriverManager.getConnection(DBConst.URL, DBConst.NAME, DBConst.PASSWORD);
			//得到SQL执行对象
			stmt = conn.createStatement();
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
		 
	}
	
	/**
	 * @return ArrayList<Person>
	 * Description 获得所有联系人信息
	 */
	public ArrayList<Person> getAllResult()
	{
		ArrayList<Person> list = new ArrayList<Person>();
		
		getConn();
		try {
			ResultSet rs = stmt.executeQuery("select * from person");
			while(rs.next())
			{
				Person person = new Person();
				person.setCellphone(rs.getString(1));
				person.setName(rs.getString(2));
				person.setSex(rs.getString(3));
				person.setQq(rs.getString(4));
				person.setEmail(rs.getString(5));
				person.setGroupnum(rs.getInt(6));
				list.add(person);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("查询失败");
			e.printStackTrace();
		}
		closeConn();
		return list;
	}
	/**
	 * @returnArrayList<Group>
	 * Description 获得所有的分组
	 */
	public ArrayList<Group> getAllGroup()
	{
		ArrayList<Group> list = new ArrayList<Group>();
		getConn();
		try {
			ResultSet rs = stmt.executeQuery("select * from fenlei");
			while(rs.next())
			{
				Group group = new Group();
				group.setId(rs.getInt(1));
				group.setGroupname(rs.getString(2));
				list.add(group);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("查询失败");
			e.printStackTrace();
		}
		closeConn();
		return list;
	}
	
	/**
	 * @param str
	 * @return ArrayList<Person>
	 * Description 每个分组具体的联系人
	 */
	public ArrayList<Person> getInnerGroup(String str)
	{
		ArrayList<Person> list = new ArrayList<>();
		getConn();
		try {
			 
			ResultSet rs = stmt.executeQuery("select * from person where groupnum in (select id from fenlei where groupname = '"+str+"')" );
			while(rs.next())
			{
				Person person = new Person();
				person.setCellphone(rs.getString(1));
				person.setName(rs.getString(2));
				person.setSex(rs.getString(3));
				person.setQq(rs.getString(4));
				person.setEmail(rs.getString(5));
				person.setGroupnum(rs.getInt(6));
				list.add(person);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("查询失败");
			e.printStackTrace();
		}
		closeConn();
		return list;
	}
	
	/**
	 * @return length
	 * Description 得到联系人总数
	 */
	public int getPersonCount()
	{
		getConn();
		ResultSet rs;
		int length = 0;
		try {
			rs = stmt.executeQuery("select * from person");
			rs.last();
			length = rs.getRow();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConn();
		return length;
	}
	/**
	 * @return length
	 * Description 得到组的总数
	 */
	public int getGroupCount()
	{
		getConn();
		ResultSet rs;
		int length = 0;
		try {
			rs = stmt.executeQuery("select * from fenlei");
			rs.last();
			length = rs.getRow();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConn();
		return length;
	}
	
	/**
	 * @param str
	 * @return length
	 * Description 得到每个分组联系人的总数
	 */
	public int getSingleGroupCount(String str)
	{
		getConn();
		ResultSet rs;
		int length = 0;
		try {
			rs = stmt.executeQuery("select * from person where groupnum in (select id from fenlei where groupname = '"+str+"')" );
			rs.last();
			length = rs.getRow();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConn();
		return length;
	}

	/**
	 * @param str
	 * @return ArrayList<Person>
	 * 通过姓名查询联系人
	 */
	public ArrayList<Person> getSearchResultByName(String str)
	{
		ArrayList<Person> list = new ArrayList<>();
		getConn();
		try {
			ResultSet rs = stmt.executeQuery("select * from person where name like '%"+str+"%'");
			while(rs.next())
			{
				Person person = new Person();
				person.setCellphone(rs.getString(1));
				person.setName(rs.getString(2));
				list.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConn();
		return list;
	}
	
	/**
	 * @param str
	 * @returnArrayList<Person>
	 * 通过手机号查询联系人
	 */
	public ArrayList<Person> getSearchResultByCellPhone(String str)
	{
		ArrayList<Person> list = new ArrayList<>();
		getConn();
		try {
			ResultSet rs = stmt.executeQuery("select * from person where cellphone like '"+str+"%'");
			while(rs.next())
			{
				Person person = new Person();
				person.setCellphone(rs.getString(1));
				person.setName(rs.getString(2));
				list.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConn();
		return list;
	}
	/**
	 * @param person
	 * @return boolean
	 * 添加新的联系人信息
	 */
	public boolean InsertInfo(Person person)
	{
		getConn();
		String sql = "insert into person values('"+person.getCellphone()+"','"
				+person.getName()+"','"+person.getSex()+"','"+person.getQq()+"','"
				+person.getEmail()+"','"+person.getGroupnum()+"')";
		try {
				stmt.execute(sql);
		} catch (SQLException e) {
			AddJTFRes.newInstance().CELLPHONE.setText("此号码已存在");
			AddJTFRes.newInstance().CELLPHONE.updateUI();
			return false;
		}
		closeConn();
		return true;
	}
	/**
	 * @param group
	 * @return boolean
	 * 添加新的分组名称
	 */
	public boolean InsertNewFenLei(Group group)
	{
		getConn();
		String sql = "insert into fenlei values('"+group.getId()+"','"+group.getGroupname()+"')";
		try {
			stmt.execute(sql);
		} catch (SQLException e) {
			 return false;
		}
		closeConn();
		return true;
	}
	
	/**
	 * @param str
	 * @return Person
	 * 得到单个联系人的详细信息通过手机号码的形式
	 */
	public Person getOnePersonInfo(String str)
	{
		getConn();
		ResultSet rs;
		Person person = new Person();
		try {
			rs = stmt.executeQuery("select * from person where cellphone = '"+str+"'");
			while(rs.next())
			{
				person.setCellphone(rs.getString(1));
				person.setName(rs.getString(2));
				person.setSex(rs.getString(3));
				person.setQq(rs.getString(4));
				person.setEmail(rs.getString(5));
				person.setGroupnum(rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConn();
		return person;
	}
	/**
	 * @param id
	 * @return String
	 * 由组的ID得到组的名称
	 */
	
	public void deletePersonByCell(String str)
	{
		getConn();
		try {
			stmt.executeUpdate("delete from person where cellphone = '"+str+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConn();
	}
	/**
	 * @param id
	 * @return String
	 * 通过ID得到组名
	 */
	public String getGroupName(int id)
	{
		getConn();
		String str = null;
		try {
			ResultSet rs = stmt.executeQuery("select groupname from fenlei where id = " + id);
			while(rs.next())
			{
				str = rs.getString("groupname");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConn();
		return str;
	}
	/**
	 * @param cellphone
	 * @param person
	 * 
	 * 通过手机和原始数据修改联系人的详细信息
	 */
	public void modifyPersonByCell(String cellphone, Person person) {
		getConn();
		try {
			stmt.executeUpdate("update person set cellphone = '"+person.getCellphone()+"',name = '"
					+person.getName()+"', sex = '" + person.getSex()
					+"', qq = '"+person.getQq()+"', email = '" + 
					person.getEmail()+"', groupnum = "+person.getGroupnum()
					+" where cellphone = '" +cellphone+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConn();
	}
	public void changeGroup(String string, String actionCommand) {
		
		int id = getGroupIDbyGroupName(actionCommand);
		getConn();
		try {
			stmt.executeUpdate("update person set groupnum = " + id+" where cellphone = '"+string+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConn();
	}
	
	/**
	 * @param str
	 * @return integer
	 * 通过组名返回组号
	 */
	public int getGroupIDbyGroupName(String str)
	{
		int id = 0;
		getConn();
		try {
			ResultSet rs =stmt.executeQuery("select id from fenlei where groupname = '"+str+"'");
			while(rs.next())
			{
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConn();
		return id;
	}
	public void deleteGroupRelativePerson(String groupname) {
		int id = getGroupIDbyGroupName(groupname);
		getConn();
		try {
			stmt.execute("delete from fenlei where groupname = '" + groupname + "'");
			stmt.execute("delete from person where groupnum = " + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @return void
	 * Description 关闭数据库连接
	 */
	public void closeConn()
	{
		if(stmt != null)
		{
			try {
				stmt.close();
			} catch (SQLException e) {
				System.err.println("SQL执行对象stmt关闭失败");
				e.printStackTrace();
			}
		}
		if(conn != null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				System.err.println("SQL连接对象conn关闭失败");
				e.printStackTrace();
			}
		}
	}

	public void renameGroupName(String oldName, String newName) {
		getConn();
		try {
			stmt.executeUpdate("update fenlei set groupname = '"+newName+"' where groupname = '"+oldName+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConn();
	}

	

	
}
