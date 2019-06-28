package com.app.consumer;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.client.RestTemplate;

public class ClientTest {
	public static void main(String[] args) {
		String url="http://localhost:8085/SpringWebServiceProducerEx/book/";
		
		//Http Headers
		HttpHeaders headers=new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Accept", "application/xml");
		
		String json="{\"bookId\":9,\"bookCode\":\"Java\",\"bookAuthor\":\"Yogendra\",\"bookCost\":98.6}";
		
		HttpEntity<String> entity=new HttpEntity<String>(json,headers);
		
		RestTemplate rt=new RestTemplate();
		ResponseEntity<String> resp=rt.postForEntity(url+"data", entity, String.class);
		System.out.println(resp.getBody());
		System.out.println(resp.getStatusCodeValue());
		System.out.println(resp.getStatusCode().name());
		
		ResponseEntity<String> resp1=rt.getForEntity(url+"show", String.class);
		System.out.println("=========================================");
		System.out.println(resp1.getBody());
		System.out.println(resp1.getStatusCodeValue());
		System.out.println(resp1.getStatusCode().name());
		
	}
}
