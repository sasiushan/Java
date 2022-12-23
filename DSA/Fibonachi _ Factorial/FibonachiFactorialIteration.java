import java.util.*;

public class FibonachiFactorialIteration
{
	public static int fibonachiIteration(int x)
	{
		int fibVal = 0;
		int currVal = 1;
		int lastVal = currVal;

		if(x==0)
		{
			fibVal = 0;
		}
		else if(x==1)
		{
			fibVal = 1;
		}
		else
		{
			for(int i=2;i<x;i++)
			{
				fibVal = currVal+lastVal;
				lastVal = currVal;
				currVal = fibVal;
			}
		}
		return fibVal;
	}

	public static long factorialIteration(long x)
	{
		long factorial = 1;
		for(long i=x;i>=2;i--)
		{
			factorial *=i; 
		}
		return factorial;
	}

	public static void main(String[] args)
	{
		int number;
		long num;

		Scanner sc = new Scanner(System.in);

		try{
			System.out.println("Enter the Nth term to find the fibonachi number: ");
			number = sc.nextInt();
			System.out.println(fibonachiIteration(number));
		}catch(Exception e)
		{
			System.out.println(e + "ERROR, please enter valid input!");
			e.printStackTrace();
		}

		try{
			System.out.println("Enter the Nth term to find the factorial: ");
			num = sc.nextLong();
			System.out.println(factorialIteration(num));
		}catch(Exception e)
		{
			System.out.println("Error please enter valid input !!"+ e);
		}


	}
}