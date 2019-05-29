package com.proshomon.elasticsearch.nokkhotroelastic.proshomon;

import com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.DiagnosticTestRecord;
import com.proshomon.elasticsearch.nokkhotroelastic.repository.proshomon.DiagnosticTestRecordRepository;
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
public class DiagnosticTest {

    @Value("${elasticsearch.url}")
    private String url;

    @Autowired
    DiagnosticTestRecordRepository diagnosticTestRecordRepository;

    @Test
    @Ignore
    public void saveDiagnosisTest(){
        RestTemplate restTemplate = new RestTemplate();
        List<DiagnosticTestRecord> diagnosticTestRecordList = diagnosticTestRecordRepository.findAll();
        DiagnosticTestRecord diagnosticTestRecord = new DiagnosticTestRecord();

        for (DiagnosticTestRecord record : diagnosticTestRecordList){
            diagnosticTestRecord.setId(record.getId());
            diagnosticTestRecord.setName(record.getName());

            String url = this.url + "diagnostic_test/diagnostic_test/";

            ResponseEntity<DiagnosticTestRecord> responseEntity =
                    restTemplate.postForEntity(url, diagnosticTestRecord, DiagnosticTestRecord.class);
            log.info("Status: {}", responseEntity.getStatusCode());
        }
    }
}
