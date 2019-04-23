import java.lang.reflect.Array;

public class LinkedList <T>
{
	private Node<T> firstNode;
	private int numberOfEntries;
	
	public LinkedList()
	{
		firstNode = null;
		numberOfEntries = 0;
	}
	
	public int getCurrentSize() 
	{
		return numberOfEntries;
	}
	
	public boolean isEmpty() {
		
		return firstNode == null;
	}

	public boolean add(T newEntry) 
	{
		Node newNode = new Node(newEntry, firstNode);
		firstNode = newNode;
		numberOfEntries++;		
		
		return true;
	}

	public T remove() 
	{
		T result = null;
		
		if(!isEmpty())
		{
			result = firstNode.getData();
			firstNode = firstNode.getNext();
			numberOfEntries--;
		}
		
		return result;
	}
	
	public boolean remove(T anEntry) 
	{
		boolean found = false;
		Node currentNode = firstNode;
		
		while(!found && currentNode != null)
		{
			if(anEntry.equals(currentNode.getData()))
			{
				found = true;
				currentNode.setData(firstNode.getData());
				remove();
			}
			
			currentNode = currentNode.getNext();
		}
		
		return found;
	}

	public void clear() 
	{
		while(!isEmpty())
			remove();
		
	}

	public int getFrequencyOf(T anEntry) 
	{
		
		int count = 0;
		Node currentNode = firstNode;
		
		while(currentNode != null)
		{
			if(anEntry.equals(currentNode.getData()))
			{
				count++;
			}
			currentNode = currentNode.getNext();
		}
		
		return count;
	}
	
	public boolean contains(T anEntry) 
	{
		
		boolean found = false;
		Node currentNode = firstNode;
		
		while(!found && currentNode != null)
		{
			if(anEntry.equals(currentNode.getData()))
			{
				found = true;
			}
			
			currentNode = currentNode.getNext();
		}
		
		return found;
	}
	
	public ListIterator<T> listIterator(int num)
	{
		ListIterator<T> result = new ListIterator<T>(num, firstNode);
		
		return result;
	}

	public T[] toArray() 
	{
		T[] result = null;
		Node currentNode = firstNode;
		
		if(numberOfEntries > 0)
		{
			result = (T[]) Array.newInstance(firstNode.getData().getClass(), numberOfEntries);
			
			for(int i = 0; currentNode != null; i++)
			{
				result[i] = (T)currentNode.getData();
				currentNode = currentNode.getNext();
			}	
		}
		
		return result;
	}
}
