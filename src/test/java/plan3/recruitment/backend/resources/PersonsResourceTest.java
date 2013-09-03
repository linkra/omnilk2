package plan3.recruitment.backend.resources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.core.Response.Status;

import org.junit.Test;

import plan3.recruitment.backend.model.person.Person;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.yammer.dropwizard.testing.ResourceTest;
import plan3.recruitment.backend.model.person.PersonContact;
import plan3.recruitment.backend.model.person.PersonName;

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

        Person stefan = createTestPerson("Stefan", "Petersson", "stefan@plan3.se");
        Person markus = createTestPerson("Markus", "Gustavsson", "markus@plan3.se");
        Person ian = createTestPerson("Ian", "Vännman", "ian@plan3.se");
        Person marten = createTestPerson("Mårten", "Gustafson", "marten@plan3.se");

        for(Person person : Arrays.asList(marten, ian, stefan, markus)) client.type(Constant.APPLICATION_JSON_UTF8).put(ClientResponse.class, person);
        List<Person> persons = client.get(new GenericType<List<Person>>() {});
        assertEquals(4, persons.size());
        Iterator<Person> iterator = persons.iterator();
        assertEquals(marten, iterator.next());
        assertEquals(markus, iterator.next());
        assertEquals(stefan, iterator.next());
        assertEquals(ian, iterator.next());
    }

    public Person createTestPerson(String firstName, String lastName, String email) {
        PersonName name = PersonName.valueOf(firstName, lastName);
        PersonContact personContact = PersonContact.valueOf(name, email);
        return Person.valueOf(personContact);
    }

    @Test
    public void fetchNonExistantReturns404() {
        ClientResponse response = client().resource("/person/a-non-existant-email-address-thats-not-even-valid").get(ClientResponse.class);
        assertEquals(Status.NOT_FOUND.getStatusCode(), response.getStatus());
    }

    @Test
    public void saveAndFetch() {
        // Save one person
        Person person = createTestPerson("Mårten", "Gustafson", "marten@plan3.se");
        ClientResponse response = client().resource("/person").type(Constant.APPLICATION_JSON_UTF8).put(ClientResponse.class, person);
        assertEquals(Status.CREATED.getStatusCode(), response.getStatus());

        // Fetch the saved person based on the URI in the response
        Person fetched = client().resource(response.getLocation()).get(Person.class);

        assertEquals(person, fetched);
    }
}