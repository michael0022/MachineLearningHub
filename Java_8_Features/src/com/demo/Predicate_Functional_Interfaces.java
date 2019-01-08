package com.demo;

import java.util.ArrayList;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Predicate_Functional_Interfaces 
{
	public static void main(String[] args) 
	{
		Predicate<Integer> preInt = (a) -> (a % 2) == 0;
		System.out.println(preInt.test(9));
		
		String[] name = {"Nag", "Chiranjivi", "vivek", "sarthak", "sunny"};
		Predicate<String> preString = nam -> nam.length() > 5;
		
		for(String nm : name)
		{
			if(preString.test(nm))
				System.out.println(nm);
		}
		
		ArrayList<Employees> emp = new ArrayList<Employees>();
		emp.add(new Employees("Durga", 568952));
		emp.add(new Employees("Sunny", 235689));
		emp.add(new Employees("Bunny", 124578));
		emp.add(new Employees("Chinny", 568923));
		emp.add(new Employees("Vinny", 316497));
		
		Predicate<Employees> preEmp = e -> e.salary > 300000;
		
		for(Employees e1 : emp)
		{
			if(preEmp.test(e1))
				System.out.println(e1.name);
		}
		
		int[] x = {0, 5, 10, 15, 20, 25, 30, 35};
		Predicate<Integer> evenCheck = ev -> (ev % 2) == 0;
		Predicate<Integer> greaterTen = ev -> (ev > 10);

		for(int val : x)
		{
			//if(evenCheck.or(greaterTen).test(val))
			//if(evenCheck.and(greaterTen).test(val))
			if(evenCheck.negate().test(val))
				System.out.println(val);
		}
		
		BiPredicate<Integer, Integer> biPred = (a, b) -> (a + b) % 2 == 0;
		System.out.println(biPred.test(10,  20));
		System.out.println(biPred.test(11,  20));
		
		// No autoBoxing and autoUnboxing
		int intArray[] = {0, 5, 10, 15, 20, 25, 30, 35};
		IntPredicate intPred = i -> (i % 2) == 0;
		for(int val : intArray)
		{
			if(intPred.test(val))
				System.out.println(val);
		}
	}
}

class Employees
{
	String name;
	double salary;
	
	public Employees(String name, double salary) 
	{
		this.name = name;
		this.salary = salary;
	}
}