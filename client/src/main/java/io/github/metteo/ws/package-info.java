@XmlSchema(
	namespace = UserConstants.SCHEMA_NAMESPACE,
	
	xmlns = @XmlNs(
		namespaceURI = UserConstants.SCHEMA_NAMESPACE, 
		prefix = UserConstants.SCHEMA_PREFIX
	)
)
@XmlSchemaType(name = "string", type = Priority.class)
package io.github.metteo.ws;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.XmlSchemaType;
