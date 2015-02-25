package Services;

import Global.CLogger;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.util.logging.Logger;
import models.Users;

/**
 * Created by golans on 8/20/2014.
 */
@Path("/example")
public class example {
    private final static Logger logger = CLogger.getInstance();

    @GET
    @Path("/sayHi")
    @Produces({MediaType.APPLICATION_JSON})
    public Users sayHey(@Context SecurityContext sc) {
        Users u=new Users("seffy");
        logger.info("Starting src.java.Services.example.sayHey()");
        System.out.println("Starting src.java.Services.example.sayHey()");
        return u;
    }

    //@POST
    //@Path("/")
    //@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
}
