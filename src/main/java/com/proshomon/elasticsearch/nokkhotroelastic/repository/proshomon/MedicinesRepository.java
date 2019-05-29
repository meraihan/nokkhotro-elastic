package com.proshomon.elasticsearch.nokkhotroelastic.repository.proshomon;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_nokkhotro.rowmapper.MedicineRowMapper;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.Medicines;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Slf4j
@Repository
public class MedicinesRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Medicines add(Medicines medicines) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("medicines")
                .usingGeneratedKeyColumns("id");
        HashMap<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("id", medicines.getId());
        parameterMap.put("manufacturer", medicines.getManufacturer());
        parameterMap.put("brand", medicines.getBrand());
        parameterMap.put("genericName", medicines.getGenericName());
        parameterMap.put("strength", medicines.getStrength());
        parameterMap.put("medicineType", medicines.getMedicineType());
        parameterMap.put("mrp", medicines.getMrp());

        try {
            log.info("Inserting to medicines table: {}", parameterMap.toString());
            Number autoGenId = jdbcInsert.executeAndReturnKey(parameterMap);
            if (autoGenId != null) {
                medicines.setId(String.valueOf(autoGenId.intValue()));
                log.info("Inserting medicines With ID: {}", autoGenId);
                return medicines;
            } else {
                return medicines;
            }
        } catch (DataAccessException dae) {
            log.error(dae.getMessage());
            return null;
        }
    }

    public List<Medicines> findAll() {
        String query = "select * from medicines";
        try {
            return jdbcTemplate.query(query, new MedicineRowMapper());
        } catch (DataAccessException dae) {
            log.error(dae.getMessage());
            return null;
        }
    }
}
