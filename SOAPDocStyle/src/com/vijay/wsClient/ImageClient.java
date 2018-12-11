package com.vijay.wsClient;

import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.vijay.ws.ImageServer;

public class ImageClient {

	public static void main(String[] args) throws MalformedURLException {

		URL url = new URL("http://localhost:6060/mtom?wsdl");
		QName qName = new QName("http://ws.vijay.com/", "ImageServerImplService");

		Service service = Service.create(url,qName);
		
		ImageServer imageServer = service.getPort(ImageServer.class);
		Image img = imageServer.downloadImage("family.jpg");
		
		// display it in frame
		JFrame jFrame = new JFrame();
		jFrame.setSize(800, 900);
		JLabel jLabel = new JLabel(new ImageIcon(img));
		jFrame.add(jLabel);
		jFrame.setVisible(true);
		
		System.out.println("imageServer.downloadImage() : Download Successful!");

	}

}
