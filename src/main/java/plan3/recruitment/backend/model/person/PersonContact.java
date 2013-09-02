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
    protected final PersonName personName;
    @JsonProperty
    public final String emailAddress;

    public PersonContact(@JsonProperty("personName")PersonName personName, @JsonProperty("emailAddress")String emailAddress) {
        this.personName = personName;
        this.emailAddress = emailAddress;
    }


}
