package io.khasang.genelove.entity;

import javax.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(length = 1255)
    private String question;

    @Column(length = 1255)
    private String correctAnswers;

    @Column(length = 1255)
    private String answer1;

    @Column(length = 1255)
    private String answer2;

    @Column(length = 1255)
    private String answer3;

    @Column(length = 1255)
    private String answer4;

    public Question() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }