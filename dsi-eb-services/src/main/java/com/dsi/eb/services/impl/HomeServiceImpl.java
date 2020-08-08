package com.dsi.eb.services.impl;

import org.springframework.stereotype.Service;

import com.dsi.eb.services.HomeService;
import com.dsi.eb.services.vo.CategoryVO;

/**
 * 
 * @author rjaforever
 *
 */
@Service
public class HomeServiceImpl implements HomeService {

	public CategoryVO findTop10ByCategory() {
		CategoryVO cat = new CategoryVO();
		cat.setDescription("algo");
		return cat;
	}

}
