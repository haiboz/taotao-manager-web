package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.service.ContentCategoryService;

/**
 * 内容管理
 * @author 浮生若梦
 * 2016年10月18日 下午4:47:37
 */
@Controller
@RequestMapping("content/category")
public class ContentCategoryController {
	@Autowired 
	private ContentCategoryService contentCategoryServiceImpl;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EUTreeNode> getList(@RequestParam(value="id",defaultValue="0") Long parentId){
		List<EUTreeNode> list = contentCategoryServiceImpl.getCategoryList(parentId);
		return list;
		
		
	}
	
	
	
}
