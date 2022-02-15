package com.krishna.algorithm.DSAlgo;

import java.util.Random;

import org.apache.commons.codec.binary.Base64;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		createDoublyLinkList();
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
