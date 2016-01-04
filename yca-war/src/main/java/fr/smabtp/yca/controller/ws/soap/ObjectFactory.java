
package fr.smabtp.yca.controller.ws.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.smabtp.yca.controller.ws.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Foo_QNAME = new QName("http://smabtp.fr/service/souscription/ycaService/1.0", "foo");
    private final static QName _FooResponse_QNAME = new QName("http://smabtp.fr/service/souscription/ycaService/1.0", "fooResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.smabtp.yca.controller.ws.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OperationFault }
     * 
     */
    public OperationFault createOperationFault() {
        return new OperationFault();
    }

    /**
     * Create an instance of {@link FooResponse }
     * 
     */
    public FooResponse createFooResponse() {
        return new FooResponse();
    }

    /**
     * Create an instance of {@link Foo }
     * 
     */
    public Foo createFoo() {
        return new Foo();
    }

    /**
     * Create an instance of {@link FooParamResponse1 }
     * 
     */
    public FooParamResponse1 createFooParamResponse1() {
        return new FooParamResponse1();
    }

    /**
     * Create an instance of {@link FooParam1 }
     * 
     */
    public FooParam1 createFooParam1() {
        return new FooParam1();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Foo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://smabtp.fr/service/souscription/ycaService/1.0", name = "foo")
    public JAXBElement<Foo> createFoo(Foo value) {
        return new JAXBElement<Foo>(_Foo_QNAME, Foo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FooResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://smabtp.fr/service/souscription/ycaService/1.0", name = "fooResponse")
    public JAXBElement<FooResponse> createFooResponse(FooResponse value) {
        return new JAXBElement<FooResponse>(_FooResponse_QNAME, FooResponse.class, null, value);
    }

}
