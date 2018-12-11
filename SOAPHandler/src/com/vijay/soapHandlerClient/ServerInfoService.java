
package com.vijay.soapHandlerClient;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ServerInfoService", targetNamespace = "http://handler.vijay.com/", wsdlLocation = "http://localhost:6060/ws/serviceHandler?wsdl")
public class ServerInfoService
    extends Service
{

    private final static URL SERVERINFOSERVICE_WSDL_LOCATION;
    private final static WebServiceException SERVERINFOSERVICE_EXCEPTION;
    private final static QName SERVERINFOSERVICE_QNAME = new QName("http://handler.vijay.com/", "ServerInfoService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:6060/ws/serviceHandler?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SERVERINFOSERVICE_WSDL_LOCATION = url;
        SERVERINFOSERVICE_EXCEPTION = e;
    }

    public ServerInfoService() {
        super(__getWsdlLocation(), SERVERINFOSERVICE_QNAME);
    }

    public ServerInfoService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SERVERINFOSERVICE_QNAME, features);
    }

    public ServerInfoService(URL wsdlLocation) {
        super(wsdlLocation, SERVERINFOSERVICE_QNAME);
    }

    public ServerInfoService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SERVERINFOSERVICE_QNAME, features);
    }

    public ServerInfoService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServerInfoService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ServerInfo
     */
    @WebEndpoint(name = "ServerInfoPort")
    public ServerInfo getServerInfoPort() {
        return super.getPort(new QName("http://handler.vijay.com/", "ServerInfoPort"), ServerInfo.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServerInfo
     */
    @WebEndpoint(name = "ServerInfoPort")
    public ServerInfo getServerInfoPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://handler.vijay.com/", "ServerInfoPort"), ServerInfo.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SERVERINFOSERVICE_EXCEPTION!= null) {
            throw SERVERINFOSERVICE_EXCEPTION;
        }
        return SERVERINFOSERVICE_WSDL_LOCATION;
    }

}
