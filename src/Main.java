import java.util.ArrayList;
/**
 * Test class for the project and it consists of all the debug and functionality tests.
 * In addition, it iteratesover the data obtained from the .txt files, namely database.txt and query.txt 
 * and uses the string lines from the .txt files to achieve the expected results.
 * 
 * @author  Berk Kaan Kuguoglu
 * @version 1.0
 * @since   2016-02-28 
 */

public class Main {
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String[]> pB = new ArrayList<String[]>();      // ArrayList in which the data from database.txt is stored
		ArrayList<String[]> pBQuery = new ArrayList<String[]>(); // ArrayList in which the data from query.txt is stored
		BST bstByName = new BST();   // Binary search tree object to be created with respect to the name field
		BST bstBySName = new BST();  // Binary search tree object to be created with respect to the surname field
		BST bstByNumber = new BST(); // Binary search tree object to be created with respect to the number field
		
		System.out.println("The database is being read...\n");

		DatabaseReader.readDatabase();
		pB = DatabaseReader.getPhoneBook();
		
		/* Creating the binary search trees and inserting the values from the file
		 * database.txt with respect to their name, surname, and number fields respectively.
		 */
		
		for (int i = 0; i < pB.size(); i++) {
			String[] line = pB.get(i);
			bstByName.insertByName(line[0], line[1], line[2]);
		}
		
		for (int i = 0; i < pB.size(); i++) {
			String[] line = pB.get(i);
			bstBySName.insertBySName(line[0], line[1], line[2]);
		}
		
		for (int i = 0; i < pB.size(); i++) {
			String[] line = pB.get(i);
			bstByNumber.insertByNumber(line[0], line[1], line[2]);
		}
		
		/* Here are some debug and functionality tests for the inorder, preorder and postorder traversal algorithms.
		 * 
		 * 1. Test Cases for binary search tree in which the nodes are inserted by their names.
		 *
		 
		System.out.println("Inorder traversal by name is being done.\n");
		BST.inorder(bstByName.getRoot());
		System.out.println("\nInorder traversal by name is completed successfully.\n");
		
		System.out.println("Preorder traversal by name is being done.\n");
		BST.preorder(bstByName.getRoot());
		System.out.println("\nPreorder traversal by name is completed successfully.\n");
		
		System.out.println("Postorder traversal by name is being done.\n");
		BST.postorder(bstByName.getRoot());
		System.out.println("\nPostorder traversal by name is completed successfully.\n");

		*
		* 2. Test Cases for binary search tree in which the nodes are inserted by their surnames.
		*
		
		System.out.println("Inorder traversal by surname is being done.\n");
		BST.inorder(bstBySName.getRoot());
		System.out.println("\nInorder traversal by surname is completed successfully.\n");
		
		System.out.println("Preorder traversal by surname is being done.\n");
		BST.preorder(bstBySName.getRoot());
		System.out.println("\nPreorder traversal by surname is completed successfully.\n");
		
		System.out.println("Postorder traversal by surname is being done.\n");
		BST.postorder(bstBySName.getRoot());
		System.out.println("\nPostorder traversal by surname is completed successfully.\n");
		
		*
		* 3. Test Cases for binary search tree in which the nodes are inserted by their numbers.
		*
		
		System.out.println("Inorder traversal by number is being done.\n");
		BST.inorder(bstByNumber.getRoot());
		System.out.println("\nInorder traversal by number is completed successfully.\n");
		
		System.out.println("Preorder traversal by number is being done.\n");
		BST.preorder(bstByNumber.getRoot());
		System.out.println("\nPreorder traversal by number is completed successfully.\n");
		
		System.out.println("Postorder traversal by number is being done.\n");
		BST.postorder(bstByNumber.getRoot());
		System.out.println("\nPostorder traversal by number is completed successfully.\n");
		
		*/
		
		System.out.println("\nThe query is being read...\n");
		
		DatabaseReader.readQuery();
		pBQuery = DatabaseReader.getPhoneBookQuery();
		
		/* As seen, I mostly stick with the Inorder Traversal in terms of printing the binary search trees
		 * after each query and database file is read. In doing so, it became relatively easy to check which nodes
		 * are in the tree and their whereabouts.
		 */
		
		for (int i = 0; i < pBQuery.size(); i++) {
			String[] commandLine = pBQuery.get(i);
			System.out.println("\nThe query '" + commandLine[0] + " " +  commandLine[1] + " " + commandLine[2] + " " + commandLine[3] + "' is being implemented");
			if(commandLine[0].equalsIgnoreCase("insert")){
				bstByName.insertByName(commandLine[1], commandLine[2], commandLine[3]);
			}else if(commandLine[0].equalsIgnoreCase("delete")){
				BST.delete(bstByName, commandLine[1]);
			}
			System.out.println("\nHere is how the binary search tree looks like after the query.\n");
			BST.inorder(bstByName.getRoot());
		}
		
		System.out.println("\nAfter all the query is read");
		
		System.out.println("\nRoot node:");
		System.out.println(bstByName.getRoot());
		
		System.out.println("\nRight child of the root node:");
		System.out.println(bstByName.getRoot().getRight());
		
		System.out.println("\nTo reach the node Nicole Kidman R-R-L-R:");
		System.out.println(bstByName.getRoot().getRight().getRight().getLeft().getRight());

		
		/* Here are some debug and functionality tests for findByName, findCeilingNode and findFloorNode algorithms.
		 * Furthermore, the deletion operation can also be observed with these lines of code.
		 * 
		System.out.println("\nFind By Name");
		System.out.println(BST.findByName(bstByName.getRoot(), "Anne"));
		System.out.println("\nFind Ceiling");
		System.out.println(BST.findCeilingNode(bstByName.getRoot()));
		System.out.println("\nFind Floor");
		System.out.println(BST.findFloorNode(bstByName.getRoot()));
		System.out.println("");

		bstByName.setRoot(BST.delete(bstByName, "Jim"));
		
		System.out.println(bstByName.getRoot());
		System.out.println(bstByName.getRoot().getRight());
		System.out.println(bstByName.getRoot().getRight().getLeft());
		*/
		System.out.println(BST.countNodes(bstByName.getRoot()));
		System.out.println(BST.maxHeight(bstByName.getRoot(),0));
		System.out.println(BST.findHeight(bstByName.getRoot(),"Liam",0));

	}
		
	}

