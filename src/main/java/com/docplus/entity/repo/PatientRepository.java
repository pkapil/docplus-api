package com.docplus.entity.repo;

import com.docplus.entity.Patient;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PatientRepository extends PagingAndSortingRepository<Patient, String> {
}
