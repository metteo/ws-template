
package io.github.metteo.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "disableUser", namespace = "http://metteo.github.io/ws/user")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "disableUser", namespace = "http://metteo.github.io/ws/user")
public class DisableUser {

    @XmlElement(name = "userId", namespace = "")
    private Long userId;

    /**
     * 
     * @return
     *     returns Long
     */
    public Long getUserId() {
        return this.userId;
    }

    /**
     * 
     * @param userId
     *     the value for the userId property
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
