package com.example.choice_of_name.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "gender", schema = "choice")
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gender_seq")
    @SequenceGenerator(name = "gender_seq", initialValue = 1, allocationSize = 1, sequenceName = "gender_id_seq")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "gender")
    @JsonIgnore
    private List<Name> names;
}