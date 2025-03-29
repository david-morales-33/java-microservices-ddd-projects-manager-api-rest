package com.microservice.media.role.infrastructure.persistence.hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_role")
public class RoleEntity {
    @Id
    @Column(name = "rol_id", length = 36)
    private String id;

    @Column(name = "rol_name", length = 50, nullable = false)
    private String name;

    @Column(name = "rol_description", length = 100, nullable = false)
    private String description;

    public RoleEntity() {
    }

    public RoleEntity(String name, String id, String description) {
        this.name = name;
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
