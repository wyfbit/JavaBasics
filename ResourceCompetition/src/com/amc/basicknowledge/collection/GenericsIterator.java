package com.amc.basicknowledge.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class GenericsIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//JDK 1.4 or before
		ArrayList arrList=new ArrayList(); 
		arrList.add("123");
		arrList.add("456");
		arrList.add("789");
		for(int i=0;i<arrList.size();i++) {
			String numContent=(String)arrList.get(i);
			System.out.println(numContent);
		}
		//JDK 1.5 or latter
		ArrayList<String> arList=new ArrayList(); 
		arList.add(new String("Monday"));
		arList.add(new String("Tuesday"));
		arList.add(new String("Wensday"));
		/*for(int i = 0; i < arList.size(); i++){
		    String weekday = arList.get(i);//隐式类型转换，编译器自动完成
		    //System.out.println(weekday.toUpperCase());
		}
		
		Iterator<String> it =arList.iterator();
		while(it.hasNext()) {
			//System.out.println(it.next().toUpperCase());
		}*/
		for(String weekday:arList) {
			System.out.println(weekday.toUpperCase());
		}
	}

}
