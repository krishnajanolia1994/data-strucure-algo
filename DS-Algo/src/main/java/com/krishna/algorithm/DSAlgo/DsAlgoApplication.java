package com.krishna.algorithm.DSAlgo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.TimerTask;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.krishna.algorithm.DSAlgo.model.CircularLinkedList;
import com.krishna.algorithm.DSAlgo.model.DataStructure;
import com.krishna.algorithm.DSAlgo.model.DoublyLinkedList;
import com.krishna.algorithm.DSAlgo.model.LinkedList;
import com.krishna.algorithm.DSAlgo.model.LinkedList2;
import com.krishna.algorithm.DSAlgo.model.Tree;


@SpringBootApplication
class DsAlgoApplication extends SpringBootServletInitializer implements ApplicationRunner{ 
	
	private int x;
	
	
	

	 public DsAlgoApplication(int x) {
		super();
		this.x = x;
	}


	@Override
	   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		
		
		
		  Outer outer = new Outer(9); // First, create an instance of Outer class
	        Outer.Inner inner = outer.new Inner(); // Then, create Inner class object
	        inner.show();
	      return application.sources(DsAlgoApplication.class);
	      
	   }
	 
	 
	public static void main(String[] args) throws IOException {
		 designPattern();
//		remove();
//		
//		String str="jk";
//		String s=null;
//		
//		try {
//			str.charAt(10);
//		} catch (Exception e) {
//			e.addSuppressed(new NullPointerException());
//			e.printStackTrace();
//			// TODO: handle exception
//		}
//		
		
//		List<Integer> list = Arrays.asList(1,2,3,4,2,3,5,6);
//		Set<Integer> set=new HashSet<Integer>();
//		
//		list.stream().filter(num-> !set.add(num)).forEach(System.out::println);
		
//		java8();
//		java();
		
//		linkedList();
		//array();
		//string();
		
		//SpringApplication.run(DsAlgoApplication.class, args);

		/*String str= "bsdk7jhc,b";
		
		System.out.println(str.matches("[^1-9]+"));
		
		PriorityQueue<Integer> priorityQueue  = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		priorityQueue.add(1);
		priorityQueue.add(2);
		priorityQueue.add(3);
		priorityQueue.add(4);

		System.out.println(priorityQueue.poll());
		String name="krishna";
		name=revName(name,0);
		System.out.println(name);
		
		/*MyList l1=new MyList(1);
		MyList l2=new MyList(2);
		MyList l3=new MyList(3);
		MyList l4=new MyList(4);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		
		reverseLinkedList(l1);
		
		MyList head = l4;
		while(head!=null) {
			System.out.println(head.x);
			head=head.next;
		}
		
		int a=5;
		int b=10;
		
		a=a*b;
		
		b=a/b;
		
		a=a/b;
		
		System.out.println(a+" "+b);
		
		/*int []  = {4,2,5,3,6,3,7};
		
		int start =0;
		
		int end = ar.length-1;
		while(start<end) {
			swap(ar, start, end);
			start++;
			end--;
		}
		for(int i: ar)
			System.out.print(i+" ");
		
		ar = mergeSoart(ar,0,ar.length);
		
		long max=0;
		List<List<Integer>>  queries = new ArrayList<List<Integer>>();
		
		queries.add(Arrays.asList(1,2,100));
		queries.add(Arrays.asList(2,5,100));
		queries.add(Arrays.asList(3,4,100));

//	    int [] ar = new int [n];
	    Map<String, Integer> map = new HashMap<>();
	    boolean isOverlape;
	    String key;
	    String mapKey ;
	     queries= queries.stream().sorted((l1,l2)-> l1.get(0).compareTo(l2.get(0))).collect(Collectors.toList());
	    for(List<Integer> query : queries){
	        isOverlape  = false;
	        key = query.get(0)+"_"+query.get(1)+"";
	       
	        String[] indexes;
	        int i,j;
	        for(Map.Entry<String, Integer> entry : map.entrySet()){
	            System.err.println(entry.getKey()+" "+ entry.getValue());
	            mapKey= entry.getKey();
	            indexes= mapKey.split("_");
	            i=Integer.parseInt(indexes[0]);
	            j=Integer.parseInt(indexes[1]);
	            if(query.get(0)<j){
	                isOverlape= true;
	                
	                map.put(i+"_"+(query.get(0)),entry.getValue());
	                map.put(query.get(0)+"_"+j, entry.getValue()+query.get(2));
	                map.put((j+1)+"_"+(query.get(1)),query.get(2));
	                map.remove(mapKey);

	            }
	            
	            
	        }
	        if(!isOverlape){
	            map.put((query.get(0))+"_"+(query.get(1)),query.get(2));

	        }
	    }
	    
	    for(Map.Entry<String, Integer> entry : map.entrySet()){
	        if(entry.getValue()>max){
	            max=entry.getValue();
	        }
	        
	    }
	    
	    System.out.println(max);*/
		
//		String str="abc";
//		
//		permu(str.toCharArray(),0);
		
		/*printCombination();
		
		if(true||true)
			System.out.println("fdnjch");
		
		 PriorityQueue<Integer> pr = new PriorityQueue(Collections.reverseOrder());
		 
		 pr.add(1);
		 pr.add(10);
		 System.out.println(pr.poll()+" fdvb");
		
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
		//SpringApplication.run(DsAlgoApplication.class, args);
		//		System.out.println("The response code is: " + response.getStatusCode());
//		System.out.println("The response message body is: " + response.getEntity(String.class));

//		removeLoopFromAList();
		
//		createCircularLinkedList();
//		createDoublyLinkList();
//		createStack();
//		infixToPostFix();
//		executePostfix();
		//reverseStack();
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
		//findNonDuplicate();
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
		
		/*Tree tree = new Tree();
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
		System.out.println(b);*/

	}


	private static void designPattern() {
		
	}


	private static void remove() {
		// TODO Auto-generated method stub
		
		List<Integer> ar=new ArrayList<Integer>();
		ar.add(1);
		ar.add(2);
		ar.add(3);
		ar.add(4);
		ar.add(5);
		ar.add(7);
		ar.add(8);
		ar.add(9);
		ar.add(10);
		ar.add(11);
		
		Arrays.asList(1,2,3);
		
		new HashSet<Integer>();

		
		int k=3;
		int index=0;
		
		while((k+index-1)<ar.size()) {
			ar.remove(index+k-1);
			index+=k;
		}
		System.out.println(ar);
		
	}


	private static void CollectionFramwork() {
		
		iterator();
		List<Integer> list=new java.util.LinkedList<Integer>();
		list.add(null);
		
	 ArrayDeque<Integer> dq=new java.util.ArrayDeque<Integer>();
		list.add(null);
		
		list=new java.util.ArrayList<Integer>();
		list.add(null);
		Set<Integer> set=new HashSet<>();
		set.add(null);
		Set<Integer> sorted=new TreeSet<Integer>();
		sorted.add(null);
	}


	private static void iterator() {
		List<Integer> list=new java.util.ArrayList<Integer>();
		list.add(1);
		
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		Iterator<Integer> itr=list.iterator(); 
		while (itr.hasNext()) {
			if(itr.next()==4)
				itr.remove();
		}
		System.out.println(list);


	}


	private static void java() {
		ObjectInputStream o;
		thread();
//		valueOf();
		generic();
	}


	private static void thread() {
		Tree root=new Tree();
	}


	private static void generic() {
		show(5);
		
	}
	
	private static  <T>  void show(T value) {
		System.out.println(value);
	}


	private static void valueOf() {
		String val=String.valueOf(1);
		System.out.println(val);
	}


	private static void java8() {
		
		List<Integer> list=Arrays.asList(7,4,5,6,4,5,8,3,4,6,4,5,1);
		
		dropWhile(list);
		
//		collectAndThen(list);

		
//		toMap();
		
		
//		anyMatch();
		
//		reduce();
		
//		iterate();
		
//		flatMap1();
		
//		random();
//		methodReference();
//		CollectionFramwork();

		
//		logicalOr();
		
//		intLiteralWithUnderscore();
		
		
//		floatingPoint();
//		checkAlphabate();
//		converingArrayListIntoMap();
//		checkAlphabate();
		//remove element which do meet condition
//		removeElement();
//		parallelStrem();
//		flatMap();
//		arrayToStream();
//		streamToArray();
//		slice();
//		fingDuplicate();
//		countChar();
//		infiniteStream();
		
//        range();
        
//        mapStringToChar(); 
//		joining();
      
      
		
		
		
	}


	private static void dropWhile(List<Integer> list) {
		list.stream().dropWhile(a->(a%2)==0).forEach(System.out::println);
	}


	private static void collectAndThen(List<Integer> list) {
		list.stream().collect(Collectors.collectingAndThen(Collectors.toList(), list1->{
			Collections.reverse(list);
			return list.stream();}));
		}


	private static void toMap() {
		List<Integer> list=Arrays.asList(7,4,5,6,4,5,8,3,4,6,4,5,1);
		
		Map<Integer,Integer > map= list.stream().distinct().collect(Collectors.toMap(a->a*a, a->a+a));
		System.out.println(map);
		

	}


	private static void reduce() {
		
		List<Integer> list=Arrays.asList(7,4,5,6,4,5,8,3,4,6,4,5,1);
		
		Optional<Integer> max=list.stream().reduce((a,b)-> a>b?a:b);
		
		System.out.println(max.get());
		
	}
	
	private static void anyMatch() {
		
		List<Integer> list=Arrays.asList(7,4,5,6,4,5,8,3,4,6,4,5,1);
		
		boolean match=list.stream().anyMatch(a-> (a/7==1));
		
		System.out.println(match);
		
	}


	private static void iterate() {
		Stream.iterate(1, a-> a+a).limit(100).forEach(System.out::println);
	}


	private static void flatMap1() {
		List<String> sentences = Arrays.asList(
	            "Java is awesome",
	            "FlatMap helps in transformation",
	            "Streams make life easier"
	        );

	        // Using flatMap to transform and flatten
	        List<String[]> words = sentences.stream()
	            .map(sentence -> sentence.split(" ")) // Transform: Split sentence into words
//	            .flatMap(Arrays::stream) // Flatten: Convert Stream<String[]> to Stream<String>
	            .collect(Collectors.toList());

	        System.out.println(words);
	}
	
	public static void use(MethodRefeence ref,String name) {
		ref.print(name);
	}


	private static void methodReference() {
		
		use(System.out::println,"krishna");
	}


	private static void random() {
		Random ran= new Random(1);
		for(int i=0;i<1000;i++)
			System.out.println(ran.nextInt());
		TimerTask t;
	}


	private static void logicalOr() {
		int a=1;
		int b=2;
		
	}
	
	public static  <T>  void get(T valus) {
		System.out.println(valus);
		Set<Integer> set=new HashSet<Integer>();
	}
	


	private static void intLiteralWithUnderscore() {
		int x = 123_456_789;
		System.out.println("value of x "+x);
		
	
	}


	private static void floatingPoint() {
		float f=1.2f;
		double d=1.22;
	}


	private static void joining() {
		String str =IntStream.range(0, 1000).mapToObj(p-> new String(p+"")).collect(Collectors.joining());
		System.out.println(str);
	}


	private static void mapStringToChar() {
		String s = "Java";
        
        // Convert String to List of Characters using Streams
        List<Character> ch = s.chars() // Convert String to IntStream (stream of chars)
                               .mapToObj(c -> (char) c) // Map each int (char) to Character
                               .collect(Collectors.toList()); // Collect into a List

        System.out.println(ch);
	}


	private static void range() {
		String[] array = { "G", "e", "e", "k", "s" }; 

        List<String>list= IntStream.range(0, array.length).mapToObj(index->array[index]).collect(Collectors.toList());
        System.out.println(list);
	}


	private static void infiniteStream() {
		DoubleStream.iterate(0, i->i<100, i->i+1).forEach(System.out::println);
	}


	private static void countChar() {
		System.out.println("abbcsdhoudbkxksdgvcbadasbdxscbdxberfberfersfb".chars().filter(p->p=='b').count());
	}


	private static void fingDuplicate() {
		
		Set<Integer> set = new HashSet<Integer>();
		 Stream<Integer> stream = Stream.of(1, 2,2, 3, 4, 5,1); 
		 stream.filter(p->!set.add(p)).forEach(System.out::println);

	}


	private static void slice() {
		 Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5); 
		 stream.skip(1).limit(2-1+1).forEach(System.out::println);

	}


	private static void streamToArray() {
		 Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5); 
		 Integer[] arr=stream.collect(Collectors.toList()).toArray( new Integer  [0]);
		 
	}


	private static void arrayToStream() {
		int [] array = {1,2,3,4};
		Arrays.stream(array).filter(p->(p%2)==0).forEach(System.out::println);
		
		
	}


	private static void flatMap() {
		
		List<List<Integer>> list=Arrays.asList(Arrays.asList(1,5,3),Arrays.asList(7,5,9),Arrays.asList(6,4,10),Arrays.asList(8));
		list.stream().flatMap(p->p.stream().map(q->q*q*q)).forEach(System.out::println);
		
		
		
	}


	private static void parallelStrem() {
		List<String> names = Arrays.asList("krishna","janoliya","is","good","boy");
		names.parallelStream().forEach(System.out::println);
	}


	private static void removeElement() {
		List<String> names = Arrays.asList("krishna","janoliya","is","good","boy");
		names.stream().filter(str->!(str.length()==3)).collect(Collectors.toList()).forEach(str->System.out.println(str));
	}


	private static void converingArrayListIntoMap() {
		List<String> names = Arrays.asList("krishna","janoliya","is","good","boy");
		Map<String, Integer> nameMap=  names.stream().collect(Collectors.toMap(name->name, name->name.length()));
		
		System.out.println(nameMap);
	}


	private static void checkAlphabate() {
		String name="krishna";
		if(name.chars().allMatch(Character::isAlphabetic)) {
			System.out.println("all alphabate");
		}
	}


	private static void linkedList() {
		//reverseLinkedList();
		flat();
		

		
	}


	private static void flat() {
		// TODO Auto-generated method stub
		LinkedList2 l5 = new LinkedList2();
		l5.setName(5);
		LinkedList2 l10 = new LinkedList2();
		l10.setName(10);
		LinkedList2 l19 = new LinkedList2();
		l19.setName(19);
		LinkedList2 l28 = new LinkedList2();
		l28.setName(28);
		LinkedList2 l7 = new LinkedList2();
		l7.setName(7);
		LinkedList2 l8 = new LinkedList2();
		l8.setName(8);

		LinkedList2 l30 = new LinkedList2();
		l30.setName(30);
		LinkedList2 l20 = new LinkedList2();
		l20.setName(20);

		LinkedList2 l22 = new LinkedList2();
		l22.setName(22);
		LinkedList2 l50 = new LinkedList2();
		l50.setName(50);
		LinkedList2 l35 = new LinkedList2();
		l35.setName(35);
		LinkedList2 l40 = new LinkedList2();
		l40.setName(40);
		
		
		l5.setNext(l10);
		l10.setNext(l19);
		l19.setNext(l28);
		
		l7.setNext(l8);
		l8.setNext(l30);
		l5.setBottom(l7);
		
		l10.setBottom(l20);
		
		l22.setNext(l50);
		l19.setBottom(l22);

		l35.setNext(l40);
		l28.setBottom(l35);
		
		System.out.println("");
		
        java.util.PriorityQueue<LinkedList2> pr=
        		new java.util.PriorityQueue<>((a,b)->a.getName()-b.getName());

		
        LinkedList2 temp=l5;
        LinkedList2 bottom=null;
        while(temp!=null){
            if(temp.getBottom()!=null){
                bottom=temp.getBottom();
                pr.add(bottom);
                temp.setBottom(null);
            }
            temp=temp.getNext();

        }
        pr.add(l5);
        
        LinkedList2 head=null;
        LinkedList2 tail=null;
        LinkedList2 node=null;
        LinkedList2 next=null;
        while(pr.size()>0){
            node=pr.remove();

            next=node.getNext();
            if(next!=null){
                pr.add(next);
            }
            node.setNext(null);
            if(head==null){
                head=node;
                tail=node;
            }else{
                tail.setBottom(node);
                tail=tail.getBottom();
            }
        }
        
        while(head!=null) {
        	System.out.println(head.getName());
        	head=head.getBottom();
        }
        

		
	}


	private static void reverseLinkedList() {
		LinkedList head = new LinkedList();
		head.setName("1");
		LinkedList l2 = new LinkedList();
		l2.setName("2");
		LinkedList l3 = new LinkedList();
		l3.setName("3");
		LinkedList l4 = new LinkedList();
		l4.setName("4");
		LinkedList l5 = new LinkedList();
		l5.setName("5");
		LinkedList l6 = new LinkedList();
		l6.setName("6");
		
		head.setNext(l2);
		l2.setNext(l3);
		l3.setNext(l4);
		l4.setNext(l5);
		l5.setNext(l6);
		
		LinkedList next=head.getNext();
		head.setNext(null);
		LinkedList nextnext=null;

		while(next!=null) {
			nextnext=next.getNext();
			next.setNext(head);
			head=next;
			next=nextnext;
			
		}
		System.out.println("");
		
	}


	private static void string() {
		// TODO Auto-generated method stubS
		removeDupRecursively();
		

	}


	private static void removeDupRecursively() {
		String s = "acaaabbbacdddd";
		int i = 0;
		while (s.length() > 0 && i < s.length() - 1) {
			int j = i + 1;
			if (s.charAt(i) == s.charAt(i + 1)) {
				System.out.println(s + " 34");
				for (j = i + 1; j < s.length(); j++)
					if (!(s.charAt(i) == s.charAt(j)))
						break;
				s = s.replace(s.substring(i, j), "");
				if(i!=0)
					i--;


			}else {
				i++;
			}
		}

		System.out.println(s);
	}
	
	static String  rem(String s,int start){
        for(int i=start;i<s.length()-1;i++){
            int j=i+1;
            if(s.charAt(i)==s.charAt(i+1)){
                System.out.println(s+" 34");
                for(j=i+1;j<s.length();j++)
                    if(!(s.charAt(i)==s.charAt(j)))
                        break;
                s=s.replace(s.substring(i,j),"");
               
                    rem(s,0);
                    
            }
        }
        return s;
    }


	private static void array() {
		getInversion();
		tappingOfWater();
		stockExchange();
	}

	private static void stockExchange() {
		int n = 7;
		int A[] = {100,180,260,310,40,535,695};
		ArrayList<ArrayList<Integer> > result=new ArrayList<ArrayList<Integer>>();
		int maxIndexArray []=new int [n];
		maxIndexArray[n-1]=n-1;
		
		for(int i=n-2;i>=0;i--) {
			if(A[i]<A[i+1]) {
				maxIndexArray[i]=maxIndexArray[i+1];
			}else {
				maxIndexArray[i]=i;
			}
		}
		int i=0;
		ArrayList<Integer> list;
		while(i<n-1) {
			if(A[i]<A[i+1]) {
				list=new ArrayList<Integer>();
				list.add(i);
				list.add(maxIndexArray[i]);
				result.add(list);
				i=maxIndexArray[i];
			}else {
				i++;
			}
		}
		
		 List<String>list1  = new ArrayList<>();
	        
	       
	        
	         list1= list1.stream().sorted((a,b)->a.compareTo(b)).
	        collect(Collectors.toList());
		
	}


	private static void tappingOfWater() {
		int arr[] = {3,0,0,2,0,4};
		int n=6;
		java.util.LinkedList<Integer> stack = new java.util.LinkedList<>();
		
		int nge[]=new int [6];
		
		for(int i=0;i<arr.length;i++) {
			if(stack.size()==0)
				stack.addFirst(i);
			else {
				if(arr[i]>stack.peekFirst()) {
					nge[stack.removeFirst()]=i;
					
				}
			}
		}
		
	}


	//need to be correct 
	
	private static void getInversion() {
		AtomicLong count= new AtomicLong(0);
		
		int n = 8;
		int arr[] = {57, 38, 91, 10, 38 ,28, 79, 41};
		
		mergeSort(arr,0,n-1,count);
		System.out.println(count.get());
	}


	private static void mergeSort(int[] arr, int start, int end, AtomicLong count) {
		if(start<end) {
			int mid=(start+end)/2;
			mergeSort(arr, start, mid, count);
			mergeSort(arr, mid+1, end, count);
			merge(arr,start,mid,end,count);

		}
	}


	private static void merge(int[] arr, int start, int mid, int end, AtomicLong count) {		
		int [] a1=new int [mid-start+1];
		int [] a2=new int [end-mid];
		int index=0;
		for(int i=start;i<=mid;i++) {
			a1[index]=arr[i];
			index++;
		}
		index=0;
		for(int i=mid+1;i<=end;i++) {
			a2[index]=arr[i];
			index++;
		}
		int a1Index=0;
		int a2Index=0;
		index=start;
		while(a1Index<a1.length&&a2Index<a2.length) {
			if(a1[a1Index]<a2[a2Index]) {
				arr[index] = a1[a1Index];
				a1Index++;
			}else {
				if(a1[a1Index]!=a2[a2Index])
					count.addAndGet(a1.length-a1Index);
				arr[index] = a2[a2Index];
				a2Index++;
			}
			index++;
			
		}
		while(a1Index<a1.length) {
			arr[index] = a1[a1Index];
			a1Index++;
			index++;
		}
		
		while(a2Index<a2.length) {
			arr[index] = a2[a2Index];
			a2Index++;
			index++;
		}
	}


	private static String revName(String name,int index) {
		
		if(index==name.length()-1) {
			return name.charAt(index)+"";
		}
		
		String next = revName(name, index+1);
		
		return next+name.charAt(index);
	}

	private static MyList reverseLinkedList(MyList l) {
		if(l.next==null) {
			return l;
		}
		
		MyList next = reverseLinkedList(l.next);
		next.next=l;
		l.next=null;
		
		return l;
	}

	private static int[] mergeSoart(int[] ar, int start, int end) {
		if(start<end) {
			
		}
		
		
		return null;
	}

	private static void permu(char[] charArray, int i) {
		if(i==charArray.length-1) {
			System.out.println(new String(charArray));
		}else {
			for(int j=i;j<charArray.length;j++) {
				swap(charArray,i,j);
				permu(charArray, i+1);
				swap(charArray,i,j);

			}
		}
	}

	private static void swap(char[] charArray, int i, int j) {
		char temp=charArray[i];
		charArray[i]=charArray[j];
		charArray[j]=temp;
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
		int [] per= new int [5];
		
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


	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
