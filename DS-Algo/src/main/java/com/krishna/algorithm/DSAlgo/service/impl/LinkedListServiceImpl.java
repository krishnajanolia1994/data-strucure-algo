package com.krishna.algorithm.DSAlgo.service.impl;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.krishna.algorithm.DSAlgo.model.DataStructure;
import com.krishna.algorithm.DSAlgo.model.LinkedList;
import com.krishna.algorithm.DSAlgo.model.Tree;
import com.krishna.algorithm.DSAlgo.service.LinkedListService;

@Component
public class LinkedListServiceImpl implements LinkedListService{
	DataStructure dataStructure = DataStructure.getDataStruture();


	@Override
	public LinkedList AddNode(String name, String surname) {
		
		LinkedList linkedList = dataStructure.getHead();
		
		LinkedList linkedListNode = new LinkedList();
		
		linkedListNode.setName(name);
		linkedListNode.setSurName(surname);
		
		linkedListNode.setNext(null);
		

		if(linkedList==null) {
			linkedListNode.setName(name);
			
			linkedListNode.setSurName(surname);
			linkedListNode.setNext(null);
			dataStructure.setHead(linkedListNode);
		}else { 
			LinkedList temp = linkedList;
			LinkedList lastNode = getLastNode(temp);
			lastNode.setNext(linkedListNode);         
		}
		
		return dataStructure.getHead();
		
	}


	private LinkedList getLastNode(LinkedList linkedList) {
		while(linkedList.getNext()!=null) {
			linkedList = linkedList.getNext();
		}
		return linkedList;
	}


	@Override
	public LinkedList delete(String name) {
		
		LinkedList linkedList = dataStructure.getHead();
		
		if(linkedList==null)
			return linkedList;
		if(linkedList.getName().equals(name)) {
			dataStructure.setHead(linkedList.getNext());
			return dataStructure.getHead();

		}
		
		LinkedList parent = getParentNode(dataStructure.getHead(),name);
		if(parent!=null) {
			
			LinkedList grandChild = parent.getNext().getNext();
			parent.setNext(grandChild);
			
		}
		return dataStructure.getHead();
	}


	private LinkedList getParentNode(LinkedList head, String name) {
		LinkedList parent = null;
		LinkedList temp = head;
		while(temp.getNext()!=null) {
			if( temp.getNext().getName().equals(name))
				parent = temp;
			temp=temp.getNext();
		}
				
		return parent;
	}


	@Override
	public LinkedList deleteByPosition(int index) {
		LinkedList linkedList = dataStructure.getHead();
		
		if(linkedList==null)
			return linkedList;
		
		LinkedList parent = getParentNodeByIndex(dataStructure.getHead(), index);
		if(parent!=null) {
			
			LinkedList grandChild = parent.getNext().getNext();
			parent.setNext(grandChild);
			
		}
		
		return dataStructure.getHead();
	}


	private LinkedList getParentNodeByIndex(LinkedList head, int index) {
		for(int i=0 ;i<index-1 ;i++) {
			head=head.getNext();
		}
		return head;
	}


	@Override
	public Integer findLength() {
		
		int count = 0;
		if(dataStructure.getHead()!=null) {
			LinkedList linkedList = dataStructure.getHead();
			while(linkedList!=null) {
				count++;
				linkedList=linkedList.getNext();
			}
		}
		return count;
	}


	@Override
	public Integer findLengthByRecursion() {
		LinkedList linkedList = dataStructure.getHead();
		int length=getLength(linkedList);
		return length;
	}


	private int getLength(LinkedList head) {
		if(head==null)
			return 0;
		return 1+getLength(head.getNext());
	}


	@Override
	public LinkedList swap(String first, String second) {
		if(first==second) {
			System.out.println("same element");
			return dataStructure.getHead();
		}
		
		LinkedList linkedList = dataStructure.getHead();
		if(linkedList.getName().equals(first)||linkedList.getName().equals(second)) {
			LinkedList firstNode = null;
			LinkedList secondNodeParent = null;
			firstNode = linkedList;

			if(linkedList.getName().equals(first)) {
				while(linkedList.getNext()!=null) {
					if(linkedList.getNext().getName().equals(second)) {
						secondNodeParent = linkedList;
					}
					linkedList=linkedList.getNext();
				}
				swapNode(linkedList, firstNode, secondNodeParent);
			}else {
				while(linkedList.getNext()!=null) {
					if(linkedList.getNext().getName().equals(first)) {
						secondNodeParent = linkedList;
					}
					linkedList=linkedList.getNext();

				}
				swapNode(linkedList, firstNode, secondNodeParent);
			}
				
		}else {
			LinkedList fistParent = null;
			LinkedList secondParent = null;
			boolean fistFount =false;
			boolean seondFound = false;
			while(linkedList.getNext()!=null) {
				
				if(!fistFount&&linkedList.getNext().getName().equals(first)) {
					fistFount= true;
					fistParent= linkedList;
				}else if(!seondFound&&linkedList.getNext().getName().equals(second)) {
					seondFound=true;
					secondParent=linkedList;
				}else if(fistFount&& seondFound)
					break;
				linkedList=linkedList.getNext();
				
			}
			if(fistParent!=null&&secondParent!=null) {
				LinkedList firstNode = fistParent.getNext();
				LinkedList firstChild = firstNode.getNext();
				LinkedList secondNode = secondParent.getNext();
				LinkedList secondChild = secondNode.getNext();
				secondParent.setNext(firstNode);
				firstNode.setNext(secondChild);
				fistParent.setNext(secondNode);
				secondNode.setNext(firstChild);
			}
		}
		 
		return dataStructure.getHead(); 
	}


	private void swapNode(LinkedList linkedList, LinkedList firstNode, LinkedList secondNodeParent) {
		if(secondNodeParent!=null) {
			LinkedList firstChildNode = firstNode.getNext();
			LinkedList secondChildNode = secondNodeParent.getNext().getNext();
			LinkedList secondNode = secondNodeParent.getNext();
			secondNode.setNext(firstChildNode);
			secondNodeParent.setNext(firstNode);
			firstNode.setNext(secondChildNode);
			dataStructure.setHead(secondNode);
		}
	}


	@Override
	public LinkedList getLinkedList() {
		return dataStructure.getHead();
	}


	@Override
	public LinkedList reverse() {
		LinkedList head = dataStructure.getHead();
		reverse(head,true);
		return dataStructure.getHead();
	}


	private LinkedList reverse(LinkedList head,boolean isHead) {
		if(head.getNext()==null) {
			dataStructure.setHead(head);
			return head;
		}
		LinkedList next = head.getNext();
		if(isHead) {
			head.setNext(null);
			isHead=false;
		}
		LinkedList reverse = reverse(next,isHead); 
		reverse.setNext(head);
		return head;
	}


	@Override
	public LinkedList meargeSoart() {
		LinkedList  head = dataStructure.getHead();
		LinkedList  tail = getTail(dataStructure.getHead());
		 meargeSoart(head,tail);
		dataStructure.setHead(head);
		return dataStructure.getHead();
	}


	private LinkedList meargeSoart(LinkedList head, LinkedList tail) {
		if(head!=tail) {
			LinkedList mid = getMid(head,tail);
			meargeSoart(head,mid);
			meargeSoart(mid.getNext(), tail);
			head = mearge(head,mid,tail);
		}
		return head;
	}


	private LinkedList mearge(LinkedList head, LinkedList mid, LinkedList tail) {
		
		LinkedList head1 = null;
		LinkedList tail1 = null;

		LinkedList head2 = null;
		LinkedList tail2 = null;

		LinkedList tempHead = head;
		
		while(tempHead != mid.getNext()) {
			if(head1==null) {
				head1 = new LinkedList();
				head1.setName(tempHead.getName());
				head1.setNext(null);
				tail1= head1;
				tempHead = tempHead.getNext();
			}else {
				LinkedList node  = new LinkedList();
				node.setName(tempHead.getName());
				node.setNext(null);
				tail1.setNext(node);
				tail1=node;
				tempHead = tempHead.getNext();
			}
			
		}
		while(tempHead != tail.getNext()) {
			if(head2==null) {
				head2 = new LinkedList();
				head2.setName(tempHead.getName());
				head2.setNext(null);
				tail2= head2;
				tempHead = tempHead.getNext();
			}else {
				LinkedList node  = new LinkedList();
				node.setName(tempHead.getName());
				node.setNext(null);
				tail2.setNext(node);
				tail2=node;
				tempHead = tempHead.getNext();
			}
			
		}
		tempHead = head;
		while(head1 !=null && head2!=null) {
			if(Integer.parseInt(head1.getName())< Integer.parseInt(head2.getName())) {
				tempHead.setName(head1.getName());
				head1= head1.getNext();
				tempHead= tempHead.getNext();
			}else {
				tempHead.setName(head2.getName());
				head2=head2.getNext();
				tempHead= tempHead.getNext();
			}
		}
		
		while(head1 !=null) {
			tempHead.setName(head1.getName());
			head1 = head1.getNext();
			tempHead = tempHead.getNext();
			
		}
		while(head2!=null) {
			tempHead.setName(head2.getName());
			head2=head2.getNext();
			tempHead= tempHead.getNext();
			
		}
		return head;
	}


	private LinkedList getMid(LinkedList head, LinkedList tail) {
		LinkedList slow = head;
		LinkedList fast = head.getNext();
		LinkedList tailNext = tail.getNext();
		
		while(fast!=null && fast!=tailNext && fast.getNext()!= tailNext) {
			fast = fast.getNext();
			if(fast!=null) {
				fast=fast.getNext();
				slow = slow.getNext();
			}
		}
		
		return slow;
	}


	private LinkedList getTail(LinkedList head) {
		while(head.getNext()!=null) {
			head = head.getNext();
		}
		return head;
	}


	@Override
	public LinkedList rotate(int number) {
		
		if(dataStructure.getHead()!=null&&dataStructure.getHead().getNext()!=null) {
			for(int i=0;i<number ;i++) {
				LinkedList head = dataStructure.getHead();
				LinkedList parentTail = getParentTail(head);
				LinkedList tail = parentTail.getNext();
				parentTail.setNext(null);
				tail.setNext(head);
				dataStructure.setHead(tail);
				
				
			}
		}else
			System.out.println("there is only one element in list or empty");
		
		
		return dataStructure.getHead();
	}


	private LinkedList getParentTail(LinkedList head) {
		LinkedList tempHead = head;
		LinkedList parent = null;
		while(tempHead.getNext().getNext()!=null) {
			tempHead = tempHead.getNext();
		}
		parent = tempHead;
		return parent;
	}


	@Override
	public String crateDoublyLinkedListFromTree() {
		
		Tree tree = null;
		Random random = new Random();
		int value = 0;
//		for(int i=0;i<10 ; i++) {
//			value = random.nextInt(1000);
//			tree= addNode(value, tree);
//		}
		tree= addNode(674, tree);
		tree= addNode(577, tree);
		tree= addNode(365, tree);
		tree= addNode(294, tree);
		tree= addNode(198, tree);
		tree= addNode(491, tree);
		tree= addNode(743, tree);
		tree= addNode(740, tree);
		tree= addNode(786, tree);
		tree= addNode(749, tree);
		String list = "";
		convert(tree,tree);
//		Tree l = tree.getLeft();
//		Tree r=tree.getRight();
//		Tree rr=null;
//		Tree rl=null;
//		Tree ll=null;
//		Tree lr=null;
//		
//		tree.setLeft(l);
//		tree.setRight(r);
//		if(r!=null) {
//			tree.setRight(r);
//			rr=r.getRight();
//			rl=r.getLeft();
//
//			r.setLeft(tree);
//			r.setRight(null);
//		}
//		
//		if(l!=null) {
//			tree.setLeft(l);
//			ll=l.getLeft();
//			lr=l.getRight();
//
//			l.setRight(tree);
//			l.setLeft(null);
//		}
//		
//		
//		
//		Tree leftChild =convert(l,ll,lr);
//		Tree rightChild =convert(r,rr,rl);
		
		Tree left = tree.getLeft();
		Tree right = tree.getRight();
		left.setRight(tree);
		right.setLeft(tree);
		return list;
	}
	
	private void convert(Tree tree, Tree root) {
		if(tree!=null && (tree.getRight()!=null || tree.getLeft()!=null)) {
			
			convert(tree.getLeft(), root);
			convert(tree.getRight(), root);
			
			Tree parent = getParent(root,tree);
			
			if(parent!=null) {
				if(parent.getValue()>tree.getValue()&& tree.getRight()!=null) {
//					if(tree.getLeft()!=null)
//						tree.getLeft().setRight(tree);
					rotateLeft(tree,parent,null);
				}else if(parent.getValue()<tree.getValue()&& tree.getLeft()!=null){
//					if(tree.getRight()!=null)
//						tree.getRight().setLeft(tree);
					rotateRight(tree,parent,null);

				}
		
			}
		}
	}
	
	private Tree getParent(Tree root, Tree tree) {
		Tree parent = null;
		Tree temp = root;
		while(temp!=null) {
			if(temp.getRight()== tree || temp.getLeft()==tree) {
				parent = temp;
				break;
			}
			if(temp.getValue()<tree.getValue()) {
				temp=temp.getRight();
			}else
				temp=temp.getLeft();
		}
		return parent;
	}

	private void rotateRight(Tree tree, Tree parent, Tree firstRotate) {
		
		Tree leftList = tree.getLeft();
		Tree rightChild = tree.getRight();
		parent.setRight(tree);
		tree.setLeft(parent);
		tree.setRight(rightChild);
		if(rightChild!=null)
			rightChild.setLeft(tree);
		while(leftList!=null) {
			Tree mid = leftList;
			leftList = leftList.getLeft();
			Tree child = parent.getRight();
			
			parent.setRight(mid);
			mid.setLeft(parent);
			mid.setRight(child);
			child.setLeft(mid);
		}
		
	}

	private void rotateLeft(Tree tree, Tree parent, Tree firstRotate) {
		
		Tree rightList = tree.getRight();
		Tree leftChild = tree.getLeft();
		tree.setRight(parent);
		if(leftChild!=null) {
			leftChild.setRight(tree);
		}
		while(rightList!=null) {
			Tree Child = parent.getLeft();
			Tree mid = rightList;
			rightList = rightList.getRight();
			parent.setLeft(mid);
			mid.setRight(parent);
			mid.setLeft(Child);
			Child.setRight(mid);
		}
		
	}


//	private Tree convert(Tree parent, Tree l, Tree r) {
//		if(parent!=null) {
//			Tree rr=null;
//			Tree rl=null;
//			Tree ll=null;
//			Tree lr=null;
//			
//			if(r!=null) {
//				if(parent.getRight()==null) {
//					parent.setRight(r);
//
//				}else {
//					
//				}
//				rr=r.getRight();
//				rl=r.getLeft();
//				r.setLeft(parent);
//				r.setRight(null);
//			}
//			
//			if(l!=null) {
//				parent.setLeft(l);
//				ll=l.getLeft();
//				lr=l.getRight();
//				l.setRight(parent);
//				l.setLeft(null);
//			}
//			l=convert(l,ll,lr);
//			r=convert(r,rr,rl);			
//			
//		}
//		return parent;
//	}
//

	public Tree addNode(int value,Tree root) {

		
		if(root==null) {
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




	
}
