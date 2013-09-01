package plan3.recruitment.backend.model;

import com.google.common.base.Optional;
import com.sun.xml.internal.stream.Entity;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lina on 2013-09-01.
 */
public class PersonStorageImpl implements PersonStorage {

    private ArrayList<Person> persons = new ArrayList<Person>();

    public ArrayList getPersons() {
        return persons;
    }

    private void addPerson(Person person) {
        if (this.persons == null) {
            this.persons = new ArrayList<Person>();
        }
        persons.add(person);
    }

    @Override
    public Optional<Person> fetch(String email) {
        return Optional.absent();
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
    public List<Person> list() {
        return getPersons();
    }
}
