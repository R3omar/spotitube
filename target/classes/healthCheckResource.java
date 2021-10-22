import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/health")
public class healthCheckResource {
        @GET
        public String healthy() {
            return "Up & Running";
        }
    }
