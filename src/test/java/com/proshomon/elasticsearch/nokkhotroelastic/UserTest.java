package com.proshomon.elasticsearch.nokkhotroelastic;

import com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.Users;
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
//    @Ignore
    public void saveUserTest(){
        RestTemplate restTemplate = new RestTemplate();
        Users user = new Users();
        user.setId(null);
        user.setUsername("testfenihospital");
        user.setPassword(encoder.encode("testfenihospital"));
        user.setFirstName("testfenihospital");
        user.setLastName("testfenihospital");
        user.setPhone("01990682310");
        user.setEmail("testfenihospital@gmail.com");
        user.setServiceProviderId("pLmx_WoBt92Pyc6X7eg-");
        user.setIsServiceProvider(true);
        user.setIsEnabled(true);
        user.setIsActive(true);
        Set<String> roles = new HashSet<>();
        roles.add("ROLE_HOSPITAL");
        user.setRoles(roles);
        user.setDateOfBirth(new Date());
        user.setCreatedAt(new Date());

        String url = this.url + "user/user/";
        ResponseEntity<Users> responseEntity =
                restTemplate.postForEntity(url, user, Users.class);
        log.info("Status: {}", responseEntity.getStatusCode());
    }
}
