package com.psl.MyApp.controller;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class RnnGenerator {
	
	
	public static void usingBufferedWritter(Long textToAppend) throws IOException 
	{
	    BufferedWriter writer = new BufferedWriter(
	                                new FileWriter("C:/apache-jmeter-5.2.1/apache-jmeter-5.2.1/bin/templates/GeneratedRnn.txt", true)  //Set true for append mode
	                            );  
	    writer.newLine();   //Add new line
	    writer.write(Long.toString(textToAppend));
	    writer.close();
	}
	
	public static void main(String[] args) {
		for(int j=0;j<10;j++) {
		Random random = new Random();
	    char[] digits = new char[12];
	    digits[0] = (char) (random.nextInt(9) + '1');
	    for (int i = 1; i < 12; i++) {
	        digits[i] = (char) (random.nextInt(10) + '0');
	    }
	    System.out.println( Long.parseLong(new String(digits)));
	    try {
			usingBufferedWritter(Long.parseLong(new String(digits)));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	  

	    
	}
	}
}
