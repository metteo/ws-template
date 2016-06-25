package io.github.metteo.ws;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = UserService.SERVICE_NAME, targetNamespace = UserService.SCHEMA_NAMESPACE)
public class UserService extends Service {
	
	public static final String SCHEMA_NAMESPACE="http://metteo.github.io/ws/user";
	
	public static final String ENDPOINT_INTERFACE = "io.github.metteo.ws.UserEndpoint";
	
	public static final String PORT_NAME = "UserPort";
	public static final QName PORT_QNAME = new QName(SCHEMA_NAMESPACE, PORT_NAME);
	
	public static final String SERVICE_NAME = "UserService";
	public static final QName SERVICE_QNAME = new QName(SCHEMA_NAMESPACE,SERVICE_NAME);
	
	private static final URL WSDL_URL;
	
	static {
		Class<UserService> c = UserService.class;
		WSDL_URL = c.getClassLoader().getResource("META-INF/wsdl/" + c.getSimpleName() + ".wsdl");
	}
	
	public UserService() {
		this(WSDL_URL);
	}
	
	public UserService(URL wsdlUrl) {
		super(wsdlUrl, SERVICE_QNAME);
	}
	
	public UserService(URL wsdlUrl, WebServiceFeature[] features) {
		super(wsdlUrl, SERVICE_QNAME, features);
	}

    @WebEndpoint(name = PORT_NAME)
    public UserEndpoint getPort() {
        return super.getPort(PORT_QNAME, UserEndpoint.class);
    }
}
