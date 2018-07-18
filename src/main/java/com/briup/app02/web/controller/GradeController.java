package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Grade;
import com.briup.app02.service.IGradeService;
import com.briup.app02.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="年级相关接口")
@RestController
@RequestMapping("/grade")
public class GradeController {
	// 注入gradeService的实例
	@Autowired
	private IGradeService gradeService;
	
	@ApiOperation(value="删除课程信息 通过ID")
	@GetMapping("deleteGradeById")
	public MsgResponse deleteGradeById(long id){
		try {
		
			gradeService.deleteById(id);
		
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
		
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="更新年级信息")
	@PostMapping("updateGrade")
	public String updateGrade(Grade grade){
		try {
			gradeService.update(grade);
			return "修改成功！";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	@ApiOperation(value="保存年级信息")
	@PostMapping("saveGrade")
	public void saveCourse(Grade grade){
		try {
			gradeService.save(grade);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ApiOperation(value="查询所有年级信息")
	@GetMapping("findAllGrade")
	public MsgResponse findAllGrade(){
		try {
			List<Grade> list = gradeService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="查找年级信息 通过ID")
	@GetMapping("findGradeById")
	public Grade findGradeById(long id){
		try {
			Grade course = gradeService.findById(id);
			return course;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}













