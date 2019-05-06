package com.proshomon.elasticsearch.nokkhotroelastic.repository;

import com.proshomon.elasticsearch.nokkhotroelastic.model_old.Upazilla;
import com.proshomon.elasticsearch.nokkhotroelastic.model_old.rowmapper.UpazillaRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class UpazillaRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Upazilla> findAll() {
        String query = "select * from upazilla";
        try {
            return jdbcTemplate.query(query, new UpazillaRowMapper());
        } catch (DataAccessException dae) {
            log.error(dae.getMessage());
            return null;
        }
    }
}
