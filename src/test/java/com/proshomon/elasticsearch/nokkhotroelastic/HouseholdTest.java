package com.proshomon.elasticsearch.nokkhotroelastic;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_new.HouseholdNew;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_old.Household;
import com.proshomon.elasticsearch.nokkhotroelastic.repository.HouseholdRepository;
import com.proshomon.elasticsearch.nokkhotroelastic.utils.Helper;
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
public class HouseholdTest {

    @Value("${elasticsearch.url}")
    private String url;

    @Autowired
    HouseholdRepository householdRepository;

    @Test
    public void saveHouseholdTest(){
        List<Household> householdOldList = householdRepository.findAll();
        HouseholdNew householdNew = new HouseholdNew();
        RestTemplate restTemplate = new RestTemplate();

        for (Household household : householdOldList){
            householdNew.setId(household.getId().toString());
            householdNew.setHeadBeneficiaryId(null);
            householdNew.setHouseholdName(household.getHouseholdHeadName());
            householdNew.setSize(household.getNumOfMembers());
            householdNew.setSmartCardId(household.getSmartCardId());
            householdNew.setDivisionId(household.getDivisionIds());
            householdNew.setDistrictId(household.getDistrictIds());
            householdNew.setUpazillaId(household.getUpazillaIds());
            householdNew.setWardNo(household.getWordNo());
            householdNew.setOccupation(household.getOccupation());
            householdNew.setMunicipalityId(household.getMunicipalityIds());

            householdNew.setAddedByUserId(null);
            householdNew.setPhone(household.getContactNumber());

            householdNew.setIsActive(Boolean.valueOf(String.valueOf(household.getStatus())));
            householdNew.setCreatedAt(Helper.localDateToDate(household.getCreatedAt()));

            String url = this.url + "household/household/";
            ResponseEntity<HouseholdNew> responseEntity =
                    restTemplate.postForEntity(url, householdNew, HouseholdNew.class);
            log.info("Status: {}", responseEntity.getStatusCode());
        }


    }


}
