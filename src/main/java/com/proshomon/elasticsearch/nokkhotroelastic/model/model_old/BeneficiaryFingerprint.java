package com.proshomon.elasticsearch.nokkhotroelastic.model.model_old;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BeneficiaryFingerprint {
    private Integer id;
    private Beneficiary beneficiary;
    private FingerprintType fingerprintType;
    private String fingerprintLocation;
    private byte[] fingerImage;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public enum FingerprintType {
        PRIMARY, SECONDARY
    }
}
