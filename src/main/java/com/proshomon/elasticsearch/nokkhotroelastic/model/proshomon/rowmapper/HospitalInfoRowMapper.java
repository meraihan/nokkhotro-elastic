package com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.rowmapper;

import com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.Hospital;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HospitalInfoRowMapper implements RowMapper<Hospital> {

    @Override
    public Hospital mapRow(ResultSet rs, int i) throws SQLException {
        Hospital hospitalInfo = new Hospital();
        return hospitalInfo;
    }
}
