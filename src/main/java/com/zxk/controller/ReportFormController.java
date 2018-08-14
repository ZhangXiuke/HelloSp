package com.zxk.controller;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zxk.pojo.StudentVo;
import com.zxk.service.UserService;
import com.zxk.util.ExcelUtil;

@Controller
@RequestMapping("/Student")
public class ReportFormController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/getStudents")
	public void export(HttpServletRequest request,HttpServletResponse respone ) throws Exception{
		
		List<StudentVo> stu = userService.getStudents();
		String[][] content = new String[stu.size()][];
		//excel标题
        String[] title = {"名称","性别","年龄","学校","班级"};
        
        //excel文件名
        String fileName = "学生信息表"+System.currentTimeMillis()+".xls";
        
        String sheetName = "学生信息表";
        for(int i=0;i<stu.size();i++){
        	
        	content[i] = new String[title.length];
        	StudentVo obj = stu.get(i);
        	content[i][0] = obj.getName().toString();
        	content[i][1] = obj.getSex().toString();
        	content[i][2] = obj.getAge().toString();
        	content[i][3] = obj.getSchool().toString();
        	content[i][4] = obj.getClasses().toString();
        }
        
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);
        
        //响应到客户端
        try {
        	this.setResponseHeader(respone, fileName);
        	OutputStream os = respone.getOutputStream();
        	wb.write(os);
        	os.flush();
        	os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
	}
	
	public void setResponseHeader(HttpServletResponse response ,String fileName){
		try {
			try {
				fileName = new String(fileName.getBytes(),"ISO8859-1");
				
			} catch (UnsupportedEncodingException  e) {
				e.printStackTrace();
			}
			
			response.setContentType("application/octet-stream;charset=ISO8859-1");
			response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
			response.addHeader("Pargam", "no-cache");
			response.addHeader("Cache-Control", "no-cache");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 

}
