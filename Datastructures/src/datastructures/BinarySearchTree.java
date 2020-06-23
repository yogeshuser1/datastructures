package datastructures;

import java.util.Random;

public class BinarySearchTree {
	
	public class Node{
		
		int data;
		Node left;
		Node right;
		
		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;			
		}
		
	}

	public Node root;
	
	/**
	 * Method to add the node to the BST
	 * @param root
	 * @param data
	 */
	public Node insertNode(Node root, int data) {
		
		Node ptr = root, p = null;
		boolean isLeft = false;
		
		while(ptr != null) {
			
			if(ptr.data == data) throw new IllegalArgumentException( data + " already exists.");
			
			p = ptr;
			
			if(data < ptr.data) {
				ptr = ptr.left;
				isLeft = true;
			}else {
				ptr = ptr.right;
				isLeft = false;
			}
		}
		
		Node newNode = new Node(data,null,null);
		
		if(root == null) {
			return newNode;
		}
		
		if(isLeft)
			p.left = newNode;
		else
			p.right = newNode;
		
		return root;
	}
	
	/**
	 * The inOrderTraversal method arranges the node values of BST is ascending order.
	 * @param node
	 */
	public void inOrderTraversal(Node node) {
		if(node != null) {
			inOrderTraversal(node.left);
			System.out.print("[ " + node.data + " ] ");
			inOrderTraversal(node.right);
		}
	}
	
	public static void main(String[] args) {
		
		BinarySearchTree bst = new BinarySearchTree();
		Node root = bst.insertNode(null, 26);
		int[] arr = {12,11,17,19,62,38,45,69,83};
		for(int i = 0; i < arr.length; i++)
			bst.insertNode(root, arr[i]);
		
		bst.inOrderTraversal(root);

	}

}
