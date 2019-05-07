package com.proshomon.elasticsearch.nokkhotroelastic;

import com.proshomon.elasticsearch.nokkhotroelastic.model.ElasticModel.ElasticSearch;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_new.DistrictNew;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_old.District;
import com.proshomon.elasticsearch.nokkhotroelastic.repository.DistrictRepository;
import lombok.extern.slf4j.Slf4j;
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
public class DistrictTest {

    @Value("${elasticsearch.url}")
    private String url;

    @Autowired
    DistrictRepository districtRepository;

    @Test
    public void saveDistrictTest(){
        RestTemplate restTemplate = new RestTemplate();
        List<District> districtNewList = districtRepository.findAll();
        DistrictNew districtNew = new DistrictNew();

        String url = this.url + "division/division/_search";

        ResponseEntity<ElasticSearch> responseEntity =
                restTemplate.getForEntity(url, ElasticSearch.class);
        log.info("Body: {}", responseEntity.getBody());

        for (District district : districtNewList){
            districtNew.setId(district.getId().toString());
            districtNew.setName(district.getName());
            districtNew.setCode(district.getCode().toString());
            districtNew.setParentId(String.valueOf(responseEntity.getBody().getHits().getHits().get(0).get_id()));
            String url1 = this.url + "district/district/";
            ResponseEntity<DistrictNew> responseEntity1 =
                    restTemplate.postForEntity(url1, districtNew, DistrictNew.class);
            log.info("Status: {}", responseEntity1.getStatusCode());
        }
    }
}
