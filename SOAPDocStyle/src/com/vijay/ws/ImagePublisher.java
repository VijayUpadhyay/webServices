package com.vijay.ws;

import javax.xml.ws.Endpoint;

public class ImagePublisher {

	public static void main(String[] args) {

		Endpoint.publish("http://localhost:6060/mtom", new ImageServerImpl());
		System.out.println("Service published");
	}

}
