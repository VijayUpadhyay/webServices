package com.vijay.wsClient;

import java.awt.Image;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import com.vijay.ws.ImageServer;

public class ImageClientUpload {

	public static void main(String[] args) throws Exception{

		URL url = new URL("http://localhost:6060/mtom?wsdl");
		QName qName = new QName("http://ws.vijay.com/", "ImageServerImplService");

		Service service = Service.create(url,qName);
		
		ImageServer imgServer = service.getPort(ImageServer.class);
		
		/////////////////////Upload
		Image img = ImageIO.read(new File("H:\\family.jpg"));
		
		//Enable MTOM in client
		BindingProvider bp = (BindingProvider)imgServer;
		SOAPBinding soapBimding  = (SOAPBinding) bp.getBinding();
		soapBimding.setMTOMEnabled(true);
		
		String status = imgServer.uploadImage(img);
		System.out.println("imageServer.uploadImage() : " + status);
	}

}
