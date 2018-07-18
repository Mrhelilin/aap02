package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Course;
import com.briup.app02.service.ICourseService;
import com.briup.app02.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="课程相关接口")
@RestController
@RequestMapping("/course")
public class CourseController {
	// 注入studentService的实例
	@Autowired
	private ICourseService courseService;
	
	@ApiOperation(value="删除课程 通过ID")
	@GetMapping("deleteCourseById")
	public MsgResponse deleteCourseById(long id){
		try {
			
			courseService.deleteById(id);
			
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
		
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="更新课程")
	@PostMapping("updateCourse")
	public String updateCourse(Course course){
		try {
			courseService.update(course);
			return "修改成功！";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	@ApiOperation(value="保存课程")
	@PostMapping("saveCourse")
	public void saveCourse(Course course){
		try {
			courseService.save(course);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ApiOperation(value="查询所有课程")
	@GetMapping("findAllCourse")
	public MsgResponse findAllCourse(){
		try {
			List<Course> list = courseService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="查找课程 通过ID")
	@GetMapping("findCourseById")
	public Course findCourseById(long id){
		try {
			Course course = courseService.findById(id);
			return course;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}













