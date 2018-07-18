package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Clazz;

public interface ClazzMapper {
	// 查找所有班级信息
	List<Clazz> findAllClazz();
	
	// 查找班级信息通过ID
	Clazz findById(long id);
	
	// 保存班级信息
	void save(Clazz clazz);
			
	// 修改班级信息
	void update(Clazz clazz);
			
	//删除班级信息
	void deleteById(long id);
}
