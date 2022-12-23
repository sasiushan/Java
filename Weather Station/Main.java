import java.util.*;
public class Main
{
	public static void Display()
	{
		String path;
		System.out.println("Hi this is the weather data interface");
		System.out.println("Enter the name of the file you wish to read or use ( x ) to exit ");
		Scanner sc = new Scanner(System.in);
		path = sc.next();
		if(path.equals("x"))
		{
			System.out.println("GoodBye :) ");
			System.exit(0);
		}
		else
		{
			WeatherData obj = new WeatherData();
			obj.readcsv(path);
			obj.WhatIsMax();
			obj.WhatIsMin();	
		
				
			System.out.printf("The total number of entries are %d. ",WeatherData.total); //If you want to access a static varible from another class use the class . varaible
			System.out.println("\n");
			System.out.printf("The number of entries with omitted lines are %d. ",WeatherData.total-WeatherData.complete);
			System.out.println("\n");
			System.out.printf("The Maximum temperature is %2.1f. ",WeatherData.max);
			System.out.println("The Minimum temperature is: " + WeatherData.min);
		}
	}


	public static void main(String[] args)
	{
		Display();
	}
}
