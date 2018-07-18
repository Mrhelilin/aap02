package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.User;
import com.briup.app02.service.IUserService;
import com.briup.app02.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="用户相关接口")
@RestController
@RequestMapping("/user")
public class UserController {
	// 注入userService的实例
	@Autowired
	private IUserService userService;
	
	@ApiOperation(value="删除用户 通过ID")
	@GetMapping("deleteUserById")
	public MsgResponse deleteUserById(long id){
		try {
			userService.deleteById(id);
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="更新用户")
	@PostMapping("updateUser")
	public MsgResponse updateUser(User user){
		try {
			userService.update(user);
			return MsgResponse.success("更新成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="保存用户")
	@PostMapping("saveUser")
	public MsgResponse saveUser(User user){
		try {
			userService.save(user);
			return MsgResponse.success("保存成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	
	@ApiOperation(value="查询所有用户")
	@GetMapping("findAllUser")
	public MsgResponse findAllUser(){
		try {
			List<User> list = userService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="查找用户 通过ID")
	@GetMapping("findUserById")
	public MsgResponse findUserById(long id){
		try {
			User user = userService.findById(id);
			return MsgResponse.success("查找成功！", user);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
}













