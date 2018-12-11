package com.vijay.ws;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.MTOM;

@MTOM
@WebService(endpointInterface = "com.vijay.ws.ImageServer")
public class ImageServerImpl implements ImageServer {

	@Override
	public Image downloadImage(String name) {
		
		try{
			File file = new File("H:\\"+name);
			return ImageIO.read(file);
			
		}catch(IOException e){
			e.printStackTrace();
			return null;
		}
			
		
	}

	@Override
	public String uploadImage(Image data) {
		
		if(data != null)
			return "Upload successful";
		
		throw new WebServiceException("Upload failed!!");
	}

	
}
