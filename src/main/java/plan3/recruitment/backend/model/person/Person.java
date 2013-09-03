package plan3.recruitment.backend.model.person;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

public class Person implements Comparable {
    @JsonProperty
    private PersonContact personContact;

    @JsonCreator
    public static Person valueOf(@JsonProperty("personContact")final PersonContact personContact) {
        return new Person(personContact);
    }

    private Person(final PersonContact personContact) {
        this.personContact = personContact;
    }

    public PersonContact personContact() {
        return personContact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        final Person person = (Person) o;

        if (personContact().emailAddress() != null ? !personContact().emailAddress().equals(person.personContact().emailAddress()) : person.personContact().emailAddress() != null) return false;
        if (!personContact().personName().firstName().equals(person.personContact().personName().firstName())) return false;
        if (!personContact().personName().lastName().equals(person.personContact().personName().lastName())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personContact().emailAddress() != null ? personContact().emailAddress().hashCode() : 0;

        result = 31 * result + personContact().personName().firstName().hashCode();
        result = 41 * result + personContact().personName().lastName().hashCode();

        return result;
    }

    @Override
    public int compareTo(Object o) {
        if (performComparing(o)) return evaluateInstance((Person) o);
        return -1;
    }

    private boolean performComparing(Object o) {
        return o instanceof Person;
    }

    private int evaluateInstance(Person o) {
        final Person personToCompare = (Person) o;

        return personContact().personName().lastName().compareTo(personToCompare.personContact().personName().lastName());
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(getClass()).add("personContact", personContact()).toString();
    }
}