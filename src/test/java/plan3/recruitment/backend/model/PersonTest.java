package plan3.recruitment.backend.model;

import plan3.recruitment.backend.AbstractJsonRoundTripTest;
import plan3.recruitment.backend.model.person.Person;
import plan3.recruitment.backend.model.person.PersonContact;
import plan3.recruitment.backend.model.person.PersonName;

public class PersonTest extends AbstractJsonRoundTripTest<Person> {
    @Override
    public Person createInstance() {
        PersonName name = PersonName.valueOf("first", "last");
        PersonContact personContact = PersonContact.valueOf(name, "first@last.se");
        return Person.valueOf(personContact);
    }
}
