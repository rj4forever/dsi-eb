package com.dsi.eb.persistence.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.dsi.eb.persistence.model.CsPaisDO;

public interface CsPaisDAO extends PagingAndSortingRepository<CsPaisDO, Long> {

}
