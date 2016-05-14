package com.ada.article.service;

import com.ada.article.entity.SensitiveWord;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

import com.openyelp.annotation.RestFul;

@RestFul(api=SensitiveWordService.class,value="SensitiveWordService")
public interface SensitiveWordService {

	public SensitiveWord findById(Long id);

	public SensitiveWord save(SensitiveWord bean);

	public SensitiveWord update(SensitiveWord bean);

	public SensitiveWord deleteById(Long id);
	
	public SensitiveWord[] deleteByIds(Long[] ids);
	
	public Page<SensitiveWord> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<SensitiveWord> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}