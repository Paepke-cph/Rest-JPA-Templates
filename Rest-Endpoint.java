#if (${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end

/*
 * author ${USER}
 * version 1.0
*/

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

#set ($lcName = ${NAME.toLowerCase()})
#set ($pathName = ${NAME.split("Resource")[0].toLowerCase()})

@Path("/$pathName")
public class ${NAME} {            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String get() {
        throw new UnsupportedOperationException();
    }
}
