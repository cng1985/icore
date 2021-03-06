package com.ada.user.dao;


import  com.quhaodian.data.core.CriteriaDao;
import  com.quhaodian.data.core.Updater;
import  com.ada.user.entity.UserAccount;

public interface UserAccountDao extends CriteriaDao<UserAccount,Long>{

	public UserAccount findById(Long id);

	public UserAccount save(UserAccount bean);

	public UserAccount updateByUpdater(Updater<UserAccount> updater);

	public UserAccount deleteById(Long id);
}