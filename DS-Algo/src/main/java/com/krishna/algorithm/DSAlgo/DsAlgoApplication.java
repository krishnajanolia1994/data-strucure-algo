package com.krishna.algorithm.DSAlgo;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.krishna.algorithm.DSAlgo.model.CircularLinkedList;
import com.krishna.algorithm.DSAlgo.model.DataStructure;
import com.krishna.algorithm.DSAlgo.model.DoublyLinkedList;
import com.krishna.algorithm.DSAlgo.model.LinkedList;
import com.krishna.algorithm.DSAlgo.model.Tree;


@SpringBootApplication
public class DsAlgoApplication { 
	

	public static void main(String[] args) {
		
//		int [][] mat = new int [2][5];
//		
//		System.out.println(mat.length);
//		System.out.println(mat[0].length);
//
//		File file = new File("/home/ubuntu/myfolde");
//		Math.atan(-1/3);
//		System.out.println(Math.toDegrees(Math.atan2(0, -3)));
//		
//		//efficient way to multiply a number 
//		myltiplyBySaven(5);
//		isLucky(7);
//		addNumberOfBase16("12A","CD3");
//		
//		power(4,4);
//		
//		shafleAnArray(new int []{1,2,3,4,5,6,7,8});
//
//		file.mkdir();
		
//		createKeyStore();
//		pascalTriangle(7);
		
		
		
//		sieveOfEratostheneses
//		org.apache.wink.client.ClientConfig clientConfig = new org.apache.wink.client.ClientConfig();
		
		
//		Boolean b = false;
//		int k=10;
//		Map<String, Boolean> map = new HashMap<String, Boolean>();
//		System.out.println("b "+b);
//		System.out.println("b in map "+b);		double d= -1/2;

//
//		changeB(k,b,map);
//		System.out.println("b "+b);
//		System.out.println("b in map "+map.get("b"));
		
		

		
//		String b="b";
//		String c= a+b;
//		System.out.println(c.replaceAll(" ", ""));
//		 Base64 base64 = new Base64();
//	        System.out.println(new String(base64.encode("1234567890".getBytes())));

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
//		clientConfig.connectTimeout(10000);
//		clientConfig.readTimeout(10000);
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
		reverseStack();
//		createTwoStack();
//		balanceParentheses();
//		sortStack();
		
//		getStockSpan();
//		spacialStack();
		
//		stackWithMiddile();
		
//		queueWithAraay();
		
//		priorityQueue();	
//		printCombination();
		// bit algo
		findNonDuplicate();
//		checkOpositSign(-2,-5);

		
//		 rotatRight();
		 
//		 int []ar = new int [] {2,3,5,7,6,7,3,2};
//		 
//		 int result = 0;
//		 for(int i=0;i<ar.length;i++) {
//			 result^=ar[i]; 
//		 }
//		 
//		 for(int i=0;i<ar.length;i++) {
//			 if((result^ar[i])==result) {
//					System.out.println(ar[i]);
//
//			 }
//		 }
		
		Tree tree = new Tree();
		tree.setValue(10);
		
		Tree t1 = tree;
		Tree t2 = tree;
		if(t1==t2) {
			System.out.println("yes");

		}
		
		
		int n = swapLowAndHighBit();
		System.out.println(n);
		
		int a = 5;
		int b = 10;
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println(a);
		System.out.println(b);

	}

	private static int swapLowAndHighBit() {
		int i=1;
		
		int low=16384;
		int high=65536;
		int n=1073741824;
		int highBit,lowBit;
		for(i=0;i<15;i++) {
			highBit=n^high;
			lowBit=n^low;
			
			if((highBit!=0&&lowBit==0)||(highBit==0&&lowBit!=0)) {
				n=n^high;
				n=n^low;
			}
			high+=high;
			low/=2;
		}
		return n;
	}

	private static void rotatRight() {
		int i;
		i=1073741825;
			System.out.println(i>>1);
			if((i^1)<i)
			{
				i=(i>>1);
				i=i^1073741824;
				System.out.println(i);

			}
	}
	
	private static void checkOpositSign(int i, int j) {
		if((i^j)<0)
			System.out.println("true");
		else
			System.out.println("flase");

	}

	private static void findNonDuplicate() {
		int arr[] = {12, 3, 12, 1, 1, 2,2,2,5, 3} ;
		
		int finalResult = arr[0];
		int result=0;
		for(int i=1;i<arr.length;i++) {
			if(finalResult!=(finalResult^arr[i])) {
				finalResult^=arr[i];
			}else if(result!=(result^arr[i])) {
				result^=arr[i];
			}
		}
		finalResult^=result;

		
		System.out.println(finalResult);
	}

	private static void printCombination() {
		int [] ar = new int [] {1,2,3,4,5};
		int [] per= new int [3];
		
		printCombination(ar,per,0,0);
	}

	private static void printCombination(int[] ar, int[] per, int start, int current) {
		
		if(current==per.length)
			print(per);
		else for(int i=start;i<ar.length;i++) {
			per[current]= ar[i];
			current++;
			printCombination(ar, per, i+1, current);
			if(current>0)
				current--;
		}
		
	}

	private static void print(int[] per) {

		for(int i=0;i<per.length;i++)
			System.out.print(per[i]);
		System.out.println();
	}



	private static void pascalTriangle(int n) {
		int [][]ar = new int [n][n];
		int i,j;
		for(i=0;i<n;i++ ) {
			ar[i][0]=1;
			ar[i][i]=1;
		}
		
		for(i=2;i<n;i++) {
			for(j=1;j<i;j++) {
				ar[i][j]= ar[i-1][j-1]+ar[i-1][j];
				
			}
		}
		for(i=0;i<n;i++) {
			for(j=0;j<=i;j++) {
				System.out.print(ar[i][j]);
				System.out.print(" ");

			}
			System.out.println();

		}
	}












//	private static void createKeyStore() {
//		 KeySetManager keySetMgr = KeySetManager.getInstance();
//	        WSKeySet keySet = keySetMgr.getKeySet(KEY_SET_NAME);
//	        KeyReference[] allKeyReferences = keySet.getAllKeyReferences();
//	        for (int i = 0; i < allKeyReferences.length; ++i) {
//	            try {
//	                KeyReference kref = allKeyReferences[i];
//	                String keyAlias = kref.getKeyAlias();               
//	                if (!SIGNER_CERT_ALIAS.equals(keyAlias)) { continue; }
//	                WSKeyStore wsKeyStore = kref.getWSKeyStore();
//	                
//	                String location = wsKeyStore.getLocation();
//	                
//	                String type = wsKeyStore.getProperty("com.ibm.ssl.keyStoreType");
//	            
//	                String name = wsKeyStore.getProperty("com.ibm.ssl.keyStoreName");
//	                
//	                String provider = wsKeyStore.getProperty("com.ibm.ssl.keyStoreProvider");
//	            
//	                String password = wsKeyStore.getProperty("com.ibm.ssl.keyStorePassword");
//	                
//	                String scope = wsKeyStore.getProperty("com.ibm.ssl.keyStoreScope");
//	                
//	                KeyStore keyStore = KeyStoreManager.getInstance().getKeyStore(name, type, provider, location, password, scope, true, null);
//	                
//	                Certificate certificate = keyStore.getCertificate(keyAlias);
//	                
//	                PublicKey publicKey = certificate.getPublicKey();               
//
//	                return publicKey;
//	            } catch (Exception e) {
//	                e.printStackTrace();
//	            }
//	        }
//	        return null;
//	}

	private static void shafleAnArray(int[] ar) {
		int length = ar.length-1;
		Random random = new Random();
		int rand = 0;
		for(int i =0;i<length;i++ ) {
			rand = random.nextInt()%(length-i);
			if(rand<0)
				rand*=-1;
			swap(ar,rand,length-i);
		}
		
		for(int i =0;i<length;i++ ) {
			System.out.println(ar[i]);
		}
	}

	private static void power(int n, int m) {
		int result=n;
		int sum=0;
		for(int i=1;i<m;i++) {
			sum=0;
			for(int j=0;j<m;j++) {
				sum+=result;
			}
			result=sum;
		}
		
		System.out.println(result);
	}

	private static void addNumberOfBase16(String num1, String num2) {
		// A 65 B 66 C 67 D 68
		//A 10 B 11 C 12 D 13

		int length1=num1.length()-1;
		int length2=num2.length()-1;
		
		int cary=0;
		
		int op1=0;
		int op2=0;
		String result="";
		int temp=0;
		
		while(length1>=0||length2>=0) {
			op1=0;
			op2=0;
			if(length1>=0) {
				if(num1.charAt(length1)==65) {
					op1=10;
				}else if(num1.charAt(length1)==66) {
					op1=11;
				}else if(num1.charAt(length1)==67) {
					op1=12;
				}else if(num1.charAt(length1)==68) {
					op1=13;
				}else {
					op1= Integer.parseInt(num1.charAt(length1)+"");
				}
				length1--;
			}
				
			
			if(length2>=0) {
				if(num2.charAt(length2)==65) {
					op2=10;
				}else if(num2.charAt(length2)==66) {
					op2=11;
				}else if(num2.charAt(length2)==67) {
					op2=12;
				}else if(num2.charAt(length2)==68) {
					op2=13;
				}else {
					op2= Integer.parseInt(num2.charAt(length2)+"");
				}
				length2--;
			}
				
			
			temp=op1+op2+cary;
			if(temp<14) {
				cary=0;
				result =getHaxValue(temp)+ result;
			}else {
				cary=1;
				result =getHaxValue((temp-14))+ result;

			}
		}
		if(cary>0) {
			result =getHaxValue(cary)+ result;
			cary=0;

		}
		System.out.println(result);

		
	}

	private static String getHaxValue(int temp) {
		String haxValue = "";
		int value = temp;
		if(value<10) {
			haxValue+=value;
		}else if(value==10)
			haxValue+="A";
		else if(value==11)
			haxValue+="B";
		else if(value==12)
			haxValue+="C";
		else if(value==13)
			haxValue+="D";

		return haxValue;
	}

	private static void isLucky(int n) {
		boolean isLuckky = true;
		
		int index = n;
		int i=2;
		int priorNumber;
		while(i<index) {
			if(index%i==0)
			{
				isLuckky=false;
				break;
			}
			priorNumber=index-1;
			
			if(priorNumber>0) {
				
				index-=priorNumber/i;
				i++;
			}else {
				break;
			}
		}
		if(isLuckky)
			System.out.println("lucky");
	}

	private static void myltiplyBySaven(int i) {
		System.out.println((i<<3)-i);
	}

	private static void changeB(int k, Boolean b, Map<String, Boolean> map) {
		if(k>0) {
			if(k==5) {
				b=true;
				map.put("b", b);
			}
			changeB(k-1, b,map);
		}
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
		
		
		String [] infix = {"A","+","B","-","C","*","D"};
		
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
