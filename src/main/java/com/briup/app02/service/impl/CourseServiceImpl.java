package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Course;
import com.briup.app02.dao.CourseMapper;
import com.briup.app02.service.ICourseService;

@Service
public class CourseServiceImpl implements ICourseService {
	@Autowired
	private CourseMapper courseMapper;
	
	
	@Override
	public List<Course> findAll() throws Exception {

		List<Course> list = courseMapper.findAll();
		
		return list;
	}


	@Override
	public Course findById(long id) throws Exception {
		return courseMapper.findById(id);
	}


	@Override
	public void save(Course course) throws Exception {
		courseMapper.save(course);
	}


	@Override
	public void update(Course course) throws Exception {
		courseMapper.update(course);
	}


	@Override
	public void deleteById(long id) throws Exception {
		
		Course course = courseMapper.findById(id);
	
		if(course!=null){
			courseMapper.deleteById(id);
		} else {
			throw new Exception("要删除的课程不存在");
		}
		
		
	}
}
