package com.dsi.eb.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dsi.eb.services.HomeService;
import com.dsi.eb.services.vo.CategoryVO;

@RestController
@RequestMapping("/dsi/eb/home")
public class HomeRestController {

	@Autowired
	private HomeService homeService;

	@GetMapping(value = "/getCategoriesHome", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public CategoryVO getCategoriesHome() {
		return homeService.findTop10ByCategory();
	}
}
