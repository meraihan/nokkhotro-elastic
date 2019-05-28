package com.proshomon.elasticsearch.nokkhotroelastic;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proshomon.elasticsearch.nokkhotroelastic.model.ElasticModel.ElasticSearch;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_old.Beneficiary;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.Households;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.enums.Relationship;
import com.proshomon.elasticsearch.nokkhotroelastic.repository.BeneficiaryRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class UpdateHeadBeneficiaryTest {

    @Value("${elasticsearch.url}")
    private String url;
    @Autowired
    BeneficiaryRepository beneficiaryRepository;

    @Test
    @Ignore
    public void updateBeneficiaryIdTest(){
        RestTemplate restTemplate = new RestTemplate();
        List<Beneficiary> beneficiaryListByHHId = null;
        String headBeneficiaryId = "";
        List<Beneficiary> beneficiaryOldList  = beneficiaryRepository.findAll();
        for (Beneficiary beneficiary : beneficiaryOldList){
            beneficiaryListByHHId = beneficiaryRepository.findByHHRelationWithHousehold(beneficiary.getHouseholdIds());
            if (beneficiaryListByHHId.size()!=0){
                for (Beneficiary beneficiary1 : beneficiaryListByHHId){
                    if(beneficiary1.getRelationWithHousehold().equals(String.valueOf(Relationship.SELF))){
                        headBeneficiaryId = beneficiaryListByHHId.get(0).getHouseholdIds();
                    }
                }

            }
            String newBeneIf = headBeneficiaryId;
            Map<String, Object> map = new HashMap<>(), map2 = new HashMap<>(), map3 = new HashMap<>();
            map3.put("id", beneficiaryListByHHId.get(0).getHousehold().getId());
            map2.put("match", map3);
            map.put("query", map2);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Map> entity = new HttpEntity<Map>(map, headers);
            String url = this.url + "household/household/_search/";

            ResponseEntity<ElasticSearch> responseEntity = restTemplate
                    .exchange(url, HttpMethod.POST, entity, ElasticSearch.class);
            log.info("Body: {}", responseEntity.getBody());

            Households aNew = new Households();
            aNew.setId(responseEntity.getBody().getHits().getHits().get(0).get_source().getId());
            aNew.setHeadBeneficiaryId(newBeneIf);
            aNew.setHouseholdName(responseEntity.getBody().getHits().getHits().get(0).get_source().getHouseholdName());
            aNew.setPhone(responseEntity.getBody().getHits().getHits().get(0).get_source().getPhone());
            aNew.setSize(responseEntity.getBody().getHits().getHits().get(0).get_source().getSize());
            aNew.setSmartCardId(responseEntity.getBody().getHits().getHits().get(0).get_source().getSmartCardId());
            aNew.setCardNo(responseEntity.getBody().getHits().getHits().get(0).get_source().getCardNo());
            aNew.setDivisionId(responseEntity.getBody().getHits().getHits().get(0).get_source().getDivisionId());
            aNew.setDistrictId(responseEntity.getBody().getHits().getHits().get(0).get_source().getDistrictId());
            aNew.setUpazillaId(responseEntity.getBody().getHits().getHits().get(0).get_source().getUpazillaId());
            aNew.setWardNo(responseEntity.getBody().getHits().getHits().get(0).get_source().getWardNo());
            aNew.setOccupation(responseEntity.getBody().getHits().getHits().get(0).get_source().getOccupation());
            aNew.setMunicipalityId(responseEntity.getBody().getHits().getHits().get(0).get_source().getMunicipalityId());
            aNew.setHouseholdBalance(responseEntity.getBody().getHits().getHits().get(0).get_source().getHouseholdBalance());

            aNew.setIsActive(Boolean.TRUE);
            aNew.setCreatedAt(responseEntity.getBody().getHits().getHits().get(0).get_source().getCreatedAt());
            aNew.setUpdatedAt(responseEntity.getBody().getHits().getHits().get(0).get_source().getUpdatedAt());
            aNew.setDeletedAt(responseEntity.getBody().getHits().getHits().get(0).get_source().getDeletedAt());
            try {
                ObjectMapper oMapper = new ObjectMapper();
                Map<String, Object> maps = oMapper.convertValue(aNew, Map.class);
                HttpHeaders headerss = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                HttpEntity<Map> entitys = new HttpEntity<Map>(maps, headerss);
                String urlForUpdates = this.url + "household/household/"+responseEntity.getBody().getHits().getHits().get(0).get_id()+"?pretty";
                ResponseEntity<ElasticSearch> responseEntity1 = restTemplate
                        .exchange(urlForUpdates, HttpMethod.PUT, entitys, ElasticSearch.class);
                log.info("Body: {}", responseEntity1.getStatusCode());
            }catch (DataAccessException e){
                log.error(String.valueOf(e));
            }
        }

    }
}
