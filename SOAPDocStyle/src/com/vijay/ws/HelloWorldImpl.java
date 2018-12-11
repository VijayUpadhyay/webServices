package com.vijay.ws;

import javax.jws.WebService;

@WebService(endpointInterface = "com.vijay.ws.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	@Override
	public String getName(String name) {
		return "Hello "+name+" !!";
	}

}
