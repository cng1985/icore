package com.ada.user.service;

import com.ada.data.core.Pagination;
import com.ada.user.entity.UserFollow;





public interface UserFollowService {
	public Pagination getPage(int pageNo, int pageSize);

	public UserFollow findById(Long id);

	public UserFollow save(UserFollow bean);

	public UserFollow update(UserFollow bean);

	public UserFollow deleteById(Long id);
	
	public UserFollow[] deleteByIds(Long[] ids);
	
	
	public UserFollow follow(UserFollow bean);
	public UserFollow follow(long  userid,long followid);
	public UserFollow unFollow(UserFollow bean);
	public UserFollow unFollow(long  userid,long followid);
	
	public Pagination pageByUser(long userid,int pageNo, int pageSize);

	public UserFollow remove(UserFollow follow);

}