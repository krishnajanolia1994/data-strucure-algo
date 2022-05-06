package com.krishna.algorithm.DSAlgo.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.krishna.algorithm.DSAlgo.model.Tree;
import com.krishna.algorithm.DSAlgo.model.TreeWithRandom;
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
				parent.setRight(node)  ;
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

	@Override
	public Tree inorder() {
		Tree temp = root;
		inorderTavest(temp);
		return root;
	}

	private void inorderTavest(Tree temp) {
		if(temp!=null) {
			inorderTavest(temp.getLeft());
			System.out.println(temp.getValue());
			inorderTavest(temp.getLeft());

		}
	}

	@Override
	public Tree preorder() {
		Tree temp = root;
		preorderTavest(temp);
		return root;
	}

	private void preorderTavest(Tree temp) {
		if(temp!=null) {
			System.out.println(temp.getValue());
			inorderTavest(temp.getLeft());
			inorderTavest(temp.getLeft());

		}

		
	}

	@Override
	public Tree postorder() {
		Tree temp = root;
		postorderTavest(temp);
		return root;
	}

	private void postorderTavest(Tree temp) {
		if(temp!=null) {
			inorderTavest(temp.getLeft());
			inorderTavest(temp.getLeft());
			System.out.println(temp.getValue());

		}

	}

	@Override
	public int getDiameter() {
		Tree temp = root;
		
		return getDiameter(temp);
	}

	private int getDiameter(Tree temp) {
		
		if(temp==null)
			return 0;
		
		int lHeight = getHeight(temp.getLeft());
		int rHeight = getHeight(temp.getRight());
		
		int lDiameter = getDiameter(temp.getLeft());
		int rDiameter = getDiameter(temp.getLeft());
		
		


		return max((1+lHeight+rHeight), max(lDiameter,rDiameter));
	}

	@Override
	public Tree convertIntoThreadeBinaryTree(int[] inorder, int[] preorder) {
		Tree tree = new Tree();
		if(inorder!=null&&inorder.length!=0 && preorder!=null && preorder.length!=0) {
			Tree root = new Tree();
			int length = inorder.length;
			root.setValue(preorder[0]);
			int index=0;
			try {
				index = getIndex(inorder,preorder,0,length-1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			addSubTree(inorder,0,index-1,preorder,root);
			addSubTree(inorder,index+1,length-1,preorder,root);

		}
		return tree;
	}

	private void addSubTree(int[] inorder, int start, int end, int[] preorder, Tree root) {
		int index=0;
		try {
			index = getIndex(inorder, preorder, start, end);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Tree node = new Tree();
		node.setValue(inorder[index]);
		if(start==0||(end+1<inorder.length&&inorder[end+1]==root.getValue())) {
			root.setLeft(node);
		}else {
			root.setRight(node);
		}
		if(start!=end) {
			addSubTree(inorder,start,index-1,preorder,root);
			addSubTree(inorder,index+1,end,preorder,root);

		}
	}

	private int getIndex(int[] inorder, int[] preorder, int start, int end) throws Exception {
		int index=-1;
		for(int i=0;i<preorder.length;i++) {
			for(int j=start;j<=end;j++) {
				if(preorder[i]==inorder[j]) {
					index=j;
					break;
				}
			}
			if(index!=-1)
				break;
		}
		if(index==-1)
			throw new Exception("index out of bound");
		return index;
	}

	@Override
	public String copyTreeWithRandomNode(int[] values) {
		String response = "";
		if(values.length==0) {
			response="no value";
		}else {
			TreeWithRandom root = new TreeWithRandom();
			
			
		}
		return response;
	}

	@Override
	public String getWidth() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void isBst() {
		Tree temp = root;
		Boolean isBst = true;
		isBst=isBST(isBst,temp);
	}

	private Boolean isBST(Boolean isBst, Tree temp) {
		if(temp!=null)
		{
			if((temp.getLeft()!=null&&temp.getValue()<temp.getLeft().getValue())||(temp.getRight()!=null&&temp.getValue()>temp.getRight().getValue()))
			{
				isBst=false;
			}
			if(isBst) {
				isBST(isBst, temp.getLeft());
				isBST(isBst, temp.getRight());

			}
		}
		return isBst;
		
	}

	@Override
	public Integer getLCA(int value, int value1) {
		int small;
		int big;
		if(value>value1)
		{
			big=value;
			small = value1;
		}else {
			big=value1;
			small = value;

		}
		Tree tree = root;
		while(tree!=null){
			if(tree.getValue()==small||tree.getValue()==big||tree.getValue()<big||tree.getValue()>small)
			{
				break;
			}
			if(small<tree.getValue()&&big<tree.getValue())
				tree = tree.getLeft();
			else
				tree=tree.getRight();
		}
		return null;
	}

	@Override
	public Tree getKthSmallestElement(int maxCount) {
		Tree value =new Tree();
//		Integer count = 0;
		Tree temp =root;
		Tree count = new Tree();
		count.setValue(0);
		Map< Integer, Integer> map = new HashMap<Integer, Integer>();
		
		getKthSmallestElement(temp,count,maxCount,map);
		value.setValue(map.get(maxCount));
		return value;
	}

	private Tree getKthSmallestElement(Tree temp, Tree count, int maxCount, Map<Integer, Integer> map) {
			if(temp!=null&&count.getValue()<maxCount) {
			getKthSmallestElement(temp.getLeft(), count, maxCount,map);
			count.setValue(count.getValue()+1);
			map.put(count.getValue(), temp.getValue());
			
			
			getKthSmallestElement(temp.getRight(), count, maxCount,map);

			
		}
		return temp;
	}

}
