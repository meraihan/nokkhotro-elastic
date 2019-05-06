package com.proshomon.elasticsearch.nokkhotroelastic.model_old.rowmapper;


import com.proshomon.elasticsearch.nokkhotroelastic.model_old.Beneficiary;
import com.proshomon.elasticsearch.nokkhotroelastic.model_old.BeneficiaryFingerprint;
import com.proshomon.elasticsearch.nokkhotroelastic.utils.Helper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BeneficiaryFingerprintRowMapper implements RowMapper<BeneficiaryFingerprint> {

    @Override
    public BeneficiaryFingerprint mapRow(ResultSet rs, int i) throws SQLException {
        BeneficiaryFingerprint beneficiaryFingerprint = new BeneficiaryFingerprint();
        beneficiaryFingerprint.setId(rs.getInt("id"));
        Beneficiary beneficiary = new Beneficiary();
        beneficiary.setId(rs.getInt("beneficiary_id"));
        beneficiaryFingerprint.setBeneficiary(beneficiary);
        beneficiaryFingerprint.setFingerprintType(BeneficiaryFingerprint.FingerprintType.valueOf(rs.getString(
                "fingerprint_type")));
        beneficiaryFingerprint.setFingerprintLocation(rs.getString("fingerprint_location"));
        beneficiaryFingerprint.setCreatedAt(Helper.timeStampToLocalDateTime(rs.getTimestamp("created_at")));
        beneficiaryFingerprint.setUpdatedAt(Helper.timeStampToLocalDateTime(rs.getTimestamp("updated_at")));
        beneficiaryFingerprint.setDeletedAt(Helper.timeStampToLocalDateTime(rs.getTimestamp("deleted_at")));
        return beneficiaryFingerprint;
    }
}
