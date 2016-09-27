package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转
 * @author 浮生若梦
 * 2016年9月26日 下午2:57:41
 */
@Controller
public class PageController {
	/**
	 * 打开首页
	 * @return
	 */
	@RequestMapping("/")
	public String showIndex(){
		return "index";
	}
	/**
	 * 页面展示
	 * @param page
	 * @return
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
}
