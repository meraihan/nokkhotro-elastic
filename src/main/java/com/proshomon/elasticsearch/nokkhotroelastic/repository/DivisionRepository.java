package com.proshomon.elasticsearch.nokkhotroelastic.repository;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_nokkhotro.Division;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_nokkhotro.rowmapper.DivisionRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class DivisionRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Division> findAll() {
        String query = "select * from division";
        try {
            return jdbcTemplate.query(query, new DivisionRowMapper());
        } catch (DataAccessException dae) {
            log.error(dae.getMessage());
            return null;
        }
    }
}
