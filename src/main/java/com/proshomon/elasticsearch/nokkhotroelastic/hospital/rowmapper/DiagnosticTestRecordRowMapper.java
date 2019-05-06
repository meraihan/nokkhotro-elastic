package com.proshomon.elasticsearch.nokkhotroelastic.hospital.rowmapper;

import com.proshomon.elasticsearch.nokkhotroelastic.hospital.DiagnosticTestRecord;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DiagnosticTestRecordRowMapper  implements RowMapper<DiagnosticTestRecord> {

    @Override
    public DiagnosticTestRecord mapRow(ResultSet rs, int i) throws SQLException {
        DiagnosticTestRecord diagnosticTestRecord = new DiagnosticTestRecord();
        diagnosticTestRecord.setId(rs.getString("id"));
        diagnosticTestRecord.setName(rs.getString("name"));
        return diagnosticTestRecord;
    }
}
