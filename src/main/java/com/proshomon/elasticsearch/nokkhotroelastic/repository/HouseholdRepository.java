package com.proshomon.elasticsearch.nokkhotroelastic.repository;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_old.Household;
import com.proshomon.elasticsearch.nokkhotroelastic.model.model_old.rowmapper.HouseholdRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class HouseholdRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Household> findAll() {
        String query = "select * from household";
        try {
            return jdbcTemplate.query(query, new HouseholdRowMapper());
        } catch (DataAccessException dae) {
            log.error(dae.getMessage());
            return null;
        }
    }

    public boolean update(String cardNo, String smartCardId) {
        String query = "UPDATE household SET  card_no = ? WHERE smart_card_id = ?";
        try {
            return jdbcTemplate.update(query, new Object[]{cardNo, smartCardId}) == 1;
        } catch (DataAccessException e) {
            log.error("Update failed for household id: {}. Error: {}", smartCardId, e.getLocalizedMessage());
            return false;
        }
    }

}
