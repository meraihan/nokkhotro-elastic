package com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.rowmapper;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.SurgeriesService;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SurgeriesServiceRowMapper implements RowMapper<SurgeriesService> {

    @Override
    public SurgeriesService mapRow(ResultSet rs, int i) throws SQLException {
        SurgeriesService surgeriesService = new SurgeriesService();
        surgeriesService.setName(rs.getString("name"));
        surgeriesService.setCharge(rs.getDouble("fee"));
        return surgeriesService;
    }
}
