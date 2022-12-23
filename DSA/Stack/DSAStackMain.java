import java.util.*;
public class DSAStackMain
{
	public static void stackInterface(int inNumber) throws Exception
	{
		DSAStack dsaStack = new DSAStack(inNumber);

		
		Scanner sc = new Scanner(System.in);
		int selection=0;
		int stackNumber=0;

		System.out.println("What operations do you wish to run:");
		System.out.println("(Please make selection from {1, 2, 3, 4}) ");
		do
		{
			System.out.println("1> 'push()'");
			System.out.println("2> 'pop()'");
			System.out.println("3> 'top()'");
			System.out.println("4> 'Exit()'");
			
			selection= sc.nextInt();

			if(selection==1)
			{
				System.out.println("\n\n\n");
				for(int i=0;i<inNumber;i++)
				{
					
					System.out.print("Insert number "+ i + ": ");
					stackNumber = sc.nextInt();
					dsaStack.push(stackNumber);
				}
				System.out.println("\n\n\n");
				dsaStack.display();
				System.out.println("\n\n\n");
			}
			else if(selection==2) 
			{
				System.out.println("\n\n\n");
				dsaStack.pop();
				dsaStack.display();
				System.out.println("\n\n\n");
			}
			else if(selection ==3) 
			{
				System.out.println("\n\n\n");
				Object topValue = dsaStack.top();
				System.out.println("top value is :" + topValue);
				System.out.println("Stack size is:"+ dsaStack.size());
				System.out.println("\n\n\n");

			}
		}while(selection!=4);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the stack you wish to create: ");
		int inNumber = sc.nextInt();

		stackInterface(inNumber);

	}
}