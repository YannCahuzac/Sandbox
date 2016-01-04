package fr.smabtp.yca.controller.ws.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.4.4
 * 2015-11-18T17:27:07.650+01:00
 * Generated source version: 2.4.4
 * 
 */
@WebService(targetNamespace = "http://smabtp.fr/service/souscription/ycaService/1.0", name = "ycaService")
@XmlSeeAlso({ObjectFactory.class})
public interface YcaService {

    @WebResult(name = "fooParamResponse1", targetNamespace = "")
    @RequestWrapper(localName = "foo", targetNamespace = "http://smabtp.fr/service/souscription/ycaService/1.0", className = "fr.smabtp.yca.controller.ws.soap.Foo")
    @WebMethod(action = "foo")
    @ResponseWrapper(localName = "fooResponse", targetNamespace = "http://smabtp.fr/service/souscription/ycaService/1.0", className = "fr.smabtp.yca.controller.ws.soap.FooResponse")
    public fr.smabtp.yca.controller.ws.soap.FooParamResponse1 foo(
        @WebParam(name = "fooParam1", targetNamespace = "")
        fr.smabtp.yca.controller.ws.soap.FooParam1 fooParam1
    ) throws OperationFault_Exception;
}