package lifecoach.adaptor.endpoint;

import lifecoach.adaptor.webservice.AdaptorImplementation;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URISyntaxException;

import javax.xml.ws.Endpoint;

public class AdaptorPublisher 
{
    public static void main(String[] args) throws IllegalArgumentException, IOException, URISyntaxException
    {
        String PROTOCOL = "http://";
        String HOSTNAME = InetAddress.getLocalHost().getHostAddress();
        String PORT = "6904";
        String BASE_URL = "/ws/adaptorBmi";
        
        if (HOSTNAME.equals("127.0.0.1"))
        {
            HOSTNAME = "localhost";
        }       

        if (String.valueOf(System.getenv("PORT")) != "null")
        {
            PORT = String.valueOf(System.getenv("PORT"));
        }
        
        String endpointUrl = PROTOCOL + HOSTNAME + ":" + PORT + BASE_URL;
        
        System.out.println("Starting People Service...");
        System.out.println("--> Published. Check out " + endpointUrl + "?wsdl");
        Endpoint.publish(endpointUrl, new AdaptorImplementation());
    }
}
