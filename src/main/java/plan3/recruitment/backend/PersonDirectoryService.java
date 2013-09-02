package plan3.recruitment.backend;

import plan3.recruitment.backend.model.person.PersonResource;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class PersonDirectoryService extends Service<PersonDirectoryConfiguration> {

    @Override
    public void initialize(final Bootstrap<PersonDirectoryConfiguration> bootstrap) {}

    @Override
    public void run(final PersonDirectoryConfiguration configuration, final Environment environment) throws Exception {
        environment.scanPackagesForResourcesAndProviders(PersonResource.class);
    }

    public static void main(final String[] args) throws Exception {
        new PersonDirectoryService().run(args);
    }
}