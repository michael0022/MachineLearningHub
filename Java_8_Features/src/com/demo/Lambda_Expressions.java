package com.demo;

public class Lambda_Expressions 
{
	public static void main(String[] args) 
	{
		/** 
		    We have not used implementation class of absMeth()
			method but still able to call using lambda expression.
		**/
		
		MyInterface_1 interf_1 = () -> System.out.println("Hello by lambda expression !!");
		interf_1.absMeth(); // it will call the lambda expression written above.
		
		MyInterface_2 interf_2 = (c, d) -> System.out.println("Sum is: " + (c + d));
		interf_2.add(10, 20); // it will call the lambda expression written above.
		
		MyInterface_3 interf_3 = e -> e * e; // It is detecting return type as we we have declare in squareIt() method. 
		System.out.println(interf_3.squareIt(50));
	}
}

@FunctionalInterface
interface MyInterface_1
{
	public void absMeth();
}

@FunctionalInterface
interface MyInterface_2
{
	public void add(int a, int b);
	// public void product(int a, int b); not supported
}

@FunctionalInterface
interface MyInterface_3
{
	public int squareIt(int a);
}

