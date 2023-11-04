package com.docplus.entity.repo;

import com.docplus.entity.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "patients")
public interface PatientRepository extends MongoRepository<Patient, String> {
}
