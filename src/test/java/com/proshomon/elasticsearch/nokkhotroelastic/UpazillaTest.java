package com.proshomon.elasticsearch.nokkhotroelastic;

import com.proshomon.elasticsearch.nokkhotroelastic.model.ElasticModel.ElasticSearch;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_new.UpazillaNew;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_old.Upazilla;
import com.proshomon.elasticsearch.nokkhotroelastic.repository.UpazillaRepository;
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
public class UpazillaTest {

    @Value("${elasticsearch.url}")
    private String url;

    @Autowired
    UpazillaRepository upazillaRepository;

    @Test
    public void saveUpazillaTest(){
        RestTemplate restTemplate = new RestTemplate();
        List<Upazilla> upazillaOldList = upazillaRepository.findAll();
        UpazillaNew upazillaNew = new UpazillaNew();

        for (Upazilla upazilla : upazillaOldList){
            Map<String, Object> map = new HashMap<>(), map2 = new HashMap<>(), map3 = new HashMap<>();
            if(upazilla.getCode()==22){
                map3.put("name", "Chadpur");
            } else if(upazilla.getCode()==29){
                map3.put("name", "Feni");
            } else map3.put("name", "null");

            map2.put("match", map3);
            map.put("query", map2);


            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Map> entity = new HttpEntity<Map>(map, headers);

            String url = this.url + "district/district/_search";

            ResponseEntity<ElasticSearch> responseEntity = restTemplate
                    .exchange(url, HttpMethod.POST, entity, ElasticSearch.class);

            log.info("Body: {}", responseEntity.getBody().getHits());

            upazillaNew.setId(upazilla.getId().toString());
            upazillaNew.setName(upazilla.getName());
            upazillaNew.setCode(upazilla.getCode().toString());
            upazillaNew.setParentId(responseEntity.getBody().getHits().getHits().get(0).get_id());
            String url1 = this.url + "upazilla/upazilla/";
            ResponseEntity<UpazillaNew> responseEntity1 =
                    restTemplate.postForEntity(url1, upazillaNew, UpazillaNew.class);
            log.info("Status: {}", responseEntity1.getStatusCode());
        }
    }

}
