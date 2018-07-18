package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Survey;
import com.briup.app02.dao.SurveyMapper;
import com.briup.app02.dao.extend.SurveyVMMapper;
import com.briup.app02.service.ISurveyService;
import com.briup.app02.vm.SurveyVM;

@Service
public class SurveyServiceImpl implements ISurveyService {
	//注入SurveyMapper 	让spring产生一个SurveyMapper的对象，然后送过来
	@Autowired
	private SurveyMapper surveyMapper;
	@Autowired
	private SurveyVMMapper surveyVMMapper;

	@Override
	public List<Survey> findAll() throws Exception {
		return surveyMapper.findAll();
	}

	@Override
	public List<SurveyVM> findAllSurveyVM() throws Exception {
		return surveyVMMapper.findAllSurveyVM();
	}

	@Override
	public Survey findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return surveyMapper.findById(id);
	}

	@Override
	public void save(Survey survey) throws Exception {
		// TODO Auto-generated method stub
		surveyMapper.save(survey);
	}

	@Override
	public void update(Survey survey) throws Exception {
		// TODO Auto-generated method stub
		 surveyMapper.update(survey);
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		 surveyMapper.deleteById(id);
	}

}
