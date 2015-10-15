package com.ada.user.service;

import com.ada.data.core.Pagination;
import com.ada.user.entity.UserRole;
import com.openyelp.annotation.RestFul;



@RestFul(api=UserRoleService.class,value="UserRoleService")
public interface UserRoleService {
	public Pagination getPage(int pageNo, int pageSize);

	public UserRole findById(Long id);

	public UserRole save(UserRole bean);

	public UserRole update(UserRole bean);

	public UserRole deleteById(Long id);
	
	public UserRole[] deleteByIds(Long[] ids);
}