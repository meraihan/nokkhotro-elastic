package com.proshomon.elasticsearch.nokkhotroelastic.model.model_old.rowmapper;


import com.proshomon.elasticsearch.nokkhotroelastic.model.model_old.Division;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DivisionRowMapper implements RowMapper<Division> {
    @Override
    public Division mapRow(ResultSet rs, int i) throws SQLException {
        Division division = new Division();
        division.setId(rs.getInt("id"));
        division.setCode(rs.getInt("Code"));
        division.setName(rs.getString("Name"));
        return division;
    }
}
