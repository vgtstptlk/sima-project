package com.vgtstptlk.simaproject.controller;

import com.vgtstptlk.simaproject.entity.Question;
import com.vgtstptlk.simaproject.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Question> getQuestions(){
        return questionService.getQuestions();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Question> addQuestion(@RequestBody List<Question> questions) {
        return questionService.addQuestions(questions);
    }

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
}
