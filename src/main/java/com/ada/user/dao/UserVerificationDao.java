package com.ada.user.dao;

import com.quhaodian.data.core.CriteriaDao;
import com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import com.ada.user.entity.UserVerification;

public interface UserVerificationDao extends CriteriaDao<UserVerification, Long> {
	Pagination getPage(int pageNo, int pageSize);

	UserVerification findById(Long id);

	/**
	 * 根据手机号码和分类查找发过短信的对象
	 * 
	 * @param phone
	 * @param catalog
	 * @return
	 */
	UserVerification findByName(String phone, Integer catalog);

	UserVerification save(UserVerification bean);

	UserVerification updateByUpdater(Updater<UserVerification> updater);

	UserVerification deleteById(Long id);
}