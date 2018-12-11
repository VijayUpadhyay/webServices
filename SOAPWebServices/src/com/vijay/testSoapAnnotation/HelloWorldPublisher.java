package com.vijay.testSoapAnnotation;

import javax.xml.ws.Endpoint;

public class HelloWorldPublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:5050/ws/hello", new HelloWorldImpl());
		System.out.println("Service published");
	}

}
