package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.School;
import com.briup.app02.dao.SchoolMapper;
import com.briup.app02.service.ISchoolService;

@Service
public class SchoolServiceImpl implements ISchoolService {
	@Autowired
	private SchoolMapper schoolMapper;
	
	
	@Override
	public List<School> findAll() throws Exception {
		List<School> list = schoolMapper.findAll();
		return list;
	}


	@Override
	public School findById(long id) throws Exception {
		return schoolMapper.findById(id);
	}


	@Override
	public void save(School school) throws Exception {
		schoolMapper.save(school);
	}


	@Override
	public void update(School school) throws Exception {
		schoolMapper.update(school);
	}


	@Override
	public void deleteById(long id) throws Exception {
		School school = schoolMapper.findById(id);
		if(school!=null){
			schoolMapper.deleteById(id);
		} else {
			throw new Exception("要删除的学校不存在");
		}
		
		
	}
}
