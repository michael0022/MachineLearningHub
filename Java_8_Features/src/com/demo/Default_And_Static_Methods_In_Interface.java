package com.demo;

interface MyInterface
{
	public void m1();
	public void m2();
	
	default void m3()
	{
		System.out.println("Default Method");
	}
}

interface MyInterface_Def
{
	default void m3()
	{
		System.out.println("Default Method");
	}
}

class Test1 implements MyInterface
{

	@Override
	public void m1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m2() {
		// TODO Auto-generated method stub
		
	}
	
}

class Test2 implements MyInterface
{

	@Override
	public void m1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m2() {
		// TODO Auto-generated method stub
		
	}
	
}

class Test3 implements MyInterface
{

	@Override
	public void m1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m2() {
		// TODO Auto-generated method stub
		
	}
	
}

interface MyStaticInterface
{
	public static void myStaticMethod()
	{
		System.out.println("Interface static method");
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Interface Main Method");
	}
}

public class Default_And_Static_Methods_In_Interface implements MyInterface_Def, MyStaticInterface
{
	@Override
	public void m3() 
	{
		System.out.println("Overridding version of default method");
	}
	
	public static void main(String[] args) 
	{
		Default_And_Static_Methods_In_Interface defObject = new Default_And_Static_Methods_In_Interface();
		defObject.m3();
		
		MyStaticInterface.myStaticMethod();
		
		/**
		   Not allowed as static methods of interface is not available in 
		   implementing class by default.
		 
		   myStaticMethod();
		   Default_And_Static_Methods_In_Interface.myStaticMethod();
		   defObject.myStaticMethod();
		   
		 **/
	}
}

