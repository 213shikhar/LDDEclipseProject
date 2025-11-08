package com.dao;
import com.database.DBConfig;
import java.sql.*;
import java.io.*;

public class AdminDAO {
	Connection r = null;
	PreparedStatement ps;
	
	public AdminDAO(){
		DBConfig k = new DBConfig();
		r = k.getCon();
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
		public boolean checkAdmin(String e, String p) {
			try {
//				System.out.println("Checking Login....");
				ps = r.prepareStatement("select * from admin where Password = ? and Email = ?");
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
}
