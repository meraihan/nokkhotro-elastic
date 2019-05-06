package com.proshomon.elasticsearch.nokkhotroelastic;

import com.proshomon.elasticsearch.nokkhotroelastic.model.DivisionNew;
import com.proshomon.elasticsearch.nokkhotroelastic.model_old.Division;
import com.proshomon.elasticsearch.nokkhotroelastic.repository.DivisionRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class DivisionTest {

    @Value("${elasticsearch.url}")
    private String url;

    @Autowired
    DivisionRepository divisionRepository;

    @Test
    public void saveDivisionTest(){

        List<Division> divisionList = divisionRepository.findAll();

        DivisionNew newDivision = new DivisionNew();
        RestTemplate restTemplate = new RestTemplate();

        for (Division oldDivision : divisionList){
            newDivision.setId(oldDivision.getId().toString());
            newDivision.setName(oldDivision.getName());
            newDivision.setCode(oldDivision.getCode().toString());

            String url = this.url + "division/division/";
            ResponseEntity<DivisionNew> responseEntity =
                    restTemplate.postForEntity(url, newDivision, DivisionNew.class);
            log.info("Status: {}", responseEntity.getStatusCode());
        }
    }

}
