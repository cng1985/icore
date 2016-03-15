package com.ada.user.dao;

import com.ada.data.core.BaseDao;
import com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import com.ada.user.entity.UserInfo;

public interface UserInfoDao extends BaseDao<UserInfo, Long> {

	/** 加密方法 */
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8; // 盐长度

	/**
	 * 
	 * @param username
	 * @param password
	 * @param email
	 * @return -1为用户已存在 1 注册成功
	 */
	public UserInfo register(String username, String password, String email);

	public Pagination getPage(int pageNo, int pageSize);

	public UserInfo findById(Long id);
	
	public UserInfo findByName(String name);


	public UserInfo save(UserInfo bean);

	public UserInfo updateByUpdater(Updater<UserInfo> updater);

	public UserInfo deleteById(Long id);
}