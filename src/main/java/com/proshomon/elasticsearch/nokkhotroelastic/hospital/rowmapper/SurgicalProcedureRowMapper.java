package com.proshomon.elasticsearch.nokkhotroelastic.hospital.rowmapper;

import com.proshomon.elasticsearch.nokkhotroelastic.hospital.SurgicalProceduresRecord;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SurgicalProcedureRowMapper  implements RowMapper<SurgicalProceduresRecord> {

    @Override
    public SurgicalProceduresRecord mapRow(ResultSet rs, int i) throws SQLException {
        SurgicalProceduresRecord surgicalProceduresRecord = new SurgicalProceduresRecord();
        surgicalProceduresRecord.setId(rs.getString("id"));
        surgicalProceduresRecord.setName(rs.getString("name"));
        return surgicalProceduresRecord;
    }
}
