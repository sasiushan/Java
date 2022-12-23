import java.util.*;
import java.io.*;

public class TestHarness
{
	public static void main(String[] args)
	{
		//test case 1
		DSAGraph graph = new DSAGraph();
		graph.addEdge("0", "1");
		graph.addEdge("0", "2");
		graph.addEdge("0", "3");
		graph.addEdge("1", "2");
		graph.addEdge("0", "6");

		graph.display();
		System.out.println("\nThe number of verticies is: " + graph.getVertexCount());
	


		//test case 2
		Scanner sc = new Scanner(System.in);
		String input;

		System.out.println("\n-----TESTING-----\nREAD FROM FILE AND CREATE DSAGRAPH OBJECT\n");
		System.out.println("Enter the name of the file you wish to read: ");
		input  = sc.nextLine();
		DSAGraph returnGraph = graph.readFile(input);


		returnGraph.display();

		System.out.println("\n-++++---++++---++++---++++---++++");
		System.out.print("BREADTH FIRST SEARCH : ");
		// returnGraph.bFS("A");
		System.out.println("\n-++++---++++---++++---++++---++++");

		System.out.print("DEPTH FIRST SEARCH : ");
		returnGraph.dFS("A");
		System.out.println("\n-++++---++++---++++---++++---++++");
	}
}


/*

	0 | 1-2-3
	1 | 2
	2 | 
	3 | 

*/