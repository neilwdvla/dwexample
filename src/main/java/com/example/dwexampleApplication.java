package com.example;

import com.example.health.TemplateHealthCheck;
import com.example.resources.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class dwexampleApplication extends Application<dwexampleConfiguration> {

    public static void main(final String[] args) throws Exception {
        new dwexampleApplication().run(args);
    }

    @Override
    public String getName() {
        return "dwexample";
    }

    @Override
    public void initialize(final Bootstrap<dwexampleConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final dwexampleConfiguration configuration,
                    final Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }

}
