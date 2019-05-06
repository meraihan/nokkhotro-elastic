package com.proshomon.elasticsearch.nokkhotroelastic.repository.hospital;

import com.proshomon.elasticsearch.nokkhotroelastic.hospital.SurgicalProceduresRecord;
import com.proshomon.elasticsearch.nokkhotroelastic.hospital.rowmapper.SurgicalProcedureRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class SurgeriesProcedureRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<SurgicalProceduresRecord> findAll() {
        String query = "select * from surgeries";
        try {
            return jdbcTemplate.query(query, new SurgicalProcedureRowMapper());
        } catch (DataAccessException dae) {
            log.error(dae.getMessage());
            return null;
        }
    }
}
