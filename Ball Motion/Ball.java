import java.io.*;
import java.lang.Thread;
public class Ball
{
	public static void main(String[] args) throws InterruptedException
	{

		// boolean turnOn = true;
		// while(turnOn==true)
		// {
		// 	System.out.println("  0  ");
		// 	System.out.println("     ");
		// 	System.out.println("     ");
		// 	System.out.println("     ");
		// 	System.out.println("_____");
		// 	Thread.sleep(100);
		// 	cls();

		// 	System.out.println("     ");
		// 	System.out.println("  0  ");
		// 	System.out.println("     ");
		// 	System.out.println("     ");
		// 	System.out.println("_____");
		// 	Thread.sleep(100);
		// 	cls();

		// 	System.out.println("     ");
		// 	System.out.println("     ");
		// 	System.out.println("  0  ");
		// 	System.out.println("     ");
		// 	System.out.println("_____");
		// 	Thread.sleep(100);
		// 	cls();

		// 	System.out.println("     ");
		// 	System.out.println("     ");
		// 	System.out.println("     ");
		// 	System.out.println("  0  ");
		// 	System.out.println("_____");
		// 	Thread.sleep(100);
		// 	cls();

		// 	System.out.println("     ");
		// 	System.out.println("     ");
		// 	System.out.println("     ");
		// 	System.out.println("     ");
		// 	System.out.println("__0__");
		// 	Thread.sleep(100);
		// 	cls();


		// 	System.out.println("     ");
		// 	System.out.println("     ");
		// 	System.out.println("     ");
		// 	System.out.println("     ");
		// 	System.out.println("_____");
		// 	Thread.sleep(100);
		// 	cls();

		// 	System.out.println("     ");
		// 	System.out.println("     ");
		// 	System.out.println("     ");
		// 	System.out.println("     ");
		// 	System.out.println("__0__");
		// 	Thread.sleep(100);
		// 	cls();

		// 	System.out.println("     ");
		// 	System.out.println("     ");
		// 	System.out.println("     ");
		// 	System.out.println("  0  ");
		// 	System.out.println("_____");

		// 	Thread.sleep(100);
		// 	cls();

		// 	System.out.println("     ");
		// 	System.out.println("     ");
		// 	System.out.println("  0  ");
		// 	System.out.println("     ");
		// 	System.out.println("_____");
		// 	Thread.sleep(100);
		// 	cls();

		// 	System.out.println("     ");
		// 	System.out.println("  0  ");
		// 	System.out.println("     ");
		// 	System.out.println("     ");
		// 	System.out.println("_____");
		// 	Thread.sleep(100);
		// 	cls();

		// 	System.out.println("  0  ");
		// 	System.out.println("     ");
		// 	System.out.println("     ");
		// 	System.out.println("     ");
		// 	System.out.println("_____");
		// 	Thread.sleep(100);
		// 	cls();

		// }

		boolean s = true;
	

			// for(int i=0;i<rows;i++)
			// {
			// 	for(int j=0;j<column;j++)
			// 	{
			// 		arr[rows][column] = j; 
			// 	}
			// }

			// for(int i=0;i<=rows;i++)
			// {
			// 	for(int j=0;j<=column;j++)
			// 	{
			// 		System.out.print(arr[i][j]);
			// 	}
			// 	System.out.println();
			// }


		String [][] myTwoDArray;
		int rows = 4;
		int column = 7;


		myTwoDArray = new String[rows][column];

		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<column;j++)
			{
				myTwoDArray[i][j] = " ";
				
			}		
		}
		
		for (int i=0;i<rows;i++)
		{
			
			for (int j=0;j<column;j++)
			{
				System.out.print(myTwoDArray[i][j]);
			}	
			System.out.println();
		}	

	}

	public static void cls()
	{  
    	System.out.print("\033[H\033[2J");  
    	System.out.flush();  
	}  


}