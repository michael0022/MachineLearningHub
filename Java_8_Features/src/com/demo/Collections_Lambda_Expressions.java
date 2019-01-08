package com.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Collections_Lambda_Expressions 
{
	public static void main(String[] args) 
	{
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(20);
		arrayList.add(10);
		arrayList.add(25);
		arrayList.add(5);
		arrayList.add(30);
		arrayList.add(0);
		arrayList.add(15);
		arrayList.add(20);
		
		System.out.println(arrayList);
		
		Comparator<Integer> myComparator = (I1, I2) -> (I1 < I2) ? -1 : (I1 < I2) ? 1 : 0;
		
		Collections.sort(arrayList, myComparator);
		// System.out.println(arrayList);
		
		arrayList.stream().forEach(System.out :: println);
		
		List<Integer> listInt = arrayList.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
		listInt.stream().forEach(System.out :: println);
	}
}

/*class MyComparator implements Comparator<Integer>
{
	// for ascending order
	@Override
	public int compare(Integer I1, Integer I2) 
	{
		if(I1 < I2)
			return -1;
		
		else if(I1 > I2)
			return 1;
		
		else
			return 0;
	}
	
}*/
