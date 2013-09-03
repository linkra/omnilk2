package plan3.recruitment.backend.model.person;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created with IntelliJ IDEA.
 * User: lina
 * Date: 2013-09-02
 * Time: 07:39
 */
public class PersonContact {
    @JsonProperty
    private final PersonName personName;
    @JsonProperty
    private final String emailAddress;

    public static PersonContact valueOf(@JsonProperty("personName")final PersonName personName, @JsonProperty("emailAddress")final String emailAddress) {
        return new PersonContact(personName, emailAddress);
    }

    private PersonContact(@JsonProperty("personName")final PersonName personName, @JsonProperty("emailAddress")final String emailAddress) {
        this.personName = personName;
        this.emailAddress = emailAddress;
    }

    public PersonName personName() {
        return personName;
    }

    public String emailAddress() {
        return emailAddress;
    }
}
