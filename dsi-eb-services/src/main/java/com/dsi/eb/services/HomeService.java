package com.dsi.eb.services;

import com.dsi.eb.services.vo.CategoryVO;

/**
 * 
 * @author rjaforever
 *
 */
public interface HomeService {

	CategoryVO findTop10ByCategory();

}
