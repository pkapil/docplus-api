package com.docplus.entity.repo;

import com.docplus.entity.Hospital;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "hospitals")
public interface HospitalRepository extends MongoRepository<Hospital, String> {
}
