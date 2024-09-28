package com.example.acurator;

import java.awt.Choice;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.NavigableSet;
import java.util.RandomAccess;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AcuratorApplication implements Callable<Integer>{
	
	
	

	

	public static void main(String[] args) {
		
		
		ExecutorService ex;
		
		Collections c;
		
		Vector<Integer> v;
		
		
		Set<String> treeset = new TreeSet<String>(Collections.reverseOrder());
		
		treeset.add("xz");
		treeset.add("bq");
		treeset.add("ad");
		treeset.add("ab");
		treeset.add("aa");
		
		for(String str: treeset) {
			System.out.println(str);
		}
		rendomAccess();
		
		
		new HashMap<Integer, Integer>();
		
		stream();
		date();
		
		List<Integer> li = Arrays.asList(12,13,14,15);
		
		li.stream().skip(0).limit(2).forEach(val->System.out.println(val));
		
		Consumer<List<Integer>> con = (values)-> {for(int i=0;i<values.size();i++)
			values.set(i, values.get(i)*2);
		};
		
		Consumer<List<Integer>> print=(values)-> {
			for(int val:values) {
				System.out.println(val);
			}
		};
		
		con.accept(li);
		
		con.andThen(print).accept(li);
		
		Vector a = new Vector(1);
        Vector b = new Vector(1);
        Vector c1 = new Vector(1);
		
		MyClone cl=new MyClone(10);
		
		MyClone cl1=cl.clone();
		
		cl1.setA(20);
		
		System.out.println(cl.getA());
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        
        for(int v1: list) {
        	if(list.size()==5) {
        		list.remove(4);
        	}
        	System.out.println(v1);
        }

		
		Set<Integer> set = new HashSet<Integer>();
		
		Set<Integer> set1 = new LinkedHashSet<Integer>();

		
		int[] Arr = {1, 2, 4, 8};
		int[] temArr = Arrays.copyOfRange(Arr, 1, Arr.length-1);
		
		for(int val: temArr)
			System.out.println(val);
		
		UUID id = UUID.randomUUID();

		System.out.println(id.toString()+2);
		//unicode();
		
		/*Comparable<Integer> c;
		Comparator<Integer> c1;
		
		  Optional<String> emptyOptional = Optional.empty();
	        try {
	            emptyOptional.orElseThrow(); // Throws NoSuchElementException
	        } catch (NoSuchElementException e) {
	            System.out.println("Exception caught: " + e);
	        }
		var x=10;
		LocalDate localDate=LocalDate.now();
		
		
		localDate.compareTo(LocalDate.now());
		
		localDate.isAfter(LocalDate.now());
		
		LocalTime localTime= LocalTime.now();
		
		LocalDateTime localDateTime = LocalDateTime.now();
		
		System.out.println(localDate+" | "+localTime+" | "+localDateTime);
		
		localDateTime.minus(Duration.ofMillis(10000));
		
		localDateTime.get(ChronoField.YEAR);
		
		
		Stream.iterate(0, i->(i<100),i->i+1 ).forEach(i -> System.out.println(i) );
		
		List<Integer> lis=new ArrayList<Integer>();
		
		Stream<Double> stream 
        = Stream.iterate(2.0, 
                         decimal -> decimal > 0.25 , decimal -> decimal / 2); 
		stream.collect(Collectors.toList());
    // print Values 
    stream.forEach(System.out::println); 
		
		
		Stream<String> stream1 = Stream.of("Geeks", "for"); 
        Stream<String> stream2 = Stream.of("GeeksQuiz", "GeeksforGeeks"); 
  
        // concatenating both the Streams 
        // with Stream.concat() function 
        // and displaying the result 
        Stream.concat(stream1, stream2) 
            .forEach(element -> System.out.println(element)); 
		
		//DoubleStream 
		  
        // Iterate the DoubleStream with i 
        // by incrementing the value with 1 
        //.iterate(0, i -> i + 1) 

        // Print the DoubleStream 
        // using forEach() method. 
        //.forEach(System.out::println); 
		
		List<Integer> numbers = Arrays.asList(1, 2,100, 3, 4, 5);
		
		
		int[] ar = numbers.stream().mapToInt(a->a).toArray();

        Optional<Integer> sum = numbers.stream().reduce((a, b) -> {
        	int max=a;
        	if(b>max)
        		max=b;
        	return max;
        });
        
        sum.ifPresent(System.out::println);
        
        System.out.println(sum.get());
        
        
		int Integer=3;
		
		
        Integer k=100000;
        
        byte  by=  k.byteValue();
        
        System.out.println(by);
        
        System.out.println(k%127);

		
		byte b=120;
		
		long s;
		s=b;
		System.out.println(s);
		
		Consumer<Integer> con= j-> System.out.println(j*j);
		
		Consumer<Integer> then= j-> System.out.println("hi "+j);
		con.andThen(then).accept(5);
		
		//Function<Integer, Integer> fun= k-> k*k;
		//Function<String, Integer> after= (String k)-> Integer.parseInt(k+10);
		
	//	Function res=fun.compose(after);
//		System.out.println(res);
		
		
		
		
		

		
		System.out.println();
		//SpringApplication.run(AcuratorApplication.class, args);*/
	}

	private static void rendomAccess() {
		ArrayList<Integer> myli = new ArrayList<Integer>();
		if(myli instanceof RandomAccess)
			System.out.println("yes");
	}

	private static void stream() {
		
		Vector<Integer> v = new Vector<Integer>();
		
		List<Integer> list11= new ArrayList<Integer>();
		
		list11=Collections.checkedList(list11, Integer.class);
		list11.add(1);
		
		heighrversion();
		
		DoubleStream.iterate(0, i-> i<10, i->(i+1))
		.forEach(System.out::println);
		
		//unmodifiableList();
    
		mapToObj();// this method also contain slice
		
		
	}

	private static void heighrversion() {
		String s  = """
			hi
			i am kris
			""";
					
		System.out.println(s);
		
		httpClient();
		String str="ha".repeat(4);
		System.out.println(str);
	}

	private static void httpClient() {
		HttpClient client = HttpClient.newHttpClient();
	        HttpRequest request;
			try {
				request = HttpRequest.newBuilder()
				        .uri(new URI("https://www.example.com"))
				        .GET()
				        .build();
				MyClone clone = new MyClone(10);
				
				BodyPublisher bodyPublishers = BodyPublishers.ofString(""); 
				HttpRequest.newBuilder()
		        .uri(new URI("https://www.example.com"))
		        .POST(bodyPublishers)
		        .build();
				
				try {
			        HttpResponse<String> response;

					response = client.send(request, HttpResponse.BodyHandlers.ofString());

			        System.out.println(response.statusCode());
			        System.out.println(response.body());
				} catch (IOException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	private static void mapToObj() {
		DoubleStream temperatures = DoubleStream.of(36.5, 37.0, 38.2, 39.4);
		
		Thread t = Thread.currentThread();
		t.getState();

        // Convert the double values to a Stream of Strings with a "°C" suffix
		int start=1;
        Stream<Object> temperatureStrings = temperatures.skip(start).
        		limit((2)<(4-start)?(2):(4-start)).mapToObj(temp -> temp + "°C");

        // Print the resulting Stream of Strings
        temperatureStrings.forEach(System.out::println);
	}

	private static void unmodifiableList() {
		var unmodifiableList
        = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
              .collect(Collectors.collectingAndThen(
                  Collectors.toList(),
                  Collections::unmodifiableList));

		System.out.println(unmodifiableList);

		// Operations like this will result in an exception
		unmodifiableList.add(12);
	}

	private static void date() {
		
		LocalTime time  = LocalTime.now();
		LocalTime max = LocalTime.MAX;
		LocalTime mid = LocalTime.MIDNIGHT;
		LocalTime noon = LocalTime.NOON;
		LocalTime min = LocalTime.MIN;

		
		System.out.println(max+ " "+ mid+ " " + noon+" "+min+ " "+time);
		
		time.plus(Duration.ofMinutes(30));
		time.plus(33, ChronoUnit.MINUTES);
		time.isAfter(min);
		time.isBefore(min);
		
		time.minus(20, ChronoUnit.MINUTES);
		time.minusMinutes(2);
		
		LocalDate maxdate= LocalDate.MAX;
		LocalDate mindate= LocalDate.MIN;
		LocalDate date= LocalDate.now();
		
		date.minus(2, ChronoUnit.DAYS);
		date.plus(3, ChronoUnit.DAYS);
		date.getMonthValue();
		date.isAfter(date);
		date.isBefore(date);
		date.isEqual(date);

		System.out.println(maxdate+ " "+ mindate+ " "+ date);
		
		
		
		LocalDateTime d = LocalDateTime.now();
//		LocalDateTime.of(0, 0, 0, 0, 0);
		d.plus(1, ChronoUnit.DAYS);
		d.minusDays(1);
		d.minus(1, ChronoUnit.DAYS);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		d.isAfter(d);
		d.isBefore(d);
		d.isEqual(d);
		String formatedDate =d.format(formatter);
		
		System.out.println(formatedDate);
		
		System.out.println();
	}

	private static void unicode() {
		// TODO Auto-generated method stub
		
		int start = 0x0000; // Start of Unicode
        int end = 0x10FFFF; // End of Unicode (in Unicode 13.0, the maximum code point is 0x10FFFF)

        // Create a StringBuilder to store the characters
        StringBuilder unicodeString = new StringBuilder();

        // Iterate over the range and append characters to the StringBuilder
        for (int i = start; i <= end; i++) {
            if (Character.isDefined(i) && !Character.isISOControl(i)) {
                unicodeString.append(Character.toChars(i));
                
                if(unicodeString.length()>4000) {
                    System.out.println(unicodeString.toString()+"end");
                    unicodeString = new StringBuilder();
                }
                // Limit output for demonstration purposes
                
            }
        }

        // Print the resulting string
		
	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

}
