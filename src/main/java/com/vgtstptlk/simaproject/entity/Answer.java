package com.vgtstptlk.simaproject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String text;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Coefficient> coefficients;

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    @JsonBackReference
    private Question question;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Coefficient> getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(List<Coefficient> coefficients) {
        this.coefficients = coefficients;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
