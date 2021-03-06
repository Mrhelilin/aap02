package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Questionnaire;
import com.briup.app02.dao.QuestionnaireMapper;
import com.briup.app02.service.IQuestionnaireService;

@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService {
	//注入QuestionnaireMapper 	让spring产生一个QuestionnaireMapper的对象，然后送过来
	@Autowired
	private QuestionnaireMapper questionnaireMapper;


	@Override
	public List<Questionnaire> findAll() throws Exception {
		return questionnaireMapper.findAll();
	}
	@Override
	public Questionnaire findById(long id) throws Exception {
		return questionnaireMapper.findById(id);

}
	@Override
	public void save(Questionnaire questionnaire) throws Exception {
		// TODO Auto-generated method stub
		questionnaireMapper.save(questionnaire);
	}
	@Override
	public void update(Questionnaire questionnaire) throws Exception {
		// TODO Auto-generated method stub
		 questionnaireMapper.update(questionnaire);
	}
	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		questionnaireMapper.deleteById(id);
	}
}