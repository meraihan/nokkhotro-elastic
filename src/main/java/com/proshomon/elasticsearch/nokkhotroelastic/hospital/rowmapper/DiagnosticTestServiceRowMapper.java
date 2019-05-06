package com.proshomon.elasticsearch.nokkhotroelastic.hospital.rowmapper;

import com.proshomon.elasticsearch.nokkhotroelastic.hospital.DiagnosticTestsService;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DiagnosticTestServiceRowMapper implements RowMapper<DiagnosticTestsService> {


    @Override
    public DiagnosticTestsService mapRow(ResultSet rs, int i) throws SQLException {
        DiagnosticTestsService diagnosticTestsService = new DiagnosticTestsService();
        diagnosticTestsService.setName(rs.getString("name"));
        diagnosticTestsService.setFee(rs.getDouble("fee"));
        return diagnosticTestsService;
    }
}
