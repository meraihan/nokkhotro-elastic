package com.proshomon.elasticsearch.nokkhotroelastic;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proshomon.elasticsearch.nokkhotroelastic.model.elasticsearch.ElasticSearch;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_nokkhotro.Household;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.Balance;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.HouseholdBalance;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.Households;
import com.proshomon.elasticsearch.nokkhotroelastic.repository.HouseholdRepository;
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

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class UpdateCardTest {

    @Value("${elasticsearch.url}")
    private String url;
    @Autowired
    HouseholdRepository householdRepository;

    @Test
    @Ignore
    public void updateCard(){
        RestTemplate restTemplate = new RestTemplate();
        List<Household> householdOldList = householdRepository.findAll();

        for (Household hh : householdOldList){
            Map<String, Object> map = new HashMap<>(), map2 = new HashMap<>(), map3 = new HashMap<>();
            map3.put("smartCardId", hh.getSmartCardId());
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
            aNew.setHeadBeneficiaryId(responseEntity.getBody().getHits().getHits().get(0).get_source().getHeadBeneficiaryId());
            aNew.setHouseholdName(responseEntity.getBody().getHits().getHits().get(0).get_source().getHouseholdName());
            aNew.setPhone(responseEntity.getBody().getHits().getHits().get(0).get_source().getPhone());
            aNew.setSize(responseEntity.getBody().getHits().getHits().get(0).get_source().getSize());
            aNew.setSmartCardId(responseEntity.getBody().getHits().getHits().get(0).get_source().getSmartCardId());
            aNew.setCardNo(hh.getCardNo());
            aNew.setDivisionId(responseEntity.getBody().getHits().getHits().get(0).get_source().getDivisionId());
            aNew.setDistrictId(responseEntity.getBody().getHits().getHits().get(0).get_source().getDistrictId());
            aNew.setUpazillaId(responseEntity.getBody().getHits().getHits().get(0).get_source().getUpazillaId());
            aNew.setWardNo(responseEntity.getBody().getHits().getHits().get(0).get_source().getWardNo());
            aNew.setOccupation(responseEntity.getBody().getHits().getHits().get(0).get_source().getOccupation());
            aNew.setMunicipalityId(responseEntity.getBody().getHits().getHits().get(0).get_source().getMunicipalityId());

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

            aNew.setHouseholdBalance(hhbalance);

            aNew.setIsActive(true);
            aNew.setCreatedAt(responseEntity.getBody().getHits().getHits().get(0).get_source().getCreatedAt());
            aNew.setUpdatedAt(responseEntity.getBody().getHits().getHits().get(0).get_source().getUpdatedAt());
            aNew.setDeletedAt(responseEntity.getBody().getHits().getHits().get(0).get_source().getDeletedAt());

            try {
                ObjectMapper oMapper = new ObjectMapper();
                Map<String, Object> maps = oMapper.convertValue(aNew, Map.class);
                HttpHeaders headerss = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                HttpEntity<Map> entitys = new HttpEntity<Map>(maps, headerss);
                String urlForUpdatess = this.url + "household/household/"+responseEntity.getBody().getHits().getHits().get(0).get_id()+"?pretty";
                ResponseEntity<ElasticSearch> responseEntity1 = restTemplate
                        .exchange(urlForUpdatess, HttpMethod.PUT, entitys, ElasticSearch.class);
                log.info("Bodys: {}", responseEntity1.getStatusCode());
            }catch (DataAccessException e){
                log.error(String.valueOf(e));
            }
        }

    }

}
