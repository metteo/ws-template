@XmlSchema(
	namespace = UserService.SCHEMA_NAMESPACE,
	
	xmlns = @XmlNs(
		namespaceURI = UserService.SCHEMA_NAMESPACE, 
		prefix = UserService.SCHEMA_PREFIX
	)
)
package io.github.metteo.ws;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlSchema;
