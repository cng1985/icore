package com.ada.user.service;

import java.util.List;

import com.ada.data.core.Pagination;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import com.ada.user.entity.UserDevice;
import com.ada.user.entity.UserInfo;
import com.ada.user.entity.UserRole;

public interface UserInfoService {


	/** 加密方法 */
	String HASH_ALGORITHM = "SHA-1";
	int HASH_INTERATIONS = 1024;
	int SALT_SIZE = 8; // 盐长度
	
	Pagination getPage(int pageNo, int pageSize);

	UserInfo findById(Long id);

	UserInfo update(String username, String phone, String email);

	UserInfo save(UserInfo bean);

	UserInfo update(UserInfo bean);

	UserInfo deleteById(Long id);

	UserInfo[] deleteByIds(Long[] ids);

	UserInfo login(String username, String password, String macaddress);

	UserInfo findByUsername(String username);

	int register(String email, String username, String password);

	UserInfo reg(String email, String username, String password);

	UserInfo reg(UserInfo user);

	UserInfo updateUserLogin(UserInfo user);

	Pagination pageByRole(long roleid, int pageNo, int pageSize);

	Pagination pageByFollower(long userid, int pageNo, int pageSize);

	UserInfo addRole(long id, UserRole bean);

	UserInfo addRole(long id, long roleid);

	/**
	 * 查找用户的权限
	 * 
	 * @param id 用户id
	 * @return 权限集合
	 */
	List<String> findAuthorities(Long id);
	
	Page<UserInfo> findPage(Pageable pageable);

	Page<UserInfo> page(Pageable pageable);


	long count(Filter... filters);

	List<UserInfo> list(Integer first, Integer count, List<Filter> filters, List<Order> orders);

	List<UserInfo> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
	UserInfo loginqq(String openid, String nickname, String figureurl_qq_1);

}