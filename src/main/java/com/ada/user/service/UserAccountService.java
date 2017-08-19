package com.ada.user.service;

import com.ada.user.entity.UserAccount;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import com.ada.user.entity.UserInfo;
import com.ada.user.enums.AccountType;
import com.ada.user.vo.UserAccountVo;

import java.util.List;


public interface UserAccountService {

	public UserAccount findById(Long id);

	UserAccount findByUsername(String username, AccountType accountType);

    public UserAccountVo reg(UserAccount bean);

	public UserAccount update(UserAccount bean);

	public UserAccount deleteById(Long id);
	
	public UserAccount[] deleteByIds(Long[] ids);
	
	public Page<UserAccount> findPage(Pageable pageable);
	
	public Page<UserAccount> page(Pageable pageable);
	
	public Page<UserAccount> page(Pageable pageable, Object search);

	public long count(Filter... filters);


	public List<UserAccount> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}