package com.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Custom_Object_Sorting_Lambda_Expressions 
{
	public static void main(String[] args) 
	{
		ArrayList<Employee> emp = new ArrayList<Employee>();
		emp.add(new Employee("Durga", 568952));
		emp.add(new Employee("Sunny", 235689));
		emp.add(new Employee("Bunny", 124578));
		emp.add(new Employee("Chinny", 568923));
		emp.add(new Employee("Vinny", 316497));
		
		System.out.println(emp);
		Comparator<Employee> myComparator = (I1, I2) -> (I1.eno < I2.eno) ? -1 : (I1.eno < I2.eno) ? 1 : 0;
		Collections.sort(emp, myComparator);	
		System.out.println(emp);
	}
}

class Employee
{
	String name;
	int eno;
	
	Employee(String name, int eno) 
	{
		this.name = name;
		this.eno = eno;
	}
	
	@Override
	public String toString()
	{
		return eno + " : " + name;
	}
}
