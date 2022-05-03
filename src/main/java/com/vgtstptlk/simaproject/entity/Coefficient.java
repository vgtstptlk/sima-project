package com.vgtstptlk.simaproject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Coefficient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String name;

    @Column
    private Double coeff;

    @ManyToOne
    @JoinColumn(name = "answer_id", referencedColumnName = "id")
    @JsonBackReference
    private Answer answer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Answer getAnswer() {
        return answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCoeff() {
        return coeff;
    }

    public void setCoeff(Double coeff) {
        this.coeff = coeff;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
