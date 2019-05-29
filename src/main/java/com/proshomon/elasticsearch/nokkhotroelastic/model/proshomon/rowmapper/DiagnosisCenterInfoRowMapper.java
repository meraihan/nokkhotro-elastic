package com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.rowmapper;

import com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.DiagnosticCenter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DiagnosisCenterInfoRowMapper implements RowMapper<DiagnosticCenter> {

    @Override
    public DiagnosticCenter mapRow(ResultSet rs, int i) throws SQLException {
        DiagnosticCenter diagnosisCenterInfo = new DiagnosticCenter();
        return diagnosisCenterInfo;
    }
}
