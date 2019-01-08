package com.demo;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Consumer_Functional_Interfaces 
{
	public static void main(String[] args) 
	{
		Consumer<String> c = s -> System.out.println(s);
		c.accept("Synechron");
		
		ArrayList<Student> stud = new ArrayList<Student>();
		stud.add(new Student("Durga", 100));
		stud.add(new Student("Sunny", 65));
		stud.add(new Student("Bunny", 55));
		stud.add(new Student("Chinny", 45));
		stud.add(new Student("Vinny", 25));
		
		Function<Student, String> fStu = stu -> stu.marks > 80 ? "Distinction" : stu.marks >= 60 ? "First Class" : stu.marks >= 50 ? "Second Class" : stu.marks >=35 ? "Third Class" : "Failed";
		Predicate<Student> preStud = pStu -> pStu.marks >= 60;
		
		Consumer<Student> cStu = cs ->
		{
			System.out.println(cs.name);
			System.out.println(cs.marks);
			System.out.println(fStu.apply(cs));
		};
		
		for(Student s : stud)
		{
			if(preStud.test(s))
				cStu.accept(s);
		}
		
		ArrayList<Customer> cust = new ArrayList<Customer>();
		populate(cust);
		
		BiConsumer<Customer, Double> biCons = (f, e) -> f.salary += e;
		
		for(Customer cu : cust)
			biCons.accept(cu, 1000.00);
		
		for(Customer cu : cust)
			System.out.println(cu.name + " : " + cu.salary);
	}

	private static void populate(ArrayList<Customer> cust) 
	{
		cust.add(new Customer("Durga", 1000));
		cust.add(new Customer("Sunny", 2000));
		cust.add(new Customer("Bunny", 3000));
		cust.add(new Customer("Chinny", 4000));
		cust.add(new Customer("Vinny", 5000));		
	}
}

class Customer
{
	String name;
	double salary;
	
	public Customer(String name, double salary) 
	{
		this.name = name;
		this.salary = salary;
	}
}
