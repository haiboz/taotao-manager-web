package com.taotao.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamVo;
import com.taotao.service.ItemParamService;

/**
 * itemParam控制层
 * @author 浮生若梦
 * 2016年10月12日 下午2:16:31
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamController {
	
	@Autowired
	public ItemParamService ItemParamServiceImpl;
	
	
	@RequestMapping("/query/itemcatid/{catId}")
	@ResponseBody
	public TaotaoResult queryParamByCatId(@PathVariable long catId){
		List<TbItemParamVo> list = ItemParamServiceImpl.queryParamByCatId(catId);
		if(!CollectionUtils.isEmpty(list)){
			return TaotaoResult.ok(list.get(0));
		}else{
			return TaotaoResult.ok();
		}
	}
	
	/**
	 * 规格模版新增
	 * @param catId
	 * @param paramData
	 * @return
	 */
	@RequestMapping("/save/{catId}")
	@ResponseBody
	public TaotaoResult insertItemParam(@PathVariable long catId,String paramData){
		TbItemParam itemParam = new TbItemParam();
		itemParam.setItemCatId(catId);
		itemParam.setParamData(paramData);
		TaotaoResult result = ItemParamServiceImpl.insertItemParam(itemParam);
		return result;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoResult deleteParam(String ids){
		TaotaoResult result = ItemParamServiceImpl.deleteParam(ids);
		return result;
	}
	
	
	
	
	
}
