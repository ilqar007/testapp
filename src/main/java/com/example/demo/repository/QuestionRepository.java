package com.example.demo.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Question;
import com.example.demo.domain.enums.QuestionStatus;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer>  {

	Set<Question> findByStatus(QuestionStatus status);

}
