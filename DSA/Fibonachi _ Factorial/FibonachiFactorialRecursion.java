import java.util.*;

public class FibonachiFactorialRecursion
{

	public static int FibonachiRecursive(int x)
	{
		int fib=0;

		if(x == 0) 
		{
			fib = 0;
		}
		else if (x == 1)
		{
			fib = 1;
		}	
		else
		{
			fib = FibonachiRecursive(x-1) + FibonachiRecursive(x-2); 
		}	
		return fib;
	}

	public static long FactorialRecursive(long x)
	{
		long factorial = 1;
		if(x==0)
		{
			factorial = 1;
		}
		else
		{
			factorial = x * FactorialRecursive(x-1); 
		}
		return factorial;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		try{	
			System.out.println("Enter a number to run the Fibonachi Sequence: ");//values after 39-40 resulted in slower performance of the program.
			int n = sc.nextInt();
			System.out.println(FibonachiRecursive(n));
		}catch(Exception e)
		{
			System.out.println("Error! You have made an invalid Input");
		}

		try{
				System.out.println("\nEnter the number to find the Factorial: ");
				long num = sc.nextInt();
				System.out.println(FactorialRecursive(num));
		}catch(Exception e)
		{
				System.out.println("Error invalid Input!");
		}

	}
}







