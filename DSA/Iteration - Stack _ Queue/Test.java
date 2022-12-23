import java.util.*;
public class Test
{
	public static LinkListIterator linkList = new LinkListIterator();
	public static DSAStack stack = new DSAStack();
	public static DSAQueue queue = new DSAQueue();

	public static void main(String[] args) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int choice;

		do
		{
			main();
			choice = sc.nextInt();

			if(choice == 1)
			{
				int choice2;
				do 
				{
					stackTestingInterface(); 
					choice2 = sc.nextInt();
					stackTesting(choice2);

				}while(choice2!=5);
			}
			else if(choice == 2)
			{
				int choice2;
				do
				{
					queueTestingInterface();
					choice2 = sc.nextInt();	
					queueTesting(choice2);

				}while(choice2!=5);
			}
		}while(choice != 3);
	}

	public static void main()
	{
		System.out.println("\n\n\n\nSTACK-QUEUE_TESTING");
		System.out.println("What menu options will you be trying?");
		System.out.println("(1) Stack Testing ");
		System.out.println("(2) Queue Testing ");
		System.out.println("(3) Exit");
	}


	public static void stackTestingInterface()
	{
		System.out.println("\n\n\nWELCOME TO STACK TESTING");
		System.out.println("Enter the option (number) you wish to execute");
		System.out.println("(1) push");
		System.out.println("(2) top");
		System.out.println("(3) pop");
		System.out.println("(4) Iterator");
		System.out.println("(5) Exit");
	}
	public static void stackTesting(int choice2) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		String stackInput;

		if(choice2 == 1) //push
		{
			System.out.println("\n\n\nENTER INPUT TO PUSH");
			stackInput = sc.nextLine();
			stack.push(stackInput);
		}
		if(choice2 == 2) //top
		{
			System.out.println("\n\n\n");
			Object resultValue = stack.top();
			System.out.println("top value: "+resultValue+"\n");
		}
		if(choice2 ==3) //pop
		{
			System.out.println("\n\n\nPOPPING VALUE FROM STACK...");
			Object delValue = stack.pop();
			System.out.println("popped value: "+delValue+"\n");
		}
		if(choice2 == 4)
		{
			System.out.println("\n\n\nITERATING THE STACK.......");
			System.out.print("OUTPUT: ");
			while(stack.isEmpty()==false)
			{
				System.out.print(stack.pop()+" ");
			}
			System.out.println();
		}
	}

	public static void queueTestingInterface()
	{
		System.out.println("\n\n\nWELCOME TO QUEUE TESTING");
		System.out.println("Enter the (number) option you wish to execute");
		System.out.println("(1) enqueue");
		System.out.println("(2) dequeue");
		System.out.println("(3) peek");
		System.out.println("(4) Iterator");
		System.out.println("(5) Exit\n");

	}

	public static void queueTesting(int choice2)
	{
		Scanner sc = new Scanner(System.in);
		String queueInput;

		if(choice2 == 1)
		{
			System.out.println("\n\n\nENTER INPUT TO ENQUEUE: ");
			queueInput = sc.nextLine();
			queue.enqueue(queueInput);
		}
		if(choice2 == 2)
		{
			System.out.println("\n\n\ndequeue-ing from queue.....");
			Object delVal = queue.dequeue();
			System.out.println("dequeued valued: "+ delVal);
		}
		if(choice2 == 3)
		{
			System.out.println("\n\n\n");
			Object topVal = queue.peek();
			System.out.println("top value in queue is: "+ topVal);
		}
		if(choice2 == 4)
		{
			System.out.println("\n\n\nITERATING THE QUEUE......");
			System.out.print("OUTPUT: ");
			while(queue.isEmpty()==false)
			{
				System.out.print(queue.dequeue()+" ");
			}
			System.out.println();
		}
	}

}