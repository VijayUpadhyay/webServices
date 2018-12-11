package com.vijay.testSoapAnnotation;

import javax.jws.WebService;

@WebService(endpointInterface = "com.vijay.testSoapAnnotation.HelloWorld")
public class HelloWorldImpl implements HelloWorld{

	@Override
	public String getName(String name) {
		return "Hello "+name;
	}

}
