package com.proshomon.elasticsearch.nokkhotroelastic.repository;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_old.Beneficiary;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_old.rowmapper.BeneficiaryRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class BeneficiaryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Beneficiary> findAll() {
        String query = "select * from beneficiary";
        try {
            return jdbcTemplate.query(query, new BeneficiaryRowMapper());
        } catch (DataAccessException dae) {
            log.error(dae.getMessage());
            return null;
        }
    }

    public List<Beneficiary> findAllSelf() {
        String query = "select * from beneficiary where relation_with_household='SELF'";
        try {
            return jdbcTemplate.query(query, new BeneficiaryRowMapper());
        } catch (DataAccessException dae) {
            log.error(dae.getMessage());
            return null;
        }
    }


    public boolean updateHouseholdIds(int houeholdId, String householdIds) {
        String query = "UPDATE beneficiary SET  houehold_ids = ? WHERE household_id = ?";
        try {
            return jdbcTemplate.update(query, householdIds, houeholdId) == 1;
        } catch (DataAccessException e) {
            log.error("Error: {}", e.getLocalizedMessage());
            return false;
        }
    }

    public List<Beneficiary> findByHHRelationWithHousehold(String householdId, String relations) {
        String query = "SELECT * FROM beneficiary WHERE relation_with_household= ?  AND  houehold_ids=?";
        try {
            return jdbcTemplate.query(query, new Object[]{relations, householdId}, new BeneficiaryRowMapper());
        } catch (DataAccessException dae) {
            log.error("Beneficiary Data Not Found, Error: {}", dae.getLocalizedMessage());
            return new ArrayList<>();
        }
    }

    public List<Beneficiary> getBeneficiaryListByHouseholdId(Integer householdId) {
        String query = "SELECT * FROM beneficiary WHERE household_id = ?";
        try {
            return jdbcTemplate.query(query, new Object[]{householdId}, new BeneficiaryRowMapper());
        } catch (DataAccessException dae) {
            log.error("Beneficiary Data Not Found, Error: {}", dae.getLocalizedMessage());
            return null;
        }
    }
}
