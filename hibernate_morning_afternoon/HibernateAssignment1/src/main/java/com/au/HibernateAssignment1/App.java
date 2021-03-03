package com.au.HibernateAssignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.au.util.SessionUtil;

/**
 * Hello world!
 *
 */
public class App 
{
	public static Scanner sc=new Scanner(System.in);
	public static void printEmployee(Employee e) {
		System.out.println("------------------");
		System.out.println("Id: "+e.getId());
		System.out.println("Name: "+e.getFname()+" "+e.getLname());
		System.out.println("Age: "+e.getAge());
		System.out.println("Salary: "+e.getSalary());
		System.out.println("Date of birth: "+e.getDob());
		System.out.println("Designation: "+e.getDesignation());
		System.out.println("------------------");
	}
	public static void setEmployeeUI(Employee e) {
		e.setFname(sc.next());
		e.setLname(sc.next());
		e.setAge(sc.nextInt());
		e.setSalary(sc.nextInt());
		e.setDob(sc.next());
		e.setDesignation(sc.nextLine());
	}
    public static void main( String[] args )
    {
        System.out.println( "Employee Management System" );
        Session session=SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		while(true) {
			System.out.println("Select a choice from below ...");
			System.out.println("1. Create employee");
			System.out.println("2. Update all employee");
			System.out.println("3. Update employee by id");
			System.out.println("4. Delete employee - warning: this cannot be recovered");
			System.out.println("5. Get all employee");
			System.out.println("6. Get Employee by id");
			System.out.println("7. exit");
			int choice=7;
			System.out.println("Enter your choice: ");
			choice=sc.nextInt();
			if(choice==1) {
				System.out.println("Enter employee all details in order firstname, lastname, age, salary, date of birth, designation");
				Employee e=new Employee();
				setEmployeeUI(e);
				session.save(e);
			}else if(choice==2) {
				while(true) {
					System.out.println("Enter employee id to update record");
					 int id = sc.nextInt();
					 Employee e=session.load(Employee.class, id);
					 System.out.println("Enter employee all details in order firstname, lastname, age, salary, date of birth, designation");
					 setEmployeeUI(e);
					 session.update(e);
					 System.out.println("Do you want to conitnue (y/n)");
					 String ch=sc.next();
					 if(ch.toLowerCase().equals("n"))
						 break;
				}
			}else if(choice==3) {
				System.out.println("Enter employee id to update record");
				int id=sc.nextInt();
				Employee e=session.load(Employee.class, id);
				System.out.println("Enter employee all details in order firstname, lastname, age, salary, date of birth, designation");
				setEmployeeUI(e);
				session.update(e);
			}else if(choice==4) {
				System.out.println("Enter employee id to delete permanently");
				int id=sc.nextInt();
				Employee e=session.load(Employee.class, id);
				String confirmMsg="y";
				System.out.println("warning: this cannot be recovered..");
				System.out.println("Do you want to continue y/n ");
				confirmMsg=sc.next();
				if(confirmMsg.toLowerCase().equals("y"))
					session.delete(e);
			}else if(choice==5) {
				List<Employee> employees=session.createCriteria(Employee.class).list();
				employees.forEach(e->printEmployee(e));
			}else if(choice==6) {
				System.out.println("Enter employee id to fetch record");
				int id=sc.nextInt();
				Employee e=session.load(Employee.class, id);
				printEmployee(e);
			}else if(choice==7) {
				break;
			}
		}
		tx.commit();
		session.close();
		System.out.println("welcome again");
    }
}
