package com.docplus.config;


import com.couchbase.client.core.deps.com.fasterxml.jackson.databind.JavaType;
import com.couchbase.client.core.deps.com.fasterxml.jackson.databind.type.TypeFactory;
import com.couchbase.client.core.deps.com.fasterxml.jackson.databind.util.Converter;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.convert.CustomConversions;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.auditing.EnableCouchbaseAuditing;

import java.time.Instant;
import java.util.Arrays;
import java.util.Optional;

@Configuration
@EnableCouchbaseAuditing
public class AppConfig extends AbstractCouchbaseConfiguration {


    @Value("${couchbase.bootStrapServers}")
    private String bootStrapServers;

    @Value("${couchbase.username}")
    private String username;

    @Value("${couchbase.password}")
    private String password;

    @Value("${couchbase.bucketname}")
    private String bucketname;

    @Override
    public String getConnectionString() {
        return bootStrapServers;
    }

    @Override
    public String getUserName() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getBucketName() {
        return bucketname;
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