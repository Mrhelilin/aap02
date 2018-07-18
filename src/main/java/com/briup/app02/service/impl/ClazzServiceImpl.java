package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Clazz;
import com.briup.app02.dao.ClazzMapper;
import com.briup.app02.dao.extend.ClazzVMMapper;
import com.briup.app02.service.IClazzService;
import com.briup.app02.vm.ClazzVM;

@Service
public class ClazzServiceImpl implements IClazzService {
	//注入ClazzMapper 	让spring产生一个ClazzMapper的对象，然后送过来
	@Autowired
	private ClazzMapper clazzMapper;
	@Autowired
	private ClazzVMMapper clazzVMMapper;

	@Override
	public List<Clazz> findAll() throws Exception {
		return clazzMapper.findAllClazz();
	}

	@Override
	public List<ClazzVM> findAllClazzVM() throws Exception {
		return clazzVMMapper.findAllClazzVM();
	}
	
	@Override
	public Clazz findById(long id) throws Exception{
		return clazzMapper.findById(id);
	}

	@Override
	public void save(Clazz clazz) throws Exception {
		// TODO Auto-generated method stub
		clazzMapper.save(clazz);
	
	}

	@Override
	public void update(Clazz clazz) throws Exception {
		// TODO Auto-generated method stub
		clazzMapper.update(clazz);
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		
				Clazz clazz = clazzMapper.findById(id);
				
				if(clazz!=null){
					clazzMapper.deleteById(id);
				} else {
					throw new Exception("要删除的学生不存在");
				}

	}

}
