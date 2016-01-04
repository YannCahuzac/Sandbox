
package fr.smabtp.yca.ws.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fooResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fooResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fooParamResponse1" type="{http://smabtp.fr/service/souscription/ycaService/1.0}fooParamResponse1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fooResponse", propOrder = {
    "fooParamResponse1"
})
public class FooResponse {

    @XmlElement(required = true)
    protected FooParamResponse1 fooParamResponse1;

    /**
     * Gets the value of the fooParamResponse1 property.
     * 
     * @return
     *     possible object is
     *     {@link FooParamResponse1 }
     *     
     */
    public FooParamResponse1 getFooParamResponse1() {
        return fooParamResponse1;
    }

    /**
     * Sets the value of the fooParamResponse1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link FooParamResponse1 }
     *     
     */
    public void setFooParamResponse1(FooParamResponse1 value) {
        this.fooParamResponse1 = value;
    }

}
