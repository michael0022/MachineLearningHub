package com.demo;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Function_Functional_Interfaces 
{
	public static void main(String[] args) 
	{
		Function<Integer, Integer> func = i -> i * i;
		System.out.println(func.apply(25));
		
		Function<String, Integer> strFunc = str -> str.length();
		System.out.println(strFunc.apply("Synechron"));
		
		ArrayList<Student> stud = new ArrayList<Student>();
		stud.add(new Student("Durga", 100));
		stud.add(new Student("Sunny", 65));
		stud.add(new Student("Bunny", 55));
		stud.add(new Student("Chinny", 45));
		stud.add(new Student("Vinny", 25));
		
		Function<Student, String> fStu = stu -> stu.marks > 80 ? "Distinction" : stu.marks >= 60 ? "First Class" : stu.marks >= 50 ? "Second Class" : stu.marks >=35 ? "Third Class" : "Failed";
		Predicate<Student> preStud = pStu -> pStu.marks >= 60;
		
		for(Student s : stud)
		{
			if(preStud.test(s))
				System.out.println(fStu.apply(s));
		}
		
		Function<Integer, Integer> f1 = i -> 2 * i;
		Function<Integer, Integer> f2 = i -> i * i * i;
		
		System.out.println(f1.andThen(f2).apply(4));
		System.out.println(f1.compose(f2).apply(4));
		
		BiFunction<Integer, String, Student> biF = (marks, ename) -> new Student(ename, marks);
		Student myStu = biF.apply(87, "Michael");
		System.out.println(myStu.marks);
		System.out.println(myStu.name);
	}
}

class Student
{
	String name;
	int marks;
	public Student(String name, int marks) 	
	{
		this.marks = marks;
		this.name = name;
	}
}