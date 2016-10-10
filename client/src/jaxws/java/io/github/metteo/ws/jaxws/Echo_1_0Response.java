
package io.github.metteo.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "echo_1_0Response", namespace = "http://metteo.github.io/ws/user")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "echo_1_0Response", namespace = "http://metteo.github.io/ws/user")
public class Echo_1_0Response {

    @XmlElement(name = "return", namespace = "")
    private io.github.metteo.ws.Request_1_0 _return;

    /**
     * 
     * @return
     *     returns Request_1_0
     */
    public io.github.metteo.ws.Request_1_0 getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(io.github.metteo.ws.Request_1_0 _return) {
        this._return = _return;
    }

}
