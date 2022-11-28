package com.example.choice_of_name.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "name", schema = "choice")
public class Name {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "name_seq")
    @SequenceGenerator(name = "name_seq", initialValue = 1, allocationSize = 1, sequenceName = "name_id_seq")
    private Long id;
    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @JsonIgnore
    private Category category;
    @ManyToOne
    @JoinColumn(name = "gender_id", referencedColumnName = "id")
    @JsonIgnore
    private Gender gender;
    @ManyToOne
    @JoinColumn(name = "language_id", referencedColumnName = "id")
    @JsonIgnore
    private Language language;
}
