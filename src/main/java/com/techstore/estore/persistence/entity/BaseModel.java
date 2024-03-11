package com.techstore.estore.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.sql.Timestamp;

@MappedSuperclass
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "uuid", updatable = false, nullable = false)
    private String uuid;

    private Timestamp createTime = new Timestamp(System.currentTimeMillis());
    private Timestamp updateTime = null;
    private Timestamp deleteTime = null;
    private Boolean isDeleted = false;
    private String deletedReason = null;

    @Version
    private int version;

    public BaseModel(){}

    public BaseModel(Long id, String uuid, Timestamp createTime, Timestamp updateTime, Timestamp deleteTime, Boolean isDeleted, String deletedReason, int version) {
        this.id = id;
        this.uuid = uuid;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleteTime = deleteTime;
        this.isDeleted = isDeleted;
        this.deletedReason = deletedReason;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Timestamp getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Timestamp deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public String getDeletedReason() {
        return deletedReason;
    }

    public void setDeletedReason(String deletedReason) {
        this.deletedReason = deletedReason;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
