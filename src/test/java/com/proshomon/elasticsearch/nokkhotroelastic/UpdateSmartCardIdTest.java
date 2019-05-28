package com.proshomon.elasticsearch.nokkhotroelastic;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_old.Household;
import com.proshomon.elasticsearch.nokkhotroelastic.repository.HouseholdRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class UpdateSmartCardIdTest {

    @Autowired
    HouseholdRepository householdRepository;

    @Test
    @Ignore
    public void updateSmartCardIdTest(){

        List<Household> householdList =  householdRepository.findAll();

        for (Household household: householdList){
            if(household.getId()<7001){
                continue;
            }
            String smartCardIdFIrst = household.getSmartCardId().substring(0,8);
            String updatedId = household.getSmartCardId().replace(smartCardIdFIrst, "20302950");

            householdRepository.updateSmartCardId(updatedId, household.getId());
            log.info(updatedId);

            if(household.getId()>15000){
                break;
            }
        }
    }

}
