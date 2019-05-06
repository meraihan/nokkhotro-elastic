package com.proshomon.elasticsearch.nokkhotroelastic.model_old.rowmapper;

import com.proshomon.elasticsearch.nokkhotroelastic.model_old.Municipality;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MunicipalityRowMapper implements RowMapper<Municipality> {
    @Override
    public Municipality mapRow(ResultSet rs, int i) throws SQLException {
        Municipality municipality = new Municipality();
        municipality.setId(rs.getInt("Id"));
        municipality.setUpazillaId(rs.getInt("upazilla_id"));
        municipality.setCode(rs.getInt("municipality_code"));
        municipality.setName(rs.getString("municipaliti_name"));
        return municipality;
    }
}
