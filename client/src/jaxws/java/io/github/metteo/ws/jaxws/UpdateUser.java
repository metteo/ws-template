
package io.github.metteo.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "updateUser", namespace = "http://metteo.github.io/ws/user")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateUser", namespace = "http://metteo.github.io/ws/user")
public class UpdateUser {

    @XmlElement(name = "user", namespace = "")
    private io.github.metteo.ws.User user;

    /**
     * 
     * @return
     *     returns User
     */
    public io.github.metteo.ws.User getUser() {
        return this.user;
    }

    /**
     * 
     * @param user
     *     the value for the user property
     */
    public void setUser(io.github.metteo.ws.User user) {
        this.user = user;
    }

}
