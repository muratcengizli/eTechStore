package com.techstore.estore.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "uuid", updatable = false, nullable = false)
    private String uuid;

    @CreationTimestamp
    private Timestamp createTime;

    private Timestamp updateTime;
    private Timestamp deleteTime;

    @Builder.Default
    private Boolean isDeleted = false;
    private String deletedReason;

    @Version
    private int version;
}
