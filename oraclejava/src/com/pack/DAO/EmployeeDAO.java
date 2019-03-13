package com.pack.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pack.JDBCConnection;
import com.pack.model.Employee;

public class EmployeeDAO {
	public static int insertEmployee(Employee e) throws Exception{
		Connection con=JDBCConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into employee values (?,?,?,?,?)");
		ps.setInt(1,e.getId());
		ps.setString(2,e.getName());
		ps.setFloat(3,e.getSal());
		java.sql.Date d1=new java.sql.Date(e.getDob().getTime());
		ps.setDate(4,d1);
		ps.setString(5,e.getDesignation());
		int i=ps.executeUpdate();
		con.close();
		return i;
	}
	public static int updateEmployee(Employee e) throws Exception{
		Connection con=JDBCConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("update employee set salary=?,designation=? where id=?");
		ps.setFloat(1, e.getSal());
		ps.setString(2, e.getDesignation());
		ps.setInt(3, e.getId());
		int i=ps.executeUpdate();
		con.close();
		return i;
	}
	
	public static int deleteEmployee(int e) throws Exception{
		Connection con=JDBCConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("delete from employee where id=?");
		ps.setInt(1,e);
		int i=ps.executeUpdate();
		con.close();
		return i;
	}
	public static List<Employee> fetchEmployee() throws Exception{
		Connection con=JDBCConnection.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from employee");
		List<Employee> l=new ArrayList<>();
		while(rs.next()){
			Employee e=new Employee();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setSal(rs.getFloat(3));
			java.util.Date d = new java.util.Date(rs.getDate(4).getTime());
			e.setDob(d);
			e.setDesignation(rs.getString(5));
			l.add(e);
		}
		return l;
	}
}
