package com.docplus.entity.repo;

import com.docplus.entity.VitalInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "vitalinfos")
public interface VitalInfoRepository extends MongoRepository<VitalInfo, String> {
}
