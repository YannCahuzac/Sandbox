
package fr.smabtp.yca.controller.ws.soap;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter1
    extends XmlAdapter<String, Long>
{


    public Long unmarshal(String value) {
        return ((long)javax.xml.bind.DatatypeConverter.parseLong(value));
    }

    public String marshal(Long value) {
        if (value == null) {
            return null;
        }
        return (javax.xml.bind.DatatypeConverter.printLong((long)(long)value));
    }

}
