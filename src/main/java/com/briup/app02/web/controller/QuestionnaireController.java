package com.briup.app02.web.controller;
 
 import java.util.List;
 
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Questionnaire;
import com.briup.app02.service.IQuestionnaireService;
 import com.briup.app02.util.MsgResponse;

 
 import io.swagger.annotations.Api;
 import io.swagger.annotations.ApiOperation;
 
 @Api(description="问卷表相关接口")
 @RestController
 @RequestMapping("/questionnaire")
 public class QuestionnaireController {
 	@Autowired
 	private IQuestionnaireService questionnaireService;
 	
 	@ApiOperation(value="查询所有问卷表")
 	@GetMapping("findAllQuestionnaire")
 	public MsgResponse findAllQuestionnaire(){
 		try {
 			List<Questionnaire> list = questionnaireService.findAll();
 			return MsgResponse.success("success", list);
 		} catch (Exception e) {
 			e.printStackTrace();
 			return MsgResponse.error(e.getMessage());
 		}
 	}
 	
 	@ApiOperation(value="查询问卷表 通过ID")
 	@GetMapping("findQuestionnaireById")
 	public MsgResponse findQuestionnaireById(long id ){
 		try {
 			Questionnaire questionnaire = questionnaireService.findById(id);
 			return MsgResponse.success("success",questionnaire );
 		} catch (Exception e) {
 			e.printStackTrace();
 			return MsgResponse.error(e.getMessage());
 		}
 	}
 	
	@ApiOperation(value="删除问卷表 通过ID")
	@PostMapping("deleteQuestionnaireById")
	public MsgResponse deleteQuestionnaireById(long id){
		try {
			
			questionnaireService.deleteById(id);
		
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
	
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="更新问卷表")
	@PostMapping("updateQuestionnaire")
	public MsgResponse updateQuestionnaire(Questionnaire questionnaire){
		try {
			questionnaireService.update(questionnaire);
			return MsgResponse.success("更新成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="保存问卷表")
	@PostMapping("saveQuestionnaire")
	public MsgResponse saveCourse(Questionnaire questionnaire){
		try {
			questionnaireService.save(questionnaire);
			return MsgResponse.success("保存成功！", null);
			
		} catch (Exception e) {
			return MsgResponse.error(e.getMessage());
		}
	}
	
 }