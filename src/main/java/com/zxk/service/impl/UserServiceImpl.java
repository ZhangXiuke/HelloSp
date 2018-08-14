package com.zxk.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxk.dao.StudentDao;
import com.zxk.dao.UserDao;
import com.zxk.pojo.StudentVo;
import com.zxk.pojo.UserVo;
import com.zxk.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserDao userDao; 
	
	@Resource
	private StudentDao studentDao;
	
	public List<UserVo> getAllUser() {
		return userDao.getAllUser();
	}


	public List<StudentVo> getStudents() {
		
		return studentDao.getStudents();
	}


}
