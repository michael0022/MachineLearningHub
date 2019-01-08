package com.demo;

@FunctionalInterface
interface Functional_Interface 
{
	public void MyAbstractMethod(); // compulsory
	default void MyDefaultMethod() 
	{
		
	}
	
	public static void myStaticMethod()
	{
		
	}
}

@FunctionalInterface
interface Sub_Functional_Interface extends Functional_Interface
{
	// It is fine as it is overridding abstract method from parent class.

	public void MyAbstractMethod(); // Valid Syntax
	// public void subMyAbstractMethod(); // Not supported
}
