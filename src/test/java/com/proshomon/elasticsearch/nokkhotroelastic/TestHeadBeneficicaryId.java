package com.proshomon.elasticsearch.nokkhotroelastic;

import com.proshomon.elasticsearch.nokkhotroelastic.model_old.Beneficiary;
import com.proshomon.elasticsearch.nokkhotroelastic.model_old.Household;
import com.proshomon.elasticsearch.nokkhotroelastic.repository.BeneficiaryRepository;
import com.proshomon.elasticsearch.nokkhotroelastic.repository.HouseholdRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestHeadBeneficicaryId {
    @Value("${elasticsearch.url}")
    private String url;

    @Autowired
    HouseholdRepository householdRepository;
    @Autowired
    BeneficiaryRepository beneficiaryRepository;

    @Test
    public void testHeadBeneficiaryId(){
        RestTemplate restTemplate = new RestTemplate();
        List<Household> householdOldList = householdRepository.findAll();
        List<Beneficiary> beneficiarySelf = null;
        for (Household household: householdOldList){
            List<Beneficiary> beneficiaryList = beneficiaryRepository.getBeneficiaryListByHouseholdId(household.getId());
            String hhIds = "";
            for(Beneficiary beneficiary: beneficiaryList){
                if(beneficiary.getRelationWithHousehold()== "SELF"){
                    hhIds = beneficiary.getHouseholdIds();
                    break;
                } else hhIds = "";

            }
            log.info("household ids:{}", hhIds);
//            Map<String, Object> map = new HashMap<>(), map2 = new HashMap<>(), map3 = new HashMap<>();
//            map3.put("id", beneficiarySelf.get(0).getHousehold().getId());
//            map2.put("match", map3);
//            map.put("query", map2);
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_JSON);
//            HttpEntity<Map> entity = new HttpEntity<Map>(map, headers);
//            String url = this.url + "household/household/_search/";



        }
    }
}
