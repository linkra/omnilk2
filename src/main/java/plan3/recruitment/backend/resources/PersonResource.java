package plan3.recruitment.backend.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.google.common.base.Optional;
import plan3.recruitment.backend.model.person.Person;
import plan3.recruitment.backend.model.person.PersonStorageImpl;

@Path("person")
@Produces(Constant.APPLICATION_JSON_UTF8)
@Consumes(Constant.APPLICATION_JSON_UTF8)
public class PersonResource {

    private PersonStorageImpl storage = new PersonStorageImpl();

    @GET
    public Collection<Person> list() {
        return this.storage.list();
    }

    @GET
    @Path(Constant.EMAIL_PATH_PARAM)
    public Optional fetch(@PathParam(Constant.EMAIL_PARAM) final String email) {
        return this.storage.fetch(email);
    }

    @PUT
    public Response save(final Person person, @Context final UriInfo uri) throws URISyntaxException{
        this.storage.save(person);
        URI resourceUri = new URI("/" + person.personContact.emailAddress);
        return Response.created(resourceUri).build();
    }
}