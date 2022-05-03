package com.vgtstptlk.simaproject.service;

import com.vgtstptlk.simaproject.entity.Question;
import com.vgtstptlk.simaproject.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> getQuestions(){
        return questionRepository.findAll();
    }

    public List<Question> addQuestions(List<Question> questions) {
        return questionRepository.saveAll(questions);
    }

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }
}
