
package io.github.metteo.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "echo_2_0", namespace = "http://metteo.github.io/ws/user")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "echo_2_0", namespace = "http://metteo.github.io/ws/user")
public class Echo_2_0 {

    @XmlElement(name = "request", namespace = "")
    private io.github.metteo.ws.Request_2_0 request;

    /**
     * 
     * @return
     *     returns Request_2_0
     */
    public io.github.metteo.ws.Request_2_0 getRequest() {
        return this.request;
    }

    /**
     * 
     * @param request
     *     the value for the request property
     */
    public void setRequest(io.github.metteo.ws.Request_2_0 request) {
        this.request = request;
    }

}
