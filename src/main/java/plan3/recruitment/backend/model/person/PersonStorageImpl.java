package plan3.recruitment.backend.model.person;

import com.google.common.base.Optional;

import java.util.Collection;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by lina on 2013-09-01.
 */
public class PersonStorageImpl implements PersonStorage {

    private SortedSet<Person> persons = new TreeSet<>();

    public SortedSet<Person> getPersons() {
        return persons;
    }

    private void addPerson(Person person) {
        if (this.persons == null) this.persons = new TreeSet<>();
        persons.add(person);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Optional<Person> fetch(String email) {
        Iterator<Person> personIterator = getPersons().iterator();
        while(personIterator.hasNext()) {
            Person optPerson = personIterator.next();
            if (compareField(email, optPerson)) return Optional.of(optPerson);
        }
        return Optional.absent();
    }

    private boolean compareField(String email, Person person) {
        if (person.personContact().emailAddress().equals(email)) return true;
        return false;
    }

    @Override
    public void save(Person person) {
        addPerson(person);
    }

    @Override
    public boolean remove(Person personToRemove) {
        Iterator<Person> existingPersonsIterator = getPersons().iterator();
        while(existingPersonsIterator.hasNext()) {
            Person iteratorPerson = existingPersonsIterator.next();
            if (compareField(personToRemove.personContact().emailAddress(), iteratorPerson))
            {
                existingPersonsIterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public SortedSet<Person> list() {
        return getPersons();
    }

    public Person createPerson(String firstName, String lastName, String email) {
        PersonName name = PersonName.valueOf(firstName, lastName);
        PersonContact personContact = PersonContact.valueOf(name, email);
        return Person.valueOf(personContact);
    }
}
