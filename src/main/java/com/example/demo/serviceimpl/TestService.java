package com.example.demo.serviceimpl;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Question;
import com.example.demo.domain.enums.QuestionStatus;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.service.ITestService;

@Service
public class TestService implements ITestService {

	@Autowired
	private QuestionRepository questionRepository;
	@Override
	public void SaveQuestion(Question question) {
		// TODO Auto-generated method stub
		question.setStatus(QuestionStatus.New);
		questionRepository.save(question);
	}
	@Override
	public void editQuestion(Question question) throws Exception {
		// TODO Auto-generated method stub
		Question questionInDb = questionRepository.getOne(question.getId());
		if(questionInDb.getStatus() == QuestionStatus.New)
			questionRepository.save(question);
		else
			throw new Exception("Statusu yeni deyil");
	}
	@Override
	public void removeQuestion(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Question question = questionRepository.getOne(id);
		if(question.getStatus() == QuestionStatus.New)
			questionRepository.delete(question);
		else
			throw new Exception("Statusu yeni deyil");
	}
	@Override
	public Set<Question> getNewQuestions() {
		// TODO Auto-generated method stub
		return questionRepository.findByStatus(QuestionStatus.New);
	}
	
	public Set<Question> getApprovedQuestions() {
		// TODO Auto-generated method stub
		return questionRepository.findByStatus(QuestionStatus.Approved);
	}
	@Override
	public void removeApprovedQuestion(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Question question = questionRepository.getOne(id);
		if(question.getStatus() == QuestionStatus.Approved)
			questionRepository.delete(question);
		else
			throw new Exception("Statusu təsdiqlənmiş deyil");
	}

}
