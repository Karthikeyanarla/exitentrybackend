package com.iitgn.entryexit.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

        ;

@Setter
@Getter
@Entity
@Table(name = "roles")
public class Role {

    @Id
    private long id;

    @Column(length = 60)
    private String name;
}
