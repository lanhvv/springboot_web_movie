package com.example.demo.domain;

import jakarta.persistence.*;

@Entity(name = "typ")
@Table(name = "typ")
public class Typ extends CommonTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public Typ() {
    }

    public Typ(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
