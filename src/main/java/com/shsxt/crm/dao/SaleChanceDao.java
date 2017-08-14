package com.shsxt.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.shsxt.crm.dto.SaleChanceQuery;
import com.shsxt.crm.model.SaleChance;

public interface SaleChanceDao {
	
	@Select("select * from t_sale_chance where is_valid = 1")
	List<SaleChance> selectForPage(SaleChanceQuery query, PageBounds pageBounds);
	
}
