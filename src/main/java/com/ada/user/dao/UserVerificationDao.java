package com.ada.user.dao;

import com.ada.data.core.CriteriaDao;
import com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import com.ada.user.entity.UserVerification;

public interface UserVerificationDao extends CriteriaDao<UserVerification, Long> {
	public Pagination getPage(int pageNo, int pageSize);

	public UserVerification findById(Long id);

	/**
	 * 根据手机号码和分类查找发过短信的对象
	 * 
	 * @param phone
	 * @param catalog
	 * @return
	 */
	public UserVerification findByName(String phone, Integer catalog);

	public UserVerification save(UserVerification bean);

	public UserVerification updateByUpdater(Updater<UserVerification> updater);

	public UserVerification deleteById(Long id);
}