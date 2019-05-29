package com.proshomon.elasticsearch.nokkhotroelastic.model.nokkhotro;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserSession {
    private Long sessionId;
    private Integer userId;
    private Boolean isSessionValid;
    private String phoneNumber;
    private LocalDateTime createdDate;
    private LocalDateTime expiredDate;
}
