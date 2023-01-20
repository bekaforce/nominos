package com.example.choice_of_name.repo;

import com.example.choice_of_name.dto.NameDto;
import com.example.choice_of_name.model.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NameRepo extends JpaRepository<Name, Long> {
    @Query(value = "select n.title, n.description from choice.name n " +
            "where n.country_id = :country_id " +
            "and n.gender_id = :gender_id " +
            "and n.language_id = :language_id", nativeQuery = true)
    List<NameDto> searchAllByCountryGenderAndLanguage(@Param(value = "country_id") Long country_id, @Param(value = "gender_id") Long gender_id, @Param(value = "language_id") Long language_id);

    Name findNameById(Long id);


    @Query(value = "select n.title, n.description from choice.name n " +
            "where n.language_id = :language_id " +
            "order by n.title", nativeQuery = true)
    List<NameDto> findAllByLanguageAndOrderByTitle(Long language_id);
}
