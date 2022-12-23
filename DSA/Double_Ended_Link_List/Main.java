public class Main
{
	public static void main(String[] args)
	{
		LinkList list = new LinkList();
		list.insertFirst(20);
		list.insertFirst(40);
		list.insertFirst(60);

		list.insertLast(100);
		list.insertLast(200);


		list.display();


		Object remove = list.removeFirst();
		System.out.println("\n" + remove + " remove first ");

		Object removeL = list.removeLast();
		System.out.print(removeL + " remove last\n");


		System.out.println("\nFINAL LIST: ");
		list.display();


		Object peekF = list.peekFirst();
		System.out.println("\nPeekFirst: " + peekF);


		Object peekL = list.peekLast();
		System.out.println("\nPeekLast: " + peekL);
		
	}
}