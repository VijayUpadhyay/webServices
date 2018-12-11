package com.vijay.soapHandlerClient;

public class SoapHandlerClient {

	public static void main(String[] args) {
		
		ServerInfoService service = new ServerInfoService();
		ServerInfo info = service.getServerInfoPort();
		
		System.out.println(info.getName());

	}

}
