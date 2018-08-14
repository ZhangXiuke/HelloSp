package com.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zxk.dao.UserDao;
import com.zxk.pojo.UserVo;

public class TestMyBatisSpring {

	@Test
	public void test(){
		
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		UserDao userDao = ctx.getBean(UserDao.class);
		List<UserVo> user = userDao.getAllUser();
		for(UserVo u : user){
			System.out.println(u.getName());
		}
	}

}
