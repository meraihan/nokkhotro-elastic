package com.proshomon.elasticsearch.nokkhotroelastic;

import com.proshomon.elasticsearch.nokkhotroelastic.model.nokkhotro.Household;
import com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.Balance;
import com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.HouseholdBalance;
import com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.Households;
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

import java.math.BigDecimal;
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
//    @Ignore
    public void saveHouseholdTest(){
        List<Household> householdOldList = householdRepository.findAll();
        Households households = new Households();
        RestTemplate restTemplate = new RestTemplate();

        for (Household household : householdOldList){
            households.setId(household.getId().toString());
            households.setHeadBeneficiaryId(null);
            households.setHouseholdName(household.getHouseholdHeadName());
            households.setSize(household.getNumOfMembers());
            households.setSmartCardId(household.getSmartCardId());
            households.setCardNo(household.getCardNo());
            households.setDivisionId(household.getDivisionIds());
            households.setDistrictId(household.getDistrictIds());
            households.setUpazillaId(household.getUpazillaIds());
            households.setWardNo(household.getWordNo());
            households.setOccupation(household.getOccupation());
            households.setMunicipalityId(household.getMunicipalityIds());

            households.setAddedByUserId(null);

            HouseholdBalance hhbalance = new HouseholdBalance();
            Balance balance = new Balance();

            balance.setPhc(BigDecimal.valueOf(3100.00));
            balance.setAccident(BigDecimal.valueOf(6300.00));
            balance.setMaternity(BigDecimal.valueOf(12700.00));
            hhbalance.setOpeningBalance(balance);

            Balance balance1 = new Balance();
            balance1.setPhc(BigDecimal.valueOf(3100.00));
            balance1.setAccident(BigDecimal.valueOf(6300.00));
            balance1.setMaternity(BigDecimal.valueOf(12700.00));
            hhbalance.setCurrentBalance(balance1);

            households.setHouseholdBalance(hhbalance);
            households.setPhone(household.getContactNumber());
            households.setIsActive(Boolean.TRUE);
            households.setCreatedAt(Helper.localDateToDate(household.getCreatedAt()));

            String url = this.url + "household/household/";
            ResponseEntity<Households> responseEntity =
                    restTemplate.postForEntity(url, households, Households.class);
            log.info("Status: {}", responseEntity.getStatusCode());
        }
    }


}
