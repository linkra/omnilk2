package plan3.recruitment.backend.model.person;

import com.google.common.base.Optional;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by lina on 2013-09-01.
 */
public class PersonStorageImpl implements PersonStorage {

    private TreeSet<Person> persons = new TreeSet<Person>();

    public TreeSet getPersons() {
        return persons;
    }

    private void addPerson(Person person) {
        if (this.persons == null) this.persons = new TreeSet<Person>();
        persons.add(person);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Optional<Person> fetch(String email) {
        Iterator<Person> personIterator = getPersons().iterator();
        while(personIterator.hasNext()) { Person optPerson = personIterator.next(); if (compareField(email, optPerson)) return Optional.of(optPerson); }
        return Optional.absent();
    }

    private boolean compareField(String email, Person optPerson) {
        if (optPerson.personContact().emailAddress().equals(email)) return true;
        return false;
    }

    @Override
    public void save(Person person) {
        addPerson(person);
    }

    @Override
    public boolean remove(Person person) {
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TreeSet<Person> list() {
        return getPersons();
    }
}
