package io.github.metteo.ws;

import javax.xml.namespace.QName;

public interface UserConstants {

	String SCHEMA_NAMESPACE = "http://metteo.github.io/ws/user";
	String SCHEMA_PREFIX = "usr";
	
	String ENDPOINT_INTERFACE = "io.github.metteo.ws.UserEndpoint";
	
	String PORT_NAME = "UserPort";
	QName PORT_QNAME = new QName(SCHEMA_NAMESPACE, PORT_NAME);
	
	String SERVICE_NAME = "UserService";
	QName SERVICE_QNAME = new QName(SCHEMA_NAMESPACE, SERVICE_NAME);

}
