package plan3.recruitment.backend.resources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.core.Response.Status;

import org.junit.Test;

import plan3.recruitment.backend.model.Person;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.yammer.dropwizard.testing.ResourceTest;

public class PersonsResourceTest extends ResourceTest {

    @Override
    protected void setUpResources() throws Exception {
        addResource(new PersonResource());
    }

    @Test
    public void emptyList() {
        WebResource person = client().resource("/person");
        List<Person> emptyList = person.get(new GenericType<List<Person>>() {});
        assertTrue(emptyList.isEmpty());
    }

    @Test
    public void listShouldBeSortedOnLastname() {
        WebResource client = client().resource("/person");
        Person stefan = Person.valueOf("Stefan", "Petersson", "stefan@plan3.se");
        Person markus = Person.valueOf("Markus", "Gustavsson", "markus@plan3.se");
        Person ian = Person.valueOf("Ian", "Vännman", "ian@plan3.se");
        Person marten = Person.valueOf("Mårten", "Gustafson", "marten@plan3.se");
        for(Person person : Arrays.asList(marten, ian, stefan, markus)) {
            client.type(PersonResource.APPLICATION_JSON_UTF8).put(ClientResponse.class, person);
        }
        List<Person> persons = client.get(new GenericType<List<Person>>() {});
        assertEquals(4, persons.size());
        Iterator<Person> iterator = persons.iterator();
        assertEquals(marten, iterator.next());
        assertEquals(markus, iterator.next());
        assertEquals(stefan, iterator.next());
        assertEquals(ian, iterator.next());
    }

    @Test
    public void fetchNonExistantReturns404() {
        ClientResponse response = client()
                .resource("/person/a-non-existant-email-address-thats-not-even-valid")
                .get(ClientResponse.class);
      //  assertSame(Status.NOT_FOUND.getStatusCode(), response.getStatus());
        assertEquals(Status.NOT_FOUND.getStatusCode(), response.getStatus());
    }

    @Test
    public void saveAndFetch() {
        // Save one person
        Person person = Person.valueOf("Mårten", "Gustafson", "marten@plan3.se");

        ClientResponse response = client()
                .resource("/person")
                .type(PersonResource.APPLICATION_JSON_UTF8)
                .put(ClientResponse.class, person);

        //assertSame(Status.CREATED.getStatusCode(), response.getStatus());
       assertEquals(Status.CREATED.getStatusCode(), response.getStatus());

        String location = response.getLocation().getPath();
        // Fetch the saved person based on the URI in the response
        Person fetched = client().resource(location).get(Person.class);

        assertEquals(person, fetched);
    }
}