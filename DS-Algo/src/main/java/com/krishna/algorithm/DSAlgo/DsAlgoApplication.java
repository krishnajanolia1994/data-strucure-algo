package com.krishna.algorithm.DSAlgo;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.MediaType;

import org.apache.commons.codec.binary.Base64;
import org.apache.wink.client.ClientConfig;
import org.apache.wink.client.ClientRequest;
import org.apache.wink.client.ClientResponse;
import org.apache.wink.client.Resource;
import org.apache.wink.client.RestClient;
import org.apache.wink.client.handlers.ClientHandler;
import org.apache.wink.client.handlers.HandlerContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.krishna.algorithm.DSAlgo.model.DataStructure;

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
		SpringApplication.run(DsAlgoApplication.class, args);
//		System.out.println("The response code is: " + response.getStatusCode());
//		System.out.println("The response message body is: " + response.getEntity(String.class));

		
		
	}

}
