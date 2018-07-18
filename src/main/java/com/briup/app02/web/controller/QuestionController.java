package com.briup.app02.web.controller;
 
 import java.util.List;
 
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;
 
 import com.briup.app02.service.IQuestionService;
 import com.briup.app02.util.MsgResponse;
 import com.briup.app02.vm.QuestionVM;
 
 import io.swagger.annotations.Api;
 import io.swagger.annotations.ApiOperation;
 
 @Api(description="题库相关接口")
 @RestController
 @RequestMapping("/question")
 public class QuestionController {
 	@Autowired
 	private IQuestionService questionService;
 	
 	@ApiOperation(value="保存问题",notes="保存的同时保存问题选项,id不需要输入")
 	@PostMapping("savaQuestion")
 	public MsgResponse saveQuestion(QuestionVM questionVM)
 	{
 		try {
 			
 			
 			return MsgResponse.success("保存成功", questionVM);
			
		} catch (Exception e) {
			// TODO: handle exception
			return MsgResponse.error(e.getMessage());
		}
 	
 	}
 	
 	@ApiOperation(value="查询所有问题",notes="级联查询出属于该题目的选项")
 	@GetMapping("findAllQuestionVM")
 	public MsgResponse findAllQuestionVM(){
 		try {
 			List<QuestionVM> list = questionService.findAllQuestionVM();
 			return MsgResponse.success("success", list);
 		} catch (Exception e) {
 			e.printStackTrace();
 			return MsgResponse.error(e.getMessage());
 		}
 	}
 }