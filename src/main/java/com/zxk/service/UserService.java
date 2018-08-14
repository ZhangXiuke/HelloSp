package com.zxk.service;

import java.util.List;

import com.zxk.pojo.StudentVo;
import com.zxk.pojo.UserVo;

public interface UserService {
	
	public List<UserVo> getAllUser();
	
	public List<StudentVo> getStudents();
}
