package com.shsxt.crm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.shsxt.crm.dao.SaleChanceDao;
import com.shsxt.crm.dto.SaleChanceQuery;
import com.shsxt.crm.model.SaleChance;

@Service
public class SaleChanceService {
	
	@Autowired
	private SaleChanceDao saleChanceDao;

	public Map<String, Object> selectForPage(SaleChanceQuery query) {
		
		// 构建一个分页对象
		Integer page = query.getPage();
		if (page == null) {
			page = 1;
		}
		Integer pageSize = query.getRows();
		if (pageSize == null) {
			pageSize = 10;
		}
		String sort = query.getSort();
		if (StringUtils.isBlank(sort)) {
			sort = "id.desc"; // 数据库字段.desc/asc
		}
		PageBounds pageBounds = new PageBounds(page, pageSize, Order.formString(sort));
		
		// 查询
		List<SaleChance> saleChances = saleChanceDao.selectForPage(query, pageBounds);
		PageList<SaleChance> result = (PageList<SaleChance>) saleChances;
		
		// 返回分页结果
		Paginator paginator = result.getPaginator();
		Map<String, Object> map = new HashMap<>();
		map.put("paginator", paginator);
		map.put("rows", result);
		map.put("total", paginator.getTotalCount());
		
		return map;
	}
	
	
}
