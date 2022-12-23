import java.util.*;
public class LinkListIterator implements Iterable
{
	private class ListNode
	{
		public Object value;
		public ListNode next;

		public ListNode(Object inValue)
		{	
			value = inValue;
			next = null;
		}

		public Object getValue()
		{
			return value;
		}

		public ListNode getNext()
		{
			return next;
		}

		public void setValue(Object inValue)
		{
			value = inValue;
		}
		public void setNext(ListNode inNext)
		{
			next = inNext;
		}
	}

	public ListNode head;
	public ListNode tail;

	public LinkListIterator()
	{
		head = null;
		tail = null;
	}

	public void display()
	{
		if(isEmpty())
		{
			System.out.println("Link List is empty");
		}
		else
		{
			ListNode currNode = head;
			while(currNode!=null)
			{
				System.out.print(currNode.getValue() + " ");
				currNode = currNode.getNext();
			}
			System.out.println();
		}
	}

	public boolean isEmpty()
	{
		return head == null;
	}

	public void insertFirst(Object inValue)
	{
		ListNode newNode = new ListNode(inValue);
		if(isEmpty())
		{
			head = newNode;
			tail = newNode;
		}
		else
		{
			newNode.setNext(head);
			head = newNode;
		}
	}

	public void insertLast(Object inValue)
	{
		ListNode newNode = new ListNode(inValue);
		if(isEmpty())
		{
			head= newNode;
			tail = newNode;
		}
		else
		{
			tail.setNext(newNode);
			tail = newNode;
		}
	}

	public Object removeFirst()
	{
		Object delNode =null;
		if(isEmpty())
		{
			System.out.println("Link list is empty");
		}
		else if(head==tail)
		{
			head = null;
			tail = null;
		}
		else
		{
			delNode = head.getValue();
			head = head.getNext();
		}

		return delNode;
	}

	public Object removeLast()
	{
		Object delNode = null;
		if(isEmpty())
		{
			System.out.println("Link List is empty");
		}
		else
		{
			ListNode currNode = head;
			ListNode prevNode = null;

			while(currNode.getNext()!=null)
			{
				prevNode = currNode;
				currNode = currNode.getNext();
			}

			delNode = currNode.getValue();

			if(!(head==tail))
			{
				tail = prevNode;
				tail.setNext(null);
			}
			else
			{
				head = null;
				tail = null;
			}
		}
		return delNode;
	}

	public Object peekFirst()
	{
		Object returnNode=null;
		if(isEmpty())
		{
			System.out.println("Link List is empty");
		}
		else
		{
			returnNode = head.getValue();
		}
		return returnNode;
	}

	public Object peekLast()
	{
		Object returnNode=null;
		if(isEmpty())
		{
			System.out.println("Link List is empty");
		}
		else
		{
			returnNode = tail.getValue();
		}
		return returnNode;
	}

	public Iterator iterator()
    {
        return new MyLinkedListIterator(this);
    }
    private class MyLinkedListIterator implements Iterator
    {
        private ListNode iterNext;
        public MyLinkedListIterator(LinkListIterator theList) { 
            iterNext = theList.head;
        }
        public boolean hasNext() {
            return (iterNext != null);
        }
        public Object next() {
        Object value;
        if (iterNext == null){
            value = null;
        }
        else {
            value = iterNext.getValue();// ← Get the value in the node
            iterNext = iterNext.getNext(); //← Ready for subsequent calls to next()
        }
        return value;
        }
        public void remove() {
            throw new UnsupportedOperationException("Not supported"); 
        } 
    }

}