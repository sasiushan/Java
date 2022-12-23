import java.util.*;
import java.io.*;
public class DSALinkListTest
{
	public static DSALinkedList linkList = new DSALinkedList();

	public static void main(String[] args)
	{

		Scanner sc = new Scanner(System.in);
		int choice;

		do
		{
			menuInterface();
			choice = sc.nextInt();

			if(choice == 1)
			{
				option1(); //peekfirst
			}
			else if(choice == 2)
			{
				option2();	//peekLast
			}
			else if(choice == 3)
			{
				option3();	//insertFirst()
			}
			else if(choice == 4)
			{
				option4();	//insertLast()
			}
			else if(choice == 5)
			{
				option5();	//removeFirst()
			}
			else if(choice == 6)
			{
				option6();	//removeLast()
			}
			else if(choice == 7)
			{
				option7();	//display()
			}
			else if(choice == 8)
			{
				option8();	//write serialized file
			}
			else if(choice == 9)
			{
				option9();	//read serialized file
			}
		}while(choice != 10);
	}

	public static void menuInterface()
	{
		System.out.println("\n\n\n");
		System.out.println("LINK LIST MENU");
		System.out.println("Enter the (number) operation you wish to run:");
		System.out.println("<1> Peek First ");
		System.out.println("<2> Peek Last ");
		System.out.println("<3> Insert First ");
		System.out.println("<4> Insert Last ");
		System.out.println("<5> Remove First ");
		System.out.println("<6> Remove Last ");
		System.out.println("<7> Display ");
		System.out.println("<8> Write a serialized file ");
		System.out.println("<9> Read a serialized file ");
		System.out.println("<10> Exit\n\n\n");

	}

	public static void option1()	//peekfirst
	{
		Object returnVal = linkList.peekFirst();
		System.out.println("Peek first:" + returnVal);
	}

	public static void option2()	//peekLast
	{
		Object returnVal = linkList.peekLast();
		System.out.println("Peek Last: "+ returnVal);
	}

	public static void option3()	//insertFirst()
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the object you wish to insert 'FIRST' into linklist ");
		String input = sc.nextLine();
		linkList.insertFirst(input);
	}

	public static void option4()	//insertLast()
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the object you wish to insert 'LAST' into the link list" );
		String input = sc.nextLine();
		linkList.insertLast(input);
	}

	public static void option5()	//removeFirst()
	{
		System.out.println("\n");
		Object delVal = linkList.removeFirst();
		System.out.println("removed first: "+delVal);
	}

	public static void option6()	//removeLast()
	{
		System.out.println("\n");
		Object delVal = linkList.removeLast();
		System.out.println("removed last: "+delVal);
	}

	public static void option7()	//display()
	{
		System.out.println("\n");
		linkList.display();
	}

	public static void option8()
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the name of the file to save link list ");
		String fileName = sc.nextLine();

		linkList.save(linkList, fileName);
	}

	public static void option9()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of the file you wish to read ");
		// String fileName = sc.nextLine();

		linkList.load("out2.txt");
	}

	
}