package fr.smabtp.yca.controller;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.servlet.http.HttpServlet;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

import fr.smabtp.yca.ws.soap.FooParam1;
import fr.smabtp.yca.ws.soap.FooParamResponse1;
import fr.smabtp.yca.ws.soap.OperationFault_Exception;
import fr.smabtp.yca.ws.soap.YcaService;

@WebService(targetNamespace = "http://smabtp.fr/service/souscription/ycaService/1.0")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class YcaServiceImpl extends HttpServlet implements YcaService {

	// URL d'appel glassfish:
	// http://localhost:8080/yca-war/YcaServiceImplService
	// Il semblerait que glassfish ait rajouté "Service" à la fin lors de la
	// déclaraton en tant que servlet..

	// Pour générer SOAP WS (côté serveur):
	// 1) Générer (ou récupérer) le WSDL
	// 2) Générer le client ( = classes JAVA correspondantes au WSDL) grace au
	// plugin maven
	// 3) Faire un controller en mode servlet (dans le web.xml) qui implemente
	// la classe client service
	// 4) Ne pas oublier d'ajouter à ce controller les annotation @Web... ainsi
	// que le @BindingType
	// 5) Tester via soapUi si on appelle bien notre WS SOAP
	// NB: Si on est côté client: on fait les étapes 1 à 2 et on doit ensuite:
	// 3 bis) Instancier la classe qui fait un "extends Service"
	// (YcaService_Service dans notre cas)
	// 4 bis) Faire un get sur l'implémentation côté serveur de l'interface
	// (getYcaServicePort() dans notre cas)
	// 5 bis) Appeler les méthodes du service

	@WebResult(name = "fooParamResponse1", targetNamespace = "")
	@WebMethod(action = "foo")
	public FooParamResponse1 foo(
			@WebParam(name = "fooParam1", targetNamespace = "") FooParam1 fooParam1)
			throws OperationFault_Exception {

		FooParamResponse1 ret = new FooParamResponse1();
		ret.setResult(fooParam1.getA() + fooParam1.getB());
		return ret;
	}
}