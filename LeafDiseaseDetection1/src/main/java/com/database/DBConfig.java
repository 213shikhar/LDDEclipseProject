package com.database;
import java.sql.*;

public class DBConfig {
	Connection con;
	public DBConfig(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lddDB", "root", "sql213");
//			System.out.println("Connected to Database!");
		}
		catch (Exception excp) {}
	}
	public Connection getCon() {
		return con;
	}
}