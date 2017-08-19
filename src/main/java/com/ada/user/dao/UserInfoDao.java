package com.ada.user.dao;

import com.ada.data.core.CriteriaDao;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.data.rest.domain.AbstractVo;
import com.ada.user.entity.UserInfo;
import com.ada.user.vo.UserStateVo;

public interface UserInfoDao extends CriteriaDao<UserInfo, Long> {

    /**
     * 加密方法
     */
    String HASH_ALGORITHM = "SHA-1";
    int HASH_INTERATIONS = 1024;
    int SALT_SIZE = 8; // 盐长度

    /**
     * @param username
     * @param password
     * @param email
     * @return -1为用户已存在 1 注册成功
     */
    UserInfo register(String username, String password, String email);

    /**
     * 修改用户密码功能
     *
     * @param user        用户id
     * @param oldPassword 老密码
     * @param newPassword 新密码
     * @return
     */
    AbstractVo modifyPassword(Long user, String oldPassword, String newPassword);

    UserStateVo reg(UserInfo user);

    Pagination getPage(int pageNo, int pageSize);

    UserInfo findById(Long id);

    UserInfo findByName(String name);


    UserInfo save(UserInfo bean);

    UserInfo updateByUpdater(Updater<UserInfo> updater);

    UserInfo deleteById(Long id);
}