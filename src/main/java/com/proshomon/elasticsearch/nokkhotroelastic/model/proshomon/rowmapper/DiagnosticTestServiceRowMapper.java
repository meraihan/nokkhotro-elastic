package com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.rowmapper;

import com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.DiagnosticTests;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DiagnosticTestServiceRowMapper implements RowMapper<DiagnosticTests> {


    @Override
    public DiagnosticTests mapRow(ResultSet rs, int i) throws SQLException {
        DiagnosticTests diagnosticTestsService = new DiagnosticTests();
        diagnosticTestsService.setId(rs.getString("es_id"));
        diagnosticTestsService.setName(rs.getString("name"));
        diagnosticTestsService.setPrice(rs.getBigDecimal("fee"));
        return diagnosticTestsService;
    }
}
