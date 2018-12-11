package com.vijay.handler;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;

public class SoapHandler implements SOAPHandler<SOAPMessageContext>{
	
	@Override
	public boolean handleMessage(SOAPMessageContext arg0) {
		System.out.println("Server : handleMessage()......");
		Boolean isRequest = (Boolean) arg0.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		//for response message only, true for outbound messages, false for inbound
		if(!isRequest){
			
			try {
				SOAPMessage msg = arg0.getMessage();
				SOAPEnvelope envelop = msg.getSOAPPart().getEnvelope();
				SOAPHeader header = envelop.getHeader();
				
				if(header == null){
					header = envelop.addHeader();
					 generateSOAPErrMessage(msg, "No SOAP header.");
				}
				
				//Get client mac address from SOAP header
			     Iterator it = header.extractHeaderElements(SOAPConstants.URI_SOAP_ACTOR_NEXT);
				
			   //if no header block for next actor found? throw exception
			     if (it == null || !it.hasNext()){
			      	generateSOAPErrMessage(msg, "No header block for next actor.");
		             }
			     
			   //if no mac address found? throw exception
			     Node macNode = (Node) it.next();
			     String macValue = (macNode == null) ? null : macNode.getValue();

			      if (macValue == null){
			      	  generateSOAPErrMessage(msg, "No mac address in header block.");
			      }

			       //if mac address is not match, throw exception
			       if(!macValue.equals("3C-A0-67-DB-60-95")){
			       	   generateSOAPErrMessage(msg, "Invalid mac address, access is denied.");
			       }else{
			    	   System.out.println("Welcome Vijay!!");
			       }

			       //tracking
			       msg.writeTo(System.out);
				
			} catch (SOAPException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch(IOException e){
				System.err.println(e);
			}
			
			
		}
		return true;
	}


	@Override
	public void close(MessageContext arg0) {
		System.out.println("Server : close()......");		
	}

	@Override
	public boolean handleFault(SOAPMessageContext arg0) {
		System.out.println("Server : handleFault()......");
		return true;
	}

	
	@Override
	public Set<QName> getHeaders() {
		System.out.println("Server : getHeaders()......");
		return null;
	}

	// MAC Address validator

	private void generateSOAPErrMessage(SOAPMessage msg, String reason) {
	       try {
	          SOAPBody soapBody = msg.getSOAPPart().getEnvelope().getBody();
	          SOAPFault soapFault = soapBody.addFault();
	          soapFault.setFaultString(reason);
	          throw new SOAPFaultException(soapFault);
	       }
	       catch(SOAPException e) { }
	    }
	
}
