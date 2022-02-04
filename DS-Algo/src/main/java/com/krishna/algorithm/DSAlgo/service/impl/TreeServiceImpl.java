package com.krishna.algorithm.DSAlgo.service.impl;

import org.springframework.stereotype.Component;

import com.krishna.algorithm.DSAlgo.model.Tree;
import com.krishna.algorithm.DSAlgo.service.TreeService;

@Component
public class TreeServiceImpl implements TreeService{
private static Tree root;
	
	private static Tree avlRoot;

	private static boolean flag = false;

	@Override
	public Tree addNode(int value) {

		while (flag) {
		}

		flag = true;
		if (root == null) {
			root = new Tree() ;
			root.setValue(value);
			root.setLeft(null);
			root.setRight(null);
		} else {
			Tree parent = getParentLeaf(value ,root);
			Tree node = new Tree();
			node.setValue(value);
			node.setLeft(null);
			node.setRight(null);
			if (value > parent.getValue())   {
				parent.setRight(node)       ;
			} else {
				parent.setLeft(node);
			}

		}
		flag = false;
		return root;
	}

	private Tree getParentLeaf(int value ,Tree root )   {

		Tree temp = root;

		while (temp != null) {
			if (temp.getValue() < value) {
				if (temp.getRight() == null)
					break;
				temp = temp.getRight();
			} else {
				if (temp.getLeft() == null)
					break;
				temp = temp.getLeft() ;

			}

		}

		return temp;
	}

	@Override
	public Tree deleteNode(int value) {
		
		while (flag) {
		}

		flag = true;

		Tree parent = null;
		Tree nodeToBeDeleted = getNodeToBeDeletedParent(value);
		if (nodeToBeDeleted != null) {
			if (nodeToBeDeleted.getLeft() == null && nodeToBeDeleted.getRight() == null) {
				parent = getParent(value,root) ;
				if (parent == null)
					root = null;
				else {
					if (parent.getValue() < value)
						parent.setRight(null);
					else
						parent.setLeft(null);
				}
			} else if (nodeToBeDeleted.getLeft() != null && nodeToBeDeleted.getLeft().getRight() != null) {
				Tree leftRightMost = getleftRightMost(nodeToBeDeleted.getLeft().getRight());
				parent = getParent(leftRightMost.getValue(),root);
				swap(nodeToBeDeleted, leftRightMost);
				parent.setRight(leftRightMost.getLeft());
			} else if (nodeToBeDeleted.getRight() != null && nodeToBeDeleted.getRight().getLeft() != null) {
				Tree rightLeftMost = getRightLeftMost(nodeToBeDeleted.getRight().getLeft());
				parent = getParent(rightLeftMost.getValue(),root);
				swap(nodeToBeDeleted, rightLeftMost);
				parent.setLeft(rightLeftMost.getRight());
			} else if (nodeToBeDeleted.getLeft() != null) {
				parent = getParent(nodeToBeDeleted.getValue(),root);
				if (parent == null) {
					Tree left = nodeToBeDeleted.getLeft();
					Tree right = nodeToBeDeleted.getRight();
					left.setRight(right);
					root = left;
				} else
					parent.setLeft(nodeToBeDeleted.getLeft());

			} else if (nodeToBeDeleted.getRight() != null) {
				parent = getParent(nodeToBeDeleted.getValue(),root);
				if (parent == null) {
					Tree left = nodeToBeDeleted.getLeft();
					Tree right = nodeToBeDeleted.getRight();
					right.setLeft(left);
					root = right;
				} else

					parent.setRight(nodeToBeDeleted.getRight());
			}
		}
		flag = false;
		return root;
	}

	private Tree getRightLeftMost(Tree left) {
		Tree leftMost = left;
		while (leftMost.getLeft() != null)
			leftMost = leftMost.getLeft();
		return leftMost;
	}

	private void swap(Tree nodeToBeDeleted, Tree leftRightMost) {
		int temp = nodeToBeDeleted.getValue();
		nodeToBeDeleted.setValue(leftRightMost.getValue());
		leftRightMost.setValue(temp);
	}

	private Tree getleftRightMost(Tree right) {
		Tree rightMost = right;
		while (rightMost.getRight() != null)
			rightMost = rightMost.getRight();
		return rightMost;
	}

	private Tree getParent(int value , Tree root) {
		Tree parent = null;
		Tree temp = root;
		while (temp != null) {
			if ((temp.getRight() != null && temp.getRight().getValue() == value)
					|| (temp.getLeft() != null && temp.getLeft().getValue() == value)) {
				parent = temp;
				break;
			}
			if (temp.getValue() < value)
				temp = temp.getRight();
			else
				temp = temp.getLeft();
		}
		return parent;
	}

	private Tree getNodeToBeDeletedParent(int value) {
		Tree nodeToBeDeleted = null;
		Tree temp = root;

		while (temp != null) {
			if (temp.getValue() == value) {
				nodeToBeDeleted = temp;
				break;
			}
			if (temp.getValue() < value)
				temp = temp.getRight();
			else
				temp = temp.getLeft();

		}
		return nodeToBeDeleted;
	}

	@Override
	public Tree getNode(int value) {
		
		while (flag) {
		}

		flag = true;

		
		Tree nodeToBeSerach = null;
		Tree temp = root;
		while (temp != null) {
			if (temp.getValue() == value) {
				nodeToBeSerach = temp;
				break;
			}
			if (temp.getValue() < value)
				temp = temp.getRight();
			else
				temp = temp.getLeft();
		}
		
		flag=false;
		return nodeToBeSerach;
	}

	@Override
	public Tree addAvlNode(int value) {
		while (flag) {
		}

		flag = true;
		if (avlRoot == null) {
			avlRoot = new Tree();
			avlRoot.setValue(value);
			avlRoot.setLeft(null);
			avlRoot.setRight(null);
		} else {
			Tree parent = getParentLeaf(value, avlRoot);
			Tree node = new Tree();
			node.setValue(value);
			node.setLeft(null);
			node.setRight(null);
			if (value > parent.getValue()) {
				parent.setRight(node);
			} else {
				parent.setLeft(node);
			}

		}
		
		Tree temp = avlRoot;
		balance(value, temp);

		flag= false;
		return avlRoot;
	}

	private void balance(int value, Tree temp) {
		
		if(temp.getValue()!=value) {
			if(temp.getValue()<value)
				balance(value, temp.getRight());
			else
				balance(value, temp.getLeft());
		}
		
		int balanceOfTree = getHeight(temp.getLeft()) - getHeight(temp.getRight());
		
		if(balanceOfTree> 1) {
			if(temp.getLeft().getValue()<value)
				leftRotate(temp.getLeft());
			rightRotate(temp);
		}
		
		if(balanceOfTree<-1) {
			if(temp.getRight().getValue()>value)
				rightRotate(temp.getRight());
			leftRotate(temp);
		}
		
		
		
	}

	private void rightRotate(Tree node) {
		Tree parent = getParent(node.getValue(),avlRoot);
		Tree left = node.getLeft();
		Tree leftRight = node.getLeft().getRight();
		left.setRight(node);
		node.setLeft(leftRight);
		
		setParent(node, parent, left);
		
	}

	private void setParent(Tree node, Tree parent, Tree left) {
		if(parent!=null) {
			if(parent.getValue()<node.getValue())
				parent.setRight(left);
			else
				parent.setLeft(left);
		}else {
			avlRoot= left;
		}
	}

	private void leftRotate(Tree node) {
		Tree parent = getParent(node.getValue(), avlRoot);
		Tree right = node.getRight();
		Tree rightLeft = node.getRight().getLeft();
		right.setLeft(node);
		node.setRight(rightLeft);
		setParent(node, parent, right);

	}

	private int getHeight(Tree node) {
		
		if(node==null)
			return -1;
		
		return 1 + max(getHeight(node.getLeft()),getHeight(node.getRight()));
	}

	private int max(int height, int height2) {
		int max =height;
		if(height2>height)
			max=height2;
		return max ;
	}

}
