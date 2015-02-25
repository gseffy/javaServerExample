package Auth;
import Global.CLogger;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

import javax.ws.rs.WebApplicationException;
import java.util.logging.Logger;

public class Auth  implements ContainerRequestFilter {
    private final static Logger logger = CLogger.getInstance();

    @Override
    public ContainerRequest filter(ContainerRequest containerRequest) throws WebApplicationException{
        System.out.println("Starting Auth");
        String method = containerRequest.getMethod();

        // myresource/get/56bCA for example
        String path = containerRequest.getPath(true);

            //We do allow wadl to be retrieve
        if(method.equals("GET") && (path.equals("application.wadl") || path.equals("application.wadl/xsd0.xsd"))){
            return containerRequest;
        }

        //Get the authentification passed in HTTP headers parameters
        String auth = containerRequest.getHeaderValue("Authorization");
        //throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        return containerRequest;
    }

}
