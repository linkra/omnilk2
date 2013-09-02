package plan3.recruitment.backend.model.person;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person implements Comparable {

    @JsonProperty
    protected PersonContact personContact;

    public Person(PersonContact personContact) {
        this.personContact = personContact;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return personContact.personName.firstName + ' ' + personContact.personName.lastName + " [" + personContact.emailAddress + "] ";
    }

    // DO NOT REMOVE THIS METHOD. But feel free to adjust to suit your needs.
    public static Person valueOf(final PersonContact personContact) {
        return new Person(personContact);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (this.personContact.emailAddress != null ? !this.personContact.emailAddress.equals(person.personContact.emailAddress) : person.personContact.emailAddress != null) return false;
        if (!this.personContact.personName.firstName.equals(person.personContact.personName.firstName)) return false;
        if (!this.personContact.personName.lastName.equals(person.personContact.personName.lastName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = this.personContact.emailAddress != null ? this.personContact.emailAddress.hashCode() : 0;
        result = 31 * result + this.personContact.personName.firstName.hashCode();
        result = 41 * result + this.personContact.personName.lastName.hashCode();
        return result;
    }

    @Override
    public int compareTo(Object o) {
        if (performComparing(o)) return evaluateInstance((Person) o);
        return -1;
    }

    private boolean performComparing(Object o) {
        if (o instanceof Person) return true;
        return false;
    }

    private int evaluateInstance(Person o) {
        Person personToCompare = (Person) o;
        return this.personContact.personName.lastName.compareTo(personToCompare.personContact.personName.lastName);
    }
}