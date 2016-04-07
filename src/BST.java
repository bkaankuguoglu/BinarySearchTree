/**
 * This class implements a Binary Search Tree ADT by using the Node class defined in the same package.
 * Every Binary search search tree object has a root node, whose parent is defined as null and at most
 * two child nodes. Since it is a binary search tree structure, elements are always inserted in the tree
 * accordingly.
 * 
 * @author  Berk Kaan Kuguoglu
 * @version 1.0
 * @since   2016-02-28 
 */

public class BST {
	private Node root;
	private Node parent; 
	private static int nodeCount;
	private static int maxHeight;
	
	
	/**
	 * This constructor for BST class. It only constructs a BST object with a root node
	 * that points to null.
	 */
	public BST(){
		this.root = null;
	}
	
	public boolean isEmpty(){
		return root == null;
		
	}
	
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	
	/**
	 * Creates a node with the given inputs and inserts it into the binary search tree
	 * as well as checking binary search tree conditions. 
	 * 
	 * @param name name field in the node to be created
	 * @param sname surname field in the node to be created
	 * @param no number field in the node to be created
	 * 
	 */
	public void insertByName(String name, String sname, String no){
		root = insertByName(root, name, sname, no);
		System.out.println("The node Node(" + name + ", " + sname + ", " + no + ") is inserted to the tree successfully.");

	}
	
	
	/**
	 * Creates a node with the given inputs and inserts it into the binary search tree
	 * as well as checking binary search tree conditions with respect to their name field. 
	 * 
	 * @param bstNode the Binary Search Tree which is being operated
	 * @param name name field in the node to be created
	 * @param sname surname field in the node to be created
	 * @param no number field in the node to be created
	 * @return bstNode the root Node of the binary search tree after the new node is inserted
	 *  
	 */
	public Node insertByName(Node bstNode, String name, String sname, String no){
		if(bstNode == null){
			bstNode = new Node(name, sname, no);
			bstNode.setParent(parent);
		}
		else{
			parent = bstNode;
			if(name.compareTo(bstNode.getName())<0)
				bstNode.setLeft(insertByName(bstNode.getLeft(),name,sname,no));		
			
			else
				bstNode.setRight(insertByName(bstNode.getRight(),name,sname,no));
		}
		

		return bstNode;
		
	}
	
	/**
	 * Creates a node with the given inputs and inserts it into the binary search tree
	 * as well as checking binary search tree conditions with respect to their surname field. 
	 * 
	 * @param name name field in the node to be created
	 * @param sname surname field in the node to be created
	 * @param no number field in the node to be created
	 * 
	 */
	public void insertBySName(String name, String sname, String no){
		root = insertBySName(root, name, sname, no);
	}

	/**
	 * Creates a node with the given inputs and inserts it into the binary search tree
	 * as well as checking binary search tree conditions with respect to their surname field. 
	 * 
	 * @param bstNode the Binary Search Tree which is being operated
	 * @param name name field in the node to be created
	 * @param sname surname field in the node to be created
	 * @param no number field in the node to be created
	 * @return bstNode the root Node of the binary search tree after the new node is inserted
	 *  
	 */	
	public Node insertBySName(Node bstNode, String name, String sname, String no){
		if(bstNode == null){
			bstNode = new Node(name, sname, no);
			bstNode.setParent(parent);
		}
		else{
			parent = bstNode;
			if(sname.compareTo(bstNode.getSurname())<0)
				bstNode.setLeft(insertBySName(bstNode.getLeft(),name,sname,no));
			else
				bstNode.setRight(insertBySName(bstNode.getRight(),name,sname,no));
		}
		return bstNode;
		
	}
	
	/**
	 * Creates a node with the given inputs and inserts it into the binary search tree
	 * as well as checking binary search tree conditions with respect to their number field. 
	 * 
	 * @param name name field in the node to be created
	 * @param sname surname field in the node to be created
	 * @param no number field in the node to be created
	 * 
	 */
	public void insertByNumber(String name, String sname, String no){
		root = insertByNumber(root, name, sname, no);
	}

	/**
	 * Creates a node with the given inputs and inserts it into the binary search tree
	 * as well as checking binary search tree conditions with respect to their number field. 
	 * 
	 * @param bstNode the Binary Search Tree which is being operated
	 * @param name name field in the node to be created
	 * @param sname surname field in the node to be created
	 * @param no number field in the node to be created
	 * @return bstNode the root Node of the binary search tree after the new node is inserted
	 *  
	 */
	public Node insertByNumber(Node bstNode, String name, String sname, String no){
		if(bstNode == null){
			bstNode = new Node(name, sname, no);
			bstNode.setParent(parent);
		}
		else{
			parent = bstNode;
			if(no.compareTo(bstNode.getNumber())<0)
				bstNode.setLeft(insertByNumber(bstNode.getLeft(),name,sname,no));
			else
				bstNode.setRight(insertByNumber(bstNode.getRight(),name,sname,no));
		}
		return bstNode;
		
	}
	
	/**
	 * Recursively looks up for name of a node in the given binary search tree and returns it 
	 *  
	 * @param bst the Binary Search Tree which is being operated
	 * @param name name of the node being looked up
	 * @return bst the root Node of the binary search tree after the new node is inserted
	 *  
	 */
	public static Node findByName (Node bst, String name){
		if(bst != null){
			if(bst.getName().equals(name)){
				System.out.println("The node " + bst + " is found!");
				return bst;							
			}else if(bst.getName().compareTo(name)>0){
				System.out.println(bst.getLeft().getName() + " <- " + bst.getName());
				return findByName(bst.getLeft(), name);
			}else{ 
				System.out.println(bst.getName() + " -> " + bst.getRight().getName());
				return findByName(bst.getRight(), name);
			
			}
		}else
		return null;
	}
	/**
	 * Recursively looks up for the ceiling node of a node in the given binary search tree and returns it 
	 *  
	 * @param bst the starting node for the ceiling node which is being searched
	 * @return startingNode the ceiling node of a given node, possibly in the given binary search tree
	 *  
	 */
	public static Node findCeilingNode (Node bst){
		Node startingNode = null;
		String s = "";

		if(bst != null){
			if(bst.getLeft()!=null){
				startingNode = bst.getLeft();
				s = startingNode.getName() + " <- " ;
				while(startingNode.getRight()!=null){
					startingNode = startingNode.getRight();
					s = startingNode.getName() + " <- "  + s;

				}	
			}
		}
		System.out.println(s);

		return startingNode;
	}
	
	/**
	 * Recursively looks up for the floor node of a node in the given binary search tree and returns it 
	 *  
	 * @param bst the starting node for the floor node which is being searched
	 * @return startingNode the floor node of a given node, possibly in the given binary search tree
	 *  
	 */
	public static Node findFloorNode (Node bst){
		Node startingNode = null;
		String s = "";
		if(bst != null){
			if(bst.getRight()!=null){
				startingNode = bst.getRight();
				s += " -> " + startingNode.getName();
				while(startingNode.getLeft()!=null){
					startingNode = startingNode.getLeft();
					s += " -> " + startingNode.getName();
				}
			}
		}
		System.out.println(s);

		return startingNode;
	}
	
	/**
	 * It checkes whether there is floor node or ceiling node to be used for the deletion procedure.
	 * If floor node is not available to use, it returns the ceiling node of a given node
	 *   
	 * @param node for the floor node which is being searched
	 * @return startingNode the floor node of a given node, possibly in the given binary search tree
	 *  
	 */
	public static Node floorOrCeiling(Node node){
		Node floorNode = findFloorNode(node);
		Node ceilingNode = findCeilingNode(node);
		
		if (ceilingNode!=null){
			System.out.println("The ceiling node for the " + node + " is ");
			System.out.println(ceilingNode);
			
			/*
			System.out.println("\nRight child of the floor node:");
			System.out.println(floorNode.getRight());
			System.out.println("\nLeft child of the floor node:");
			System.out.println(floorNode.getLeft());
			System.out.println("\nParent node of the floor node:");
			System.out.println(node.getParent());
			*/

			return ceilingNode;
		
		}else{		
			System.out.println("The floor node for " + node + " is ");
			System.out.println(floorNode);
			
			/*
			System.out.println("\nRight child of the ceiling node:");
			System.out.println(ceilingNode.getRight());
			System.out.println("\nLeft child of the ceiling node:");
			System.out.println(ceilingNode.getLeft());
			System.out.println("\nParent node of the ceiling node:");
			System.out.println(ceilingNode.getParent());
			*/
			
			return floorNode;
		}

		
	}
	
	/**
	 * Removes the node from the binary search tree given as inputs. It firstly looks up the node
	 * to be deleted and then it creates a substitute node for the one which is to be removed.
	 * When it is applied to the binary search tree, it does not the break the conditions that satisfy
	 * binary search tree. 
	 *  
	 * @param bst the binary search tree which is being operated
	 * @param name name of the node to be removed from the tree
	 * @return bstRoot the root node of a binary search tree after the deletion operation
	 *  
	 */
	
	public static Node delete (BST bst, String name){
		Node bstRoot = bst.getRoot();
		Node deletedNode = findByName(bstRoot, name);      // The node to be removed from the bst.
		Node substituteNode = floorOrCeiling(deletedNode); // The substitute node for the removed one.
		
		
		System.out.println("\nThe node to be deleted:");
		System.out.println(deletedNode);

		System.out.println("\nThe substitute for the deleted node:");
		System.out.println(substituteNode);
		
		/* If the node to be removed is an external node, which has no children nodes,
		   then there is no need for the substitute node. Thus, we can simply set the nodes
		   that point to the external nodes to null to remove the node.
		*/
		if ((deletedNode.getRight()==null)&&(deletedNode.getLeft()==null)){
			if(deletedNode.getName().compareTo(deletedNode.getParent().getName())<0)
				deletedNode.getParent().setLeft(null);			
			else
				deletedNode.getParent().setRight(null);
			
			deletedNode.setLeft(null);
			deletedNode.setRight(null);
			deletedNode.setParent(null);
			
			return bstRoot;
		}
		
		/* If the node to be removed is not a root node, we'll apply the general approach.
		*/
		if (deletedNode.getParent()!=null){

			/* If the name of the parent node of the substitute node precedes the one of the substitute,
			 * then, set the right child of the parent node to a null unless the substitute node is a child
			 * of the deleted node.
			 */
			if(substituteNode.getParent().getName().compareTo(substituteNode.getName())<0)			
				if(substituteNode == deletedNode.getRight())
					substituteNode.getParent().setRight(substituteNode.getRight());
				else	
				substituteNode.getParent().setRight(null);
			
			/* If the name of the parent node of the substitute node succeeds the one of the substitute,
			 * then, set the left child of the parent node to a null unless the substitute node is a child
			 * of the deleted node.
			 */
			else
				if(substituteNode == deletedNode.getLeft())
					substituteNode.getParent().setLeft(substituteNode.getLeft());
				else
					substituteNode.getParent().setLeft(null);
			
			
			/* If the name of the parent node of the deleted node succeed the one of the substitute,
			 * then, set substitute node as the left child of the parent node of the deleted node.
			 * Otherwise, set the substitute to the right child.
			 */
			if(deletedNode.getParent().getName().compareTo(substituteNode.getName())>0)
				deletedNode.getParent().setLeft(substituteNode);
				
			else
				deletedNode.getParent().setRight(substituteNode);			
			

			/* Duplicates the binding that the deleted node previously had.
			 */
			substituteNode.setLeft(deletedNode.getLeft());
			substituteNode.setRight(deletedNode.getRight());
			substituteNode.setParent(deletedNode.getParent());
			
			
			/* If the deleted node has any child, then set the substitute node as their parent node.
			 */
			if (deletedNode.getRight()!=null)
				deletedNode.getRight().setParent(substituteNode);
			
			if (deletedNode.getLeft()!=null)
			deletedNode.getLeft().setParent(substituteNode);
			
			deletedNode.setLeft(null);
			deletedNode.setRight(null);
			deletedNode.setParent(null);
		}	
		/* If the node to be removed is a root node, we'll approach a bit differently.
		*/			
		else{
			/* Sets the child node of the parent of the substitute one to null.
			*/			
			if(substituteNode.getParent().getName().compareTo(substituteNode.getName())<0)
				substituteNode.getParent().setRight(null);
			else
				substituteNode.getParent().setLeft(null);
			
			/* Duplicates the binding that the deleted node previously had without setting the parent node.
			 */
			substituteNode.setLeft(deletedNode.getLeft());
			substituteNode.setRight(deletedNode.getRight());
			
			
			/* If the deleted node has any child, then set the substitute node as their parent node.
			*/			
			if (deletedNode.getRight()!=null)
				deletedNode.getRight().setParent(substituteNode);
			
			if (deletedNode.getLeft()!=null)
			deletedNode.getLeft().setParent(substituteNode);	
			
			
			deletedNode.setLeft(null);
			deletedNode.setRight(null);
			deletedNode.setParent(null);
			
			System.out.println("\nThe node " + deletedNode + " is removed from the tree successfully\n");
			
			return substituteNode;
		}
		
		System.out.println("\nThe node " + deletedNode + " is removed from the tree successfully\n");


		return bstRoot;
		
	}
	
	public static int findHeight (Node bst, String name, int height){
		if(bst != null){
			if(bst.getName().equals(name)){
				return height;
			}else if(bst.getName().compareTo(name)>0){
				height++;
				return findHeight (bst.getLeft(), name, height);
			}else{ 
				height++;
				return findHeight (bst.getRight(), name, height);
			
			}
		}
		return height;
	}
	
	public static int countNodes(Node root){
		if(root != null){
			nodeCount ++; 
			countNodes(root.getLeft());
			countNodes(root.getRight());
		}
		return nodeCount;

	}
	
	public static int maxHeight(Node root, int height){
		if(root != null){
			if ((root.getLeft()==null)&&(root.getRight()==null)){
				if(maxHeight<height)
					maxHeight = height;
				height = 0;
			}
			else
			height++;
			maxHeight(root.getLeft(),height);
			maxHeight(root.getRight(),height);
		}
		return maxHeight;

	}
	
	
	/**
	 * Prints out all the nodes in the binary search tree according to inorder traversal,
	 *  
	 * @param root the root node of the binary search tree which is being operated	 
	 *   
	 */
	public static void inorder(Node root){

		if(root != null){
			inorder(root.getLeft());
			System.out.println(root.toString());
			inorder(root.getRight());
		}

	}
	
	/**
	 * Prints out all the nodes in the binary search tree according to preorder traversal,
	 *  
	 * @param root the root node of the binary search tree which is being operated	 
	 *   
	 */
	public static void preorder(Node root){
		if(root != null){
			System.out.println(root.toString());
			inorder(root.getLeft());
			inorder(root.getRight());
		}
	}

	
	/**
	 * Prints out all the nodes in the binary search tree according to postorder traversal,
	 *  
	 * @param root the root node of the binary search tree which is being operated	 
	 *   
	 */
	public static void postorder(Node root){
		if(root != null){
			inorder(root.getLeft());
			inorder(root.getRight());
			System.out.println(root.toString());

		}
	}
	
	@Override
	public String toString() {
		
		return "BST [root=" + root + "]";
	}

	public int getNodeCount() {
		return nodeCount;
	}

	public void setNodeCount(int nodeCount) {
		this.nodeCount = nodeCount;
	}
}
