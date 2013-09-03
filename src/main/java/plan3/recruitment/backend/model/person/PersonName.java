package plan3.recruitment.backend.model.person;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created with IntelliJ IDEA.
 * User: lina
 * Date: 2013-09-02
 * Time: 07:40
 */
public class PersonName {
    @JsonProperty
    private final String firstName;
    @JsonProperty
    private final String lastName;

    public PersonName(@JsonProperty("firstName")final String firstName, @JsonProperty("lastName")final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }
}
