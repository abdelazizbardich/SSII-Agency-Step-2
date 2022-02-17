package com.ssiiagency.entities;

import org.springframework.stereotype.Component;

import javax.persistence.*;
@Entity(name = "role")
@Component
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_role", nullable = false)
    private Long id_role;

    public Long getId_role() {
        return id_role;
    }

    @Column(name = "name")
    private String name;

    public Role() {
    }

    public Role(String name) {
        this.id_role = id_role;
        this.name = name;
    }

    public void setId_role(Long id_role) {
        this.id_role = id_role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id_role=" + id_role +
                ", name='" + name + '\'' +
                '}';
    }
}
