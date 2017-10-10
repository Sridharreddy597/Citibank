package com.bcj.HackerRank.binarysearch;

public class Node {

	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
	}

	public void insert(int value) {
		if (value <= data) {
			if (left == null)
				left = new Node(value);
			else
				left.insert(value);
		} else {
			if (value > data) {
				if (right == null)
					right = new Node(value);
				else
					right.insert(value);
			}
		}
	}

	public boolean contains(int value) {

		if (data == value)
			return true;
		else if (value <= data) {
			if (left == null)
				return false;
			else
				return left.contains(value);
		} else {
			if (right == null)
				return false;
			else
				return right.contains(value);
		}

	}

	public void printInOrder() {
		if (left != null) {
			left.printInOrder();
		}
		System.out.println(data);
		if (right != null) {
			right.printInOrder();
		}
	}

	public boolean checkBST(Node root) {

		return isBST(root, -1, -1);
	}

	private boolean isBST(Node root, int lowValue, int highValue) {
		if (root == null) {
			return true;
		} else if (lowValue >= 0 && root.data <= lowValue) {
			return false;
		}
		if (highValue >= 0 && root.data >= highValue) {
			return false;
		}

		return (isBST(root.left, lowValue, root.data) && isBST(root.right, root.data, highValue));
	}
	
}
