package com.proshomon.elasticsearch.nokkhotroelastic.repository.proshomon;

import com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.DiagnosticTestRecord;
import com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.rowmapper.DiagnosticTestRecordRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class DiagnosticTestRecordRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<DiagnosticTestRecord> findAll() {
        String query = "select * from diagnosis_tests";
        try {
            return jdbcTemplate.query(query, new DiagnosticTestRecordRowMapper());
        } catch (DataAccessException dae) {
            log.error(dae.getMessage());
            return null;
        }
    }

}
