package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.service.ContentService;

@Controller
@RequestMapping("content/query")
public class ContentController {
		
	@Autowired 
	private ContentService contentServiceImpl;

	/**
	 * 获取一个内容分类下的内容列表
	 * @param categoryId
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getContentList( Long categoryId,int page,int rows){
		EUDataGridResult result = contentServiceImpl.getContentList(categoryId,page,rows);
		return result;
	}
	
}
