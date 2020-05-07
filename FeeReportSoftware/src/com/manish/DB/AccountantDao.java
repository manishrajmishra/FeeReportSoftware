package com.manish.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.manish.Beans.AccountantBean;

public class AccountantDao {
	
public static int save(AccountantBean bean){
	int status=0;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("insert into fee_accountant(name,email,password,address,contact) values(?,?,?,?,?)");
		ps.setString(1,bean.getName());
		ps.setString(2,bean.getEmail());
		ps.setString(3,bean.getPassword());
		ps.setString(4,bean.getAddress());
		ps.setString(5,bean.getContact());
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}
public static ResultSet validate(String email,String password){
	//boolean status=false;
	ResultSet rs=null;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("select * from fee_accountant where email=? and password=?");
		ps.setString(1,email);
		ps.setString(2,password);
		 rs=ps.executeQuery();
		//status=rs.next();
		//con.close();
	}catch(Exception ex){System.out.println(ex);}
	return rs;
}
public static ResultSet validate(String email){
	//boolean status=false;
	ResultSet rs=null;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("select * from fee_accountant where email=?");
		ps.setString(1,email);
		 rs=ps.executeQuery();
		 return rs;
		//status=rs.next();
		//con.close();
	}catch(Exception ex){System.out.println(ex);}
	return rs;
}
public static int update(AccountantBean bean){
	int status=0;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("update fee_accountant set name=?,email=?,password=?,address=?,contact=? where id=?");
		ps.setString(1,bean.getName());
		ps.setString(2,bean.getEmail());
		ps.setString(3,bean.getPassword());
		ps.setString(4,bean.getAddress());
		ps.setString(5,bean.getContact());
		ps.setInt(6,bean.getId());
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}	

public static int delete(int id){
	int status=0;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("delete from fee_accountant where id=?");
		ps.setInt(1,id);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}

public static List<AccountantBean> getAllRecords(){
	List<AccountantBean> list=new ArrayList<AccountantBean>();
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("select * from fee_accountant");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			AccountantBean bean=new AccountantBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setEmail(rs.getString(3));
			bean.setPassword(rs.getString(4));
			bean.setAddress(rs.getString(5));
			bean.setContact(rs.getString(6));
			list.add(bean);
		}
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	
	return list;
}

public static AccountantBean getRecordById(int id){
	AccountantBean bean=new AccountantBean();
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("select * from fee_accountant where id=?");
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setEmail(rs.getString(3));
			bean.setPassword(rs.getString(4));
			bean.setAddress(rs.getString(5));
			bean.setContact(rs.getString(6));
		}
		con.close();
	}catch(Exception ex){System.out.println(ex);
	}
	return bean;
}

public static ResultSet getSearchResults(String searchField, String searchString){
	ResultSet rst=null;
	int id = 0;
	if("id".equalsIgnoreCase(searchField)) {
		id=Integer.parseInt(searchString);
		try {
			Connection con=DB.getCon();
			PreparedStatement pstmt=con.prepareStatement("SELECT * FROM fee_accountant WHERE "+searchField+" LIKE '%"+searchString+"%'");
			rst=pstmt.executeQuery();
			if(rst!=null) {
				return rst;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}else {
		try {
			Connection con=DB.getCon();
			PreparedStatement pstmt=con.prepareStatement("SELECT * FROM fee_accountant WHERE "+searchField+" LIKE '%"+searchString+"%'");
			rst=pstmt.executeQuery();
			if(rst!=null) {
				System.out.println(rst.getFetchSize());
				return rst;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return rst;
}
}
