package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.pojo.TaotaoResult;
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
	
	/**
	 * 查询内容分裂列表
	 * @param parentId
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public List<EUTreeNode> getList(@RequestParam(value="id",defaultValue="0") Long parentId){
		List<EUTreeNode> list = contentCategoryServiceImpl.getCategoryList(parentId);
		return list;
	}
	
	
	/**
	 * 新增内容分类
	 * @param parentId
	 * @param name
	 * @return
	 */
	@RequestMapping("/create")
	@ResponseBody
	public TaotaoResult insertContentCagegory( Long parentId,String name){
		TaotaoResult result = contentCategoryServiceImpl.insertContentCategory(parentId, name);
		return result;
	}
	
	/**
	 * 更新内容分类
	 * @param id
	 * @param name
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	public TaotaoResult updateContentCagegory( Long id,String name){
		TaotaoResult result = contentCategoryServiceImpl.updateContentCategory(id, name);
		return result;
	}
	
	/**
	 * 删除内容分类
	 * @param parentId
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoResult deleteContentCagegory( Long parentId,Long id){
		TaotaoResult result = contentCategoryServiceImpl.deleteContentCategory(parentId, id);
		return result;
	}
	
}
