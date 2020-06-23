package datastructures;

/**
 * This is Binary Search Tree implementation. This implementation allows:
 * 1. Searching the node in the BST
 * 2. Adding the node in the BST
 * 3. Deleting the node in the BST
 * 4. Inorder Traversal of the BST
 * 5. Preorder Traversal of the BST
 * 6. Postorder Traversal of the BST
 * 
 * @author yogesh meshram
 *
 */
public class BinarySearchTree {

	/**
	 * Node class to define the datastucture for BST
	 * @author yogesh meshram
	 *
	 */
	public class Node {

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
	 * 
	 * @param root
	 * @param data
	 */
	public Node insertNode(Node root, int data) {

		Node ptr = root, p = null;
		boolean isLeft = false;

		while (ptr != null) {

			if (ptr.data == data)
				throw new IllegalArgumentException(data + " already exists.");

			p = ptr;

			if (data < ptr.data) {
				ptr = ptr.left;
				isLeft = true;
			} else {
				ptr = ptr.right;
				isLeft = false;
			}
		}

		Node newNode = new Node(data, null, null);

		if (root == null) {
			return newNode;
		}

		if (isLeft)
			p.left = newNode;
		else
			p.right = newNode;

		return root;
	}
	
	/**
	 * Method to search the node in the BST.
	 * @param root
	 * @param target
	 * @return
	 */
	public Node searchNode(Node root, int target) {

		Node ptr = root;

		while (ptr != null) {
			if (ptr.data == target)
				break;

			if (target < ptr.data) {
				ptr = ptr.left;

			} else {
				ptr = ptr.right;
			}

		}

		if (ptr == null) {
			throw new IllegalArgumentException(target + "node not found");
		}
		return ptr;
	}	
	
	/**
	 * The inOrderTraversal method arranges the node values of BST is ascending
	 * order.
	 * 
	 * @param node
	 */
	public void inOrderTraversal(Node node) {
		if (node != null) {
			inOrderTraversal(node.left);
			System.out.print("[ " + node.data + " ] ");
			inOrderTraversal(node.right);
		}
	}

	/**
	 * The preOrderTraversal method
	 * order.
	 * 
	 * @param node
	 */
	public void preOrderTraversal(Node node) {
		if (node != null) {
			System.out.print("[ " + node.data + " ] ");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}

	/**
	 * The preOrderTraversal method
	 * order.
	 * 
	 * @param node
	 */
	public void postOrderTraversal(Node node) {
		if (node != null) {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print("[ " + node.data + " ] ");
		}
	}

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		Node root = bst.insertNode(null, 26);
		int[] arr = { 12, 11, 17, 19, 62, 38, 45, 69, 83 };
		for (int i = 0; i < arr.length; i++)
			bst.insertNode(root, arr[i]);

		bst.inOrderTraversal(root);

	}

}
