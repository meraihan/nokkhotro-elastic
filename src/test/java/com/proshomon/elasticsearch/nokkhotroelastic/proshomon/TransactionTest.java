package com.proshomon.elasticsearch.nokkhotroelastic.proshomon;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TransactionTest {

    @Value("${elasticsearch.url}")
    private String url;

    @Test
    public void saveTransaction(){

        Transaction transaction = new Transaction();
        RestTemplate restTemplate = new RestTemplate();


        String url = this.url + "transactions/transactions/";
        ResponseEntity<Transaction> responseEntity =
                restTemplate.postForEntity(url, transaction, Transaction.class);
        log.info("Status: {}", responseEntity.getStatusCode());
    }
}
