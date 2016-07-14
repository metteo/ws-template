
package io.github.metteo.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "updateUserResponse", namespace = "http://metteo.github.io/ws/user")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateUserResponse", namespace = "http://metteo.github.io/ws/user")
public class UpdateUserResponse {

    @XmlElement(name = "return", namespace = "")
    private io.github.metteo.ws.User _return;

    /**
     * 
     * @return
     *     returns User
     */
    public io.github.metteo.ws.User getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(io.github.metteo.ws.User _return) {
        this._return = _return;
    }

}
