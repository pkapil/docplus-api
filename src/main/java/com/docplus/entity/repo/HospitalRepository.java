package com.docplus.entity.repo;

import com.docplus.entity.Hospital;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HospitalRepository extends PagingAndSortingRepository<Hospital, String> {
}
