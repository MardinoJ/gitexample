import java.util.Iterator;

public class ListIterator <T> implements Iterator<T>
{
	Node<T> currentNode;
	
	public ListIterator(int num, Node<T> currentNode)
	{
		for(int i = 0; i < num; i++)
			currentNode = currentNode.getNext();
		
		this.currentNode = currentNode;
	}

	public boolean hasNext() 
	{
		return currentNode != null;
	}

	public T next() 
	{
		T result = currentNode.getData();
		currentNode = currentNode.getNext();
		
		return result;
	}
	
	
}
