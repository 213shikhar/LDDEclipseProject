package com.dao;
import java.sql.*;
import java.io.*;
import com.database.DBConfig;

public class UserDAO {
	Connection r = null;
	PreparedStatement ps;
	
	public UserDAO(){
		DBConfig k = new DBConfig();
		r = k.getCon();
	}
	// inserting record in the database
	public void addRecord(String n, String p, String e) {
		try {
			ps = r.prepareStatement("insert into user values(?,?,?)");
			ps.setString(1, n);
			ps.setString(2, p);
			ps.setString(3, e);
			ps.execute();
//			System.out.println("Record Added!");
		}
		catch (Exception excp){}
	}
	
	public void addAdmin(String n, String p, String e) {
		try {
			ps = r.prepareStatement("insert into admin values(?,?,?)");
			ps.setString(1, n);
			ps.setString(2, p);
			ps.setString(3, e);
			ps.execute();
//			System.out.println("Admin Added!");
		}
		catch (Exception excp){}
	}
	
	// checking for existing record
	public boolean checkRecord(String e, String p) {
		try {
//			System.out.println("Checking Login....");
			ps = r.prepareStatement("select * from user where Password = ? and Email = ?");
			ps.setString(1, p);
			ps.setString(2, e);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		}
		catch(Exception excp) {}
		return false;
	}
	
	public ResultSet profileUser(String em, String p) throws Exception {
		ps = r.prepareStatement("select * from user where Email = ? and Password = ?");
		ps.setString(1, em);
		ps.setString(2, p);
		ResultSet rs = ps.executeQuery();
		return rs;
	}
	
	public void updatePassword(String np, String em) {
		try {
			ps = r.prepareStatement("update user set Password = ? where Email = ?");
			ps.setString(1, np);
			ps.setString(2, em);
			ps.execute();
		}
		catch(Exception e) {}
		
	}
	
	public void addFeedback(String fd, String em) {
		try {
			ps = r.prepareStatement("update user set Feedback = ? where Email = ?");
			ps.setString(1, fd);
			ps.setString(2, em);
			ps.executeUpdate();
		}
		catch(Exception e) {}
	}
}