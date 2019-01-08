package com.demo;

interface Left
{
	default void m1()
	{
		System.out.println("Left interface m1 Method");
	}
}

interface Right
{
	default void m1()
	{
		System.out.println("Right interface m1 Method");
	}
}

public class Multiple_Inheritance_Feature implements Left, Right
{
	public static void main(String[] args) 
	{
		Multiple_Inheritance_Feature mulObj = new Multiple_Inheritance_Feature();
		mulObj.m1();
	}

	@Override
	public void m1() 
	{
		Right.super.m1();
		Left.super.m1();
		System.out.println("Our own overridden method");
	}
}
