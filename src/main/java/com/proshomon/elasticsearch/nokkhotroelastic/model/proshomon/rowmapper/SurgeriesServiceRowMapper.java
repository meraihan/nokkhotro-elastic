package com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.rowmapper;

import com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.SurgeriesService;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SurgeriesServiceRowMapper implements RowMapper<SurgeriesService> {

    @Override
    public SurgeriesService mapRow(ResultSet rs, int i) throws SQLException {
        SurgeriesService surgeriesService = new SurgeriesService();
        surgeriesService.setId(rs.getString("es_id"));
        surgeriesService.setName(rs.getString("name"));
        surgeriesService.setPrice(rs.getBigDecimal("fee"));
        return surgeriesService;
    }
}
