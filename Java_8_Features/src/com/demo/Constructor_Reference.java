package com.demo;

public class Constructor_Reference 
{
	public static void main(String[] args) 
	{
		// constructor reference
		MyInterf interf = Sample::new;
		Sample samp1_1 = interf.get("Durga");
		Sample samp1_2 = interf.get("Ravi");
	}
}

class Sample
{
	Sample(String str) 
	{
		// Business logic can be written here
		System.out.println("Sample class constructor execution with argument: " + str);
	}
}

interface MyInterf
{
	public Sample get(String str);
}