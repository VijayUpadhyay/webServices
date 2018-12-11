package com.vijay.handler;

import javax.xml.ws.Endpoint;

public class SOAPHandlerPublisher {

	public static void main(String[] args) {

		 Endpoint.publish("http://localhost:6060/ws/serviceHandler", new ServerInfo());
		   System.out.println("Service is published!");
	}

}
