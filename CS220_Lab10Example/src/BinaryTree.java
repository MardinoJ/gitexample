
public class BinaryTree <T> 
{
	private BinaryNode root;
	
	public BinaryTree()
	{
		this.root = null;
	}
	
	public BinaryTree(T rootData)
	{
		root = new BinaryNode(rootData);
	}
	
	public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
	{
		privateSetTree(rootData, leftTree, rightTree);
	}
	
	public void setTree(T rootData)
	{
		root = new BinaryNode(rootData);
	}
	
	public void setTree(BinaryTree<T> leftTree, BinaryTree<T> rightTree)
	{
		if(leftTree != null)
			root.setLeftChild(leftTree.root);
		else
			root.setLeftChild(null);
		
		if(rightTree != null)
			root.setRightChild(rightTree.root);
		else
			root.setRightChild(null);
	}
	
	public void setTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
	{
		privateSetTree(rootData, leftTree, rightTree);
	}
	
	private void privateSetTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
	{
		root = new BinaryNode(rootData);
		
		if((leftTree != null) && !leftTree.isEmpty())
			root.setLeftChild(leftTree.root);
		
		if((rightTree != null) && !rightTree.isEmpty())
		{
			if(rightTree != leftTree)
				root.setRightChild(rightTree.root);
			else
				root.setRightChild(rightTree.root.copy());
		}
		
		if((leftTree != null) && (leftTree != this))
			leftTree.clear();
		if((rightTree != null) && (rightTree != this))
			rightTree.clear();
	}
	
	public T getRootData() throws Exception
	{
		if(isEmpty())
			throw new Exception();
		else
			return root.getData();
	}
	
	public boolean isEmpty()
	{
		return root == null;
	}
	
	public void clear()
	{
		root = null;
	}
	
	protected void SetRootData(T rootData)
	{
		root.setData(rootData);
	}
	
	protected void setRootNode(BinaryNode rootNode)
	{
		root = rootNode;
	}
	
	protected BinaryNode getRootNode()
	{
		return root;
	}
	
	public int getNumberOfNode()
	{
		return root.getNumberOfNodes();
	}
	
	public void inorderTraverse(LinkedList<T> list)
	{
		inorderTraverse(root, list);
	}
	
	private void inorderTraverse(BinaryNode node, LinkedList<T> list)
	{
		if(node != null)
		{
			inorderTraverse(node.getLeftChild(), list);
			list.add(node.getData());
			inorderTraverse(node.getRightChild(), list);
		}
	}
	
	public void preorderTraverse()
	{
		preorderTraverse(root);
	}
	
	public void preorderTraverse(BinaryNode node)
	{
		if(node != null)
		{
			System.out.printf("%s, ", node.getData());
			preorderTraverse(node.getLeftChild());
			preorderTraverse(node.getRightChild());
		}
	}
	
	public void postorderTraverse()
	{
		postorderTraverse(root);
	}
	
	public void postorderTraverse(BinaryNode node)
	{
		if(node != null)
		{
			postorderTraverse(node.getLeftChild());
			postorderTraverse(node.getRightChild());
			System.out.printf("%s, ", node.getData());
		}
	}
	
	
	
	private class BinaryNode
	{
		private T data;
		private BinaryNode leftChild;
		private BinaryNode rightChild;
		
		public BinaryNode()
		{
			this(null);
		}
		
		public BinaryNode(T data)
		{
			this(data, null, null);
		}
		
		public BinaryNode(T data, BinaryNode leftChild, BinaryNode rightChild)
		{
			this.data = data;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}
		
		public T getData()
		{
			return this.data;
		}
		
		public BinaryNode getLeftChild()
		{
			return this.leftChild;
		}
		
		public BinaryNode getRightChild()
		{
			return this.rightChild;
		}
		
		public void setData(T data)
		{
			this.data = data;
		}
		
		public void setLeftChild(BinaryNode leftChild)
		{
			this.leftChild = leftChild;
		}
		
		public void setRightChild(BinaryNode rightChild)
		{
			this.rightChild = rightChild;
		}
		
		public boolean hasLeftChild()
		{
			return leftChild != null;
		}
		
		public boolean hasRightChild()
		{
			return rightChild != null;
		}
		
		public boolean isLeaf()
		{
			return (leftChild == null) && (rightChild == null);
		}
		
		
		public int getNumberOfNodes()
		{
			int leftNumber = 0;
			int rightNumber = 0;
			
			if(leftChild != null)
				leftNumber = leftChild.getNumberOfNodes();
			
			if(rightChild != null)
				rightNumber = rightChild.getNumberOfNodes();
			
			return 1 + leftNumber + rightNumber;
		}
		
		public int getHeight()
		{
			return getHeight(this);
		}
		
		
		private int getHeight(BinaryNode node)
		{
			int height = 0;
			if(node != null)
				height = 1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));
			
			return height;
		}
		
		public BinaryNode copy()
		{
			BinaryNode newRoot = new BinaryNode(data);
			
			if(leftChild != null)
				newRoot.setLeftChild(leftChild.copy());
			
			if(rightChild != null)
				newRoot.setRightChild(rightChild.copy());
			
			return newRoot;
		}		
	}
}
