package plan3.recruitment.backend.model.person;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

import com.google.common.base.Optional;

public interface PersonStorage {

    /**
     * Return an {@link Optional} wrapping the {@link Person} with the supplied email address or an
     * {@link Optional#absent()} if the persons doesn't exist in this {@link PersonStorage}.
     */
    public Optional<Person> fetch(String email);

    /**
     * Add the given {@link Person} to this {@link PersonStorage}
     */
    public void save(Person person);

    /**
     * Remove the given {@link Person}. Return {@code true} if the {@link Person} existed and was removed, {@code false}
     * if the person didn't exist
     */
    public boolean remove(Person person);

    /**
     * Return all {@link Person}s in this {@link PersonStorage}
     */
    public SortedSet<Person> list();
}