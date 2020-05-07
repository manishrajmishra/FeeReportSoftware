package com.manish.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.manish.Beans.StudentBean;
public class StudentDao {
	
public static int save(StudentBean bean){
	int status=0;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("insert into fee_student(name,email,sex,course,fee,paid,due,address,contact,doj) values(?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1,bean.getName());
		ps.setString(2,bean.getEmail());
		ps.setString(3,bean.getSex());
		ps.setString(4,bean.getCourse());
		ps.setInt(5,bean.getFee());
		ps.setInt(6,bean.getPaid());
		ps.setInt(7,bean.getDue());
		ps.setString(8,bean.getAddress());
		ps.setString(9,bean.getContact());
		ps.setDate(10,(Date) bean.getDoj());
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}
public static int update(StudentBean bean){
	int status=0;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("update fee_student set name=?,email=?,sex=?,course=?,fee=?,paid=?,due=?,address=?,contact=?,doj=? where rollno=?");
		ps.setString(1,bean.getName());
		ps.setString(2,bean.getEmail());
		ps.setString(3,bean.getSex());
		ps.setString(4,bean.getCourse());
		ps.setInt(5,bean.getFee());
		ps.setInt(6,bean.getPaid());
		ps.setInt(7,bean.getDue());
		ps.setString(8,bean.getAddress());
		ps.setString(9,bean.getContact());
		ps.setDate(10,(Date) bean.getDoj());
		ps.setInt(11,bean.getRollno());
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}	
public static int delete(int rollno){
	int status=0;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("delete from fee_student where rollno=?");
		ps.setInt(1,rollno);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}
public static int deleteByName(String name){
	int status=0;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("delete from student where name=?");
		ps.setString(1,name);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}

public static List<StudentBean> getAllRecords(){
	List<StudentBean> list=new ArrayList<StudentBean>();
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("select * from fee_student");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			StudentBean bean=new StudentBean();
			bean.setRollno(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setEmail(rs.getString(3));
			bean.setSex(rs.getString(4));
			bean.setCourse(rs.getString(5));
			bean.setFee(rs.getInt(6));
			bean.setPaid(rs.getInt(7));
			bean.setDue(rs.getInt(8));
			bean.setAddress(rs.getString(9));
			bean.setContact(rs.getString(10));
			bean.setDoj(rs.getDate(11));
			list.add(bean);
		}
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	
	return list;
}
public static List<StudentBean> getDues(){
	List<StudentBean> list=new ArrayList<StudentBean>();
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("select * from fee_student where due>0");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			StudentBean bean=new StudentBean();
			bean.setRollno(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setEmail(rs.getString(3));
			bean.setSex(rs.getString(4));
			bean.setCourse(rs.getString(5));
			bean.setFee(rs.getInt(6));
			bean.setPaid(rs.getInt(7));
			bean.setDue(rs.getInt(8));
			bean.setAddress(rs.getString(9));
			bean.setContact(rs.getString(10));
			bean.setDoj(rs.getDate(11));
			list.add(bean);
		}
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	
	return list;
}

public static StudentBean getRecordByRollno(int rollno){
	StudentBean bean=new StudentBean();
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("select * from fee_student where rollno=?");
		ps.setInt(1,rollno);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			bean.setRollno(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setEmail(rs.getString(3));
			bean.setSex(rs.getString(4));
			bean.setCourse(rs.getString(5));         
			bean.setFee(rs.getInt(6));
			bean.setPaid(rs.getInt(7));
			bean.setDue(rs.getInt(8));
			bean.setAddress(rs.getString(9));
			bean.setContact(rs.getString(10));
			bean.setDoj(rs.getDate(11));
		}
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	
	return bean;
}



public static ResultSet getSearchResults(String searchField, String searchString){
	ResultSet rst=null;
	int rollno=0;
	if("rollno".equalsIgnoreCase(searchField)) {
		rollno=Integer.parseInt(searchString);
		try {
			Connection con=DB.getCon();
			PreparedStatement pstmt=con.prepareStatement("SELECT * FROM fee_student WHERE "+searchField+" LIKE '%"+searchString+"%'");
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
				PreparedStatement pstmt=con.prepareStatement("SELECT * FROM fee_student WHERE "+searchField+" LIKE '%"+searchString+"%'");
				rst=pstmt.executeQuery();
			
			if(rst!=null) {
				return rst;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return rst;
}



public static ResultSet getTotalCollection(String searchString) {
	ResultSet rst=null;
	try {
		Connection con=DB.getCon();
		PreparedStatement pstmt=con.prepareStatement("Select SUM(paid) as totalPaid, COUNT(paid) as totalregister from fee_student where doj='"+searchString+"'");
		rst=pstmt.executeQuery();
		return rst;
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return rst;
}
}