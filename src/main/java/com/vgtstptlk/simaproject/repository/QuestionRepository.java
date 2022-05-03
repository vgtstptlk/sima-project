package com.vgtstptlk.simaproject.repository;

import com.vgtstptlk.simaproject.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
