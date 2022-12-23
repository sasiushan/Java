import java.util.*;
public class TestHarness
{
	public static void main(String[] args)
	{
		test1();
		// test2();

	}

	public static void test1()
	{
	
		DSAHashTable t = new DSAHashTable(5);
		Scanner sc = new Scanner(System.in);

		//put()
		t.put("z", 16);
		t.put("a", 13);
		t.put("g", 223);
		t.put("s", 400);
		t.put("abcd", 4553);
		t.put("xyz", 1000000);
		t.put("efgh", 12);
		t.put("mno", 1);


		//print hashTable
		System.out.println("===============================");
		System.out.println("            HASHTABLE          ");
		System.out.println("===============================");
		t.display();
		System.out.println("===============================\n");



		//remove()
		System.out.println("\n===============================");
		System.out.println("    HASHTABLE AFTER REMOVE()   ");
		System.out.println("===============================");
		t.remove("z");
		t.display();
		System.out.println("===============================\n");
	

		//get()
		System.out.println("\n===============================");
		System.out.println("         HASHTABLE GET()       ");
		System.out.println("===============================");
		// t.get("a");//"a" is present in the hashArray
		// t.get("p");//"p" is  not present in the hashArray
		// t.get("xyz");//"xyz" is present in the hashArray
		// t.get("z");//"z" was removed from hashArray
		System.out.println("===============================\n");
	


		//reSize()
		System.out.println("\n===============================");
		System.out.println("   HASHTABLE AFTER RESIZE()    ");
		System.out.println("===============================");
		t.resize();
		t.display();
		System.out.print("------------------------------\n");
		System.out.println("Enter filename to save hash table content: ");
		String outFile;
		outFile = sc.next();
		t.saveFile(outFile);
		
	}

	public static void test2()
	{

		Scanner sc = new Scanner(System.in);
		int size;
		String fileName;

		DSAHashTable hashTable = new DSAHashTable(7000);
		System.out.println("Enter the name of the file you wish to read: ");

		fileName = sc.next();
		hashTable.readFile(fileName);
		hashTable.display();
		
	}
}