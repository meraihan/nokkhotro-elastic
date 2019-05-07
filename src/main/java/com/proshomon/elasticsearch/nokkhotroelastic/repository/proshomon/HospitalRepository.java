package com.proshomon.elasticsearch.nokkhotroelastic.repository.proshomon;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.ConsultationsService;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.Hospital;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.SurgeriesService;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.rowmapper.ConsultationsServiceRowMapper;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.rowmapper.HospitalInfoRowMapper;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.rowmapper.SurgeriesServiceRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class HospitalRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Hospital> findAll() {
        String query = "select * from hospital_info";
        try {
            return jdbcTemplate.query(query, new HospitalInfoRowMapper());
        } catch (DataAccessException dae) {
            log.error(dae.getMessage());
            return null;
        }
    }

    public List<ConsultationsService> findAllConsultationServiceBySPId(String parentId) {
        String query = "select * from consultations_service where parent_id=?";
        try {
            return jdbcTemplate.query(query,  new Object[]{parentId}, new ConsultationsServiceRowMapper());
        } catch (DataAccessException dae) {
            log.error(dae.getMessage());
            return null;
        }
    }

    public List<SurgeriesService> findAllSurgeriesBySPId(String parentId) {
        String query = "select * from surgeries_service where id=?";
        try {
            return jdbcTemplate.query(query, new Object[]{parentId},  new SurgeriesServiceRowMapper());
        } catch (DataAccessException dae) {
            log.error(dae.getMessage());
            return null;
        }
    }
}
