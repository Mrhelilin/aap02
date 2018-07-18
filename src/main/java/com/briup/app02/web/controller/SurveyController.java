package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Survey;
import com.briup.app02.service.ISurveyService;
import com.briup.app02.util.MsgResponse;
import com.briup.app02.vm.SurveyVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="调查相关接口")
@RestController
@RequestMapping("/survey")
public class SurveyController {
	//注入service层的对象
	@Autowired
	private ISurveyService surveyService ;
	
	@ApiOperation(value="查询所有调查"
			,notes="只能查询出调查信息，并且级联查询到班级，课程和老师,问卷")
	@GetMapping("findAllSurveyVM")
	public MsgResponse findAllSurveyVM(){
		try {
			List<SurveyVM> list = surveyService.findAllSurveyVM();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	// http://ip:port/survey/findAllSurvey
	@ApiOperation(value="查询所有调查"
			,notes="只能查询出调查的基本信息，无法级联查询到班级，课程和老师,问卷")
	@GetMapping("findAllSurvey")
	public MsgResponse findAllSurvey(){
		try {
			List<Survey> list = surveyService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="删除调查 通过ID")
	@PostMapping("deleteSurveyById")
	public MsgResponse deleteSurveyById(long id){
		try {
			
			surveyService.deleteById(id);
		
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
	
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="更新调查")
	@PostMapping("updateSurvey")
	public MsgResponse updateSurvey(Survey survey){
		try {
			surveyService.update(survey);
			return MsgResponse.success("更新成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="保存调查")
	@PostMapping("saveSurvey")
	public MsgResponse saveCourse(Survey survey){
		try {
			surveyService.save(survey);
			return MsgResponse.success("保存成功！", null);
			
		} catch (Exception e) {
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="查找调查通过ID")
	@GetMapping("findSurveyById")
	public MsgResponse findSurveyById(long id){
		try {
			Survey survey = surveyService.findById(id);
			return MsgResponse.success("查找成功！", survey);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
