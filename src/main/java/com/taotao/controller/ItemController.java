package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

/**
 * 商品接口
 * @author 浮生若梦
 * 2016年9月26日 下午2:35:00
 */
@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	public ItemService itemService;
	
	/**
	 * 查询一条记录 测试
	 * @param itemId
	 * @return
	 */
	@RequestMapping("{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable long itemId){
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
	}
	
	/**
	 * 分页查询商品列表
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("list")
	@ResponseBody
	public EUDataGridResult getPageList(Integer page,Integer rows){
		EUDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}
	
	/**
	 * 新增商品
	 * @param item
	 * @return
	 */
	@RequestMapping(value="save",method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult createItem(TbItem item,String desc) throws Exception {
		TaotaoResult reault = itemService.createItem(item,desc);
		return reault;
	}
	
}
