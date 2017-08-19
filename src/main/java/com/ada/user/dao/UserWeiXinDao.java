package com.ada.user.dao;

import com.ada.data.core.CriteriaDao;
import com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import com.ada.user.entity.UserInfo;
import com.ada.user.entity.UserQQ;
import com.ada.user.entity.UserWeiXin;

public interface UserWeiXinDao extends CriteriaDao<UserWeiXin, Long> {
	Pagination getPage(int pageNo, int pageSize);

	UserWeiXin findById(Long id);

	UserWeiXin save(UserWeiXin bean);

	UserWeiXin updateByUpdater(Updater<UserWeiXin> updater);

	UserWeiXin deleteById(Long id);

	UserWeiXin login(String access_token, String openid) throws Exception;

	/**
	 * 微信登陆返回用户
	 * 
	 * @param access_token
	 * @return
	 */
	UserInfo loginOauth(String access_token, String openid);

}