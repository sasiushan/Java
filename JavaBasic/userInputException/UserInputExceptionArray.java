import java.util.*;
public class UserInputExceptionArray
{
	public static void main (String[] args)
	{
		int [] theArray;
		theArray = new int[100];
		int theArrayLen = theArray.length;

		for(int i = 0; i < theArrayLen; i = i + 1)
		{
			theArray[i] = i * i;	
						
			System.out.println("theArray["+i+"] is: " + theArray[i]);
		}
	}
}	
