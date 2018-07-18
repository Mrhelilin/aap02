package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Clazz;
import com.briup.app02.service.IClazzService;
import com.briup.app02.util.MsgResponse;
import com.briup.app02.vm.ClazzVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="班级相关接口")
@RestController
@RequestMapping("/clazz")
public class ClazzController {
	//注入service层的对象
	@Autowired
	private IClazzService clazzService ;
	
	@ApiOperation(value="查询所有班级",notes="只能查询出班级信息，并且级联查询到年级和班主任")
	@GetMapping("findAllClazzVM")
	public MsgResponse findAllClazzVM(){
		try {
			List<ClazzVM> list = clazzService.findAllClazzVM();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	
	@ApiOperation(value="查询所有班级",notes="只能查询出班级的基本信息，无法级联查询到年级和班主任")
	@GetMapping("findAllClazz")
	public MsgResponse findAllClazz(){
		try {
			List<Clazz> list = clazzService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="删除班级 通过ID")
	@PostMapping("deleteClazzById")
	public MsgResponse deleteClazzById(long id){
		try {
			// 调用service层代码删除答案信息
			clazzService.deleteById(id);
			// 如果删除成功返回成功信息
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
			// 先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端开发者知道错误所在
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="更新班级")
	@PostMapping("updateClazz")
	public MsgResponse updateClazz(Clazz clazz){
		try {
			clazzService.update(clazz);
			return MsgResponse.success("更新成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="保存班级")
	@PostMapping("saveClazz")
	public MsgResponse saveCourse(Clazz clazz){
		try {
			clazzService.save(clazz);
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value="查找班级通过ID")
	@GetMapping("findClazzById")
	public MsgResponse findClazzById(long id){
		try {
			Clazz clazz = clazzService.findById(id);
			return MsgResponse.success("查找成功", clazz);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
}
