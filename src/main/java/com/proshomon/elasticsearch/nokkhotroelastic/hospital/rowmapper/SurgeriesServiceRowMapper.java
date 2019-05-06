package com.proshomon.elasticsearch.nokkhotroelastic.hospital.rowmapper;

import com.proshomon.elasticsearch.nokkhotroelastic.hospital.SurgeriesService;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SurgeriesServiceRowMapper implements RowMapper<SurgeriesService> {

    @Override
    public SurgeriesService mapRow(ResultSet rs, int i) throws SQLException {
        SurgeriesService surgeriesService = new SurgeriesService();
        surgeriesService.setName(rs.getString("name"));
        surgeriesService.setFee(rs.getDouble("fee"));
        return surgeriesService;
    }
}
