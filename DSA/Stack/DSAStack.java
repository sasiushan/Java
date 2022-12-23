import java.util.*;
public class DSAStack
{


	/*
		LIFO
		stack = { 22, 33, 44, 55}

		-----------------
		|				|	
		|		55		|
		|_______________|
		|				|
		|		44		|
		|---------------|
		|		33		|
		|---------------|
		|				|
		|		22		|	
		-----------------
		
	*/



	private Object stack[];
	private int count = 0;
	private int DEFAULT_CAPACITY;

	public DSAStack()
	{

	}

	public DSAStack(int defaultCapacity)
	{
		DEFAULT_CAPACITY = defaultCapacity;
		stack = new Object[DEFAULT_CAPACITY];
		count = 0;
	}

	public int getCount()
	{
		return count;
	}

	public boolean isEmpty()
	{
		return count == 0;
	}

	public boolean isFull()
	{
		return count == stack.length;
	}

	public void push(Object inValue) throws Exception //insert
	{
		if(isFull())
		{
			throw new Exception("Stack is full");
		}
		else
		{
			stack[count] = inValue;
			count++;
		}
	}

	public Object top()//look at top value of stack
	{
		Object topVal="";
		if(isEmpty())
		{
			System.out.println("Stack is empty");
			// throw new Exception("Error, stack is empty");
		}
		else
		{
			topVal = stack[count-1]; //count-1 is the end of the array which is the top of the stack
		}
		return topVal;
	}

	public Object pop() throws Exception//delete top value
	{
		Object deleteVal = top();
		count--;
		return deleteVal;
	}

	public int size()
	{
		return stack.length;
	}

	public void display()
	{
		System.out.print("Stack: { ");
		for(int i=count-1;i>=0;i--)
		{
			System.out.print(stack[i]+" ");
		}
		System.out.print(" }");
	}
	

}