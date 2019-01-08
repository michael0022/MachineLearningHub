package com.demo;

public class Anonymous_Inner_Class_Lambda_Expressions 
{
	public static void main(String[] args) 
	{
		Runnable myRun = () ->
		{	
				for(int i = 0; i < 10; i++)
					System.out.println("Child Thread");
			
		};
		
		Thread myThread = new Thread(myRun);
		myThread.start();
		
		for(int i = 0; i < 10; i++)
			System.out.println("Main Thread");

	}
}
