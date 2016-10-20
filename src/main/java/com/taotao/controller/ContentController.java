package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;

@Controller
@RequestMapping("content")
public class ContentController {
		
	@Autowired 
	private ContentService contentServiceImpl;

	/**
	 * 获取一个内容分类下的内容列表
	 * @param categoryId
	 * @return
	 */
	@RequestMapping("/query/list")
	@ResponseBody
	public EUDataGridResult getContentList( Long categoryId,int page,int rows){
		EUDataGridResult result = contentServiceImpl.getContentList(categoryId,page,rows);
		return result;
	}
	
	/**
	 * 新增内容
	 * @param tbCOntent
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult saveContent(TbContent tbContent){
		TaotaoResult result = contentServiceImpl.saveContent(tbContent);
		return result;
	}
	
	/**
	 * 修改内容
	 * @param tbContent
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public TaotaoResult editContent(TbContent tbContent){
		TaotaoResult result = contentServiceImpl.editContent(tbContent);
		return result;
	}
	
	/**
	 * 批量删除内容
	 * @param tbContent
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoResult deleteContent(String ids){
		TaotaoResult result = contentServiceImpl.deleteContent(ids);
		return result;
	}
	
	
	
	
	
}
