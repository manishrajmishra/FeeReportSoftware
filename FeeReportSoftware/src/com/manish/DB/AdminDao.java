package com.manish.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDao {

	public static ResultSet validate(String email,String password){
		ResultSet rs=null;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from fee_admin where email=? and password=?");
			ps.setString(1,email);
			ps.setString(2,password);
			 rs=ps.executeQuery();
		}catch(Exception ex){System.out.println(ex);}
		return rs;
	}
	
	public static ResultSet validate(String email){
		ResultSet rs=null;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from fee_admin where email=?");
			ps.setString(1,email);
			 rs=ps.executeQuery();
			 return rs;
		}catch(Exception ex){System.out.println(ex);}
		return rs;
	}
	
}
