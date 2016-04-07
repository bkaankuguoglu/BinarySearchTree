/**
 * This class implements a Node structure which consists of the nodes left, right and parent; 
 * and the String fields name, surname and number. 
 * 
 * @author  Berk Kaan Kuguoglu
 * @version 1.0
 * @since   2016-02-28 
 */

public class Node {
    private Node left;
    private Node right;
    private Node parent;
	
	private String name;
	private String surname;
	private String number;
	
	/**
	 * This constructor for Node class. 
	 */
	public Node(Node left, Node right, Node parent, String name, String surname, String number) {
		this.left = left;
		this.right = right;
		this.parent = parent;
		
		this.name = name;
		this.surname = surname;
		this.number = number;
	}
	
	/**
	 * This constructor for Node class. 
	 */
	public Node(String name, String surname, String number) {
		this.left = null;
		this.right = null;
		this.parent = null;
		
		this.name = name;
		this.surname = surname;
		this.number = number;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "Node [name=" + name + ", surname=" + surname + ", number=" + number + "]";
	}
	
	
	
	
}
