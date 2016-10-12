package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taotao.service.ItemParamItemService;

/**
 * 商品规格控制层
 * @author 浮生若梦
 * 2016年10月12日 下午4:31:06
 */
@Controller
public class ItemParamItemController {
	
	@Autowired 
	private ItemParamItemService itemParamItemServiceImpl;
	
	@RequestMapping("/showItem/{itemId}")
	public String showItemParam(@PathVariable Long itemId, Model model){
		
		String str = itemParamItemServiceImpl.getItemParamByItemId(itemId);
		model.addAttribute("itemParam",str);
		return "item";
	}
	
	
	
}
