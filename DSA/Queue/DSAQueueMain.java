import java.util.*;
public class DSAQueueMain
{
	public static void queueInterface(int inNumber) throws Exception
	{
		DSAQueue dsaQueue = new DSAQueue(inNumber);
		
		Scanner sc = new Scanner(System.in);
		int selection=0;
		int queueNumber=0;

		System.out.println("What operations do you wish to run:");
		System.out.println("(Please make selection from {1, 2, 3, 4}) ");
		do
		{
			System.out.println("1> 'enqueue()'");
			System.out.println("2> 'dequeue'");
			System.out.println("3> 'peek'");
			System.out.println("4> 'Exit()'");
			
			selection= sc.nextInt();

			if(selection==1)
			{
				System.out.println("\n\n\n");
				for(int i=0;i<inNumber;i++)
				{
					
					System.out.print("Insert number "+ i + ": ");
					queueNumber = sc.nextInt();
					dsaQueue.enqueue(queueNumber);
				}
				System.out.println("\n\n\n");
				dsaQueue.display();
				System.out.println("\n\n\n");
			}
			else if(selection==2) 
			{
				System.out.println("\n\n\n");
				dsaQueue.dequeue();
				dsaQueue.dequeueDisplay();
				System.out.println("\n\n\n");
			}
			else if(selection ==3) 
			{
				System.out.println("\n\n\n");
				Object topValue = dsaQueue.peek();
				System.out.println("the front value in the queue is :" + topValue);
				System.out.println("\n\n\n");
			}
		}while(selection!=4);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\n\nEnter the size of the queue you wish to create: ");
		int inNumber = sc.nextInt();

		queueInterface(inNumber);
	}

}