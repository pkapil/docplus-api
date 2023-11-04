package com.docplus;

import com.docplus.entity.repo.HospitalRepository;
import com.docplus.entity.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DocPlusApiStarter implements CommandLineRunner {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    HospitalRepository hospitalRepository;


    public static void main(String[] args) {
        SpringApplication.run(DocPlusApiStarter.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
