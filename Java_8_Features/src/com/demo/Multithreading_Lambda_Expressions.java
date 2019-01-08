package com.demo;

public class Multithreading_Lambda_Expressions 
{
	public static void main(String[] args) 
	{
		Runnable r = () ->
		{
			for(int i = 0; i < 10; i++)
				System.out.println("Child Thread");
		};
		
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