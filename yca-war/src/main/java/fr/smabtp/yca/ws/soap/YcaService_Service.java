package fr.smabtp.yca.ws.soap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.4.4
 * 2015-11-17T16:18:32.569+01:00
 * Generated source version: 2.4.4
 * 
 */
@WebServiceClient(name = "ycaService", 
                  wsdlLocation = "file:/C:/Users/A15489/workspaceKeplerJEE/workspaceTest1/yca-parent/yca-war/src/main/resources/ycaService.wsdl",
                  targetNamespace = "http://smabtp.fr/service/souscription/ycaService/1.0") 
public class YcaService_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://smabtp.fr/service/souscription/ycaService/1.0", "ycaService");
    public final static QName YcaServicePort = new QName("http://smabtp.fr/service/souscription/ycaService/1.0", "ycaServicePort");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/Users/A15489/workspaceKeplerJEE/workspaceTest1/yca-parent/yca-war/src/main/resources/ycaService.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(YcaService_Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/C:/Users/A15489/workspaceKeplerJEE/workspaceTest1/yca-parent/yca-war/src/main/resources/ycaService.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public YcaService_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public YcaService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public YcaService_Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns YcaService
     */
    @WebEndpoint(name = "ycaServicePort")
    public YcaService getYcaServicePort() {
        return super.getPort(YcaServicePort, YcaService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns YcaService
     */
    @WebEndpoint(name = "ycaServicePort")
    public YcaService getYcaServicePort(WebServiceFeature... features) {
        return super.getPort(YcaServicePort, YcaService.class, features);
    }

}
