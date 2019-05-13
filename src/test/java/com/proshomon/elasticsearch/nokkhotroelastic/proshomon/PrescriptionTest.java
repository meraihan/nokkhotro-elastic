package com.proshomon.elasticsearch.nokkhotroelastic.proshomon;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.Prescription;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class PrescriptionTest {

    @Value("${elasticsearch.url}")
    private String url;

    @Test
    public void savePrescription(){

        Prescription prescription = new Prescription();
        RestTemplate restTemplate = new RestTemplate();


        String url = this.url + "prescription/prescription/";
        ResponseEntity<Prescription> responseEntity =
                restTemplate.postForEntity(url, prescription, Prescription.class);
        log.info("Status: {}", responseEntity.getStatusCode());
    }
}

