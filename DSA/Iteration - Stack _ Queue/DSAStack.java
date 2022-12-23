import java.util.*;
public class DSAStack implements Iterable
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


	private LinkListIterator stack;
	public DSAStack()
	{
		stack = new LinkListIterator();
	}

	public boolean isEmpty(){
        boolean empty = stack.isEmpty();
        return empty;
    }
    public void push(Object value)
    {
        stack.insertFirst(value);
    }
    public Object pop()
    {
        Object topVal = stack.removeFirst();
        return topVal;
    }
    public Object top()
    {
        Object topVal = stack.peekFirst();
        return topVal;
    }

    public Iterator iterator()
    {
        return stack.iterator();
    }
	

}