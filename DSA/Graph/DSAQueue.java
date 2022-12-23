import java.util.*;
public class DSAQueue
{

	/*
		
		FIFO
		Queue = { 22, 33, 44, 55, 66}

		  front							   rear   count
			0		1		2 		3 		4  		5
		-------------------------------------------------
		|		|		|		|		|		|		|
		|		|		|		|		|		|		|
		|	22	|	33	|	44	|	55	|	66	|		|
		|		|		|		|		|		|		|
		|		|		|		|		|		|		|
		-------------------------------------------------

								

	*/
	private Object queue[];
	private int count = 0;
	private int DEFAULT_CAPACITY;
	private int front;
	private int rear;


	public DSAQueue()
	{

	}

	public DSAQueue(int defaultCapacity)
	{
		DEFAULT_CAPACITY = defaultCapacity;
		queue = new Object[DEFAULT_CAPACITY];
		count = 0;
		rear = -1;
		front = 0;
	}

	public boolean isEmpty()
	{
		return count==0;
	}

	public boolean isFull()
	{
		return count == queue.length;
	}
 
	public void enqueue(Object inValue) //insert
	{
		if(isFull())
		{
			System.out.println("Queue is full ");
		}
		else
		{
			count++;
			rear++;
			queue[rear] = inValue;
		}
	}

	public Object peek() //check the first item
	{
		Object topValue="";
		if(isEmpty())
		{
			System.out.println("Error, Queue is empty");
		}
		else
		{
			topValue = queue[front];
		}
		return topValue;
	}

	public Object dequeue()
	{
		Object topVal;
		topVal = peek();
		front++;
		System.out.println("Deleted top value "+ topVal+ " from queue");
		return topVal;
	}

	public void display()
	{
		System.out.print("Queue: { ");
		for(int i=0;i<count;i++)
		{
			System.out.print(queue[i]+" ");
		}
		System.out.print(" } ");
	}

	public void dequeueDisplay()
	{
		System.out.print("Queue: { ");
		for(int i=front;i<count;i++)
		{
			System.out.print(queue[i]+" ");
		}
		System.out.print(" } ");
	}
}