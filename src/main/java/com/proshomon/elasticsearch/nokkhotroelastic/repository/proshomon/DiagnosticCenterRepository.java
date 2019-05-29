package com.proshomon.elasticsearch.nokkhotroelastic.repository.proshomon;

import com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.DiagnosticCenter;
import com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.DiagnosticTests;
import com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.rowmapper.DiagnosisCenterInfoRowMapper;
import com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.rowmapper.DiagnosticTestServiceRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class DiagnosticCenterRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<DiagnosticCenter> findAll() {
        String query = "select * from diagnosis_center_info";
        try {
            return jdbcTemplate.query(query, new DiagnosisCenterInfoRowMapper());
        } catch (DataAccessException dae) {
            log.error(dae.getMessage());
            return null;
        }
    }

    public List<DiagnosticTests> findAllDiagnosticTestsServiceBySPId(String parentId) {
        String query = "select * from diagnostic_tests_service where parent_id=?";
        try {
            return jdbcTemplate.query(query, new Object[]{parentId}, new DiagnosticTestServiceRowMapper());
        } catch (DataAccessException dae) {
            log.error(dae.getMessage());
            return null;
        }
    }
}
