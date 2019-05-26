package com.proshomon.elasticsearch.nokkhotroelastic;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_new.UserNew;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTest {

    @Value("${elasticsearch.url}")
    private String url;

    PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Test
    public void saveUserTest(){
        RestTemplate restTemplate = new RestTemplate();
        UserNew user = new UserNew();
        user.setId(null);
        user.setUsername("concernbd");
        user.setPassword(encoder.encode("concernbd"));
        user.setFirstName("concernbd");
        user.setLastName("concernbd");
        user.setPhone("01722680415");
        user.setEmail("concernbd@gmail.com");
        user.setServiceProviderId("");
        user.setIsServiceProvider(false);
        user.setIsEnabled(true);
        user.setIsActive(true);
        Set<String> roles = new HashSet<>();
        roles.add("ROLE_ADMIN");
        user.setRoles(roles);
        user.setDateOfBirth(new Date());
        user.setCreatedAt(new Date());

        String url = this.url + "user/user/";
        ResponseEntity<UserNew> responseEntity =
                restTemplate.postForEntity(url, user, UserNew.class);
        log.info("Status: {}", responseEntity.getStatusCode());
    }
}
