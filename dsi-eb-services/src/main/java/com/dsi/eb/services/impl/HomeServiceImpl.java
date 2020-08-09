package com.dsi.eb.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.eb.persistence.dao.CsPaisDAO;
import com.dsi.eb.persistence.model.CsPaisDO;
import com.dsi.eb.services.HomeService;
import com.dsi.eb.services.vo.CategoryVO;

/**
 * 
 * @author rjaforever
 *
 */
@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	CsPaisDAO csPaisDAO;

	public CategoryVO findTop10ByCategory() {
		CategoryVO cat = new CategoryVO();
		cat.setDescription("algo");

		CsPaisDO pais = new CsPaisDO();
		pais.setClave("MX");
		pais.setNombre("Mexico");

		csPaisDAO.save(pais);
		return cat;
	}

}
