package com.demo;

import java.util.Date;
import java.util.function.Supplier;

public class Supplier_Functional_Interfaces 
{
	public static void main(String[] args) 
	{
		Supplier<Date> sDate = () -> new Date();
		System.out.println(sDate.get());
		
		Supplier<String> sOTP = () -> 
		{
			String OTP = "";
			for(int i = 0; i < 6; i++)
				OTP = OTP + (int)(Math.random() * 10);
			
			return OTP;
		};
		
		System.out.println(sOTP.get());
	}
}
