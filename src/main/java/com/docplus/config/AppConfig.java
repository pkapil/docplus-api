package com.docplus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.auditing.EnableCouchbaseAuditing;

import java.time.Instant;
import java.util.Optional;

@Configuration
@EnableCouchbaseAuditing
public class AppConfig extends AbstractCouchbaseConfiguration {

    @Override
    public String getConnectionString() {
        return "couchbase://127.0.0.1";
    }

    @Override
    public String getUserName() {
        return "docplus";
    }

    @Override
    public String getPassword() {
        return "passw0rd";
    }

    @Override
    public String getBucketName() {
        return "docplus";
    }

    @Bean
    public NaiveAuditorAware auditorAwareRef() {
        return new NaiveAuditorAware();
    }

    @Bean
    public DateTimeProvider dateTimeProviderRef() {
        return () -> Optional.of(Instant.now());
    }

}