package io.github.metteo.ws;

import java.net.URL;

import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

import static io.github.metteo.ws.UserConstants.*;

@WebServiceClient(name = UserConstants.SERVICE_NAME, targetNamespace = UserConstants.SCHEMA_NAMESPACE)
public class UserService extends Service {
	
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
    
    @WebEndpoint(name = PORT_NAME)
    public UserEndpoint getPort(WebServiceFeature... features) {
        return super.getPort(PORT_QNAME, UserEndpoint.class, features);
    }
    
    @WebEndpoint(name = PORT_NAME)
    public UserEndpointAsync getAsyncPort() {
        return super.getPort(PORT_QNAME, UserEndpointAsync.class);
    }
    
    @WebEndpoint(name = PORT_NAME)
    public UserEndpointAsync getAsyncPort(WebServiceFeature... features) {
        return super.getPort(PORT_QNAME, UserEndpointAsync.class, features);
    }
}
