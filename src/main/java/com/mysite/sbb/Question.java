package com.mysite.sbb;

import java.time.LocalDateTime;
import java.util.List;

import com.mysite.sbb.Answer;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @ManyToOne
    private Question question;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
}