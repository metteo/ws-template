
package io.github.metteo.ws.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "findAllUsersResponse", namespace = "http://metteo.github.io/ws/user")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findAllUsersResponse", namespace = "http://metteo.github.io/ws/user")
public class FindAllUsersResponse {

    @XmlElement(name = "return", namespace = "")
    private List<io.github.metteo.ws.User> _return;

    /**
     * 
     * @return
     *     returns List<User>
     */
    public List<io.github.metteo.ws.User> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<io.github.metteo.ws.User> _return) {
        this._return = _return;
    }

}
