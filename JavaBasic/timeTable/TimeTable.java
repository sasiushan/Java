import java.util.*;
public class TimeTable
{
	public static void main(String[] args)
	{
		int num= -1;

		Scanner sc = new Scanner(System.in);			
		while ((num < 1) || (num > 12))
		{
			System.out.println("Enter a number within the range of 1 to 12");
			num = sc.nextInt();
		}	
		for (int table = 1; table <= num; table++)//this is for the times table
		{	
			System.out.println("The " + table + " Times Table " );			
				for (int number = 1; number <= 12; number++)/*when the number begins from one and goes till 12 */ 						       {	
					System.out.println( " " + table + "x" + number + " = " + (table * number));
				}		
		}
		sc.close();
	}
}	
