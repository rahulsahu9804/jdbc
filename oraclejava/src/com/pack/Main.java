package com.pack;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.pack.model.Employee;
import com.pack.service.EmployeeBo;


public class Main {

	public static void main(String[] args) throws Exception {
		Scanner s=new Scanner(System.in);
		String name;
		float sal;
		String dob;
		String desg;
		int ch;
		int num;
		
		// TODO Auto-generated method stub
		do{
			
			System.out.println("####Employee Info ####");
			System.out.println("Menu");
			System.out.println("1.Add Employee");
			System.out.println("2.Update Employee");
			System.out.println("3.Delete Employee");
			System.out.println("4.View Employee");
			System.out.println("Enter Choice");
			ch=Integer.parseInt(s.nextLine());
			switch(ch){
			case 1:
				System.out.println("Enter Employee Name");
				name=s.nextLine();
				System.out.println("Enter Salary");
				sal=Float.parseFloat(s.nextLine());
				System.out.println("Enter DOB");
				dob=s.nextLine();
				System.out.println("Enter Designation");
				desg=s.nextLine();
				Random r=new Random();
				num = r.nextInt(900000)+100000;
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				sdf.setLenient(false);
				Date d=null;
				try{
					d=sdf.parse(dob);
				}
				catch(ParseException e){
					System.out.println(e);
				}
				Employee e=new Employee(num, name, sal, d, desg);
				int i=EmployeeBo.insertEmployee(e);
				if(i==1){
					System.out.println("Employee inserted successfully");
				}
					break;
					
					case 2:
						System.out.println("Enter Employee id");
						num=Integer.parseInt(s.nextLine());
						System.out.println("Enter employee salary");
						sal=Float.parseFloat(s.nextLine());
						System.out.println("Enter Designation");
						desg=s.nextLine();
						Employee e1= new Employee(num,sal,desg);
						int i1=EmployeeBo.updateEmployee(e1);
						if(i1==1){
							System.out.println("Employee updated successfully");
						}
						break;
						
						
					case 3:
						System.out.println("Enter Employee id");
						num=Integer.parseInt(s.nextLine());
						int i2=EmployeeBo.deleteEmployee(num);
						if(i2==1){
							System.out.println("\nEmployee deleted successfully\n");
						}
						break;
					case 4:
						List<Employee> l=EmployeeBo.fetchEmployee();
						System.out.format("%-10s %-20s %-10s %-15s %-10s\n", "EmployeeId","EmplyeeName","Salary","Date of Birth","Designation");
						SimpleDateFormat sdf1=new SimpleDateFormat("dd-MM-yyyy");
						for(Employee e3:l)
						{
							System.out.format("%-10s %-20s %-10s %-15s %-10s\n",e3.getId(),e3.getName(),e3.getSal(),sdf1.format(e3.getDob()),e3.getDesignation());
						}
						break;
				}
		
			}while(ch<5);
		
		}
}

