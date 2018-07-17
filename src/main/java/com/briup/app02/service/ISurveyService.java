package com.briup.app02.service;

import java.util.List;

import com.briup.app02.bean.Survey;
import com.briup.app02.vm.SurveyVM;

public interface ISurveyService {
	List<Survey> findAll() throws Exception;
	
	List<SurveyVM> findAllSurveyVM() throws Exception;
}
