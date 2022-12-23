import java.util.*;
public class Main
{
	public static void main(String[] args)
	{

		test1();
		test2();
	
	}
	public static void test1()
	{
		/*

			> heap consist of priority and value.
			> Higher priority numbers will be displayed first.
	
		*/
		System.out.println("############## TEST 1 ###################");

		DSAHeap newHeap = new DSAHeap(10);
		
		/*	Add random entries */
		newHeap.add(241, "Step 3");
		newHeap.add(241, "Step 4");
		newHeap.add(100, "Step 6");
		newHeap.add(322, "Step 2");
		newHeap.add(82, "Step 7");
		newHeap.add(210, "Step 5");
		newHeap.add(500, "Step 1");
		
		/* display */
		System.out.println("\nHEAPS \n");
		System.out.println("Display: ");
		newHeap.display();

		/* remove */
		System.out.println("\n");
		newHeap.remove();
		System.out.println("Display after delete: ");
		newHeap.display();

		/* Heap Sort & display */
		System.out.println();
		newHeap.heapSort();
		System.out.println("\nDisplay after heapSort() with highest priority first: ");
		newHeap.displayAfterHeapSort();

	}

	public static void test2()
	{
		Scanner sc = new Scanner(System.in);
		String inFile;

		System.out.println("\n\n############## TEST 2 ###################");
		DSAHeap newHeap = new DSAHeap(7000);
		System.out.println("Enter the name of the file you wish to read: ");
		inFile = sc.next();
		newHeap.readFile(inFile);
		newHeap.display();
	}
}