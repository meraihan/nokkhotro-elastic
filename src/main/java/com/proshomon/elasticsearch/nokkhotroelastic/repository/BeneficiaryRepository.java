package com.proshomon.elasticsearch.nokkhotroelastic.repository;

import com.proshomon.elasticsearch.nokkhotroelastic.model_old.Beneficiary;
import com.proshomon.elasticsearch.nokkhotroelastic.model_old.rowmapper.BeneficiaryRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Repository
public class BeneficiaryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Beneficiary add(Beneficiary beneficiary) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("beneficiary")
                .usingGeneratedKeyColumns("id");
        HashMap<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("full_name", beneficiary.getFullName());
        parameterMap.put("household_id", beneficiary.getHousehold().getId());
        parameterMap.put("contact_number", beneficiary.getContactNumber());
        parameterMap.put("blood_group", beneficiary.getBloodGroup());
        parameterMap.put("marrital_status", beneficiary.getMarritalStatus().name());
        parameterMap.put("relation_with_household", beneficiary.getRelationWithHousehold());
        parameterMap.put("date_of_birth", beneficiary.getDateOfBirth());
        parameterMap.put("gender", beneficiary.getGender().name());
        parameterMap.put("photo_path", beneficiary.getPhotoPath());
        parameterMap.put("fingerprint_key1", beneficiary.getFingerprintKey1());
        parameterMap.put("fingerprint_key2", beneficiary.getFingerprintKey2());
        parameterMap.put("disability", beneficiary.getDisability());
        parameterMap.put("created_by", beneficiary.getCreatedBy());
        parameterMap.put("created_at", LocalDateTime.now());
        parameterMap.put("updated_at", LocalDateTime.now());
        parameterMap.put("deleted_at", LocalDateTime.now());

        try {
            log.info("Inserting to Beneficiary table: {}", parameterMap.toString());
            Number autoGenId = jdbcInsert.executeAndReturnKey(parameterMap);
            if (autoGenId != null) {
                beneficiary.setId(autoGenId.intValue());
                log.info("Inserting Beneficiary Data With ID: {}", autoGenId);
                return beneficiary;
            } else {
                return beneficiary;
            }
        } catch (DataAccessException dae) {
            log.error(dae.getMessage());
            return null;
        }
    }

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


    public boolean deleteById(Integer beneficiaryId) {
        String query = "DELETE FROM beneficiary WHERE id = ?";
        try {
            return jdbcTemplate.update(query, beneficiaryId) == 1;
        } catch (DataAccessException dae) {
            log.error("Beneficiary delete failed, Error: {}", dae.getLocalizedMessage());
            return false;
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
    public Beneficiary findById(int beneficiaryId) {
        String query = "SELECT * FROM beneficiary  \n" +
                "                WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(query, new Object[]{beneficiaryId}, new BeneficiaryRowMapper());
        } catch (DataAccessException dae) {
            log.error("Beneficiary Data Not Found, Error: {}", dae.getLocalizedMessage());
            return new Beneficiary();
        }
    }
}
