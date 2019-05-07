package com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.rowmapper;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.ConsultationsService;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultationsServiceRowMapper implements RowMapper<ConsultationsService> {

    @Override
    public ConsultationsService mapRow(ResultSet rs, int i) throws SQLException {
        ConsultationsService consultationsService = new ConsultationsService();
        consultationsService.setName(rs.getString("name"));
        consultationsService.setCharge(rs.getDouble("fee"));
        return consultationsService;
    }
}
