package com.docplus;

import com.docplus.entity.Patient;
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

    public static void main(String[] args) {
        SpringApplication.run(DocPlusApiStarter.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        Patient myPojo = factory.manufacturePojo(Patient.class);
        myPojo.setVersion(null);
        patientRepository.save(myPojo);

        for (Patient p : patientRepository.findAll()) {
            System.out.println(p);
        }

    }
}
