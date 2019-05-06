package com.proshomon.elasticsearch.nokkhotroelastic.model_old;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Role {
    private Integer id;
    private RoleName roleName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public enum RoleName{
        ADMIN, USER
    }
}
