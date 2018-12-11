package com.vijay.soapHandlerClient;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class SoapHandlerInjectMacAddress implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		System.out.println("Client : handleFault()......");
		return true;
	}

	@Override
	public void close(MessageContext context) {
		System.out.println("Client : close()......");
	}

	@Override
	public boolean handleMessage(SOAPMessageContext context) {

		System.out.println("Client : handleMessage()......");
		Boolean isRequest = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if(isRequest){
			try{
			SOAPMessage soapmessage = context.getMessage();
			SOAPEnvelope soapEnvelop = soapmessage.getSOAPPart().getEnvelope();
			SOAPHeader header = soapmessage.getSOAPHeader();
			
			if(header == null)
				header = soapEnvelop.addHeader();
			
			String macAddres = getMacAddress();

			
			QName qName = new QName("http://handler.vijay.com/", "macAddress");
			SOAPHeaderElement headerEle = header.addHeaderElement(qName);
			
			headerEle.setActor(SOAPConstants.URI_SOAP_ACTOR_NEXT);
			headerEle.addTextNode(macAddres);
			soapmessage.saveChanges();
			
		}catch(SOAPException e){
			e.printStackTrace();
		}
		}
		return true;
	}

	@Override
	public Set<QName> getHeaders() {
		System.out.println("Client : getHeaders()......");
		return null;
	}
	
	private String getMacAddress(){
		
		InetAddress ip;
		StringBuilder sb = new StringBuilder();
		try{
			ip = InetAddress.getLocalHost();
			
			System.out.println("Current IP Address: "+ip.getHostAddress());
			
			NetworkInterface netInterface = NetworkInterface.getByInetAddress(ip);
			byte[] mac = netInterface.getHardwareAddress();
			
			System.out.println("Current MAC Address:");
			
			for(int i=0;i<mac.length; i++){
				sb.append(String.format("%02X%s", mac[i],(i< mac.length-1)? "-" : ""));
				
			}
			System.out.println(sb.toString());
		}catch (UnknownHostException e) {
			e.printStackTrace();
		}catch(SocketException s){
			s.printStackTrace();
		}
		
		return sb.toString();
	}
}
