package com.demo;

public class Method_Reference 
{
	// This method acts like run method
	public static void methodReference() 
	{
		for(int i = 0; i < 10; i++)
			System.out.println("Child Thread");
	}
	
	public static void main(String[] args) 
	{
		/** 
		    Alternate way of writing lambda expressions, called method reference.
		    Here, functional interface Runnable's run method internally referring
		    the Method_And_Constructor_Reference class's methodReference method
		**/
		
		Runnable r = Method_Reference::methodReference;
		
		Thread th = new Thread(r);
		th.start();
		
		for(int i = 0; i < 10; i++)
			System.out.println("Main Thread");
		
	}
}

/*
 * Replaced from lambda expression
 * 
 * 
class MyRunnable implements Runnable
{
	@Override
	public void run() 
	{
		for(int i = 0; i < 10; i++)
			System.out.println("Child Thread");
	}
}*/