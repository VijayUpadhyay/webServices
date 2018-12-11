package com.vijay.ws;

import javax.xml.ws.Endpoint;

public class HelloWorldPublisher {

	public static void main(String[] args) {
		
		Endpoint endpoint = Endpoint.publish("http://localhost:6060/hello/docStyle",new HelloWorldImpl());
	}

}
