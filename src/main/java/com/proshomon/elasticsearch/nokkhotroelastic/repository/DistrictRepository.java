package com.proshomon.elasticsearch.nokkhotroelastic.repository;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_old.District;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_old.rowmapper.DistrictRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class DistrictRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<District> findAll() {
        String query = "select * from district";
        try {
            return jdbcTemplate.query(query, new DistrictRowMapper());
        } catch (DataAccessException dae) {
            log.error(dae.getMessage());
            return null;
        }
    }
}
