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
import com.openyelp.annotation.RestFul;

@RestFul(api = UserInfoService.class, value = "UserInfoService")
public interface UserInfoService {

	/** 加密方法 */
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8; // 盐长度

	public Pagination getPage(int pageNo, int pageSize);

	public UserInfo findById(Long id);

	public UserInfo update(String username, String phone, String email);

	public UserInfo save(UserInfo bean);

	public UserInfo update(UserInfo bean);

	public UserInfo deleteById(Long id);

	public UserInfo[] deleteByIds(Long[] ids);

	public UserInfo login(String username, String password, String macaddress);

	public UserInfo findByUsername(String username);

	public int register(String email, String username, String password);

	public UserInfo reg(String email, String username, String password);
	


	public UserInfo reg(UserInfo user);

	public UserInfo updateUserLogin(UserInfo user);

	public Pagination pageByRole(long roleid, int pageNo, int pageSize);

	public Pagination pageByFollower(long userid, int pageNo, int pageSize);

	public UserInfo addRole(long id, UserRole bean);

	public UserInfo addRole(long id, long roleid);

	/**
	 * 查找用户的权限
	 * 
	 * @param id 用户id
	 * @return 权限集合
	 */
	public List<String> findAuthorities(Long id);
	
	public Page<UserInfo> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<UserInfo> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
	public UserInfo loginqq(String openid, String nickname, String figureurl_qq_1);

}