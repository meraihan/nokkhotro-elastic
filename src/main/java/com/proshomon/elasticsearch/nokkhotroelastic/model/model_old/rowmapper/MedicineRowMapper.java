package com.proshomon.elasticsearch.nokkhotroelastic.model.model_old.rowmapper;

import com.proshomon.elasticsearch.nokkhotroelastic.model.model_proshomon.Medicines;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicineRowMapper implements RowMapper<Medicines> {
    @Override
    public Medicines mapRow(ResultSet rs, int i) throws SQLException {
        Medicines medicines = new Medicines();
        medicines.setId(rs.getString("id"));
        medicines.setManufacturer(rs.getString("manufacturer"));
        medicines.setBrand(rs.getString("brand"));
        medicines.setGenericName(rs.getString("genericName"));
        medicines.setStrength(rs.getString("strength"));
        medicines.setMedicineType(rs.getString("medicineType"));
        medicines.setMrp(rs.getString("mrp"));
        return medicines;
    }

}
