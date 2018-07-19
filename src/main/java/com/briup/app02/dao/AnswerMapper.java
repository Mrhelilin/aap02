package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Answer;
import com.briup.app02.bean.Survey;


public interface AnswerMapper {
		// 查询所有答案信息
		List<Answer> findAll();
		
		// 通过id查询答案信息
		Answer findById(long id);
		
		// 保存答案信息
		void save(Answer answer);
		
		// 修改答案信息
		void update(Answer answer);
		
		//删除答案信息
		void deleteById(long id);
		
		List<Survey> findBySurveyId(long id); 
}
