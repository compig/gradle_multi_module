package com.coldbrew.common.domain;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Embeddable
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Audit {

    @Column(length = 50, updatable = false)
    private String createdBy; // 등록자 아이디

    @Column(length = 50)
    private String updatedBy; // 수정자 아이디

    @Column(updatable = false)
    private LocalDateTime createdAt; // 등록일시

    private LocalDateTime updatedAt; // 수정일시

    @PrePersist
    public void prePersist() {
        if (createdAt == null) createdAt = LocalDateTime.now();
        this.preUpdate();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

}
