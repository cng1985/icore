package com.ada.user.freemaker;

import com.ada.data.page.Order;
import com.ada.freemarker.ListDirective;
import com.ada.user.entity.UserInfo;
import com.ada.user.service.UserInfoService;
import com.young.utils.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by cng19 on 2017/6/26.
 */
public class NewUserDirective extends ListDirective<UserInfo> {


    @Override
    public List<UserInfo> list() {

        List<UserInfo> list = userInfoService.list(0,getInt("size"), null,ListUtils.list(Order.desc("id")));
        return list;
    }

    @Autowired
    UserInfoService userInfoService;
}
