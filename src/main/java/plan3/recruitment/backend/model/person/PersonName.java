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
    protected final String firstName;
    @JsonProperty
    protected final String lastName;

    public PersonName(@JsonProperty("firstName")String firstName, @JsonProperty("lastName")String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
