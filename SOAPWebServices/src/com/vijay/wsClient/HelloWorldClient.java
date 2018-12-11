package com.vijay.wsClient;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.vijay.testSoapAnnotation.HelloWorld;

public class HelloWorldClient {
	
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:5050/ws/hello?wsdl");
		
		//1st argument service URI, refer to wsdl document above
		//2nd argument is service name, refer to wsdl document above
		//http://testSoapAnnotation.vijay.com/ -- targetNameSpace 
		//HelloWorldImplService --> serviceName
		QName qName = new QName("http://testSoapAnnotation.vijay.com/", "HelloWorldImplService");
		Service service = Service.create(url, qName);
		
		HelloWorld hello = service.getPort(HelloWorld.class);
		System.out.println(hello.getName("vijay"));
		
	}

}
