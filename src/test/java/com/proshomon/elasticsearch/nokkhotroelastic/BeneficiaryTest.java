package com.proshomon.elasticsearch.nokkhotroelastic;

import com.proshomon.elasticsearch.nokkhotroelastic.model.ElasticModel.ElasticSearch;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.enums.*;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_old.Beneficiary;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.Beneficiaries;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.Fingerprint;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.Image;
import com.proshomon.elasticsearch.nokkhotroelastic.repository.BeneficiaryRepository;
import com.proshomon.elasticsearch.nokkhotroelastic.utils.Helper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class BeneficiaryTest {

    @Value("${elasticsearch.url}")
    private String url;

    @Autowired
    BeneficiaryRepository beneficiaryRepository;

    @Test
    @Ignore
    public void saveBeneficiaryTest(){
        RestTemplate restTemplate = new RestTemplate();
        List<Beneficiary> beneficiaryList = beneficiaryRepository.findAll();
        Beneficiaries beneficiaries = new Beneficiaries();

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
            ResponseEntity<ElasticSearch> hhResponseEntity = restTemplate
                    .exchange(url, HttpMethod.POST, entity, ElasticSearch.class);
            log.info("Body: {}", hhResponseEntity.getBody());

            String householdIds = hhResponseEntity.getBody().getHits().getHits().get(0).get_id();

            //Update household ids on beneficiary table on mysql
            beneficiaryRepository.updateHouseholdIds(beneficiary.getHousehold().getId(), householdIds);

            String photoPathOld = beneficiary.getPhotoPath().substring(23);
            String photoPathNew = "images/profile/"+photoPathOld;
            Image image = new Image();
            image.setLocation(photoPathNew);
            beneficiaries.setProfilePhoto(image);

            beneficiaries.setHouseholdId(householdIds);
            beneficiaries.setId(beneficiary.getId().toString());
            beneficiaries.setName(beneficiary.getFullName());
            beneficiaries.setPhone(beneficiary.getContactNumber());
            beneficiaries.setIsActive(true);
            beneficiaries.setGender(Gender.valueOf(beneficiary.getGender().name()));
            beneficiaries.setMaritalStatus(MaritalStatus.valueOf(beneficiary.getMarritalStatus().name()));
            beneficiaries.setRelationshipWithHead(Relationship.valueOf(beneficiary.getRelationWithHousehold()));
            beneficiaries.setDateOfBirth(beneficiary.getDateOfBirth());
            beneficiaries.setDisabilityType(DisabilityType.valueOf(beneficiary.getDisability()));
            beneficiaries.setAddedByUserId(beneficiary.getCreatedBy().toString());

            Set<Fingerprint> fingerprintSet = new HashSet<>();
            Fingerprint fingerprint = new Fingerprint();
            fingerprint.setType(FingerprintType.PRIMARY);
            fingerprint.setKey(beneficiary.getFingerprintKey1());
            fingerprintSet.add(fingerprint);
            Fingerprint fingerprint1 = new Fingerprint();
            fingerprint1.setType(FingerprintType.SECONDARY);
            fingerprint1.setKey(beneficiary.getFingerprintKey2());
            fingerprintSet.add(fingerprint1);

            beneficiaries.setFingerprints(fingerprintSet);
            beneficiaries.setCreatedAt(Helper.localDateToDate(beneficiary.getCreatedAt()));

            //Add beneficiary on elastic search
            String bUrl= this.url + "beneficiary/beneficiary/";
            ResponseEntity<Beneficiaries> bResponseEntity =
                    restTemplate.postForEntity(bUrl, beneficiaries, Beneficiaries.class);
            log.info("Status: {}", bResponseEntity.getStatusCode());
        }

    }

}
