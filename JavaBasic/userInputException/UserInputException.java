//This is a program i wrote where the user inputs a number 
// and the count will keep adding from 0 till the number the user has entered. 
// However we will use exception handling, say if the user entered a string value
 // instead of an integer. we will display an output message. 
// try....catch must be used together or else it will not work!!!!!!!!!!!!!

import java.util.*;
public class UserInputException
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		try	
		{	
			int sum = 0;
			System.out.print("Enter the Integer number: ");
			int number = sc.nextInt();
			for ( int count = 0; count<= number; count++)
			{
				System.out.println("Count is: " + count + "," + "Sum is: " + sum) ;	 
				sum +=count;
			}
		}
		catch(InputMismatchException error)
		{
			System.out.println("ERROR!!!! Something went wrong." + " " + error);
			System.out.println(" The error is: " + error);	
		}	
			sc.close();
	}
}	
