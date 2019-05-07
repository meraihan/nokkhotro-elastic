package com.proshomon.elasticsearch.nokkhotroelastic;

import com.proshomon.elasticsearch.nokkhotroelastic.model.ElasticModel.ElasticSearch;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_new.BeneficiaryNew;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_new.enums.DisabilityType;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_new.enums.Relationship;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_old.Beneficiary;
import com.proshomon.elasticsearch.nokkhotroelastic.repository.BeneficiaryRepository;
import com.proshomon.elasticsearch.nokkhotroelastic.utils.Helper;
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
public class BeneficiaryTest {

    @Value("${elasticsearch.url}")
    private String url;

    @Autowired
    BeneficiaryRepository beneficiaryRepository;

    @Test
    public void saveBeneficiaryTest(){
        RestTemplate restTemplate = new RestTemplate();
        List<Beneficiary> beneficiaryList = beneficiaryRepository.findAll();
        BeneficiaryNew beneficiaryNew = new BeneficiaryNew();

        for (Beneficiary beneficiary : beneficiaryList){

            //Getting Household Data
            Map<String, Object> map = new HashMap<>(), map2 = new HashMap<>(), map3 = new HashMap<>();
            map3.put("id", beneficiary.getHousehold().getId());
            map2.put("match", map3);
            map.put("query", map2);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Map> entity = new HttpEntity<Map>(map, headers);
            String url = this.url + "household/household/_search";
            ResponseEntity<ElasticSearch> responseEntity = restTemplate
                    .exchange(url, HttpMethod.POST, entity, ElasticSearch.class);
            log.info("Body: {}", responseEntity.getBody());

            String householdIds = responseEntity.getBody().getHits().getHits().get(0).get_id();

            //Update household ids on beneficiary Repository
            beneficiaryRepository.updateHouseholdIds(beneficiary.getHousehold().getId(), householdIds);

            beneficiaryNew.setHouseholdId(householdIds);
            beneficiaryNew.setId(beneficiary.getId().toString());
            beneficiaryNew.setName(beneficiary.getFullName());
            beneficiaryNew.setPhone(beneficiary.getContactNumber());
            beneficiaryNew.setIsActive(true);
            beneficiaryNew.setGender(beneficiary.getGender().name());
            beneficiaryNew.setMaritalStatus(beneficiary.getMarritalStatus().name());
            beneficiaryNew.setRelationshipWithHead(Relationship.valueOf(beneficiary.getRelationWithHousehold()));
            beneficiaryNew.setDateOfBirth(beneficiary.getDateOfBirth());
            beneficiaryNew.setDisabilityType(DisabilityType.valueOf(beneficiary.getDisability()));
            beneficiaryNew.setAddedByUserId(beneficiary.getCreatedBy().toString());
            beneficiaryNew.setCreatedAt(Helper.localDateToDate(beneficiary.getCreatedAt()));
            beneficiaryNew.setUpdatedAt(Helper.localDateToDate(beneficiary.getUpdatedAt()));
            beneficiaryNew.setDeletedAt(Helper.localDateToDate(beneficiary.getDeletedAt()));

            //Add beneficiary on elastic search
            String url1 = this.url + "beneficiary/beneficiary/";
            ResponseEntity<BeneficiaryNew> responseEntity1 =
                    restTemplate.postForEntity(url1, beneficiaryNew, BeneficiaryNew.class);
            log.info("Status: {}", responseEntity1.getStatusCode());
        }

    }

}
