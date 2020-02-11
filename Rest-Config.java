#if (${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
/*
 * author ${USER}
 * version 1.0
*/

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * All all you REST-Endpoints in the following method.
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(org.glassfish.jersey.server.wadl.internal.WadlResource.class);
    }    
}
