package com.taotao.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.druid.support.json.JSONUtils;
import com.taotao.service.PictureService;

@Controller
@RequestMapping("/pic")
public class PictureController {
	@Autowired
	private PictureService pictureSreviceImpl;
	
	@RequestMapping("/upload")
	@ResponseBody
	public String picupload(MultipartFile uploadFile){
		Map<String,Object> result = pictureSreviceImpl.uploadPicture(uploadFile);
		String str = JSONUtils.toJSONString(result);
		return str;
	}

}
