package com.proshomon.elasticsearch.nokkhotroelastic.repository;

import com.proshomon.elasticsearch.nokkhotroelastic.model.nokkhotro.Municipality;
import com.proshomon.elasticsearch.nokkhotroelastic.model.nokkhotro.rowmapper.MunicipalityRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class MunicipalityRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Municipality> findAll() {
        String query = "select * from municipalities";
        try {
            return jdbcTemplate.query(query, new MunicipalityRowMapper());
        } catch (DataAccessException dae) {
            log.error(dae.getMessage());
            return null;
        }
    }
}
