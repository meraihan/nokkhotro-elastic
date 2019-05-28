package com.proshomon.elasticsearch.nokkhotroelastic.proshomon;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.SurgicalProceduresRecord;
import com.proshomon.elasticsearch.nokkhotroelastic.repository.proshomon.SurgeriesProcedureRepository;
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
public class SurgeriesProcedureTest {

    @Value("${elasticsearch.url}")
    private String url;

    @Autowired
    SurgeriesProcedureRepository surgeriesProcedureRepository;

    @Test
    @Ignore
    public void saveSurgeriesProcedureTest(){
        RestTemplate restTemplate = new RestTemplate();
        List<SurgicalProceduresRecord> recordList = surgeriesProcedureRepository.findAll();
        SurgicalProceduresRecord proceduresRecord = new SurgicalProceduresRecord();
        for (SurgicalProceduresRecord record : recordList){
            proceduresRecord.setId(null);
            proceduresRecord.setName(record.getName());

            String url = this.url + "surgery/surgery/";

            ResponseEntity<SurgicalProceduresRecord> responseEntity =
                    restTemplate.postForEntity(url, proceduresRecord, SurgicalProceduresRecord.class);
            log.info("Status: {}", responseEntity.getStatusCode());
        }
    }
}
