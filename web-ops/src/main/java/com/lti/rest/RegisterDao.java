package com.lti.rest;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


public class RegisterDao {

		public void add(Register reg){
			Connection conn=null; //managed the connection between the app and database
			PreparedStatement stmt=null;
			try {
				
				InputStream is=this.getClass().getClassLoader().getResourceAsStream("dev-db.properties");
				Properties dbprops=new Properties();
				dbprops.load(is);
				
				Class.forName(dbprops.getProperty("driver"));
				conn = DriverManager.getConnection(dbprops.getProperty("url"),dbprops.getProperty("user"),dbprops.getProperty("pass"));
				
				
				
				/*Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");*/
				
				String sql = "insert into Register values(?,?,?,?)"; 
				stmt = conn.prepareStatement(sql);
				
				stmt.setString(1, reg.getName()); 
				stmt.setString(2, reg.getEmail()); 
				stmt.setString(3, reg.getUsername());
				stmt.setString(4,  reg.getPassword());
				stmt.executeUpdate();
			}
			catch(ClassNotFoundException e) {
				System.out.println("JDBC Driver not found");
			}
			catch(SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			finally {
				try { conn.close(); } catch(Exception e) {
			} 


		}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       }	   
	   }
