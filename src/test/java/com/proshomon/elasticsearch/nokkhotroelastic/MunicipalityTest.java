package com.proshomon.elasticsearch.nokkhotroelastic;

import com.proshomon.elasticsearch.nokkhotroelastic.model.ElasticModel.ElasticSearch;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_new.MunicipalityNew;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_old.Municipality;
import com.proshomon.elasticsearch.nokkhotroelastic.repository.MunicipalityRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class MunicipalityTest {
    @Value("${elasticsearch.url}")
    private String url;

    @Autowired
    MunicipalityRepository municipalityRepository;

    @Test
    public void saveMunicipalityTest(){
        RestTemplate restTemplate = new RestTemplate();
        List<Municipality> municipalityOldList = municipalityRepository.findAll();
        MunicipalityNew municipalityNew = new MunicipalityNew();

        for (Municipality municipality : municipalityOldList){
            Map<String, Object> map = new HashMap<>(), map2 = new HashMap<>(), map3 = new HashMap<>();
            if(municipality.getCode()==14){
                map3.put("name", "Feni");
            } else if(municipality.getCode()==50){
                map3.put("name", "Chadpur");
            } else map3.put("name", "null");

            map2.put("match", map3);
            map.put("query", map2);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Map> entity = new HttpEntity<Map>(map, headers);

            String url = this.url + "upazilla/upazilla/_search";

            ResponseEntity<ElasticSearch> responseEntity = restTemplate
                    .exchange(url, HttpMethod.POST, entity, ElasticSearch.class);

            log.info("Body: {}", responseEntity.getBody().getHits());
            municipalityNew.setId(municipality.getId().toString());
            municipalityNew.setName(municipality.getName());
            municipalityNew.setCode(municipality.getCode().toString());
            municipalityNew.setParentId(responseEntity.getBody().getHits().getHits().get(0).get_id());

            String url1 = this.url + "municipality/municipality/";
            ResponseEntity<MunicipalityNew> responseEntity1 =
                    restTemplate.postForEntity(url1, municipalityNew, MunicipalityNew.class);
            log.info("Status: {}", responseEntity1.getStatusCode());
        }
    }

}
