package com.krishna.algorithm.DSAlgo;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.net.ssl.SSLContext;

import org.apache.commons.codec.binary.Base64;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.NumberUtils;

import com.krishna.algorithm.DSAlgo.model.CircularLinkedList;
import com.krishna.algorithm.DSAlgo.model.DataStructure;
import com.krishna.algorithm.DSAlgo.model.DoublyLinkedList;
import com.krishna.algorithm.DSAlgo.model.LinkedList;

@SpringBootApplication
public class DsAlgoApplication { 
	

	public static void main(String[] args) {
		
		
		org.apache.wink.client.ClientConfig clientConfig = new org.apache.wink.client.ClientConfig();
		
		
		String a="a    "; 
		
		
		String b="b";
		String c= a+b;
		System.out.println(c.replaceAll(" ", ""));
		 Base64 base64 = new Base64();
	        System.out.println(new String(base64.encode("1234567890".getBytes())));

//		javax.ws.rs.core.Application app = new javax.ws.rs.core.Application() {
//		       public Set<Class<?>> getClasses() {
//		           Set<Class<?>> classes = new HashSet<Class<?>>();
//		           classes.add(MyCustomEntityProvider.class);
//		           return classes;
//		       }
//		};
//		clientConfig.applications(app);

//		org.apache.wink.client.RestClient client = new org.apache.wink.client.RestClient(clientConfig);
//
//		org.apache.wink.client.Resource resource = client.resource("https://postman-echo.com/post");
//
//		ClientResponse response = resource.contentType(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE).post("The request body as a string");
//		    
//		System.out.println("The response code is: " + response.getStatusCode());
//		System.out.println("The response message body is: " + response.getEntity(String.class));


//		ClientConfig clientConfig= new ClientConfig();
		clientConfig.connectTimeout(10000);
		clientConfig.readTimeout(10000);
//		clientConfig.handlers(new ClientHandler() {
//			
//			@Override
//			public ClientResponse handle(ClientRequest request, HandlerContext context) throws Exception {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		});
//		
//		RestClient client = new RestClient();
//		Resource resource = client.resource("https://postman-echo.com/post");
//		ClientResponse response =resource.contentType(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE).post("");
//		SpringApplication.run(DsAlgoApplication.class, args);
//		System.out.println("The response code is: " + response.getStatusCode());
//		System.out.println("The response message body is: " + response.getEntity(String.class));

//		removeLoopFromAList();
		
//		createCircularLinkedList();
//		createDoublyLinkList();
//		createStack();
//		infixToPostFix();
//		executePostfix();
//		reverseStack();
//		createTwoStack();
//		balanceParentheses();
//		sortStack();
		
//		getStockSpan();
//		spacialStack();
		
//		stackWithMiddile();
		
//		queueWithAraay();
		
		priorityQueue();		
		
	}

	private static void priorityQueue() {
		int [] queue = new int [15];
		
		int rear = 0;
		int front =-1;
		Random random = new Random();
		for(int i=0;i<15;i++) {
			int randomInt = random.nextInt(1000);
			front = enPriorityQueue(queue,front,randomInt);
			
		}	
		rear = deQueueAll(queue,front,rear);

	}

	private static int enPriorityQueue(int[] queue, int front, int randomInt) {
		int size = queue.length;
		System.out.println("queue element to be add "+ randomInt);

		if((front+1)<size) {
			queue[++front]=randomInt;
			swapBasedOnPriorityQueue(queue,front);
		}
		return front;

	}

	private static void swapBasedOnPriorityQueue(int[] queue, int front) {
		int temp = front;
		int priviouse= front-1;
		if(priviouse>=0) {
			while((queue[temp]%5)>(queue[priviouse]%5)) {
				swap(queue,temp,priviouse);
				temp--;
				priviouse--;
				if(priviouse<0)
					break;
			}
		}
		
	}

	private static void queueWithAraay() {
		int [] queue = new int [15];
		
		int rear = 0;
		int front =-1;
		Random random = new Random();
		for(int i=0;i<15;i++) {
			int randomInt = random.nextInt(1000);
			front = enQueue(queue,front,randomInt);
			
		}
		
		rear = deQueueAll(queue,front,rear);
	}

	private static int deQueueAll(int[] queue, int front, int rear) {
		while(rear<=front) {
			System.out.println("queue element to be removed "+queue[rear]);
			rear++;
		}
		return rear;
	}

	private static int enQueue(int[] queue, int front, int randomInt) {
		int size = queue.length;
		System.out.println("queue element to be add "+ randomInt);

		if((front+1)<size)
			queue[++front]=randomInt;
		return front;
	}

	private static void stackWithMiddile() {
		int top=0;
		int mid = 0;
		DoublyLinkedList stack = null;
		DoublyLinkedList middile = null;
		Random random = new Random();
		
		for(int i=0;i<50;i++) {
			int randomInt = random.nextInt(1000);
			if(randomInt%2==0) {
				if(stack==null) {
					stack= new DoublyLinkedList();
					stack.setNext(null);
					stack.setPriviouse(null);
					stack.setValue(randomInt);
					middile=stack;
					top++;
					mid++;
				}else {
					DoublyLinkedList  node = new DoublyLinkedList();
					node.setValue(randomInt);
					stack.setNext(node);
					node.setPriviouse(stack);
					stack=node;
					top++;
					int newMid = (top/2)+1;
					if(newMid > mid) {
						middile=middile.getNext();
						mid=newMid;
					}
				}
			}else {
				if(top<=0) {
					System.out.println("empty stack");
				}else {
					System.out.println("elemtnt At top"+stack.getValue());
					stack=stack.getPriviouse();
					if((stack!=null)) {
						stack.setNext(null);
						top--;
						int newMid = (top/2)+1;
						if(newMid < mid) {
							middile=middile.getPriviouse();
							mid=newMid;
						}
					}else {
						top=0;
						mid=0;
						middile=null;
					}
					
					
				}
			}
		if(stack!=null) {
			System.out.println(stack.getValue());
			System.out.println(middile.getValue());

		}
		
		}
	}

	private static void spacialStack() {
		int minStack [] = new int [20];
		int stack[]= new int [20];
		int top =-1;
		Random random = new Random();
		for(int i=0;i<122;i++) {
			int randomInt = random.nextInt(1000);
			int mod = randomInt%3;
			switch(mod) {
				case 0:
					if(top==20)
						System.out.println("stack is full");
					else {
						stack[++top] = randomInt;
						if(top==0 )
						{
							minStack[top]=randomInt;
						}else {
							if(minStack[top-1]>randomInt)
								minStack[top]=randomInt;
							else
								minStack[top]=minStack[top-1];

						}
					}
					break;
				case 1:
					if(top==-1) 
						System.out.println("stack is empty");
					else {
						stack[top]=0;
						minStack[top]=0;
						top--;
					}
					break;
				case 2:
					if(top==-1)
						System.out.println("stack is empty");
					else
						System.out.println("min "+ minStack[top]);

					
						
			}
		}
	}

	private static void getStockSpan() {
		
		int ar[]= {100,80,60,70,60,75,85};
		
		int size = ar.length;
		
		int stack []= new int[size];
		int top = -1;
		stack[++top]=1;
		int givenalue;
		int valueAtIndex;
		
		for(int i=1;i<size;i++) {
			givenalue = ar[i];
			++top;
			stack[top] = 1;

			int index = top-1;
			while(ar[index]<givenalue) {
				valueAtIndex = stack[index];
				index-=valueAtIndex;
				if(index<0)
					break;
			}
			if((index+1)!=top) {
				index++;
				stack[top] = top-index+1;
			}
			
			
		}
		for(int i=0;i<size;i++) {
			System.out.print(" "+ stack[i]);
		}
		
	}

	private static void sortStack() {
		int top =-1;
		int[] ar = new int [10];
		Random random = new Random();
		for(int i=0;i<9;i++) {
			int rand= random.nextInt(50);
			ar[++top] = rand;
		}
		sort(ar,top);
		System.out.println();
	}

	private static void sort(int[] ar, int top) {

		if(top>-1) {
			int min = top;
			for(int i=top;i>-1;i--) {
				if(ar[i]<ar[min]) 
					min=i;
			}
			if(min!=top) {
				swap(ar,top,min);
			}
			sort(ar,--top);
		}
	}

	private static void swap(int[] ar, int top, int min) {
		int temp = ar[top];
		ar[top]=ar[min];
		ar[min] = temp;
	}

	

	private static void balanceParentheses() {
		String parentheses ="[()]{}{}";
		
		char [] ar = new char[20];
		int top=-1;
		boolean flag = true;
		Map<String, String> map = new HashMap<String, String>();
		map.put("}", "{");
		map.put("]", "[");
		map.put(")", "(");
		
		for(int i=0;i<parentheses.length();i++) {
			String openingParentheses = map.get(parentheses.charAt(i)+"");
			if(openingParentheses==null) {
				ar[++top]=parentheses.charAt(i);
			}else {
				if(openingParentheses.charAt(0)!=ar[top]) {
					flag=false;
					break;
				}
				top--;
			}
		}
		if(flag&&top==-1)
			System.out.println("balanced");
		else
			System.out.println("unbalanced");

		
	}

	private static void createTwoStack() {
		int [] ar = new int[20];
		
		int top1=-1;
		int top2=20;
		
		for(int i=1;i<40;i++) {
			int mod = i%4;
			switch(mod) {
			   case 0:
				   top1=pushStack1(ar,top1,top2,i);
				   break;
			   case 1:
				   top2=pushStack2(ar,top1,top2,i);
				   break;
			   case 2: 
				   top1=popStack1(top1,ar);
				   break;
			   case 3 :
				   top2 = popStack2(top2,ar);
				   
				
			}
		}
	}

	private static int popStack2(int top2, int[] ar) {
			if(top2==20)
				System.out.println("stack is empty");
			else {
				System.out.println("stack 2 "+ar[top2]);
				top2++;
			}
		return top2;
	}

	private static int popStack1(int top1, int[] ar) {
		if(top1==-1)
			System.out.println("stack is empty");
		else {
			System.out.println("stack 1 "+ ar[top1]);
			top1--;
		}
		return top1;
	}

	private static int pushStack1(int[] ar, int top1, int top2, int i) {
			if((top1+1)==top2)
				System.out.println("stack is full");
			else
				ar[++top1]=i;
		return top1;
		
	}

	private static int pushStack2(int[] ar, int top1, int top2, int i) {
		if((top1+1)==top2)
			System.out.println("stack is full");
		else
			ar[--top2]=i;
		return top2;

	}

	private static void reverseStack() {
		
		int [] ar = new int[10];
		int top = -1;
		
		Random random = new Random();
		
		for(int i=0;i<10;i++) {
			int rand = random.nextInt(1000);
			top=push(ar,i,top);
		}
		
		ar = reverse(ar,top,top);
		System.out.println();
		
	}

	private static int[] reverse(int[] ar, int top, int size) {
		if(top>=0) {
			int element = ar[top];
			reverse(ar, top-1, size);
			
			ar[size-top] = element;
		}
		return ar;
	}

	private static void executePostfix() {
		String [] postfix = {"15","5","/","7","*","2","-"};
		String [] ar = new String[10];
		int top = -1;
		Map<String, Boolean> map= new HashMap<String, Boolean>();
		map.put("/", true);
		map.put("*", true);
		map.put("+", true);
		map.put("-", true);

		for(int i=0;i<postfix.length;i++) {
			
			if(map.get(postfix[i])==null) {
				ar[++top] = postfix[i];
			}else {
				int op2 = Integer.parseInt(ar[top]);
				ar[top]=null;
				top--;
				int op1 = Integer.parseInt(ar[top]);
				ar[top]=null;
				top--;
				int result=0;
				switch(postfix[i]) {
				
					case "*" :
						result = op1*op2;
						break;
					case "/" : 
						result = op1/op2;
						break;
					case "+" :
						result= op1+op2;
						break;
					case "-":
						result = op1-op2;
						
				}
				ar[++top]=result+"";

			}
			
		}
		System.out.println(ar[top]);

	}

	private static void infixToPostFix() {
		String [] ar = new String[10];
		int top = -1;
		
		
		String [] infix = {"A","+","B","-","C","+","D"};
		
		Map<String, Integer> priorty = new HashMap<String, Integer>();
		priorty.put("-", 1);
		priorty.put("+", 1);
		priorty.put("*", 2);
		priorty.put("/", 2);

		for(int i=0;i<infix.length;i++) {
			Integer prio = priorty.get(infix[i]);
			if(prio==null)
				System.out.print(infix[i]);
			else {
				if(top==-1)
				{
					top=push(ar, infix[i], top);
				}else if(priorty.get(ar[top])<priorty.get(infix[i])){
					top=push(ar, infix[i], top);

				}else{
						emptyTheStack(ar,top);
						top=-1;
						top=push(ar, infix[i], top);
					
				}
			}
		}
		emptyTheStack(ar,top);


		
	}
	
	private static void emptyTheStack(String[] ar, int top) {
		while(top!=-1) {
			System.out.print(ar[top]);
			ar[top] = null;
			top--;
			
		}
	}

	private static int pop(String[] ar, int top) {
		if(top==-1) 
			System.out.println("stack is empty");
		else {
			System.out.print( ar[top]);
			ar[top]=null;
			top--;

		}
		return top;		
	}

	private static int push(String[] ar, String rand, int top) {
		if(top==9) 
			System.out.println("stack is full");
		else
			ar[++top] = rand;
		return top;
	}


	private static void createStack() {
		 
		int [] ar = new int[10];
		int top = -1;
		
		
		Random random = new Random();
		
		for(int i=0;i<30;i++) {
			int rand = random.nextInt(1000);
			if(rand%2==0) {
				top=push(ar,rand,top);
			}else {
				pop(ar,rand,top);
			}
		}
	}

	private static int pop(int[] ar, int rand, int top) {
		if(top==-1) 
			System.out.println("stack is empty");
		else {
			System.out.println("element at top "+ ar[top]);
			top--;

		}
		return top;		
	}

	private static int push(int[] ar, int rand, int top) {
		if(top==9) 
			System.out.println("stack is full");
		else
			ar[++top] = rand;
		return top;
	}

	private static void createDoublyLinkList() {
		DoublyLinkedList head = null;
		Random random =new Random();
		int nodeToBeDelete = random.nextInt(10);

		for(int i=0;i<10;i++) {
			int rand = random.nextInt(10000);
			if(nodeToBeDelete== i ) {
				nodeToBeDelete = rand;
			}
			head = addNodeToSorteDoublyLinkedList(head,rand);
			
		}
		DoublyLinkedList temp =head;
		while(temp!=null) {
			System.out.println(" doubly linked list : "+temp.getValue());
			temp = temp.getNext();

		}
		
		temp =head;
		boolean found = false;
		while(temp!=null) {
			if(temp.getValue()== nodeToBeDelete) {
				found = true;
				System.out.println("value to be deleted : "+temp.getValue());
				break;
			}
			temp = temp.getNext();
		}
		if(found) {
			if(temp== head) {
				head=head.getNext();
				head.setPriviouse(null);
				temp=null;
			}else if(temp.getNext() == null ) {
				DoublyLinkedList parent = temp.getPriviouse();
				
				parent.setNext(null);
				temp.setPriviouse(null);
				
			}
			else {
				DoublyLinkedList parent = temp.getPriviouse();
				DoublyLinkedList child = temp.getNext();
				parent.setNext(child);
				child.setPriviouse(parent);
				temp=null;

			}
		}
		temp =head;

		while(temp!=null) {
			System.out.println(" doubly linked list after deletion: "+temp.getValue());
			temp = temp.getNext();

		}
		temp =head;
		DoublyLinkedList newHead = getTailOfDoublyLinkedList(temp);
		DoublyLinkedList newTail = newHead;
		DoublyLinkedList previouse = newHead.getPriviouse();

		while(previouse!=null)
		{
			DoublyLinkedList currentNode = previouse;
			previouse= previouse.getPriviouse();
			newTail.setNext(currentNode);
			currentNode.setPriviouse(newTail);
			currentNode.setNext(null);
			newTail=newTail.getNext();
			
		}
		
		temp =newHead;
		System.out.println();

		while(temp!=null) {

			System.out.println(" doubly linked list after revers: "+temp.getValue());
			temp = temp.getNext();

		}

	}

	private static DoublyLinkedList getTailOfDoublyLinkedList(DoublyLinkedList temp) {
		while(temp.getNext()!=null)
			temp=temp.getNext();
		return temp;
	}

	private static DoublyLinkedList addNodeToSorteDoublyLinkedList(DoublyLinkedList head, int rand) {
		DoublyLinkedList node = new DoublyLinkedList();
		
		node.setValue(rand);
		if(head==null) {
			head = node;
			head.setNext(null);
			head.setPriviouse(null);
		}else if(rand<head.getValue()) {
			node.setNext(head);
			head.setPriviouse(node);
			head = node;
			
		}else {
			DoublyLinkedList temp = head;
			while(temp.getNext()!=null) {
				if(rand> temp.getValue() && rand<temp.getNext().getValue()) {
					break;
				}
				temp = temp.getNext();
			}
			
			if(temp.getNext()!=null) {
				DoublyLinkedList child = temp.getNext();
				temp.setNext(node);
				node.setPriviouse(temp);
				node.setNext(child);
				child.setPriviouse(node);
			}else {
				temp.setNext(node);
				node.setPriviouse(temp);
				node.setNext(null);
			}
		}
		return head;
	}

	private static void createCircularLinkedList() {
		for(int i= 0;i<10;i++) {
			addNodeInCircularLinkedList(i);
		}
		travesrCircularLinkedList();
		createSortedLinked();
//		devideCircularLinkedList();

	}

	private static void createSortedLinked() {
		CircularLinkedList head = null;
		CircularLinkedList tail = null;

		Random random =new Random();

		for(int i= 0;i<10;i++) {
						
			int rand = random.nextInt(10000);
			tail = addSortedNode(head, tail, rand);
			head=tail.getNext();
			
		}
		traverseSortedNode(head);

	}

	private static void traverseSortedNode(CircularLinkedList head) {
		if(head!=null) {
			CircularLinkedList temp = head.getNext();
			System.out.println("sorted list "+head.getValue());

			while(temp!=head) {
				System.out.println("sorted list "+temp.getValue());
				temp=temp.getNext();
			}

		}
	}

	private static CircularLinkedList addSortedNode(CircularLinkedList head, CircularLinkedList tail, int rand) {
		if(head==null) {
			head = new CircularLinkedList();
			head.setValue(rand);
			tail = head;
			tail.setNext(head);
		}else {
			CircularLinkedList node = new CircularLinkedList();
			node.setValue(rand);
			if(rand<head.getValue()) 
			{
				node.setNext(head);
				head = node;
				tail.setNext(node);
			}else if(rand> tail.getValue()) {
				tail.setNext(node);
				tail=tail.getNext();
				tail.setNext(head);
				
			}else {
				CircularLinkedList temp = head;
				CircularLinkedList parent = getParentNodeOfCurentNode(temp,rand);
				CircularLinkedList child = parent.getNext();
				parent.setNext(node);
				node.setNext(child);
			}
		}
		return tail;
	}

	
	private static CircularLinkedList getParentNodeOfCurentNode(CircularLinkedList temp, int rand) {
		while(temp.getNext()!=temp) {
			if(rand> temp.getValue() && rand<= temp.getNext().getValue()) {
				break;
			}
			temp = temp.getNext();
		}
		return temp;
	}

	private static void devideCircularLinkedList() {
		DataStructure dataStructure = DataStructure.getDataStruture();
		CircularLinkedList head = dataStructure.getHeadCircularLinkedList();
		
		CircularLinkedList mid = getCircularLinkedListMid(head);
		
		CircularLinkedList head1 = head ;
		CircularLinkedList tail = mid;
		CircularLinkedList head2 = mid.getNext();
		CircularLinkedList tail2 = dataStructure.getTailCircularLinkedList();
		tail.setNext(head1);
		tail2.setNext(head2);
		CircularLinkedList tempHead1 = head1;
		
		CircularLinkedList tempHead2 = head2;
		while(tempHead1.getNext()!=head1) {
			System.out.println(tempHead1.getValue());
			tempHead1 = tempHead1.getNext();
		}
		System.out.println(tempHead1.getValue());

		while(tempHead2.getNext()!=head2) {
			System.out.println(tempHead2.getValue());
			tempHead2 = tempHead2.getNext();
		}
		System.out.println(tempHead2.getValue());

		
		
	}

	private static CircularLinkedList getCircularLinkedListMid(CircularLinkedList head) {
		CircularLinkedList slow = head;
		CircularLinkedList fast = head.getNext();
		
		while(fast!=head && fast.getNext()!=head) {
			slow=slow.getNext();
			fast=fast.getNext().getNext();
		}
		return slow;
	}

	private static void travesrCircularLinkedList() {
		
		DataStructure dataStructure = DataStructure.getDataStruture();
		CircularLinkedList head = dataStructure.getHeadCircularLinkedList();
		CircularLinkedList tempHead = head;
		while(tempHead.getNext()!=head) {
			System.out.println("value "+ tempHead.getValue());
			tempHead = tempHead.getNext();
		}
		System.out.println("value "+ tempHead.getValue());
	}

	private static void addNodeInCircularLinkedList(int value) {
		DataStructure dataStructure = DataStructure.getDataStruture();
		CircularLinkedList head = dataStructure.getHeadCircularLinkedList();
		if(head == null) {
			head = new CircularLinkedList();
			head.setValue(value);
			dataStructure.setHeadCircularLinkedList(head);
			dataStructure.setTailCircularLinkedList(head);
			head.setNext(head);
		}else {
			CircularLinkedList node = new CircularLinkedList();
			node.setValue(value);
			CircularLinkedList tail = dataStructure.getTailCircularLinkedList();
			
			tail.setNext(node);
			tail = tail.getNext();
			tail.setNext(dataStructure.getHeadCircularLinkedList());
			dataStructure.setTailCircularLinkedList(tail);
		}
	}

	private static void removeLoopFromAList() {
		
		LinkedList head = new LinkedList();
		head.setName("1");
		head.setNext(null);
		
		LinkedList tail = head;
		Random random = new Random();
		int randomInt = random.nextInt(9);
		LinkedList loop = null;
		for(int i=2;i<10;i++) {
			LinkedList node = new LinkedList();
			node.setName(""+i);
			node.setNext(null);
			tail.setNext(node);
			tail = node;
			if(randomInt == i) {
				loop=node;
			}
			
		}
		tail.setNext(loop);
		LinkedList tempHead = head;
		
		LinkedList joinNode = getJoinNode(tempHead);
		int loopCount = getLoopCount(joinNode);
		loopCount++;
		LinkedList first = head;
		LinkedList second= head;
		for(int i=0;i<loopCount;i++) {
			second = second.getNext();	
		}
		while(second.getNext()!=first) {
			second=second.getNext();
			first=first.getNext();
		}
		second.setNext(null);
		tempHead = head;
		while(tempHead!=null) {
			System.out.println(tempHead.getName());
			tempHead = tempHead.getNext();
		}

		
	}

	private static int getLoopCount(LinkedList joinNode) {
		LinkedList slow = joinNode;
		LinkedList fast = joinNode.getNext();
		int loopCount = 0;
		while(fast.getNext()!= slow) {
			fast = fast.getNext();
			loopCount++;
			
		}
		
		
		return loopCount;
	}

	private static LinkedList getJoinNode(LinkedList tempHead) {
		
		LinkedList slow = tempHead;
		LinkedList fast = tempHead.getNext();
		
		while(fast!=null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext(); 
			if(slow == fast){
				break;
			}
		}
		return slow;
	}

}
