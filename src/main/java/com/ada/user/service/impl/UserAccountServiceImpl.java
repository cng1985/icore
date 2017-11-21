package com.ada.user.service.impl;

import com.quhaodian.data.core.Finder;
import com.ada.user.dao.UserInfoDao;
import com.ada.user.entity.UserInfo;
import com.ada.user.enums.AccountType;
import com.ada.user.security.SecurityUtil;
import com.ada.user.vo.UserAccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Updater;
import com.ada.user.dao.UserAccountDao;
import com.ada.user.entity.UserAccount;
import com.ada.user.service.UserAccountService;

import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;

import java.util.List;
import java.util.LinkedList;

import com.quhaodian.data.utils.FilterUtils;


@Service
@Transactional
public class UserAccountServiceImpl implements UserAccountService {

    private UserAccountDao dao;

    @Autowired
    private UserInfoDao infoDao;

    @Override
    @Transactional(readOnly = true)
    public long count(Filter... filters) {
        return dao.count(filters);
    }

    @Override
    @Transactional
    public UserAccount deleteById(Long id) {
        UserAccount bean = dao.findById(id);
        dao.deleteById(id);
        return bean;
    }

    @Override
    @Transactional
    public UserAccount[] deleteByIds(Long[] ids) {
        UserAccount[] beans = new UserAccount[ids.length];
        for (int i = 0, len = ids.length; i < len; i++) {
            beans[i] = deleteById(ids[i]);
        }
        return beans;
    }

    @Override
    @Transactional(readOnly = true)
    public UserAccount findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public UserAccount findByUsername(String username,AccountType accountType) {
        Finder finder=Finder.create();
        finder.append("from UserAccount u where u.username=:username and u.accountType=:accountType");
        finder.setParam("username",username);
        finder.setParam("accountType",accountType);
        return dao.findOne(finder);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserAccount> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders) {
        return dao.findList(first, count, filters, orders);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<UserAccount> findPage(Pageable pageable) {
        return dao.findPage(pageable);
    }

    @Override
    public Page<UserAccount> page(Pageable pageable) {
        return dao.page(pageable);
    }

    @Override
    public Page<UserAccount> page(Pageable pageable, Object search) {
        List<Filter> filters = FilterUtils.getFilters(search);
        if (filters != null) {
            pageable.getFilters().addAll(filters);
        }
        return dao.page(pageable);
    }

    @Override
    @Transactional
    public UserAccountVo reg(UserAccount bean) {
        UserAccountVo result=new UserAccountVo();
        if (bean==null){
            result.setCode(-1);
            result.setMsg("数据无效");
            return result;
        }
        if (bean.getUsername()==null||bean.getUsername().length()<2){
            result.setCode(-2);
            result.setMsg("用户名长度过短");
            return result;
        }
        if (bean.getPassword()==null||bean.getPassword().length()<2){
            result.setCode(-3);
            result.setMsg("密码过短");
            return result;
        }
        if (bean.getAccountType()==null){
            bean.setAccountType(AccountType.Account);
        }

        Finder finder = Finder.create();
        finder.append("from UserAccount u where u.username ='" + bean.getUsername() + "'");
        finder.append(" and u.accountType=:accountType");
        finder.setParam("accountType",bean.getAccountType());
        List<UserAccount> us = dao.find(finder);
        /**
         * 检查用户名是否可用
         */
        if (us != null && us.size() > 0) {
            //result = -1;
        } else {
            UserInfo user = new UserInfo();
            user.setName(bean.getUsername());
            infoDao.save(user);
            bean.setUser(user);
            SecurityUtil securityUtil = new SecurityUtil();
            String oldpassword = securityUtil.entryptPassword(bean.getPassword());
            bean.setPassword(oldpassword);
            bean.setSalt(securityUtil.getSalt());
            dao.save(bean);
        }
        return result;
    }

    @Autowired
    public void setDao(UserAccountDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public UserAccount update(UserAccount bean) {
        Updater<UserAccount> updater = new Updater<UserAccount>(bean);
        return dao.updateByUpdater(updater);
    }
}