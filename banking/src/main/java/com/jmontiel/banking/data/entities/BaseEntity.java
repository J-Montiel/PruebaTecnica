package com.jmontiel.banking.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false, unique = true, updatable = false)
    private Integer id;

    @JsonProperty("id")
    @Column(name = "public_id", nullable = false, updatable = false, unique = true)
    private String publicId;

    @PrePersist
    public void prePersist() {
        setPublicId(UUID.randomUUID().toString());
    }
}
