import java.util.*;
public class clock
{
	public static void main (String[] args)
	{	
		int day = ' ';
		double  h = ' ';
		double m = ' ';
		Scanner sc = new Scanner(System.in);
			
		System.out.println (" welcome ");
		System.out.println (" Enter hours you wish to convert to days: ");
		int hour = sc.nextInt();
		System.out.println(" Enter the minutes you wish to convert to hours ");
		int min = sc.nextInt();
		System.out.println(" Enter the seconds you wish to convert to minutes ");
		int second = sc.nextInt();
		if (hour > 24) 
		{
			  day = hour/24;
		}
		if (min > 60)
		{
	 		 h = (double)  min/60;
		}
		if (second > 120)
		{ 
			m = (double) second/120;
		}
			
		System.out.println( day + "days" + h + "hours" + m + "minutes" );
		




	sc.close();
	}
}
