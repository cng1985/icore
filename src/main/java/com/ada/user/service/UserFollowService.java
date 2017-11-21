package com.ada.user.service;

import com.quhaodian.data.core.Pagination;
import com.ada.user.entity.UserFollow;





public interface UserFollowService {
	Pagination getPage(int pageNo, int pageSize);

	UserFollow findById(Long id);

	UserFollow save(UserFollow bean);

	UserFollow update(UserFollow bean);

	UserFollow deleteById(Long id);
	
	UserFollow[] deleteByIds(Long[] ids);
	
	
	UserFollow follow(UserFollow bean);
	UserFollow follow(long userid, long followid);
	UserFollow unFollow(UserFollow bean);
	UserFollow unFollow(long userid, long followid);
	
	Pagination pageByUser(long userid, int pageNo, int pageSize);

	UserFollow remove(UserFollow follow);

}