package com.greatlearning.bst;

class Node {
	int val;
	Node left, right;

	Node(int item) {
		val = item;
		left = right = null;
	}
}

class BSTintoSkewedTree {
	public static Node Node;
	static Node prevNode = null;
	static Node headNode = null;

	static void conversionIntoSkewed(Node root, int order) {
		if (root == null) {
			return;
		}

		if (order > 0) {
			conversionIntoSkewed(root.right, order);
		} else {
			conversionIntoSkewed(root.left, order);
		}
		Node rightNode = root.right;
		Node leftNode = root.left;

		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		if (order > 0) {
			conversionIntoSkewed(leftNode, order);
		} else {
			conversionIntoSkewed(rightNode, order);
		}
	}

	static void traverseRightSkewed(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		traverseRightSkewed(root.right);
	}

	public static void main(String[] args) {
		BSTintoSkewedTree tree = new BSTintoSkewedTree();
		tree.Node = new Node(50);
		tree.Node.left = new Node(30);
		tree.Node.right = new Node(60);
		tree.Node.left.left = new Node(10);
		tree.Node.right.left = new Node(55);

		int order = 0;
		conversionIntoSkewed(Node, order);
		System.out.println("Result after converting BST to increasing Skewed Tree");
		traverseRightSkewed(headNode);
	}
}
