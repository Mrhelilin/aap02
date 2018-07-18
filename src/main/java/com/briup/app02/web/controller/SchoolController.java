package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.School;
import com.briup.app02.service.ISchoolService;
import com.briup.app02.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="学校相关接口")
@RestController
@RequestMapping("/school")
public class SchoolController {
	
	@Autowired
	private ISchoolService schoolService;
	
	@ApiOperation(value="删除学校信息")
	@GetMapping("deleteSchoolById")
	public MsgResponse deleteSchoolById(long id){
		try {
			
			schoolService.deleteById(id);
			
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
			
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="更新学校信息")
	@PostMapping("updateSchool")
	public MsgResponse updateSchool(School school){
		try {
			schoolService.update(school);
			return MsgResponse.success("更新成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="保存学校信息")
	@PostMapping("saveSchool")
	public MsgResponse saveSchool(School school){
		try {
			schoolService.save(school);
			return MsgResponse.success("保存成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="查询所有学校信息")
	@GetMapping("findAllSchool")
	public MsgResponse findAllSchool(){
		try {
			List<School> list = schoolService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="查找学校信息 通过ID")
	@GetMapping("findSchoolById")
	public MsgResponse findSchoolById(long id){
		try {
			School school = schoolService.findById(id);
			return MsgResponse.success("删除成功！", school);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
}













