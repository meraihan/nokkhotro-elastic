package com.proshomon.elasticsearch.nokkhotroelastic.repository.proshomon;

import com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.ServiceProvider;
import com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.rowmapper.ServiceProviderRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class ServiceProviderRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ServiceProvider> findAll() {
        String query = "select * from service_provider";
        try {
            return jdbcTemplate.query(query, new ServiceProviderRowMapper());
        } catch (DataAccessException dae) {
            log.error(dae.getMessage());
            return null;
        }
    }

}
