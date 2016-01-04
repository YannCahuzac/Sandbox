
package fr.smabtp.yca.controller.ws.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for foo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="foo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fooParam1" type="{http://smabtp.fr/service/souscription/ycaService/1.0}fooParam1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "foo", propOrder = {
    "fooParam1"
})
public class Foo {

    @XmlElement(required = true)
    protected FooParam1 fooParam1;

    /**
     * Gets the value of the fooParam1 property.
     * 
     * @return
     *     possible object is
     *     {@link FooParam1 }
     *     
     */
    public FooParam1 getFooParam1() {
        return fooParam1;
    }

    /**
     * Sets the value of the fooParam1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link FooParam1 }
     *     
     */
    public void setFooParam1(FooParam1 value) {
        this.fooParam1 = value;
    }

}
