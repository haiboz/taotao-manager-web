package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.service.ItemService;

/**
 * 商品列表页
 * @author 浮生若梦
 * 2016年10月13日 下午5:04:44
 */
@Controller
@RequestMapping("rest/item")
public class RestItemController {
	@Autowired
	private ItemService itemServiceImpl;
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public TaotaoResult deleteItem(String ids){
		TaotaoResult result  = itemServiceImpl.deleteItems(ids);
		return result;
	}
	
	/**
	 * 批量上架商品
	 * @param ids
	 * @return
	 */
	@RequestMapping("reshelf")
	@ResponseBody
	public TaotaoResult reshelfItem(String ids){
		TaotaoResult result  = itemServiceImpl.reshelfItem(ids);
		return result;
	}
	
	/**
	 * 批量下架商品
	 * @param ids
	 * @return
	 */
	@RequestMapping("instock")
	@ResponseBody
	public TaotaoResult instockItem(String ids){
		TaotaoResult result  = itemServiceImpl.instockItem(ids);
		return result;
	}

}
