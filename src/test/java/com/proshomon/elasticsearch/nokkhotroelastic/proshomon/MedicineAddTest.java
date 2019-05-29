package com.proshomon.elasticsearch.nokkhotroelastic.proshomon;

import com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.Medicines;
import com.proshomon.elasticsearch.nokkhotroelastic.repository.proshomon.MedicinesRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class MedicineAddTest {

    @Value("${elasticsearch.url}")
    private String url;

    @Autowired
    MedicinesRepository medicinesRepository;

    @Test
    @Ignore
    public void addMedicine(){
        RestTemplate restTemplate = new RestTemplate();
        List<Medicines> medicinesList = medicinesRepository.findAll();

        for (Medicines medicines: medicinesList){
            String url = this.url + "medicine/medicine/";
            ResponseEntity<Medicines> responseEntity =
                    restTemplate.postForEntity(url, medicines, Medicines.class);
            log.info("Body: {}", responseEntity.getBody());
        }
    }
}
