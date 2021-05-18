package com.example.demo.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Question;
import com.example.demo.service.ITestService;



@Controller
@RequestMapping("tests")
public class TestsController {

	@Autowired
	private ITestService testService;
    @CrossOrigin("*")
    @PostMapping("/addQuestion")
    @ResponseBody
    public ResponseEntity saveQuestion(@RequestBody Question question) {
    	testService.SaveQuestion(question);
    	return new ResponseEntity(HttpStatus.CREATED);
    }
    
    @CrossOrigin("*")
    @PostMapping("/updateQuestion")
    @ResponseBody
    public ResponseEntity editQuestion(@RequestBody Question question) throws Exception {
    	testService.editQuestion(question);
    	return new ResponseEntity(HttpStatus.OK);
    }
    
    @CrossOrigin("*")
    @DeleteMapping("/deleteQuestion")
    @ResponseBody
    public ResponseEntity removeQuestion(@RequestParam("id") Integer id) throws Exception {
    	testService.removeQuestion(id);
    	return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    
    @CrossOrigin("*")
    @DeleteMapping("/deleteApprovedQuestion")
    @ResponseBody
    public ResponseEntity removeApprovedQuestion(@RequestParam("id") Integer id) throws Exception {
    	testService.removeApprovedQuestion(id);
    	return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    
    @CrossOrigin("*")
    @GetMapping("/getNewQuestions")
    @ResponseBody
    public Set<Question> getNewQuestions() {
    	return testService.getNewQuestions();    	
    }
    
    @CrossOrigin("*")
    @GetMapping("/getApprovedQuestions")
    @ResponseBody
    public Set<Question> getApprovedQuestions() {
    	return testService.getApprovedQuestions();    	
    }  
}
