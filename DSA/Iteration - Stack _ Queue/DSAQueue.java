import java.util.*;
public class DSAQueue implements Iterable
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

	private LinkListIterator queue;    
    public DSAQueue()
    {
        queue = new LinkListIterator();
    }
    public boolean isEmpty()
    {
        boolean empty = queue.isEmpty();
        return empty;
    }
    public void enqueue(Object value) 
     {
        queue.insertLast(value);
    }
    public Object dequeue()  
    {
        Object topVal = queue.removeLast();
        return topVal;
    }
    public Object peek()  
    {
        Object topVal = queue.peekLast();
        return topVal;
    }
    public Iterator iterator()
    {
        return queue.iterator();
    }



}