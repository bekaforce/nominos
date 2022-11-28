package com.example.choice_of_name.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "language", schema = "choice")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "language_seq")
    @SequenceGenerator(name = "language_seq", initialValue = 1, allocationSize = 1, sequenceName = "language_id_seq")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "language")
    @JsonIgnore
    private List<Name> names;
}
