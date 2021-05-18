package com.example.demo.service;

import java.util.Set;

import com.example.demo.domain.Question;

public interface ITestService {
void SaveQuestion(Question question);

void editQuestion(Question question) throws Exception;

void removeQuestion(Integer id) throws Exception;

Set<Question> getNewQuestions();

Set<Question> getApprovedQuestions();

void removeApprovedQuestion(Integer id) throws Exception;
}
