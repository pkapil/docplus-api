package com.docplus;

import com.docplus.entity.Hospital;
import com.docplus.entity.Patient;
import com.docplus.entity.repo.HospitalRepository;
import com.docplus.entity.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

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
        PodamFactory factory = new PodamFactoryImpl();
        Patient patient = factory.manufacturePojo(Patient.class);
        Hospital hospital = factory.manufacturePojo(Hospital.class);
        patient.setVersion(null);
        patientRepository.save(patient);
        hospital.setVersion(null);
        hospitalRepository.save(hospital);
        for (Patient p : patientRepository.findAll()) {
            System.out.println(p);
        }
        for (Hospital p : hospitalRepository.findAll()) {
            System.out.println(p);
        }

    }
}
