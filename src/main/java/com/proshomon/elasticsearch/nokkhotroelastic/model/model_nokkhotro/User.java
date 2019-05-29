package com.proshomon.elasticsearch.nokkhotroelastic.model.model_nokkhotro;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private Integer id;
    private String fullName;
    private String username;
    private String password;
    private String phone;
    private String email;
//    private List<UserRoles> authorities;
//    List<GrantedAuthority> grantedAuthorities;
    private LocalDateTime lastPasswordResetDate;
    private Boolean isEnabled;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
