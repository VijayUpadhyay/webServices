package com.vijay.webapp;

import javax.jws.WebService;

@WebService(endpointInterface="com.vijay.webapp.HelloWorld")
public class HelloworldImpl implements HelloWorld{

	@Override
	public int num() {
		// TODO Auto-generated method stub
		return 10;
	}

}
