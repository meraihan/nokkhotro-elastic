package com.proshomon.elasticsearch.nokkhotroelastic.repository.hospital;

import com.proshomon.elasticsearch.nokkhotroelastic.hospital.DiagnosisCenterInfo;
import com.proshomon.elasticsearch.nokkhotroelastic.hospital.DiagnosticTestsService;
import com.proshomon.elasticsearch.nokkhotroelastic.hospital.rowmapper.DiagnosisCenterInfoRowMapper;
import com.proshomon.elasticsearch.nokkhotroelastic.hospital.rowmapper.DiagnosticTestServiceRowMapper;
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

    public List<DiagnosisCenterInfo> findAll() {
        String query = "select * from diagnosis_center_info";
        try {
            return jdbcTemplate.query(query, new DiagnosisCenterInfoRowMapper());
        } catch (DataAccessException dae) {
            log.error(dae.getMessage());
            return null;
        }
    }

    public List<DiagnosticTestsService> findAllDiagnosticTestsServiceBySPId(String parentId) {
        String query = "select * from diagnostic_tests_service where parent_id=?";
        try {
            return jdbcTemplate.query(query, new Object[]{parentId}, new DiagnosticTestServiceRowMapper());
        } catch (DataAccessException dae) {
            log.error(dae.getMessage());
            return null;
        }
    }
}
