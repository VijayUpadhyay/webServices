package com.vijay.wsClient.jaxws;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.vijay.ws.HelloWorld;
import com.vijay.ws.HelloWorldImpl;

public class HelloWorldClient {

	public static void main(String[] args) throws MalformedURLException {
		
		URL url = new URL("http://localhost:6060/hello/docStyle?wsdl");
		QName qName = new QName("http://ws.vijay.com/", "HelloWorldImplService");// targetNamespace, Service Name.
		
		Service service = Service.create(url, qName);
		
		HelloWorld hello = service.getPort(HelloWorld.class);
		
		System.out.println(hello.getName("vijay"));
		

	}

}
