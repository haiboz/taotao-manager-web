package com.taotao.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.taotao.pojo.TbItemCat;
import com.taotao.service.ItemCatService;

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
	
	@Autowired
	private ItemCatService itemCatService;
	/**
	 * 获取商品类目树
	 * @param parentId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/list")
	public List<Map<String,Object>> categoryList(@RequestParam(value="id",defaultValue="0")Long parentId){
		List<Map<String,Object>> catList = new ArrayList<Map<String,Object>>();
		List<TbItemCat> list = itemCatService.getItemCatList(parentId);
		for (TbItemCat tbItemCat : list) {
			Map<String, Object> node = new HashMap<String,Object>();
			//按照easyUI标准构造树节点
			node.put("id", tbItemCat.getId());
			node.put("text", tbItemCat.getName());
			//如果是父节点的话就设置成关闭状态，如果是叶子节点就是open状态
			node.put("state", tbItemCat.getIsParent()?"closed":"open");
			catList.add(node);
		}
		return catList;
	}

}
