package com.iitgn.entryexit.entities;


import com.iitgn.entryexit.models.EntryExit;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
public class Record {

    @Id
    private String id;

    private String name;

    @Enumerated(EnumType.ORDINAL)
    private EntryExit type;
}
