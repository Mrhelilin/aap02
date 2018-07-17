package com.briup.app02.service;

import java.util.List;

import com.briup.app02.bean.Questionnaire;

public interface IQuestionnaireService {
	List<Questionnaire> findAll() throws Exception;
	
	
}
