package com.university.crud.springbootcrudrest.model.base;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity implements Serializable {

    @Column(name = "created_on", updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime createdOn;

    @Column(name = "modified_on", updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime modifiedOn;

    @PrePersist
    public void preInsert() {
        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
        createdOn = now;
        modifiedOn = now;
    }

    @PreUpdate
    public void preUpdate() {
        modifiedOn = OffsetDateTime.now(ZoneOffset.UTC);
    }

}
