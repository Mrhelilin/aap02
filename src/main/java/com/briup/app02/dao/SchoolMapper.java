package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.School;


public interface SchoolMapper {
	// 查询所有课程信息
		List<School> findAll();
		
		// 通过id查询课程信息
		School findById(long id);
		
		// 保存课程信息
		void save(School school);
		
		// 修改课程信息
		void update(School school);
		
		//删除课程信息
		void deleteById(long id);
}
