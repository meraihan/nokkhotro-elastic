package com.proshomon.elasticsearch.nokkhotroelastic.hospital.rowmapper;

import com.proshomon.elasticsearch.nokkhotroelastic.hospital.DiagnosisCenterInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DiagnosisCenterInfoRowMapper implements RowMapper<DiagnosisCenterInfo> {

    @Override
    public DiagnosisCenterInfo mapRow(ResultSet rs, int i) throws SQLException {
        DiagnosisCenterInfo diagnosisCenterInfo = new DiagnosisCenterInfo();
        diagnosisCenterInfo.setName(rs.getString("name"));
        return diagnosisCenterInfo;
    }
}
